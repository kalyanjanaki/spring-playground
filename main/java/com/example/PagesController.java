package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by trainer20 on 3/29/17.
 */
@RestController
public class PagesController {

    @GetMapping("/hello")
    public String SayHello()
    {
        return "Hello World";
    }
}
