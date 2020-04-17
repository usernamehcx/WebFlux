package com.baeldung.webflux.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Weather {

    private String temprature;
    private String humidity;
    private String windSpeed;

}
