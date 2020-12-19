package com.example.demo.service;

import com.example.demo.model.Hotel;
import com.example.demo.mongoDB.MongoDB;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


import static com.mongodb.client.model.Filters.eq;

@Service
public class HotelService {

    private final Logger logger = Logger.getLogger(HotelService.class);

    @Value("${connectionString}")
    private String connectionString;


    private MongoDB mongoDB = new MongoDB();

    public List<Hotel> findByCity(String city) throws Exception {
        logger.info("/ GET findByCity called.");
        try{
            mongoDB.connectToDB(connectionString);
            logger.info("Successfully entered try block with MongoDB connection established.");
            return mongoDB.hotel.find(eq("city", city)).into(new ArrayList<>());
        } catch (Exception e) {
            logger.error("Could not connect to MongoDB. Error message: " + e.getMessage(), e);
            throw new Exception("Couldn't connect to db", e);
        }
    }

}
