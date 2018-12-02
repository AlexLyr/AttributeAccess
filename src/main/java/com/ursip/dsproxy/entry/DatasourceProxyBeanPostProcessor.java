package com.ursip.dsproxy.entry;


import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.ursip.dsproxy.listener.logging.SLF4JLogLevel;
import com.ursip.dsproxy.support.ProxyDataSourceBuilder;
import com.ursip.dsproxy.transform.ParameterReplacer;
import com.ursip.dsproxy.transform.ParameterTransformer;
import com.ursip.dsproxy.transform.QueryTransformer;
import com.ursip.dsproxy.transform.TransformInfo;
import com.ursip.dsproxy.ursiplogic.PolicyQueryFilter;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

@Component
public class DatasourceProxyBeanPostProcessor implements BeanPostProcessor {


    public Object postProcessBeforeInitialization(final Object bean, final String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(final Object bean, final String beanName) throws BeansException {
        if (bean instanceof DataSource) {
            ProxyFactory factory = new ProxyFactory(bean);
            factory.setProxyTargetClass(true);
            factory.addAdvice(new ProxyDataSourceInterceptor((DataSource) bean));
            return factory.getProxy();
        }
        return bean;
    }

    private static class ProxyDataSourceInterceptor implements MethodInterceptor {
        private final DataSource dataSource;

        public ProxyDataSourceInterceptor(final DataSource dataSource) {
            super();
            this.dataSource = ProxyDataSourceBuilder.create(dataSource)
                    //TODO mb this is useless in current situation?
                    /*.queryTransformer(new QueryTransformer() {
                        public String transformQuery(TransformInfo transformInfo) {
                            return new PolicyQueryFilter(transformInfo.getQuery(),dataSource).filterQuery();
                        }
                    })*/
                    .parameterTransformer(new ParameterTransformer() {
                        public Statement transformParametersAndGetStatement(ParameterReplacer replacer, TransformInfo transformInfo, Statement ps) {
                            return new PolicyQueryFilter(replacer,transformInfo,ps,dataSource).createFilteredStatement();
                        }
                    })
                    .autoRetrieveGeneratedKeys(true)
                    .retrieveGeneratedKeysForBatch(true,true)
                    .logQueryBySlf4j(SLF4JLogLevel.INFO).build();
        }

        public Object invoke(final MethodInvocation invocation) throws Throwable {
            Method proxyMethod = ReflectionUtils.findMethod(dataSource.getClass(), invocation.getMethod().getName());
            if (proxyMethod != null) {
                return proxyMethod.invoke(dataSource, invocation.getArguments());
            }
            return invocation.proceed();
        }
    }
}
