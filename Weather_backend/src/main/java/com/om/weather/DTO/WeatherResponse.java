package com.om.weather.DTO;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class WeatherResponse {


    private Location location;

    private Current current;



    @Getter
    @Setter
    public static class Location {

        private String name;

    }




    @Getter
    @Setter
    public static class Current {


        private double temp_c;


        private int humidity;


        private Condition condition;


    }




    @Getter
    @Setter
    public static class Condition {


        private String text;

    }

}