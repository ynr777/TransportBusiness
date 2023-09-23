package com.transport.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
public class Employee {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String role;
    private int age;
    private Long salary;
    private List<String> vendors;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime updatedDate;
    private String createdUser;
    private String updatedUser;
	private boolean activeFlag = true;

}
