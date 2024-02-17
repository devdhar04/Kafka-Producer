package com.hive.app.kafka;

public interface KafkaConfiguration {

	String TOPIC_NAME = "cpu-topic";

	String SERVER_URL = "localhost:9092";

	String KEY = "org.apache.kafka.common.serialization.StringSerializer";

	String VALUE = "org.apache.kafka.common.serialization.StringSerializer";

}
