package com.hive.app.controller;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.hive.app.kafka.KafkaConfiguration;
import com.hive.app.kafka.KafkaProducerPropertiesBuilder;
import com.hive.app.network.ApiEndPoint;
import com.hive.app.network.HttpClient;
import com.hive.app.network.Request;

public class ReportingService {

    private final HttpClient httpClient;
    
    private KafkaProducerPropertiesBuilder props;

    public ReportingService() {

        this.httpClient = new HttpClient();
        props = new KafkaProducerPropertiesBuilder.Builder()
    	        .bootstrapServers(KafkaConfiguration.SERVER_URL)
    	        .keySerializer(KafkaConfiguration.KEY)
    	        .valueSerializer(KafkaConfiguration.VALUE)
    	        .build();
    }

    public void reportCPUUsage(String clientId, String groupId,double cpuUsage) {
        Request data = new Request(clientId, groupId, cpuUsage);
        sendMessage(data);
        //httpClient.postData(ApiEndPoint.ENDPOINT_SEND_REPORT, data);
    }
    
    private void sendMessage(Request request) {

         KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props.getProperties());
         
         ProducerRecord<String, String> pr = new ProducerRecord<>(KafkaConfiguration.TOPIC_NAME, "key", request.toString());
         producer.send(pr);
         producer.close();
    }
}