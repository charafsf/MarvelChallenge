package com.challenge.marvel.Marvel.Controller;

import com.challenge.marvel.Marvel.Service.MarvelApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api")
public class MarvelController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarvelController.class);
    @Autowired
    public MarvelApiService marvelApiService;


    @GetMapping(value = "", produces = "text/plain")
    public ResponseEntity<String> firstEndPoint() {

        LOGGER.info("I00 /First EndPoint Test ");
        return new ResponseEntity<String>("web service MarvelChallenge", HttpStatus.OK);
    }

    @GetMapping(value = "/characters", produces = "application/json")
    public ResponseEntity<String> get_List_personages_Marvel() {
        String url = "/characters";

        ResponseEntity<String> response = marvelApiService.searchMarvelCharacters();
        LOGGER.info("I01 /characters EndPoint ");
        return response;
    }
}
