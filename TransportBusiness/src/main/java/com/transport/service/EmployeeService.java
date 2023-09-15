package com.transport.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.transport.entity.Employee;
import com.transport.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;



    public List<Employee> getEmployeeByName(String name) {
        //log.info("Getting Employee {} from the repository.", name);

        List<Employee> employeeList = employeeRepository.findByName(name);

        if (CollectionUtils.isEmpty(employeeList)) {
            //log.info("No Employee found by name {}", name);
            return new ArrayList<Employee>();
        }
        //log.info("found {} Employee by name {}", employeeList.size(), name);
        return employeeList;
    }






    public Employee addEmployee(Employee employee) {
        //log.info("Adding Employee {} to database", employee.getName());
        Employee employee2 = employeeRepository.insert(employee);
        //log.info("Added Employee {} successfully", customer2.getName());
        return employee2;
    }
}
