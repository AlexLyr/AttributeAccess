package com.ursip.dsproxy.listener;

import com.ursip.dsproxy.ExecutionInfo;
import com.ursip.dsproxy.QueryInfo;

import java.util.List;

/**
 * Listener interface. Inject the implementation to proxy handler interceptors.
 *
 * @author Lyrchikov Alexander
 * @see ChainListener
 * @see com.ursip.dsproxy.proxy.jdk.ConnectionInvocationHandler
 * @see com.ursip.dsproxy.proxy.jdk.PreparedStatementInvocationHandler
 * @see com.ursip.dsproxy.proxy.jdk.StatementInvocationHandler
 */
public interface QueryExecutionListener {

    static QueryExecutionListener DEFAULT = new NoOpQueryExecutionListener();

    void beforeQuery(ExecutionInfo execInfo, List<QueryInfo> queryInfoList);

    void afterQuery(ExecutionInfo execInfo, List<QueryInfo> queryInfoList);
}
