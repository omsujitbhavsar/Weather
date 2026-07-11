package com.om.weather.Service;


import com.om.weather.DTO.WeatherDto;
import com.om.weather.DTO.WeatherResponse;
import com.om.weather.Model.Weather;
import com.om.weather.Repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;



@Service
public class WeatherService {



    @Autowired
    private WebClient webClient;


    @Autowired
    private WeatherRepository weatherRepository;



    @Value("${weather.api.key}")
    private String apiKey;



    // GET live weather
    public WeatherDto getWeather(String city) {


        WeatherResponse response =
                webClient.get()

                        .uri(uriBuilder -> uriBuilder
                                .scheme("https")
                                .host("api.weatherapi.com")
                                .path("/v1/current.json")
                                .queryParam("key", apiKey)
                                .queryParam("q", city)
                                .build()
                        )

                        .retrieve()

                        .bodyToMono(WeatherResponse.class)

                        .block();



        WeatherDto dto = new WeatherDto();


        dto.setCity(
                response.getLocation().getName()
        );


        dto.setTemperature(
                response.getCurrent().getTemp_c()
        );


        dto.setCondition(
                response.getCurrent()
                        .getCondition()
                        .getText()
        );


        return dto;

    }




    // POST save weather
    public WeatherDto saveWeather(WeatherDto dto) {


        Weather weather = new Weather();


        weather.setCity(dto.getCity());

        weather.setTemperature(
                dto.getTemperature()
        );

        weather.setCondition(
                dto.getCondition()
        );


        Weather saved =
                weatherRepository.save(weather);



        WeatherDto result = new WeatherDto();


        result.setCity(saved.getCity());

        result.setTemperature(
                saved.getTemperature()
        );

        result.setCondition(
                saved.getCondition()
        );


        return result;

    }

}