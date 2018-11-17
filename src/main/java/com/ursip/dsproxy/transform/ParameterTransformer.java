package com.ursip.dsproxy.transform;

/**
 * @author Lyrchikov Alexander

 */
public interface ParameterTransformer {

    static ParameterTransformer DEFAULT = new NoOpParameterTransformer();

    void transformParameters(ParameterReplacer replacer, TransformInfo transformInfo);
}
