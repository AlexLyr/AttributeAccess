package com.ursip.dsproxy.listener.logging;

/**
 * Strategy to decide whether to perform logging logic.
 *
 * TODO: replace with BooleanSupplier once it moves java8
 *
 * @author Lyrchikov Alexander
 * @see AbstractQueryLoggingListener

 */
public interface LoggingCondition {

    boolean getAsBoolean();

}
