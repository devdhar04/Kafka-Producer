package com.hive.app.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.hive.app.kafka.KafkaConfiguration;
import com.hive.app.kafka.KafkaProducerPropertiesBuilder;
import com.hive.app.model.CpuUsageViewModel;

public class Client {
	
	static final String DB_URL = "jdbc:mysql://localhost/";
    static final String USER = "root";
    static final String PASS = "root1234";
    
    public static void main(String[] args) throws Exception {
        // Client ID, replace with actual client ID
    	String clientId = "client1";
        String groupId = "groupId";
        // Server URL to report CPU usage
        //DbService.init();
        
//        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//                Statement stmt = conn.createStatement();
//             ) {		      
//                String sql = "CREATE DATABASE cpu_usage";
//                //stmt.executeUpdate(sql);
//                System.out.println("Database created successfully...");   	  
//             } catch (SQLException e) {
//                e.printStackTrace();
//             } 

        
        
        CpuUsageViewModel viewModel = new CpuUsageViewModel();
        double cpuUsage = new  CpuUsage().getCpuUsage();
        viewModel.reportCPUUsage(clientId,groupId, cpuUsage);
        System.out.println("sending Data");
        //new Client().initKafka();
    }
    
    private void initKafka() {
    	KafkaProducerPropertiesBuilder props = new KafkaProducerPropertiesBuilder.Builder()
    	        .bootstrapServers(KafkaConfiguration.SERVER_URL)
    	        .keySerializer(KafkaConfiguration.KEY)
    	        .valueSerializer(KafkaConfiguration.VALUE)
    	        .build();

         
         KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props.getProperties());
         
         ProducerRecord<String, String> pr = new ProducerRecord<>(KafkaConfiguration.TOPIC_NAME, "key", "Test Value");
         producer.send(pr);
         producer.close();
    }
}