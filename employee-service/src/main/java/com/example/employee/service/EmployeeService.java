package com.example.employee.service;

import java.util.Optional;

import com.example.employee.model.Employee;

public interface EmployeeService {

	Object createEmployee(Employee employee);

	Optional<Employee> getEmployeeById(int id);

}
