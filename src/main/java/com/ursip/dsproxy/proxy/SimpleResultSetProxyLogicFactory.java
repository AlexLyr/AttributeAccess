package com.ursip.dsproxy.proxy;

import com.ursip.dsproxy.ConnectionInfo;

import java.sql.ResultSet;

/**
 * Factory to create {@link SimpleResultSetProxyLogic}.
 *
 * @author Lyrchikov Alexander

 */
public class SimpleResultSetProxyLogicFactory implements ResultSetProxyLogicFactory {

    @Override
    public ResultSetProxyLogic create(ResultSet resultSet, ConnectionInfo connectionInfo, ProxyConfig proxyConfig) {
        return new SimpleResultSetProxyLogic(resultSet, connectionInfo, proxyConfig);
    }

}
