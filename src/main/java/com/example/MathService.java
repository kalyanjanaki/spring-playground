package com.example;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by trainer20 on 3/30/17.
 */
@RestController
public class MathService {

    @GetMapping("/math/calculate")
    public String returnResult(@RequestParam(value = "operation", defaultValue = "add") String operation,
                               @RequestParam Integer x,@RequestParam Integer y){
        String result;
        switch(operation){
            case "add":
                result =  Integer.toString(x + y);
                break;
            case "subtract":
                result = Integer.toString(x - y);
                break;
            case "multiply":
                result = Integer.toString(x * y);
                break;
            case "divide":
                result = Integer.toString(x / y);
                break;
            default:
                result = Integer.toString(x + y);

        }
        return  result;
    }

    @PostMapping("/math/sum")
    public String returnSum(@RequestParam(value ="n") Integer[] values){

        Integer result = 0;
        for (int i : values){
            result  += i;
        }
        return Integer.toString(result);
    }
}
