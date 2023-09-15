package com.transport.controller;


import com.transport.entity.Employee;
import com.transport.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees/{name}")
    public List<Employee> getemployeeByName(@PathVariable String name) {
    	
        log.info("Getting employee by name {} ", name);
        List employeeList = employeeService.getEmployeeByName(name);
        log.info("Received {} employees by name {}", employeeList.size(), name);
        return employeeList;
    }




    @PostMapping("/employees/save")
    public Employee addemployee(@RequestBody Employee employee) {
        log.info("Adding user {} to the Database", employee.getFirstName());
        return employeeService.addEmployee(employee);
    }
}
