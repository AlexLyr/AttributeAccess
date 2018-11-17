package com.ursip.dsproxy.proxy.jdk;

import com.ursip.dsproxy.ConnectionInfo;
import com.ursip.dsproxy.proxy.ConnectionProxyLogic;
import com.ursip.dsproxy.proxy.ProxyConfig;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

/**
 * Proxy InvocationHandler for {@link Connection}.
 *
 * @author Lyrchikov Alexander
 */
public class ConnectionInvocationHandler implements InvocationHandler {

    private ConnectionProxyLogic delegate;

    public ConnectionInvocationHandler(Connection connection, ConnectionInfo connectionInfo, ProxyConfig proxyConfig) {
        this.delegate = new ConnectionProxyLogic(connection, connectionInfo, proxyConfig);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return delegate.invoke(proxy, method, args);
    }

}
