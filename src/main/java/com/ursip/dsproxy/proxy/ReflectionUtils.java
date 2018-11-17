package com.ursip.dsproxy.proxy;

import java.lang.reflect.Method;

/**
 * @author Lyrchikov Alexander

 */
public class ReflectionUtils {

    public static Method getMethodIfAvailable(Class<?> clazz, String name, Class... parameterTypes) {
        try {
            return clazz.getMethod(name, parameterTypes);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

}
