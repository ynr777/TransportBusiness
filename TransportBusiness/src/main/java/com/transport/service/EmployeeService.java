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
import java.util.Optional;

@Service
@Slf4j
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getEmployeeByName(String name) {
		// log.info("Getting Employee {} from the repository.", name);

		List<Employee> employeeList = employeeRepository.findByFirstName(name);

		if (CollectionUtils.isEmpty(employeeList)) {
			// log.info("No Employee found by name {}", name);
			return new ArrayList<Employee>();
		}
		// log.info("found {} Employee by name {}", employeeList.size(), name);
		return employeeList;
	}
	
	public List<Employee> getEmployees() {
		// log.info("Getting Employee {} from the repository.", name);

		List<Employee> employeeList = employeeRepository.findAll();

		if (CollectionUtils.isEmpty(employeeList)) {
			// log.info("No Employee found by name {}", name);
			return new ArrayList<Employee>();
		}
		// log.info("found {} Employee by name {}", employeeList.size(), name);
		return employeeList;
	}

	public Employee editEmployee(String id, Employee employee) {
		Optional<Employee> employeeData = employeeRepository.findById(id);
		Employee editEmployee = employeeData.get();
		editEmployee.setActiveFlag(false);
		employeeRepository.save(editEmployee);
		
		return employeeRepository.insert(employee);

	}

	public Employee addEmployee(Employee employee) {
		// log.info("Adding Employee {} to database", employee.getName());
		Employee employee2 = employeeRepository.insert(employee);
		// log.info("Added Employee {} successfully", customer2.getName());
		return employee2;
	}
}
