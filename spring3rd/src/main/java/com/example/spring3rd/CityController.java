package com.example.spring3rd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
    private int cityCode = 59;
    private String cityName = "Sai Gon";
    private String numberDist = "21";
    @GetMapping("/getcity")
    public City getCity() {
        return new City(cityCode, cityName, numberDist);
    }
}
