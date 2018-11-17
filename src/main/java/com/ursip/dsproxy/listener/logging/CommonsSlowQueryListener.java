package com.ursip.dsproxy.listener.logging;

import com.ursip.dsproxy.support.CommonsLogUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.TimeUnit;

/**
 * Log slow query using Commons-Logging.
 *
 * @author Lyrchikov Alexander

 */
public class CommonsSlowQueryListener extends AbstractSlowQueryLoggingListener {

    protected Log log = LogFactory.getLog(CommonsSlowQueryListener.class);
    protected CommonsLogLevel logLevel = CommonsLogLevel.WARN; // default WARN

    public CommonsSlowQueryListener() {
    }

    public CommonsSlowQueryListener(long threshold, TimeUnit thresholdTimeUnit) {
        this.threshold = threshold;
        this.thresholdTimeUnit = thresholdTimeUnit;
    }

    @Override
    protected void writeLog(String message) {
        CommonsLogUtils.writeLog(this.log, this.logLevel, message);
    }

    public void setLogLevel(CommonsLogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public void setLog(String logName) {
        setLog(LogFactory.getLog(logName));
    }

    public void setLog(Log log) {
        this.log = log;
    }

    public Log getLog() {
        return log;
    }

    public CommonsLogLevel getLogLevel() {
        return logLevel;
    }

}
