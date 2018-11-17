package com.ursip.dsproxy.proxy;

/**
 * Provide a method to unwrap the original jdbc object from proxy object.
 *
 * <p>Proxy object created by {@link JdbcProxyFactory} implements this interface.
 *
 * @author Lyrchikov Alexander
 * @see JdbcProxyFactory
 * @see com.ursip.dsproxy.proxy.jdk.ConnectionInvocationHandler
 * @see com.ursip.dsproxy.proxy.jdk.StatementInvocationHandler
 * @see com.ursip.dsproxy.proxy.jdk.PreparedStatementInvocationHandler
 * @see com.ursip.dsproxy.proxy.jdk.CallableStatementInvocationHandler
 * @see com.ursip.dsproxy.proxy.jdk.ResultSetInvocationHandler
 */
public interface ProxyJdbcObject {

    /**
     * Method to return wrapped source object(Connection, Statement, PreparedStatement, CallableStatement).
     *
     * @return source object
     */
    Object getTarget();
}
