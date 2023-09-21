package com.transport.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.transport.entity.Employee;

import java.util.List;

public interface DailyRegistryRepository extends MongoRepository<Employee, String> {

    List<Employee> findByFirstName(String firstName);
    List<Employee> findByRole(String role);

}
