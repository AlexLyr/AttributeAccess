package com.ursip.dsproxy.support;

import com.ursip.dsproxy.QueryCountHolder;

import javax.servlet.*;
import java.io.IOException;

/**
 * Servlet filter to clear the {@link com.ursip.dsproxy.QueryCount} stored in thread local at the end of the
 * http servlet request lifecycle when {@link com.ursip.dsproxy.listener.DataSourceQueryCountListener} is used.
 *
 * @author Lyrchikov Alexander
 * @see QueryCounterClearHandlerInterceptor
 * @see QueryCounterClearServletRequestListener
 */
public class QueryCounterClearFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);

        QueryCountHolder.clear();
    }

    public void destroy() {
    }
}
