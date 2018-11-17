package com.ursip.dsproxy.support;

import com.ursip.dsproxy.listener.logging.SLF4JLogLevel;
import org.slf4j.Logger;

/**
 * @author Lyrchikov Alexander
 */
public class SLF4JLogUtils {

    public static void writeLog(Logger logger, SLF4JLogLevel logLevel, String message) {
        switch (logLevel) {
            case DEBUG:
                logger.debug(message);
                break;
            case ERROR:
                logger.error(message);
                break;
            case INFO:
                logger.info(message);
                break;
            case TRACE:
                logger.trace(message);
                break;
            case WARN:
                logger.warn(message);
                break;
        }
    }

}
