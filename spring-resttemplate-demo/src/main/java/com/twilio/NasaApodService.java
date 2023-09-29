package com.twilio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NasaApodService {

    private final RestTemplate restTemplate;

    @Autowired
    public NasaApodService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public NasaApodResponse getNasaApod(String apiKey) {
        String apiUrl = "https://api.nasa.gov/planetary/apod?api_key=" + apiKey;
        ResponseEntity<NasaApodResponse> responseEntity = restTemplate.getForEntity(apiUrl, NasaApodResponse.class);
        return responseEntity.getBody();
    }
}
