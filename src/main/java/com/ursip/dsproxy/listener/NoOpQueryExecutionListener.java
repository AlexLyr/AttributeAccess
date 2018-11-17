package com.ursip.dsproxy.listener;

import com.ursip.dsproxy.ExecutionInfo;
import com.ursip.dsproxy.QueryInfo;

import java.util.List;

/**
 * No operation implementation of {@link QueryExecutionListener}
 *
 * @author Lyrchikov Alexander

 */
public class NoOpQueryExecutionListener implements QueryExecutionListener {

    @Override
    public void beforeQuery(ExecutionInfo execInfo, List<QueryInfo> queryInfoList) {
        // do nothing
    }

    @Override
    public void afterQuery(ExecutionInfo execInfo, List<QueryInfo> queryInfoList) {
        // do nothing
    }
}
