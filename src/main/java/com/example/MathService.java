package com.example;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/math/volume/{l}/{w}/{h}")
    public String  returnVolume(@PathVariable("l") int length,@PathVariable("w") int width,@PathVariable("h") int height){

        return String.format("The volume of a %dx%dx%d rectangle is %d",length,width,height,(length*width*height));
    }

    @PostMapping("/math/area")
    public String returnArea(@RequestParam Map<String,String> params){

        Double Areac;
        Integer Arear;
        String Result;
        String type = params.get("type");
        int radius ;
        int width;
        int height;

        switch (type){
            case "circle":
                radius = Integer.parseInt(params.get("radius"));
                Areac = Math.PI * radius * radius;
                Result = String.format("Area of a circle with a radius of %d is %g",radius,Areac);
                break;
            case "rectangle":
                width = Integer.parseInt(params.get("width"));
                height = Integer.parseInt(params.get("height"));
                Arear = width * height;
                Result = String.format("Area of a %dx%d rectangle is %d",width,height,Arear);
                break;
            default:
                Result = "Invalid";
        }
        return Result;

    }
}
