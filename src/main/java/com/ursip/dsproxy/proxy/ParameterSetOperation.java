package com.ursip.dsproxy.proxy;

import java.lang.reflect.Method;

/**
 * Keeps a method and its arguments when parameter-set-method is called.
 *
 * @author Lyrchikov Alexander
 * @see com.ursip.dsproxy.proxy.jdk.PreparedStatementInvocationHandler

 */
public class ParameterSetOperation {

    /**
     * Check the given operation is {@link java.sql.CallableStatement#registerOutParameter} method by method name.
     *
     * @param operation a parameter set operation
     * @return true if it is a {@code registerOutParameter} operation

     */
    public static boolean isRegisterOutParameterOperation(ParameterSetOperation operation) {
        String methodName = operation.getMethod().getName();
        return StatementMethodNames.PARAMETER_METHOD_REGISTER_OUT_PARAMETER.equals(methodName);
    }

    /**
     * Check the given operation is {@code setNull} method by method name.
     *
     * @param operation a parameter set operation
     * @return true if it is a {@code setNull} operation

     */
    public static boolean isSetNullParameterOperation(ParameterSetOperation operation) {
        String methodName = operation.getMethod().getName();
        return StatementMethodNames.PARAMETER_METHOD_SET_NULL.equals(methodName);
    }

    private Method method;
    private Object[] args;

    public ParameterSetOperation() {
    }

    public ParameterSetOperation(Method method, Object[] args) {
        this.method = method;
        this.args = args;
    }


    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
