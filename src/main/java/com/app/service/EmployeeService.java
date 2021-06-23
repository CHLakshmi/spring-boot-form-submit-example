package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Bills;
import com.app.model.Employee;
import com.app.model.Students;
import com.app.repository.BillsRepository;
import com.app.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;

	public Employee findByNameAndPassword(String name, String password) {
		Optional<Employee> employee = repository.findByNameAndPassword(name,password);
		return employee.get();
	}


}
