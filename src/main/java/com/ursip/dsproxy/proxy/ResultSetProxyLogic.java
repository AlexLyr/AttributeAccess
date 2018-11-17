package com.ursip.dsproxy.proxy;

import java.lang.reflect.Method;

/**
 * Proxy logic for {@link java.sql.ResultSet}.
 *
 * @author Lyrchikov Alexander

 */
public interface ResultSetProxyLogic {

    Object invoke(Method method, Object[] args) throws Throwable;

}
