package com.om.weather.Controller;


import com.om.weather.DTO.WeatherDto;
import com.om.weather.Service.WeatherService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public String hello(HttpServletRequest request ) {
        return "hello "+ request.getSession().getId();
    }


    // GET live weather from Weather API
    @GetMapping("/{city}")
    public WeatherDto getWeather(
            @PathVariable String city) {


        return weatherService.getWeather(city);

    }

    // POST save weather in database
    @PostMapping
    public WeatherDto saveWeather(
            @Valid @RequestBody WeatherDto dto) {


        return weatherService.saveWeather(dto);

    }


}