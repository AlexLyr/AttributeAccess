package com.example.demo.common



import com.ursip.dsproxy.listener.logging.SLF4JLogLevel
import com.ursip.dsproxy.support.ProxyDataSourceBuilder
import com.ursip.dsproxy.transform.ParameterReplacer
import com.ursip.dsproxy.transform.ParameterTransformer
import com.ursip.dsproxy.transform.QueryTransformer
import com.ursip.dsproxy.transform.TransformInfo
import org.aopalliance.intercept.MethodInterceptor
import org.aopalliance.intercept.MethodInvocation
import org.springframework.aop.framework.ProxyFactory
import org.springframework.beans.BeansException
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.stereotype.Component
import org.springframework.util.ReflectionUtils
import javax.sql.DataSource


/*@Component
class DatasourceProxyBeanPostProcessor : BeanPostProcessor {

    @Throws(BeansException::class)
    override fun postProcessBeforeInitialization(bean: Any, beanName: String): Any? {
        return bean
    }

    @Throws(BeansException::class)
    override fun postProcessAfterInitialization(bean: Any, beanName: String): Any? {
        if (bean is DataSource) {
            val factory = ProxyFactory(bean)
            factory.isProxyTargetClass = true
            factory.addAdvice(ProxyDataSourceInterceptor(bean))
            factory.isExposeProxy = true
            return factory.proxy
        }
        return bean
    }

    private class ProxyDataSourceInterceptor(dataSource: DataSource) : MethodInterceptor {
        private val dataSource: DataSource

        init {
            this.dataSource = ProxyDataSourceBuilder.create(dataSource)
                    .queryTransformer(object: QueryTransformer {
                        override fun transformQuery(transformInfo: TransformInfo?): String {
                            //transformInfo!!.query = transformInfo.query.replace("first_name,","")
                            return transformInfo!!.query
                        }

                    })
                    .parameterTransformer(object: ParameterTransformer {
                        override fun transformParameters(replacer: ParameterReplacer?, transformInfo: TransformInfo?) {
                            val param = replacer!!.getValue(2) as String
                            println(param)
                        }

                    })
                    .logQueryBySlf4j(SLF4JLogLevel.INFO)
                    .build()
        }

        @Throws(Throwable::class)
        override fun invoke(invocation: MethodInvocation): Any {
            val proxyMethod = ReflectionUtils.findMethod(dataSource.javaClass, invocation.method.name)
            return if (proxyMethod != null) {
                proxyMethod.invoke(dataSource, *invocation.arguments)
            } else invocation.proceed()
        }
    }
}*/
