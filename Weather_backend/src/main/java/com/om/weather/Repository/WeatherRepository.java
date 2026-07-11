package com.om.weather.Repository;

import com.om.weather.Model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather,Integer> {
}
