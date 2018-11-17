package com.ursip.dsproxy.support;

import com.ursip.dsproxy.QueryCountHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Spring {@link org.springframework.web.servlet.HandlerInterceptor} to clear {@link com.ursip.dsproxy.QueryCount}
 * stored in thread local when {@link com.ursip.dsproxy.listener.DataSourceQueryCountListener} is used.
 *
 * @author Lyrchikov Alexander
 * @see QueryCounterClearFilter
 * @see QueryCounterClearServletRequestListener
 */
public class QueryCounterClearHandlerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        QueryCountHolder.clear();
    }

}