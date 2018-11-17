package com.ursip.dsproxy.proxy;

import com.ursip.dsproxy.ConnectionInfo;

import java.sql.ResultSet;

/**
 * Factory to create {@link ResultSetProxyLogic}.
 *
 * @author Lyrchikov Alexander

 */
public interface ResultSetProxyLogicFactory {

    ResultSetProxyLogicFactory DEFAULT = new SimpleResultSetProxyLogicFactory();

    ResultSetProxyLogic create(ResultSet resultSet, ConnectionInfo connectionInfo, ProxyConfig proxyConfig);
}
