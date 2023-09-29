package com.twilio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class NasaApodController {

    private final NasaApodService nasaApodService;

    @Autowired
    public NasaApodController(NasaApodService nasaApodService) {
        this.nasaApodService = nasaApodService;
    }

    @GetMapping("/nasa/apod")
    public Mono<NasaApodResponse> getNasaApod(@RequestParam("api-key") String apiKey) {
        return nasaApodService.getNasaApod(apiKey);
    }
}
