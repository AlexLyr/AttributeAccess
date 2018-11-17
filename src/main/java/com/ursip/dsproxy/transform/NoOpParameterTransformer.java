package com.ursip.dsproxy.transform;

/**
 * No operation implementation of {@link ParameterTransformer}.
 *
 * @author Lyrchikov Alexander

 */
public class NoOpParameterTransformer implements ParameterTransformer {

    public void transformParameters(ParameterReplacer replacer, TransformInfo transformInfo) {
        // do nothing
    }
}
