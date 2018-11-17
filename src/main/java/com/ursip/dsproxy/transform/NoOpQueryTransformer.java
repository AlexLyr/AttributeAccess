package com.ursip.dsproxy.transform;

/**
 * No operation implementation of {@link QueryTransformer}.
 *
 * @author Lyrchikov Alexander

 */
public class NoOpQueryTransformer implements QueryTransformer {
    public String transformQuery(TransformInfo transformInfo) {
        return transformInfo.getQuery();
    }
}
