package com.ursip.dsproxy.transform;

import java.sql.Statement;

/**
 * @author Lyrchikov Alexander

 */
public interface ParameterTransformer {

    static ParameterTransformer DEFAULT = new NoOpParameterTransformer();

    Statement transformParametersAndGetStatement(ParameterReplacer replacer, TransformInfo transformInfo,Statement ps);
}
