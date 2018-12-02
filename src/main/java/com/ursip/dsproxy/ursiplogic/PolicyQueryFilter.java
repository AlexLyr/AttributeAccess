package com.ursip.dsproxy.ursiplogic;


import javax.sql.DataSource;

public class PolicyQueryFilter {

    private String query;
    private DataSource dataSource;

    public PolicyQueryFilter(String query, DataSource dataSource) {
        this.query = query;
        this.dataSource = dataSource;
    }

    public String filterQuery() {
        DBUtility.getAllTables(dataSource);
        return query;
    }
}
