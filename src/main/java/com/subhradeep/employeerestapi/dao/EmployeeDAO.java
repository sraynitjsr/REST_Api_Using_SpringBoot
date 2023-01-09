package com.subhradeep.employeerestapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.subhradeep.employeerestapi.entities.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Long> {
	
}
