Лабораторная работа №3 по курсу "Разработка параллельных и распределенных программ".
Запуск:
hadoop fs -copyFromLocal 664600583_T_ONTIME_sample.csv
hadoop fs -copyFromLocal L_AIRPORT_ID.csv
export HADOOP_CLASSPATH=target/spark-examples-1.0-SNAPSHOT.jar
spark-submit --class AirportApp --master yarn-client --num-executors 3 target/spark-examples-1.0-SNAPSHOT.jar 664600583_T_ONTIME_sample.csv L_AIRPORT_ID.csv output
hadoop fs -copyToLocal output/

