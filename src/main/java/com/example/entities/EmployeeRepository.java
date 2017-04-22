package com.example.entities;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by trainer20 on 4/20/17.
 */
public interface EmployeeRepository extends CrudRepository<Employee,Long> {

    Employee findByUsername(String username);

}
