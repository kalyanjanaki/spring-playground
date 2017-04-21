package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by trainer20 on 4/20/17.
 */
@RestController
@RequestMapping("/employees")
public class EmployeesCotroller {

    @GetMapping("")
    public String getEmployees(){
        return "Super Secret List of employees";
    }
}
