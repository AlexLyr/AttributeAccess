package com.ursip.dsproxy.listener;

/**
 * Callback listener for JDBC API method invocations.
 *
 * @author Lyrchikov Alexander

 */
public interface MethodExecutionListener {

    MethodExecutionListener DEFAULT = new NoOpMethodExecutionListener();

    void beforeMethod(MethodExecutionContext executionContext);

    void afterMethod(MethodExecutionContext executionContext);

}
