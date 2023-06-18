package com.example.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
