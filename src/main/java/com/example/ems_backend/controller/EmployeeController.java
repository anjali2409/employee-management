package com.example.ems_backend.controller;

import com.example.ems_backend.dto.EmployeeDto;
import com.example.ems_backend.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
//once we annotate a class with ADD rest control annotation then this class becomes a
//spring M rest controllers and this class is capable to handle HTTP request
@RestController
//request mapping to define the base URL for all the rest apis that we are going to build within this controller
@RequestMapping("/api/employees")

public class EmployeeController {
    private EmployeeService employeeService;

    //Build Add Employee Rest Api
    @PostMapping // to map the incoming HTTP post request to this method
//    creating rest API using spring boot is very simple first we need to create a method and then we'll make that
//    method as a rest API by using spring annotations
// this annotation will extract the Json from the HTTP request & it will convert that Json in into employee Dto Java object
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

}
