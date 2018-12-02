package com.ursip.dsproxy.transform;

import java.sql.Statement;

/**
 * No operation implementation of {@link ParameterTransformer}.
 *
 * @author Lyrchikov Alexander

 */
public class NoOpParameterTransformer implements ParameterTransformer {

    public Statement transformParametersAndGetStatement(ParameterReplacer replacer, TransformInfo transformInfo, Statement ps) {
        return ps;
    }
}
