package com.transport.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.transport.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

    List<Employee> findByName(String name);
    List<Employee> findByRole(String role);

}
