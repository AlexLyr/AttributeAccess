package com.ursip.dsproxy.listener.logging;

import com.ursip.dsproxy.proxy.ParameterSetOperation;

/**
 * Convert setNull parameter operation.
 *
 * @author Lyrchikov Alexander

 */
public class SetNullParameterValueConverter implements ParameterValueConverter {

    @Override
    public String getValue(ParameterSetOperation param) {
        Integer sqlType = (Integer) param.getArgs()[1];  // second arg for setNull is always int
        return getDisplayValue(sqlType);
    }

    public String getDisplayValue(Integer sqlType) {

        String sqlTypeName = ParameterValueConverter.SQL_TYPENAME_BY_CODE.get(sqlType);

        StringBuilder sb = new StringBuilder();
        sb.append("NULL");
        if (sqlTypeName != null) {
            sb.append("(" + sqlTypeName + ")");
        }
        return sb.toString();
    }


}
