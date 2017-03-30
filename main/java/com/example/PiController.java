package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by trainer20 on 3/30/17.
 */
@RestController
public class PiController {

    @GetMapping("/math/pi")
    public String GetPI(){
        return "3.141592653589793";
    }
}
