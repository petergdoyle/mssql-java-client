/*
 */
package com.travelport.util.mssql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 */
public class ConnectionProvider {

    private final String connectionString;

    public ConnectionProvider(String connectionString) {
        this.connectionString = connectionString;
    }

    public Connection connect() throws SQLException {

        Connection connection = null;

        connection = DriverManager.getConnection(connectionString);

        return connection;
    }
}
