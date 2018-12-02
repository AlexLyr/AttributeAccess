package com.ursip.dsproxy.ursiplogic;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {
    private static final String[] TYPES = {"TABLE", "VIEW"};

    public static List<String> getAllTableNames(DatabaseMetaData metaData) {
        List<String> listOfTables = new ArrayList<String>();
        try {
            ResultSet rs = metaData.getTables(null, null, "%", TYPES);
            while (rs.next()) {
                String tableName = rs.getString(3);
                listOfTables.add(tableName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfTables;
    }

    public static List<String> getColumnsOfTable(DatabaseMetaData metaData, String tableName){
        List<String> columns = new ArrayList<String>();
        try {
            ResultSet rs = metaData.getColumns(null, null, tableName, null);
            while (rs.next()) {
                String column = rs.getString("COLUMN_NAME");
                columns.add(column);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return columns;
    }


}
