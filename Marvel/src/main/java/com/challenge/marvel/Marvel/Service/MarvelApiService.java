package com.challenge.marvel.Marvel.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class MarvelApiService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarvelApiService.class);
    @Value("${webservice.url}")
    String urlApi;

    public ResponseEntity<String> searchMarvelCharacters() {
        try {
            WebClient webClient = WebClient.builder()
                    .baseUrl(urlApi)
                    .build();

            String requete = webClient
                    .get()
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            return new ResponseEntity<>(requete, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Erreur " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }

    }
}
