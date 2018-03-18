#!/bin/bash

cd `dirname $0`
cd ../db # move to project directory

echo "+++++++++++++++++++++++++++++++++++++++"
echo "Start to initialize local database..."
echo "+++++++++++++++++++++++++++++++++++++++"
../gradlew :flywayClean :flywayMigrate -i
