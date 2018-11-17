package com.ursip.dsproxy.support;

import com.ursip.dsproxy.QueryCount;

/**
 * @author Lyrchikov Alexander
 */
public interface QueryCountLogEntryCreator {

    String getLogMessage(String datasourceName, QueryCount queryCount);
    String getLogMessageAsJson(String datasourceName, QueryCount queryCount);
}
