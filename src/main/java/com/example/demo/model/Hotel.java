package com.example.demo.model;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class Hotel {

    private ObjectId id;
    @BsonProperty(value = "name")
    private String name;
    @BsonProperty(value = "address")
    private String address;
    @BsonProperty(value = "stars")
    private int stars;
    @BsonProperty(value = "city")
    private String city;
    @BsonProperty(value = "country")
    private String country;

    public Hotel(String name, String address, int stars, String country) {
        super();
        this.name = name;
        this.address = address;
        this.stars = stars;
        this.city = city;
        this.country = country;
    }

    public Hotel() {
    }

    public ObjectId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getStars() {
        return stars;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", stars=" + stars +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
