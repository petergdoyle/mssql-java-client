# mssql-java-client
A simple java utility to test the ability to connect to a mssql database


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

**Required** 
- Java JRE 7 or later 

**Recommended** (for Windows users) but not required 
- GitBash https://git-for-windows.github.io 

A pre-built bundling of all the executables and dependencies is available for download at the follow location http://streamworksnode0.westus.cloudapp.azure.com/downloads/mssql-java-client-binaries.zip
**Note:** this still requires that a minimum of Java JRE 7 is installed 
If you need to install java then follow directions here: http://www.oracle.com/technetwork/java/javase/downloads/index.html 

If you are builing from source then the following are required to be installed on your build machine
- Java JDK 7+ (not just a JRE) **Note:** follow the links from the java download site specifically for installing the Java JDK for your operating system 
- Maven 3+ follow the instructions provided at the Maven website https://maven.apache.org/install.html 



**Test Java **
If you are on Windows then open a Command Prompt or better yet install GitBash and open up a GitBash session.
```
c:\Users\winuser> java -version
java version "1.8.0_141"
Java(TM) SE Runtime Environment (build 1.8.0_141-b16)
Java Hotspot(TM) 64-Bit Server VM (build 25.141-b16, mixed mode) 
```
**Note: **If you are on Windows and this command fails but you believe that Java is installed then follow the directions [here](http://www.wikihow.com/Compile-%26-Run-Java-Program-Using-Command-Prompt) about adding the ```java``` executable to your %PATH%

If you are on Linux (or GitBash), you know what to do.
```
[vagrant@mssql-client ~]$ java -version
openjdk version "1.8.0_141"
OpenJDK Runtime Environment (build 1.8.0_141-b16)
OpenJDK 64-Bit Server VM (build 25.141-b16, mixed mode)
```

### Build the Code

### Run the Code

The code will attempt to make a connection to the mssql database using a default jdbc-connection string that is built by either reading a properties file you provide OR you can provide the jdbc connection string you provide. 
**If you want to provide a properties file to use with the default jdbc-connection string**, you will need to provide the values via the properties file. The program will than substitue the values you provide and substitute them into the default jdbc-connection string
```
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

```
There is a properties file template you can edit and fill in the specifics this is located in the directory where you either built or unpacked the code. It is called ```mssql.properties``` and has the following dummy property values in it:
```
mssql.uri=jdbc:sqlserver://yourserver.database.windows.net:1433
mssql.database=AdventureWorks
mssql.user=yourusername@yourserver
mssql.password=yourpassword
mssql.encrypt=true
mssql.trustServerCertificate=true 
mssql.hostNameInCertificate=*.database.windows.net
mssql.loginTimeout=30

```
The resulting jdbc-connection string used by the application to connect to the database would then look like this
```
jdbc:sqlserver://yourserver.database.windows.net:1433;database=AdventureWorks;user=yourusername@yourserver;password=yourpassword;encrypt=true;trustServerCertificate=true ;hostNameInCertificate=*.database.windows.net;loginTimeout=30;
```

So to run the application with the properties file provided, change the required property values in ```mssql.properties``` to the appropriate values for your target database and run the command like this from a command prompt or shell 
```
$ java -jar target/MSSQLClient-1.0-SNAPSHOT.jar -Fmssql.properties
```



**If you want to provide a jdbc-connection string explicitly**, then run the application by providing the complete and valid jdbc-connection string making sure you enclose it in double-quotes
```
$ java -jar target/MSSQLClient-1.0-SNAPSHOT.jar "jdbc:sqlserver://yourserver.database.windows.net:1433;database=AdventureWorks;user=yourusername@yourserver;password=yourpassword;encrypt=true;trustServerCertificate=true ;hostNameInCertificate=*.database.windows.net;loginTimeout=30;"
```
#### Failures
The purpose of the application is to test successful connections to a mssql database, so if you cannot connect you will see something like this
```
Program running. Attempting to connect:
jdbc connection string: jdbc:sqlserver://yourserver.database.windows.net:1433;database=AdventureWorks;user=yourusername@yourserver;password=yourpassword;encrypt=true;trustServerCertificate=true ;hostNameInCertificate=*.database.windows.net;loginTimeout=30;
Error: Cannot connect to database
com.microsoft.sqlserver.jdbc.SQLServerException: Login failed for user 'yourusername@yourserver'. ClientConnectionId:c3c3cf00-f74a-48f1-8b21-32d45ce0d9d3
	at com.microsoft.sqlserver.jdbc.SQLServerException.makeFromDatabaseError(SQLServerException.java:258)
	at com.microsoft.sqlserver.jdbc.TDSTokenHandler.onEOF(tdsparser.java:256)
	at com.microsoft.sqlserver.jdbc.TDSParser.parse(tdsparser.java:108)
	at com.microsoft.sqlserver.jdbc.SQLServerConnection.sendLogon(SQLServerConnection.java:4290)
	at com.microsoft.sqlserver.jdbc.SQLServerConnection.logon(SQLServerConnection.java:3157)
	at com.microsoft.sqlserver.jdbc.SQLServerConnection.access$100(SQLServerConnection.java:82)
	at com.microsoft.sqlserver.jdbc.SQLServerConnection$LogonCommand.doExecute(SQLServerConnection.java:3121)
	at com.microsoft.sqlserver.jdbc.TDSCommand.execute(IOBuffer.java:7151)
	at com.microsoft.sqlserver.jdbc.SQLServerConnection.executeCommand(SQLServerConnection.java:2478)
	at com.microsoft.sqlserver.jdbc.SQLServerConnection.connectHelper(SQLServerConnection.java:2026)
	at com.microsoft.sqlserver.jdbc.SQLServerConnection.login(SQLServerConnection.java:1687)
	at com.microsoft.sqlserver.jdbc.SQLServerConnection.connectInternal(SQLServerConnection.java:1528)
	at com.microsoft.sqlserver.jdbc.SQLServerConnection.connect(SQLServerConnection.java:866)
	at com.microsoft.sqlserver.jdbc.SQLServerDriver.connect(SQLServerDriver.java:569)
	at java.sql.DriverManager.getConnection(DriverManager.java:664)
	at java.sql.DriverManager.getConnection(DriverManager.java:270)
	at com.travelport.util.mssql.ConnectionProvider.connect(ConnectionProvider.java:24)
	at com.travelport.util.mssql.ConnectionProviderRunner.main(ConnectionProviderRunner.java:101)
```

#### Successes 
If you connect successfully you should see something like this
```
Program running. Attempting to connect:
jdbc connection string: jdbc:sqlserver://yourserver.database.windows.net:1433;database=AdventureWorks;user=yourusername@yourserver;password=yourpassword;encrypt=true;trustServerCertificate=true ;hostNameInCertificate=*.database.windows.net;loginTimeout=30;
"Connection Successful!"
```



#### Resources
- Microsoft JDBC Driver for SQL Server https://docs.microsoft.com/en-us/sql/connect/jdbc/microsoft-jdbc-driver-for-sql-server
- Connecting with SSL Encryption https://docs.microsoft.com/en-us/sql/connect/jdbc/connecting-with-ssl-encryption 
