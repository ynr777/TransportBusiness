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

	@GetMapping("/employee/{name}")
	public List<Employee> getEmployeeByName(@PathVariable String name) {

		log.info("Getting employee by name {} ", name);
		List employeeList = employeeService.getEmployeeByName(name);
		log.info("Received {} employees by name {}", employeeList.size(), name);
		return employeeList;
	}

	@GetMapping("/employee")
	public List<Employee> getEmployees() {

		log.info("Getting employees ");
		List employeeList = employeeService.getEmployees();
		log.info("Received {} employees ", employeeList.size());
		return employeeList;
	}

	@GetMapping("/employee/{userId}/{password}")
	public Employee getEmployeeBylogin(@PathVariable String userId, @PathVariable String password) {

		log.info("Getting employee ");
		Employee employee = employeeService.findByLogin(userId, password);
		log.info("Received employee");
		return employee;
	}

	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		log.info("Adding user {} to the Database", employee.getFirstName());
		return employeeService.addEmployee(employee);
	}

	@PutMapping("/employee/{id}")
	public Employee editEmployee(@PathVariable String id, @RequestBody Employee employee) {
		log.info("Adding user {} to the Database", employee.getFirstName());
		return employeeService.editEmployee(id, employee);
	}
}
