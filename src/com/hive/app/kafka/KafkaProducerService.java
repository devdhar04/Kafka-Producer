package com.hive.app.kafka;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class KafkaProducerService {

	private static KafkaProducerService instance;
	private final KafkaProducer<String, String> producer;

	private KafkaProducerService(Properties props) {
		this.producer = new KafkaProducer<>(props);
	}

	public static KafkaProducerService getInstance(Properties props) {
		if (instance == null) {
			synchronized (KafkaProducerService.class) {
				if (instance == null) {
					instance = new KafkaProducerService(props);
				}
			}
		}
		return instance;
	}

	public void sendMessage(String topic, String key, String value) {
		ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);
		producer.send(record, (metadata, exception) -> {
			if (exception != null) {
				System.err.println("Error sending message: " + exception.getMessage());
			} else {
				System.out.println("Message sent successfully: topic=" + metadata.topic() + ", partition="
						+ metadata.partition() + ", offset=" + metadata.offset());
			}
		});
	}

	public void close() {
		producer.flush();
		producer.close();
	}
}