package com.example.demo.mongoDB;


import com.example.demo.model.Hotel;
import com.example.demo.service.HotelService;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.apache.log4j.Logger;

public class MongoDB implements AutoCloseable {

    private final Logger logger = Logger.getLogger(MongoDB.class);



    private MongoClient mongoClient;

    public MongoCollection<Hotel> hotel;

    public MongoDB() {

    }
    public void connectToDB(String urlString){
        ConnectionString connectionString = new ConnectionString(urlString);
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).codecRegistry(codecRegistry).build();
        mongoClient = MongoClients.create(clientSettings);
        hotel = mongoClient.getDatabase("hoteldb").getCollection("hotels", Hotel.class);
    }


    @Override
    public void close() throws Exception {
        logger.info("close called.");
        mongoClient.close();
        logger.info("Connection closed.");
    }
}
