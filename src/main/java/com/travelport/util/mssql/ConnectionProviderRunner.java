/*
 */
package com.travelport.util.mssql;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;

/**
 *
 * @author 
 */
public class ConnectionProviderRunner {

    private static final String USAGE_MSG = "Usage: java [JVM_OPTION]... -jar target/MSSQLClient-1.0-SNAPSHOT.jar <mssql.properties>";
    
    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println(USAGE_MSG);
            System.exit(1);
        }

        String mssqlPropsFn = args[0];
        File file = new File(mssqlPropsFn);
        if (!file.exists()) {
            System.out.printf("Error: File file specified as %s does not exist. Please supply a valid mssql.properties file name\n", mssqlPropsFn);
            System.out.println(USAGE_MSG);
            System.exit(1);
        }

        Properties mssqlProps = new Properties();
        InputStream input;
        try {
            input = new FileInputStream(mssqlPropsFn);
            mssqlProps.load(input);
        } catch (Exception ex) {
            System.out.printf("Error: File file specified as %s cannot be opened. Please supply a valid mssql.properties file\n", mssqlPropsFn);
            System.out.println(USAGE_MSG);
            ex.printStackTrace();
            System.exit(1);
        }

        Enumeration<?> e = mssqlProps.propertyNames();
        int requiredPropertyCount = 8;
        int propertyCount = 0;
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            String value = mssqlProps.getProperty(key);
//            System.out.printf("%s=%s\n", key, value);
            propertyCount++;
        }
        String samplePropertiesFile = "mssql.uri=jdbc:sqlserver://yourserver.database.windows.net:1433\n"
                + "mssql.database=AdventureWorks\n"
                + "mssql.user=yourusername@yourserver\n"
                + "mssql.password=yourpassword\n"
                + "mssql.encrypt=true\n"
                + "mssql.trustServerCertificate=false\n"
                + "mssql.hostNameInCertificate=*.database.windows.net\n"
                + "mssql.loginTimeout=30";
        if (propertyCount != requiredPropertyCount) {
            System.out.printf("Error: File file specified as %s does not contain %d properties. Please supply a valid mssql.properties file\n", mssqlPropsFn, requiredPropertyCount);
            System.out.printf("Sample Properties\n%s\n\n", samplePropertiesFile);
            System.out.println(USAGE_MSG);
            System.exit(1);
        }

        String connectionString = String.format("%s;"
                + "database=%s;"
                + "user=%s;"
                + "password=%s;"
                + "encrypt=%s;"
                + "trustServerCertificate=%s;"
                + "hostNameInCertificate=%s;"
                + "loginTimeout=%s;",
                mssqlProps.getProperty("mssql.uri"),
                mssqlProps.getProperty("mssql.database"),
                mssqlProps.getProperty("mssql.user"),
                mssqlProps.getProperty("mssql.password"),
                mssqlProps.getProperty("mssql.encrypt"),
                mssqlProps.getProperty("mssql.trustServerCertificate"),
                mssqlProps.getProperty("mssql.hostNameInCertificate"),
                mssqlProps.getProperty("mssql.loginTimeout"));

        System.out.println("Program running. Attempting to connect:");
        System.out.printf("jdbc connection string: %s\n", connectionString);

        try {
            Connection connection = new ConnectionProvider(connectionString).connect();
            System.out.println("Connection Successful!");
            System.out.println(connection);
        } catch (SQLException ex) {
            System.out.println("Error: Cannot connect to database");
            ex.printStackTrace();
        }

    }

}
