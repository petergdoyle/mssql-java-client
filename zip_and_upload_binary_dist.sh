#!/bin/sh
if [ -f mssql-java-client-binaries.zip ]; then
  rm -fv mssql-java-client-binaries.zip
fi
cd ..
zip -r mssql-java-client/mssql-java-client-binaries.zip --exclude=*sqljdbc_6.0.zip --exclude=*.git*  --exclude=*.vagrant* mssql-java-client/
cd -
scp mssql-java-client-binaries.zip petergdoyle@streamworksnode0.westus.cloudapp.azure.com:
