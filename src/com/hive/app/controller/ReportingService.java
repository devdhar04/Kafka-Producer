package com.hive.app.controller;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.hive.app.kafka.KafkaConfiguration;
import com.hive.app.kafka.KafkaProducerPropertiesBuilder;
import com.hive.app.network.Request;

public class ReportingService implements ReportingInterface{

    private KafkaProducerPropertiesBuilder props;

    public ReportingService() {

        props = new KafkaProducerPropertiesBuilder.Builder()
    	        .bootstrapServers(KafkaConfiguration.SERVER_URL)
    	        .keySerializer(KafkaConfiguration.KEY)
    	        .valueSerializer(KafkaConfiguration.VALUE)
    	        .build();
    }

    @Override
    public void reportCPUUsage(String clientId, String groupId,double cpuUsage) {
        Request data = new Request(clientId, groupId, cpuUsage);
        sendMessage(data);
    }
    
    private void sendMessage(Request request) {

         KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props.getProperties());
         
         ProducerRecord<String, String> pr = new ProducerRecord<>(KafkaConfiguration.TOPIC_NAME, "key", request.toString());
         producer.send(pr);
         producer.close();
    }
}

interface ReportingInterface {
	
	public void reportCPUUsage(String clientId, String groupId,double cpuUsage);
}