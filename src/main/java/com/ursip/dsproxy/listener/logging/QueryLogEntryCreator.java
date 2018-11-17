package com.ursip.dsproxy.listener.logging;

import com.ursip.dsproxy.ExecutionInfo;
import com.ursip.dsproxy.QueryInfo;

import java.util.List;

/**
 * Generate logging entry.
 *
 * @author Lyrchikov Alexander

 */
public interface QueryLogEntryCreator {

    String getLogEntry(ExecutionInfo execInfo, List<QueryInfo> queryInfoList, boolean writeDataSourceName, boolean writeConnectionId);

}
