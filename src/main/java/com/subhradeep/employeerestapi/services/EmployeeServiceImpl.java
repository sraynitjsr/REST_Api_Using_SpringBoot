package com.subhradeep.employeerestapi.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subhradeep.employeerestapi.dao.EmployeeDAO;
import com.subhradeep.employeerestapi.entities.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	public ArrayList<Employee> getEmployees() {
		return (ArrayList<Employee>) employeeDAO.findAll();
	}

	public Employee getEmployee(long employeeId) {
		return employeeDAO.getReferenceById(employeeId);
	}

	public void addEmployee(Employee emp) {
		employeeDAO.save(emp);
	}

	public boolean updateDescription(long empId, String description) {
		String title = this.getEmployee(empId).getTitle();
		try {
			employeeDAO.save(new Employee(empId, title, description));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean deleteEmployee(long empId) {
		String title = this.getEmployee(empId).getTitle();
		String descrip = this.getEmployee(empId).getDescription();
		try {
			employeeDAO.delete(new Employee(empId, title, descrip));
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}

