package com.example.demo.service;

import com.example.demo.model.Hotel;
import com.example.demo.mongoDB.MongoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.*;


@Service
public class HotelService {
    @Value("${password}")
    private String password;
    @Value("${protocol}")
    private String protocol;
    @Value("${database}")
    private String database;
    @Value("${cluster}")
    private String cluster;
    @Value("${hostname}")
    private String hostname;
    @Value("${retryWrite}")
    private String retryWrite;


    public List<Hotel> findByCity(String city) throws Exception {
        try (MongoDB mongoDB = new MongoDB(password, protocol, database, cluster, hostname, retryWrite)){
            return mongoDB.hotel.find(eq("city", city)).into(new ArrayList<>());

        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new Exception("Couldn't connect to db");
    }

}
