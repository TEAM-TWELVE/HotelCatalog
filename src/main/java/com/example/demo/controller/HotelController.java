package com.example.demo.controller;

import com.example.demo.model.Hotel;
import com.example.demo.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/{city}")
    public List<Hotel> findByCity(@PathVariable String city) throws Exception {
        var hotels = hotelService.findByCity(city);
        if(!hotels.isEmpty()){
            return hotels;
        }else {
            throw new Exception("No hotels in given city");
        }
    }
}
