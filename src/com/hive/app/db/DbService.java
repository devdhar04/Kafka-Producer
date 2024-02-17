package com.hive.app.db;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public class DbService {
	
	
	public static void init() {
		
		MongoDBManager mongoDBManager = new MongoDBManager("mongodb://localhost:27017");
	    System.out.println("Connected to MongoDB server");

        try {
            // Connect to the database
        	 
            mongoDBManager.connectToDatabase("cpu-usage");

            // Get collection (equivalent to a table in relational databases)
            MongoCollection<Document> collection = mongoDBManager.getCollection("cpu-usage");

            // Create a document (equivalent to a row in relational databases)
            Document document = new Document("clientId", "clientId")
                    .append("groupId", "groupId")
                    .append("cpuUsage", 2.47)
                    .append("timestamp", System.currentTimeMillis());

            // Insert the document into the collection
            collection.insertOne(document);

            System.out.println("Document inserted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close MongoDBManager instance
            mongoDBManager.close();
        }
	}

}
