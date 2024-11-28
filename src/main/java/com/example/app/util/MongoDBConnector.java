package com.example.app.util;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnector {
    private static MongoClient mongoClient;
    private static MongoDatabase database;

    private MongoDBConnector() {
        // Private constructor to prevent instantiation
    }

    public static MongoDatabase getDatabase() {
        if (database == null) {
            connect();
        }
        return database;
    }

    private static void connect() {
        try {
            mongoClient = MongoClients.create("mongodb+srv://chris:da_dawg@studybuddydbs.daex9.mongodb.net/?retryWrites=true&w=majority&appName=studybuddydbs"); // Replace with your connection string
            database = mongoClient.getDatabase("StudyBuddy"); // Replace with your database name
            System.out.println("Connected to MongoDB successfully!");
        } catch (Exception e) {
            e.printStackTrace(); // can ignore
            throw new RuntimeException("Failed to connect to MongoDB");
        }
    }

    public static void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}