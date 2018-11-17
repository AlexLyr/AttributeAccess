package com.ursip.dsproxy.listener.logging;

import com.ursip.dsproxy.support.CommonsLogUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Record executed query information using Commons-Logging.
 *
 * @author Lyrchikov Alexander
 */
public class CommonsQueryLoggingListener extends AbstractQueryLoggingListener {

    protected Log log = LogFactory.getLog(CommonsQueryLoggingListener.class);
    protected CommonsLogLevel logLevel = CommonsLogLevel.DEBUG; // default DEBUG


    public CommonsQueryLoggingListener() {

        // initialize logging condition that checks current log level
        this.loggingCondition = new LoggingCondition() {
            @Override
            public boolean getAsBoolean() {
                switch (logLevel) {
                    case DEBUG:
                        return log.isDebugEnabled();
                    case ERROR:
                        return log.isErrorEnabled();
                    case FATAL:
                        return log.isFatalEnabled();
                    case INFO:
                        return log.isInfoEnabled();
                    case TRACE:
                        return log.isTraceEnabled();
                    case WARN:
                        return log.isWarnEnabled();
                }
                return false;
            }
        };

    }

    @Override
    protected void writeLog(String message) {
        CommonsLogUtils.writeLog(log, this.logLevel, message);
    }

    public void setLogLevel(CommonsLogLevel logLevel) {
        this.logLevel = logLevel;
    }

    /**
     * @deprecated use {{@link #setLog(String)}}
     */
    @Override
    @Deprecated
    protected void resetLogger(String loggerName) {
        this.log = LogFactory.getLog(loggerName);
    }

    /**
     * Override {@link Log} instance with specified log name.
     *
     * @param logName log name

     */
    public void setLog(String logName) {
        this.log = LogFactory.getLog(logName);
    }

    /**
     * Override {@link Log} instance.
     *
     * @param log new log instance

     */
    public void setLog(Log log) {
        this.log = log;
    }

    /**
     * @return log

     */
    public Log getLog() {
        return log;
    }

    /**
     * @return log level to write

     */
    public CommonsLogLevel getLogLevel() {
        return logLevel;
    }

}
