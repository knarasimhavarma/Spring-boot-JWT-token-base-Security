package com.example.varma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.varma.dao.EmployeeRepository;
import com.example.varma.dto.EmployeeProject;
import com.example.varma.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepo;


	public Employee save(Employee employee) {
		return empRepo.save(employee);
	}


	public List<Employee> getAll() {
		return empRepo.findAll();
	}


	public List<EmployeeProject> employeeProjects() {
		return empRepo.employeeProjects();
	}

}