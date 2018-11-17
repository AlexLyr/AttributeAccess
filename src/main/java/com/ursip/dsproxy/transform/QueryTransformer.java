package com.ursip.dsproxy.transform;

/**
 * Interceptor that can transform the query statement.
 *
 * @author Lyrchikov Alexander

 */
public interface QueryTransformer {

    static QueryTransformer DEFAULT = new NoOpQueryTransformer();

    String transformQuery(TransformInfo transformInfo);
}
