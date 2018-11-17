package com.ursip.dsproxy.support;

import com.ursip.dsproxy.QueryCountHolder;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * {@link ServletRequestListener} to clear {@link com.ursip.dsproxy.QueryCount} stored in
 * thread local when {@link com.ursip.dsproxy.listener.DataSourceQueryCountListener} is used.
 *
 * @author Lyrchikov Alexander
 * @see QueryCounterClearFilter
 * @see QueryCounterClearHandlerInterceptor
 */
public class QueryCounterClearServletRequestListener implements ServletRequestListener {

    public void requestInitialized(ServletRequestEvent sre) {
    }

    public void requestDestroyed(ServletRequestEvent sre) {
        QueryCountHolder.clear();
    }

}
