package com.subhradeep.employeerestapi.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.subhradeep.employeerestapi.entities.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	ArrayList<Employee> employees;
	
	public EmployeeServiceImpl() {
		employees = new ArrayList<>();
		employees.add(new Employee(1, "SDE-1", "LLD"));
		employees.add(new Employee(2, "SDE-2", "HLD"));
		employees.add(new Employee(3, "SDE-3", "LLD & HLD"));
	}
	
	public ArrayList<Employee> getEmployees() {
		return this.employees;
	}

	public Employee getEmployee(long employeeId) {
		Employee temp = null;
		for(Employee emp:this.employees) {
			if(emp.getId() == employeeId) {
				temp = emp;
				break;
			}
		}
		return temp;
	}
	
	public void addEmployee(Employee emp) {
		this.employees.add(emp);
	}
	
	public boolean updateDescription(long empId, String description) {
		boolean flag = false;
		for(Employee emp:this.employees) {
			if(emp.getId() == empId) {
				emp.setDescription(description);
				flag = true;
			}
		}
		return flag;
	}

	public void deleteEmployee(long empId) {
		for(Employee emp:this.employees) {
			if(emp.getId() == empId) {
				this.employees.remove(emp);
			}
		}
	}
}

