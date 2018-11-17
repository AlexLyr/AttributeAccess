package com.ursip.dsproxy.support;

import javax.servlet.ServletRequestEvent;

/**
 * {@link javax.servlet.ServletRequestListener} to log query metrics per http request using {@link System#out}.
 *
 * @author Lyrchikov Alexander

 */
public class SystemOutQueryCountLoggingRequestListener extends AbstractQueryCountLoggingRequestListener {

    @Override
    protected void writeLog(ServletRequestEvent servletRequestEvent, String logEntry) {
        System.out.println(logEntry);
    }

}
