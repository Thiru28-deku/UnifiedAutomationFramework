package com.utf.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.utf.enums.ConfigProperties;
import com.utf.utils.ConfigUtils;

public final class DBClient {

    private DBClient() {
    }

    private static Connection connection;

    public static Connection getConnection() throws Exception {
        if (connection == null || connection.isClosed()) {
            Class.forName(ConfigUtils.get(ConfigProperties.DBDRIVER));
            connection = DriverManager.getConnection(
                ConfigUtils.get(ConfigProperties.DBURL),
                ConfigUtils.get(ConfigProperties.DBUSERNAME),
                ConfigUtils.get(ConfigProperties.DBPASSWORD)
            );
        }
        return connection;
    }

    public static ResultSet executeQuery(String query) throws Exception {
        Statement stmt = getConnection().createStatement();
        return stmt.executeQuery(query);
    }

    public static int executeUpdate(String query) throws Exception {
        Statement stmt = getConnection().createStatement();
        return stmt.executeUpdate(query);
    }

    public static void closeConnection() throws Exception {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            connection = null;
        }
    }
}