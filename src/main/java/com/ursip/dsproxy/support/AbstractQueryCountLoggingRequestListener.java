package com.ursip.dsproxy.support;

import com.ursip.dsproxy.QueryCount;
import com.ursip.dsproxy.QueryCountHolder;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import java.util.Collections;
import java.util.List;

/**
 * @author Lyrchikov Alexander

 */
public abstract class AbstractQueryCountLoggingRequestListener implements ServletRequestListener {
    private QueryCountLogEntryCreator logFormatter = new DefaultQueryCountLogEntryCreator();
    private boolean writeAsJson = false;

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        // No-op
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

        List<String> dsNames = QueryCountHolder.getDataSourceNamesAsList();
        Collections.sort(dsNames);

        for (String dsName : dsNames) {
            QueryCount count = QueryCountHolder.get(dsName);
            String logEntry;
            if (this.writeAsJson) {
                logEntry = logFormatter.getLogMessageAsJson(dsName, count);
            } else {
                logEntry = logFormatter.getLogMessage(dsName, count);
            }
            writeLog(sre, logEntry);
        }

        QueryCountHolder.clear();
    }

    protected abstract void writeLog(ServletRequestEvent servletRequestEvent, String logEntry);

    public void setLogFormatter(QueryCountLogEntryCreator logFormatter) {
        this.logFormatter = logFormatter;
    }

    public void setWriteAsJson(boolean writeAsJson) {
        this.writeAsJson = writeAsJson;
    }

}
