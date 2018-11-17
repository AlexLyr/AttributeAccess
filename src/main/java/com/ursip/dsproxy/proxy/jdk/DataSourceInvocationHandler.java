package com.ursip.dsproxy.proxy.jdk;

import com.ursip.dsproxy.proxy.DataSourceProxyLogic;
import com.ursip.dsproxy.proxy.ProxyConfig;

import javax.sql.DataSource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Proxy InvocationHandler for {@link DataSource}.
 *
 * @author Lyrchikov Alexander
 */
public class DataSourceInvocationHandler implements InvocationHandler {

    private DataSourceProxyLogic delegate;

    public DataSourceInvocationHandler(DataSource dataSource, ProxyConfig proxyConfig) {
        delegate = new DataSourceProxyLogic(dataSource, proxyConfig);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return delegate.invoke(method, args);
    }
}
