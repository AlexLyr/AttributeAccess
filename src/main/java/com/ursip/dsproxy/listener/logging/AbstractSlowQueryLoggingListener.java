package com.ursip.dsproxy.listener.logging;

import com.ursip.dsproxy.ExecutionInfo;
import com.ursip.dsproxy.QueryInfo;
import com.ursip.dsproxy.listener.SlowQueryListener;

import java.util.List;

/**
 * Abstract class to log slow query.
 *
 * This class delegates actual log writing to subclasses.
 *
 * @author Lyrchikov Alexander

 */
public abstract class AbstractSlowQueryLoggingListener extends SlowQueryListener {

    protected boolean writeDataSourceName = true;
    protected boolean writeConnectionId = true;
    protected QueryLogEntryCreator queryLogEntryCreator = new DefaultQueryLogEntryCreator();
    protected String prefix;

    @Override
    protected void onSlowQuery(ExecutionInfo execInfo, List<QueryInfo> queryInfoList, long startTimeInMills) {
        String entry = this.queryLogEntryCreator.getLogEntry(execInfo, queryInfoList, this.writeDataSourceName, this.writeConnectionId);
        if (this.prefix != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.prefix);
            sb.append(entry);
            entry = sb.toString();
        }
        writeLog(entry);
    }

    protected abstract void writeLog(String message);


    public void setQueryLogEntryCreator(QueryLogEntryCreator queryLogEntryCreator) {
        this.queryLogEntryCreator = queryLogEntryCreator;
    }

    public QueryLogEntryCreator getQueryLogEntryCreator() {
        return queryLogEntryCreator;
    }

    /**

     */
    public void setWriteDataSourceName(boolean writeDataSourceName) {
        this.writeDataSourceName = writeDataSourceName;
    }

    /**

     */
    public void setWriteConnectionId(boolean writeConnectionId) {
        this.writeConnectionId = writeConnectionId;
    }
}
