package com.example;

import com.example.utils.OMDBService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by trainer20 on 4/16/17.
 */
@RestController
public class RestTemplateControler {

    private final OMDBService restservice;

    public RestTemplateControler(OMDBService restservice) {
        this.restservice = restservice;
    }

    @GetMapping("/movies")
    public String getOMDBDetails(@RequestParam String q){
        return this.restservice.getOMDB(q);
    }

}
