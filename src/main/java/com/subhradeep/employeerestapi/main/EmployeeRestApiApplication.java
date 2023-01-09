package com.subhradeep.employeerestapi.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class EmployeeRestApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmployeeRestApiApplication.class, args);
	}
}
