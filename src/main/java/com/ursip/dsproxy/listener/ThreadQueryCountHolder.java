package com.ursip.dsproxy.listener;

import com.ursip.dsproxy.QueryCount;
import com.ursip.dsproxy.QueryCountHolder;

/**
 * Uses {@link QueryCountHolder} which uses thread local to hold {@link QueryCount}.
 *
 * @author Lyrchikov Alexander

 */
public class ThreadQueryCountHolder implements QueryCountStrategy {

    @Override
    public QueryCount getOrCreateQueryCount(String dataSourceName) {
        QueryCount queryCount = QueryCountHolder.get(dataSourceName);
        if (queryCount == null) {
            queryCount = new QueryCount();
            QueryCountHolder.put(dataSourceName, queryCount);
        }
        return queryCount;
    }

}
