package com.ursip.dsproxy.support;

/**
 * {@link org.springframework.web.servlet.HandlerInterceptor} to log query metrics to {@link System#out}.
 *
 * @author Lyrchikov Alexander

 */
public class SystemOutQueryCountLoggingHandlerInterceptor extends AbstractQueryCountLoggingHandlerInterceptor {
    @Override
    protected void writeLog(String logEntry) {
        System.out.println(logEntry);
    }
}
