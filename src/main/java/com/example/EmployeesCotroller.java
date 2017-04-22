package com.example;

import com.example.entities.Employee;
import com.example.entities.EmployeeRepository;
import com.example.entities.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by trainer20 on 4/20/17.
 */
@RestController
public class EmployeesCotroller {

    private final EmployeeRepository employeeRepository;

    public EmployeesCotroller(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/admin/employees")
    @JsonView(Views.SalaryView.class)
    public Iterable<Employee> getEmpList(){
        return this.employeeRepository.findAll();
    }
    @GetMapping("/employees")
    @JsonView(Views.NonSalaryView.class)
    public Iterable<Employee>  getEmployees(){
        return this.employeeRepository.findAll();
    }
}
