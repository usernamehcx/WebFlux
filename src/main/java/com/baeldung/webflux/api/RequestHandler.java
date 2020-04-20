package com.baeldung.webflux.api;

import com.baeldung.webflux.model.NewStock;
import com.baeldung.webflux.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.baeldung.webflux.model.WeatherEvent;
import com.baeldung.webflux.service.WeatherService;
import reactor.core.publisher.Mono;

@Component
public class RequestHandler {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private StockService stockService;

    public Mono<ServerResponse> streamWeather(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(weatherService.streamWeather(), WeatherEvent.class);
    }

    public Mono<ServerResponse> streamStock(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .header("Access-Control-Allow-Origin", "http://localhost:3000")
                .header("Access-Control-Allow-Credentials", "true")
                .body(stockService.streamStock(), NewStock.class);
    }

}
