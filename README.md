# Kafka communication between 2 microservices

### start windows(download [kafka.apache](https://kafka.apache.org/downloads))
bin\windows\zookeeper-server-start.bat config\zookeeper.properties
bin\windows\kafka-server-start.bat config\server.properties
### create topic
bin\windows\kafka-topics.bat --zookeeper localhost:2181 --topic newTopic --create --partitions 3 --replication-factor 1
### communicate:
bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic name
bin\windows\kafka-topic --zookeeper localhost:2181 --topic mytopic --describe

### list all topics
bin\windows\kafka-topic.bat –zookeeper localhost:2181 –list
### delete topic
bin\windows\kafka-topic.bat --zookeeper localhost:2181 --topic mytopic --delete
bin\windows\kafka-topics.bat --describe --zookeeper localhost:2181 --topic task

### read from file
 bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic test < test.txt
