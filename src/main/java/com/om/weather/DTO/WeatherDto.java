package com.om.weather.DTO;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class WeatherDto {

    private String city;
    private double temperature;
    private String condition;


}