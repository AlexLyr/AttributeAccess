package com.ursip.dsproxy.ursiplogic;


import com.ursip.dsproxy.proxy.ParameterKey;
import com.ursip.dsproxy.proxy.ParameterSetOperation;
import com.ursip.dsproxy.transform.ParameterReplacer;
import com.ursip.dsproxy.transform.TransformInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.UUID;

public class PolicyQueryFilter {

    Logger slf4jLogger = LoggerFactory.getLogger(this.getClass());

    private DataSource dataSource;
    private DatabaseMetaData metaData;
    private TransformInfo transformInfo;
    private ParameterReplacer parameterReplacer;
    private Statement statement;

    public PolicyQueryFilter(ParameterReplacer replacer, TransformInfo transformInfo,Statement ps, DataSource dataSource) {
        this.dataSource = dataSource;
        try {
            this.metaData = dataSource.getConnection().getMetaData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.parameterReplacer=replacer;
        this.statement = ps;
        this.transformInfo=transformInfo;
    }

    public void filterQuery() {
        DBUtility.getAllTableNames(metaData);
    }

    //TODO made the logic
    public  Statement createFilteredStatement(){
        slf4jLogger.info(statement.toString());
        try {
            PreparedStatement ps = dataSource.getConnection().prepareStatement("insert into organization_fl (id,first_name) values (?::uuid,?)");
            ps.setString(1,UUID.randomUUID().toString());
            ps.setString(2,"sdsds");
            return ps;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }
}
