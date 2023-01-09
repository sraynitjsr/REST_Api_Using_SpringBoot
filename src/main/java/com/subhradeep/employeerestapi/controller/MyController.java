package com.subhradeep.employeerestapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.subhradeep.employeerestapi.entities.Employee;
import com.subhradeep.employeerestapi.services.EmployeeService;

@RestController
public class MyController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public String home( ) {
		return "Welcome to Employee Management System";
	}

	@GetMapping("/employees")
	public ArrayList<Employee> getEmploees() {
		return this.employeeService.getEmployees();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable String employeeId) {
		return this.employeeService.getEmployee(Long.parseLong(employeeId));
	}

	@PostMapping(path="/employees",consumes="application/json")
	public void addEmployee(@RequestBody Employee emp) {
		this.employeeService.addEmployee(emp);
	}

	@PutMapping("/employees/{employeeId}")
	public boolean updateEmployeeDescription(@PathVariable String employeeId, @RequestBody String description) {
		return this.employeeService.updateDescription(Long.parseLong(employeeId), description);
	}

	@DeleteMapping("/employees/{employeeId}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable String employeeId) {
		if(this.employeeService.deleteEmployee(Long.parseLong(employeeId))) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

