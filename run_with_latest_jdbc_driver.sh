#!/bin/sh
cd $(dirname $0)
. ./get_jdbc_connection_string.sh

classpath=`.:target/lib/mssql-jdbc-6.2.1.jre8.jar:target/MSSQLClient-1.0-SNAPSHOT.jar`
java -cp $classpath com.travelport.util.mssql.ConnectionProviderRunner $jdbc_connection_string
