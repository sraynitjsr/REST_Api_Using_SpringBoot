package com.subhradeep.employeerestapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subhradeep.employeerestapi.entities.Employee;
import com.subhradeep.employeerestapi.services.EmployeeService;

@RestController
public class MyController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String home( ) {
		return "Welcome to the home page";
	}

	@GetMapping("/employees")
	public ArrayList<Employee> getEmploees() {
		return employeeService.getEmployees();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmploees() {
	
	}
}
