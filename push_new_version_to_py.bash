#!/usr/bin/env bash
set -e
MLAF_DIR=/Users/Auke/Documents/School/1718/MSDA/mlaf-java/
CASESTUDY_DIR=/Users/Auke/Documents/School/1718/MSDA/casestudy/
TARGET=pi@10.0.0.215:/home/pi/

cd $MLAF_DIR
mvn install

cd $CASESTUDY_DIR
mvn package

echo "Copying to target $TARGET"
scp target/mlaf-casestudy-1.0-SNAPSHOT-jar-with-dependencies.jar $TARGET
echo "Done"