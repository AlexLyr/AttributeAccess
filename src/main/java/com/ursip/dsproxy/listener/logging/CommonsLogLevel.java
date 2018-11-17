package com.ursip.dsproxy.listener.logging;

/**
 * Apache Commons-Logging log level representation.
 *
 * @author Lyrchikov Alexander
 */
public enum CommonsLogLevel {
    // least serious to most serious
    TRACE, DEBUG, INFO, WARN, ERROR, FATAL;

    public static CommonsLogLevel nullSafeValueOf(String name) {
        if (name == null) {
            return null;
        }
        return valueOf(name);
    }
}
