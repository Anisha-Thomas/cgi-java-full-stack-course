package com.employee.dao;

import java.sql.SQLException;
import java.util.List;

import com.employee.model.Employee;

public interface EmployeeDao {

	Employee createEmployee(Employee employee) throws SQLException;

	List<Employee> findEmployee(int empId) throws SQLException;

	void updateEmployee(int id, String fname, String lname, String cemail) throws SQLException;

	void deleteEmployee(int employeeId) throws SQLException;
	
	List<Employee> getAllEmployee() throws SQLException;
}
