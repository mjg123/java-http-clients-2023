package com.twilio;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class NasaApodService {

    private final WebClient webClient;

    public NasaApodService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.nasa.gov/planetary/apod").build();
    }

    public Mono<NasaApodResponse> getNasaApod(String apiKey) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("api_key", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(NasaApodResponse.class);
    }
}
