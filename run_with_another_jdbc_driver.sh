#!/bin/sh

while true; do
  read -e -p "Please provide the location of the jdbc jar file: " -i "$jdbc_jar_file" jdbc_jar_file
  if [ -f $jdbc_jar_file ]; then
    break;
  else echo -e "Invalid file location provided."
  fi
done

. ./get_jdbc_connection_string.sh

classpath=".:"$jdbc_jar_file":target/MSSQLClient-1.0-SNAPSHOT.jar"

java -cp $classpath com.travelport.util.mssql.ConnectionProviderRunner $jdbc_connection_string
