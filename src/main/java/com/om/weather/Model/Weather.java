package com.om.weather.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String city;
    private double temperature;
    private String condition;

    public Weather() {
    }

    public Weather(String city, double temperature, String condition) {
        this.city = city;
        this.temperature = temperature;
        this.condition = condition;
    }
}