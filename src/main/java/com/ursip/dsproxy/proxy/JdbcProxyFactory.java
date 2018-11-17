package com.ursip.dsproxy.proxy;

import com.ursip.dsproxy.ConnectionInfo;
import com.ursip.dsproxy.proxy.jdk.JdkJdbcProxyFactory;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Factory interface to return a proxy with InvocationHandler used by datasource-proxy.
 *
 * @author Lyrchikov Alexander
 */
public interface JdbcProxyFactory {

    /**
     * use JDK proxy as default.
     */
    JdbcProxyFactory DEFAULT = new JdkJdbcProxyFactory();


    DataSource createDataSource(DataSource dataSource, ProxyConfig proxyConfig);

    Connection createConnection(Connection connection, ConnectionInfo connectionInfo, ProxyConfig proxyConfig);

    Statement createStatement(Statement statement, ConnectionInfo connectionInfo, Connection proxyConnection,
                              ProxyConfig proxyConfig);

    PreparedStatement createPreparedStatement(PreparedStatement preparedStatement, String query,
                                              ConnectionInfo connectionInfo, Connection proxyConnection,
                                              ProxyConfig proxyConfig, boolean generateKey);

    CallableStatement createCallableStatement(CallableStatement callableStatement, String query,
                                              ConnectionInfo connectionInfo,
                                              Connection proxyConnection, ProxyConfig proxyConfig);

    /**
     * Create a proxy for {@link ResultSet}.
     *

     */
    ResultSet createResultSet(ResultSet resultSet, ConnectionInfo connectionInfo, ProxyConfig proxyConfig);

    /**
     * Create a proxy for {@link ResultSet} generated keys.
     *

     */
    ResultSet createGeneratedKeys(ResultSet resultSet, ConnectionInfo connectionInfo, ProxyConfig proxyConfig);

}