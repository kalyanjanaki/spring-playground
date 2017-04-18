package com.example.utils;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by trainer20 on 4/16/17.
 */
@Service
public class OMDBService {
    private final RestTemplate restTemplate = new RestTemplate();

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public String getOMDB(String queryParam){
        return restTemplate.getForObject("http://www.omdbapi.com/?s={param}",String.class,queryParam);
    }
}
