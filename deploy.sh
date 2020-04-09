#!/bin/bash

REPOSITORY=/home/pi/app/step1
PROJECT_NAME=freelec-springboot2-webservice

cd $REPOSITORY/$PROJECT_NAME/

echo ":::::::::: Git Pull"

git pull

echo ":::::::::: start project build"

./gradlew build

echo ":::::::::: move step1 directory"

cd $REPOSITORY

echo ":::::::::: copy build files"

cp $REPOSITORY/$PROJECT_NAME/build/libs/*.jar $REPOSITORY/

echo ":::::::::: check running application pid"

CURRENT_PID=$(pgrep -f ${PROJECT_NAME}*.jar)

echo ":::::::::: running application pid : $CURRENT_PID"

if [ -z "$CURRENT_PID" ]; then
 echo ":::::::::: didn't exit because not exist running application"
else
 echo ":::::::::: kill -15 $CURRENT_PID"
 kill -15 $CURRENT_PID
 sleep 5
fi

echo ":::::::::: deploy new application"

JAR_NAME=$(ls -tr $REPOSITORY/ | grep *.jar | tail -n 1)

echo ":::::::::: JAR name : $JAR_NAME"

nohup java -jar $REPOSITORY/$JAR_NAME 2>&1 &
