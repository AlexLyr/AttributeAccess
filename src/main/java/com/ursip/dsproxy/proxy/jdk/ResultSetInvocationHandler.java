package com.ursip.dsproxy.proxy.jdk;

import com.ursip.dsproxy.ConnectionInfo;
import com.ursip.dsproxy.proxy.ProxyConfig;
import com.ursip.dsproxy.proxy.ResultSetProxyLogic;
import com.ursip.dsproxy.proxy.ResultSetProxyLogicFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.ResultSet;

/**
 * Proxy InvocationHandler for {@link ResultSet}.
 *
 * @author Liam Williams
 * @author Lyrchikov Alexander

 */
public class ResultSetInvocationHandler implements InvocationHandler {

    private ResultSetProxyLogic delegate;

    public ResultSetInvocationHandler(ResultSetProxyLogicFactory factory, ResultSet resultSet, ConnectionInfo connectionInfo, ProxyConfig proxyConfig) {
        this.delegate = factory.create(resultSet, connectionInfo, proxyConfig);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return delegate.invoke(method, args);
    }
}
