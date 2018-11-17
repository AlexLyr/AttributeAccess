package com.ursip.dsproxy.listener.logging;

import com.ursip.dsproxy.ExecutionInfo;
import com.ursip.dsproxy.QueryInfo;
import com.ursip.dsproxy.listener.QueryExecutionListener;

import java.util.List;

/**
 * @author Lyrchikov Alexander

 */
public abstract class AbstractQueryLoggingListener implements QueryExecutionListener {

    protected QueryLogEntryCreator queryLogEntryCreator = new DefaultQueryLogEntryCreator();
    protected boolean writeDataSourceName = true;
    protected boolean writeConnectionId = true;
    protected LoggingCondition loggingCondition;

    @Override
    public void beforeQuery(ExecutionInfo execInfo, List<QueryInfo> queryInfoList) {
    }

    @Override
    public void afterQuery(ExecutionInfo execInfo, List<QueryInfo> queryInfoList) {
        // only perform logging logic when the condition returns true
        if (this.loggingCondition.getAsBoolean()) {
            final String entry = getEntry(execInfo, queryInfoList);
            writeLog(entry);
        }
    }

    protected String getEntry(ExecutionInfo execInfo, List<QueryInfo> queryInfoList) {
        return this.queryLogEntryCreator.getLogEntry(execInfo, queryInfoList, this.writeDataSourceName, this.writeConnectionId);
    }

    protected abstract void writeLog(String message);

    /**
     * Specify logger name.
     *
     * @param loggerName logger name

     * @deprecated use <code>setLog(String)</code> or <code>setLogger(String)</code>
     */
    @Deprecated
    public void setLoggerName(String loggerName) {
        resetLogger(loggerName);
    }

    /**
     * Callback method to reset the logger object in concrete class when log name is specified.
     *
     * @param loggerName logger name

     * @deprecated use <code>setLog(String)</code> or <code>setLogger(String)</code>
     */
    @Deprecated
    protected void resetLogger(String loggerName) {
    }

    public void setQueryLogEntryCreator(QueryLogEntryCreator queryLogEntryCreator) {
        this.queryLogEntryCreator = queryLogEntryCreator;
    }

    /**
     * @return query log entry creator

     */
    public QueryLogEntryCreator getQueryLogEntryCreator() {
        return queryLogEntryCreator;
    }

    public void setWriteDataSourceName(boolean writeDataSourceName) {
        this.writeDataSourceName = writeDataSourceName;
    }

    /**

     */
    public void setWriteConnectionId(boolean writeConnectionId) {
        this.writeConnectionId = writeConnectionId;
    }

    /**
     * A boolean supplier that determines whether to perform logging logic.
     *
     * @param loggingCondition boolean supplier

     */
    public void setLoggingCondition(LoggingCondition loggingCondition) {
        this.loggingCondition = loggingCondition;
    }
}
