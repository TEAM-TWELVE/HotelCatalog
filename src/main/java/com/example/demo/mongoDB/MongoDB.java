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

    private String password;

    private String protocol;

    private String database;

    private String cluster;

    private String hostname;

    private String retryWrite;
    private MongoClient mongoClient;

    public MongoCollection<Hotel> hotel;

    public MongoDB(String password, String protocol, String database, String cluster, String hostname, String retryWrite) {
        this.password = password;
        this.protocol = protocol;
        this.database = database;
        this.cluster = cluster;
        this.hostname = hostname;
        this.retryWrite = retryWrite;

        ConnectionString connectionString = new ConnectionString(protocol + cluster + password + hostname + database + retryWrite);
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).codecRegistry(codecRegistry).build();
        mongoClient = MongoClients.create(clientSettings);
        hotel = mongoClient.getDatabase("hoteldb").getCollection("hotels", Hotel.class);

    }

    public MongoDB() {
    }

    @Override
    public void close() throws Exception {
        logger.info("close called.");
        mongoClient.close();
        logger.info("Connection closed.");
    }
}
