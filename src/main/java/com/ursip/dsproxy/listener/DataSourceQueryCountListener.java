package com.ursip.dsproxy.listener;

import com.ursip.dsproxy.ExecutionInfo;
import com.ursip.dsproxy.QueryCount;
import com.ursip.dsproxy.QueryInfo;
import com.ursip.dsproxy.QueryType;

import java.util.List;

/**
 * Update database access information.
 *
 * <p>Default implementation uses {@link ThreadQueryCountHolder} strategy that uses thread local to keep
 * {@link com.ursip.dsproxy.QueryCount}. {@link QueryCount} can be retrieved by {@link com.ursip.dsproxy.QueryCountHolder#get(String)}.
 *
 * <p>Alternatively, {@link SingleQueryCountHolder} strategy can be used. This strategy uses single instance to keep
 * {@link QueryCount}; therefore, {@link QueryCount} holds accumulated total values from any threads until values are cleared.
 *
 * <p>In web application lifecycle, one http request is handled by one thread.
 * Storing database access information into a thread local value provides metrics
 * information per http request.
 * On the other hand, using single instance to store database access information allows you to retrieve total accumulated
 * numbers since application has started.
 *
 * <p>{@link com.ursip.dsproxy.QueryCount} holds following data:
 * <ul>
 * <li> datasource name
 * <li> number of database call
 * <li> total query execution time
 * <li> number of queries by type
 * </ul>
 *
 * @author Lyrchikov Alexander
 * @see com.ursip.dsproxy.QueryCount
 * @see com.ursip.dsproxy.QueryCountHolder
 * @see com.ursip.dsproxy.listener.QueryCountStrategy
 * @see com.ursip.dsproxy.support.CommonsQueryCountLoggingServletFilter
 * @see com.ursip.dsproxy.support.CommonsQueryCountLoggingRequestListener
 * @see com.ursip.dsproxy.support.CommonsQueryCountLoggingHandlerInterceptor
 */
public class DataSourceQueryCountListener implements QueryExecutionListener {

    // uses per thread implementation in default
    private QueryCountStrategy queryCountStrategy = new ThreadQueryCountHolder();


    public void beforeQuery(ExecutionInfo execInfo, List<QueryInfo> queryInfoList) {
    }


    public void afterQuery(ExecutionInfo execInfo, List<QueryInfo> queryInfoList) {
        final String dataSourceName = execInfo.getDataSourceName();

        QueryCount count = this.queryCountStrategy.getOrCreateQueryCount(dataSourceName);

        // increment db call
        count.incrementTotal();
        if (execInfo.isSuccess()) {
            count.incrementSuccess();
        } else {
            count.incrementFailure();
        }

        // increment elapsed time
        final long elapsedTime = execInfo.getElapsedTime();
        count.incrementTime(elapsedTime);

        // increment statement type
        count.increment(execInfo.getStatementType());

        // increment query count
        for (QueryInfo queryInfo : queryInfoList) {
            final String query = queryInfo.getQuery();
            final QueryType type = QueryUtils.getQueryType(query);
            count.increment(type);
        }

    }

    /**

     */
    public QueryCountStrategy getQueryCountStrategy() {
        return queryCountStrategy;
    }

    /**

     */
    public void setQueryCountStrategy(QueryCountStrategy queryCountStrategy) {
        this.queryCountStrategy = queryCountStrategy;
    }

}
