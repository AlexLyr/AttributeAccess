package com.ursip.dsproxy.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Lyrchikov Alexander
 */
public class MethodUtils {

    public static Object proceedExecution(Method method, Object target, Object[] args) throws Throwable {
        try {
            return method.invoke(target, args);
        }
        catch (InvocationTargetException ex) {
            throw ex.getTargetException();
        }
    }

}
