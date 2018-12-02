package com.ursip.dsproxy.ursiplogic;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtility {
    private static final String[] TYPES = {"TABLE", "VIEW"};

    public static void getAllTables(DataSource dataSource) {
        try {
            DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
            ResultSet rs = metaData.getTables(null, null, "%", TYPES);
            while (rs.next()) {
                System.out.println(rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
