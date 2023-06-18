package com.example.employee.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.employee.model.Employee;
import com.example.employee.repo.EmployeeRepo;

@Service
public class EmployeeServiceImp implements EmployeeService {

	public final EmployeeRepo empRepo;
	
	public EmployeeServiceImp(EmployeeRepo empRepo) {
		super();
		this.empRepo = empRepo;
	}

	@Override
	public Object createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return empRepo.save(employee);
	}

	@Override
	public Optional<Employee> getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return empRepo.findById(id);
	}
}
