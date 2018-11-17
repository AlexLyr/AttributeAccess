package com.ursip.dsproxy.proxy.jdk;

import com.ursip.dsproxy.ConnectionInfo;
import com.ursip.dsproxy.StatementType;
import com.ursip.dsproxy.proxy.ProxyConfig;
import com.ursip.dsproxy.proxy.StatementProxyLogic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.Statement;

/**
 * Proxy InvocationHandler for {@link Statement}.
 *
 * @author Lyrchikov Alexander
 */
public class StatementInvocationHandler implements InvocationHandler {

    private StatementProxyLogic delegate;

    public StatementInvocationHandler(
            Statement stmt, ConnectionInfo connectionInfo,
            Connection proxyConnection, ProxyConfig proxyConfig) {
        this.delegate = StatementProxyLogic.Builder.create()
                .statement(stmt, StatementType.STATEMENT)
                .connectionInfo(connectionInfo)
                .proxyConnection(proxyConnection)
                .proxyConfig(proxyConfig)
                .build();
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return delegate.invoke(method, args);
    }
}
