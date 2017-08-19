#!/bin/sh

cd ..
zip -r mssql-java-client/mssql-java-client-binaries.zip --exclude=*sqljdbc_6.0.zip --exclude=*.git*  --exclude=*.vagrant* mssql-java-client/
cd -
