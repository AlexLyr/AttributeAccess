package com.ursip.dsproxy.proxy.jdk;

import com.ursip.dsproxy.ConnectionInfo;
import com.ursip.dsproxy.StatementType;
import com.ursip.dsproxy.proxy.ProxyConfig;
import com.ursip.dsproxy.proxy.StatementProxyLogic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Proxy InvocationHandler for {@link PreparedStatement}.
 *
 * @author Lyrchikov Alexander
 */
public class PreparedStatementInvocationHandler implements InvocationHandler {

    private StatementProxyLogic delegate;

    public PreparedStatementInvocationHandler(
            PreparedStatement ps, String query, ConnectionInfo connectionInfo,
            Connection proxyConnection, ProxyConfig proxyConfig, boolean generateKey) {

        this.delegate = StatementProxyLogic.Builder.create()
                .statement(ps, StatementType.PREPARED)
                .query(query)
                .connectionInfo(connectionInfo)
                .proxyConnection(proxyConnection)
                .proxyConfig(proxyConfig)
                .generateKey(generateKey)
                .build();
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return delegate.invoke(method, args);
    }

}
