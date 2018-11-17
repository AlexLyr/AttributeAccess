package com.ursip.dsproxy.support;

import com.ursip.dsproxy.ConnectionIdManager;
import com.ursip.dsproxy.ConnectionInfo;
import com.ursip.dsproxy.proxy.JdbcProxyFactory;
import com.ursip.dsproxy.proxy.ProxyConfig;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.sql.Connection;

/**
 * Support injecting proxies by AOP.
 *
 * @author Lyrchikov Alexander
 */
public class ProxyConnectionAdvice implements MethodInterceptor {

    private ProxyConfig proxyConfig = ProxyConfig.Builder.create().build();  // default

    public Object invoke(MethodInvocation invocation) throws Throwable {

        Object retVal = invocation.proceed();

        // only when return value is connection, return proxy.
        if (!(retVal instanceof Connection)) {
            return retVal;
        }

        Connection conn = (Connection) retVal;
        String connId = this.proxyConfig.getConnectionIdManager().getId(conn);
        ConnectionInfo connectionInfo = new ConnectionInfo();
        connectionInfo.setConnectionId(connId);
        connectionInfo.setDataSourceName("");

        return this.proxyConfig.getJdbcProxyFactory().createConnection((Connection) retVal, connectionInfo, this.proxyConfig);
    }


    public JdbcProxyFactory getJdbcProxyFactory() {
        return this.proxyConfig.getJdbcProxyFactory();
    }

    public void setJdbcProxyFactory(JdbcProxyFactory jdbcProxyFactory) {
        this.proxyConfig = ProxyConfig.Builder.from(this.proxyConfig)
                .jdbcProxyFactory(jdbcProxyFactory)
                .build();
    }

    /**

     */
    public ConnectionIdManager getConnectionIdManager() {
        return this.proxyConfig.getConnectionIdManager();
    }

    /**

     */
    public void setConnectionIdManager(ConnectionIdManager connectionIdManager) {
        this.proxyConfig = ProxyConfig.Builder.from(this.proxyConfig)
                .connectionIdManager(connectionIdManager)
                .build();
    }

    /**

     */
    public ProxyConfig getProxyConfig() {
        return this.proxyConfig;
    }

    /**

     */
    public void setProxyConfig(ProxyConfig proxyConfig) {
        this.proxyConfig = proxyConfig;
    }
}
