#!/bin/sh

echo -e "Sample Jdbc Connection String"
echo -e "jdbc:sqlserver://yourserver.database.windows.net:1433;database=AdventureWorks;user=yourusername@yourserver;password=yourpassword;encrypt=true;trustServerCertificate=true ;hostNameInCertificate=*.database.windows.net;loginTimeout=30;"
echo -e ""
echo -e ""

read -e -p "Please provide a Jdbc Connection String: " -i "$jdbc_connection_string" jdbc_connection_string
