package com.ursip.dsproxy.listener;

/**
 * No-op implementation of {@link MethodExecutionListener}
 *
 * @author Lyrchikov Alexander

 */
public class NoOpMethodExecutionListener implements MethodExecutionListener {

    @Override
    public void beforeMethod(MethodExecutionContext executionContext) {
        // no-op
    }

    @Override
    public void afterMethod(MethodExecutionContext executionContext) {
        // no-op
    }

}
