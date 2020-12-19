package com.example.demo.controller;

import com.example.demo.model.Hotel;
import com.example.demo.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.log4j.Logger;
@RestController
@RequestMapping("/hotel")
public class HotelController {

    private final Logger logger = Logger.getLogger(HotelController.class);

    @Autowired
    private HotelService hotelService;

    @GetMapping("/{city}")
    public List<Hotel> findByCity(@PathVariable String city) throws Exception {
        logger.info("/city GET findByCity called.");
        var hotels = hotelService.findByCity(URLDecoder.decode(city, StandardCharsets.UTF_8));
        if(!hotels.isEmpty()){
            logger.info("hotels instance was NOT null.");
            return hotels;
        } else {
            logger.info("No hotels found in given city.");
            throw new Exception("No hotels in given city");
        }
    }
}
