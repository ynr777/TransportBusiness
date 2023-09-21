package com.transport.entity;

import lombok.Data;

import java.util.List;

import org.springframework.data.annotation.Id;

@Data
public class Employee {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String role;
    private int age;
    private Long salary;
    private List<String> vendorId;

}
