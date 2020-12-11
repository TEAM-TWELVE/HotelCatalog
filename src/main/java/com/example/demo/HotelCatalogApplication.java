package com.example.demo;

import com.example.demo.service.HotelService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBean;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication

public class HotelCatalogApplication {

    public static void main(String[] args) {

        SpringApplication.run(HotelCatalogApplication.class, args);

    }

}
