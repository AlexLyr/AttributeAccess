package com.ursip.dsproxy.listener;

import com.ursip.dsproxy.QueryCount;

/**
 * @author Lyrchikov Alexander
 * @see DataSourceQueryCountListener

 */
public interface QueryCountStrategy {

    QueryCount getOrCreateQueryCount(String dataSourceName);

}
