package com.hive.app.db;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoClients;

public class MongoDBManager {
    private MongoClient mongoClient;
    private MongoDatabase database;

    public MongoDBManager(String connectionString) {
    	//new ConnectionS
    	mongoClient = MongoClients.create(new ConnectionString("mongodb://0.0.0.0"));
    
    	MongoIterable<String> databaseNames = mongoClient.listDatabaseNames();
        System.out.println("Available databases:");
        for (String dbName : databaseNames) {
            System.out.println(dbName);
        }
    }

    public void connectToDatabase(String databaseName) {
        database = mongoClient.getDatabase(databaseName);
    }

    public MongoCollection<Document> getCollection(String collectionName) {
        return database.getCollection(collectionName);
    }

    public void close() {
        mongoClient.close();
    }
}
