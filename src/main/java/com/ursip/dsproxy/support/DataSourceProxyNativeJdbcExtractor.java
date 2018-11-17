package com.ursip.dsproxy.support;

import com.ursip.dsproxy.proxy.NativeJdbcExtractUtils;
import org.springframework.jdbc.support.nativejdbc.NativeJdbcExtractor;
import org.springframework.jdbc.support.nativejdbc.NativeJdbcExtractorAdapter;

import java.sql.*;

/**
 * Spring NativeJdbcExtractor for our proxy classes.
 *
 * <p>If delegating extractor is specified, after unwrapping our proxy, delegating
 * extractor will be applied.
 *
 * @author Lyrchikov Alexander
 */
public class DataSourceProxyNativeJdbcExtractor extends NativeJdbcExtractorAdapter {

    private NativeJdbcExtractor delegate;

    @Override
    protected Connection doGetNativeConnection(Connection con) throws SQLException {
        Connection connection = NativeJdbcExtractUtils.getConnection(con);
        if (delegate != null) {
            connection = delegate.getNativeConnection(connection);
        }
        return connection;
    }

    @Override
    public Statement getNativeStatement(Statement stmt) throws SQLException {
        Statement statement = NativeJdbcExtractUtils.getStatement(stmt);
        if (delegate != null) {
            statement = delegate.getNativeStatement(statement);
        }
        return statement;
    }

    @Override
    public PreparedStatement getNativePreparedStatement(PreparedStatement ps) throws SQLException {
        PreparedStatement preparedStatement = NativeJdbcExtractUtils.getPreparedStatement(ps);
        if (delegate != null) {
            preparedStatement = delegate.getNativePreparedStatement(preparedStatement);
        }
        return preparedStatement;
    }

    @Override
    public CallableStatement getNativeCallableStatement(CallableStatement cs) throws SQLException {
        CallableStatement callableStatement = NativeJdbcExtractUtils.getCallableStatement(cs);
        if (delegate != null) {
            callableStatement = delegate.getNativeCallableStatement(callableStatement);
        }
        return callableStatement;
    }

    public void setDelegate(NativeJdbcExtractor delegate) {
        this.delegate = delegate;
    }
}
