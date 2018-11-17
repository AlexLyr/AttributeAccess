package com.ursip.dsproxy.proxy;

import com.ursip.dsproxy.ConnectionInfo;
import com.ursip.dsproxy.DataSourceProxyException;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Factory to create {@link RepeatableReadResultSetProxyLogic}.
 *
 * @author Lyrchikov Alexander
 * @author Liam Williams

 */
public class RepeatableReadResultSetProxyLogicFactory implements ResultSetProxyLogicFactory {

    @Override
    public ResultSetProxyLogic create(ResultSet resultSet, ConnectionInfo connectionInfo, ProxyConfig proxyConfig) {
        Map<String, Integer> columnNameToIndex = columnNameToIndex(resultSet);
        return RepeatableReadResultSetProxyLogic.Builder.create()
                .resultSet(resultSet)
                .connectionInfo(connectionInfo)
                .proxyConfig(proxyConfig)
                .columnNameToIndex(columnNameToIndex)
                .columnCount(columnNameToIndex.size())
                .build();
    }

    private Map<String, Integer> columnNameToIndex(ResultSet resultSet) {
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            Map<String, Integer> columnNameToIndex = new HashMap<String, Integer>();
            for (int i = 1; i <= columnCount; i++) {
                columnNameToIndex.put(metaData.getColumnLabel(i).toUpperCase(), i);
            }
            return columnNameToIndex;
        } catch (SQLException e) {
            throw new DataSourceProxyException("Failed to obtain resultset metadata", e);
        }
    }

}
