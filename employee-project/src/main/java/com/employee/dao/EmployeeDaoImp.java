package com.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.employee.factory.MySqlConnectionFactory;
import com.employee.model.Employee;

public class EmployeeDaoImp implements EmployeeDao {
	private Connection connection = null;
	{
		try {
			connection = MySqlConnectionFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Employee createEmployee(Employee employee) throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement("insert into employee(employee_id,first_name,last_name,email) values(?,?,?,?)");
		preparedStatement.setInt(1, employee.getEmployeeId());
		preparedStatement.setString(2, employee.getfName());
		preparedStatement.setString(3, employee.getlName());
		preparedStatement.setString(4, employee.getEmail());
		preparedStatement.executeUpdate();
		return employee;
	}

	public List<Employee> getAllEmployee() throws SQLException {
		List<Employee> list = new ArrayList<Employee>();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from employee");
		while (resultSet.next()) {
			list.add(new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getString(4)));
		}
		return list;

	}

	public void deleteEmployee(int employeeId) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("delete from employee where employee_id=?");
		preparedStatement.setInt(1, employeeId);
		int count = preparedStatement.executeUpdate();
		if (count > 0) {
			System.out.println("Deleted the record with empoylee id " + employeeId);
		} else {
			System.out.println("No record found.........");
		}

	}

	@Override
	public void updateEmployee(int id, String fname, String lname, String cemail) throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement("update employee set first_name=? , last_name=? , email=? where employee_id=?");
		preparedStatement.setString(1, fname);
		preparedStatement.setString(2, lname);
		preparedStatement.setString(3, cemail);
		preparedStatement.setInt(4, id);
		int count = preparedStatement.executeUpdate();
		if (count > 0) {
			System.out.println("Updated Successfully........");
		} else {
			System.out.println("Updation failed........");
		}
	}

	@Override
	public List<Employee> findEmployee(int empId) throws SQLException {
		List<Employee> list = new ArrayList<Employee>();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from employee where employee_id= " +empId);		
			while (resultSet.next()) {
				list.add(new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4)));
			}
		return list;

	}
}
