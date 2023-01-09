package com.subhradeep.employeerestapi.services;

import java.util.ArrayList;

import com.subhradeep.employeerestapi.entities.Employee;

public interface EmployeeService {	
	public ArrayList<Employee> getEmployees();
	public Employee getEmployee(long employeeId);
	public void addEmployee(Employee emp);
	public void updateDescription(long empId, String description);
	public void deleteEmployee(long empId);
}
