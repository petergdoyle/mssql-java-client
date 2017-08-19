/*
 */
package com.travelport.util.mssql;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;

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
