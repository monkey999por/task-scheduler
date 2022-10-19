pushd %~dp0

java -jar target\task-scheduler-0.0.1-SNAPSHOT-jar-with-dependencies.jar task-scheduler.properties

pause
exit 0