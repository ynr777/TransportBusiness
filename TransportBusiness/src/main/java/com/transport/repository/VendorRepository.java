package com.transport.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.transport.entity.Employee;
import com.transport.entity.Vendor;

import java.sql.Date;
import java.util.List;

public interface VendorRepository extends MongoRepository<Vendor, String> {

    //List<Vendor> findByDate(Date date);
    //List<Vendor> findByRole(String role);

}
