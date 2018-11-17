package com.ursip.dsproxy.support;

import com.ursip.dsproxy.listener.logging.CommonsLogLevel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Spring {@link org.springframework.web.servlet.HandlerInterceptor} to log the query metrics during a http request
 * lifecycle using Apache Commons Logging.
 *
 * @author Lyrchikov Alexander
 * @see CommonsQueryCountLoggingServletFilter
 * @see CommonsQueryCountLoggingRequestListener
 */
public class CommonsQueryCountLoggingHandlerInterceptor extends AbstractQueryCountLoggingHandlerInterceptor {

    private Log log = LogFactory.getLog(CommonsQueryCountLoggingHandlerInterceptor.class);
    private CommonsLogLevel logLevel = CommonsLogLevel.DEBUG;

    public CommonsQueryCountLoggingHandlerInterceptor() {
    }

    public CommonsQueryCountLoggingHandlerInterceptor(CommonsLogLevel logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    protected void writeLog(String logEntry) {
        CommonsLogUtils.writeLog(log, logLevel, logEntry);
    }

    public void setLogLevel(CommonsLogLevel logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    protected void resetLogger(String loggerName) {
        this.log = LogFactory.getLog(loggerName);
    }

    /**
     * Override {@link Log} instance.
     *
     * @param log new log instance

     */
    public void setLog(Log log) {
        this.log = log;
    }

}
