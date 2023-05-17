package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.factory.MySqlConnectionFactory;
import com.demo.model.Customer;
import java.sql.Statement;

public class CustomerDaoImp implements CustomerDao {
	private Connection connection = null;
	{
		try {
			connection = MySqlConnectionFactory.getMySqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Customer createCustomer(Customer customer) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("insert into customer values(?,?,?,?)");
		preparedStatement.setInt(1, customer.customerId);
		preparedStatement.setString(2, customer.firstName);
		preparedStatement.setString(3, customer.lastName);
		preparedStatement.setString(4, customer.email);
		preparedStatement.executeUpdate();
		return customer;

	}

	public List<Customer> getAllCustomer() throws SQLException {
		List<Customer> list = new ArrayList<Customer>();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from customer");
		while (resultSet.next()) {
			list.add(new Customer(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getString(4)));
		}
		return list;

	}

	public void deleteCustomer(int customerId) throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement("delete from customer where customer_id=?" + customerId);
		preparedStatement.setInt(1, customerId);
		int count = preparedStatement.executeUpdate();
		if (count > 0) {
			System.out.println("Deleted the record with customer id " + customerId);
		} else {
			System.out.println("No record found.........");
		}

	}

	@Override
	public void updateCustomer(int id, String fname, String lname, String cemail) throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement("update customer set first_name=? , last_name=? , email=? where customer_id=?");
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
	public List<Customer> findCustomer(int customerId) throws SQLException {
		List<Customer> list = new ArrayList<Customer>();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from customer where customer_id= "+customerId);
		
		while (resultSet.next()) {
			list.add(new Customer(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getString(4)));
		}
		
		return list;
		
	}
}
