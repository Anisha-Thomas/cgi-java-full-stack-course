package org.demo.springjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.demo.springjdbc.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("customerDao")
public class CustomerDaoImp implements CustomerDao {

	private final DataSource dataSource;

	@Autowired
	public CustomerDaoImp(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> list = new ArrayList<Customer>();
		try {
			Connection connection = dataSource.getConnection();
			Statement statment = connection.createStatement();
			ResultSet result = statment.executeQuery("select * from customer");
			while (result.next()) {
				list.add(new Customer(result.getInt(1), result.getString(2), result.getString(3)));
			}

		} catch (Exception e) {
			e.getStackTrace();
		}

		return list;
	}

	@Override
	public Customer createCustomer(Customer customer) {

		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into customer(customer_id,first_name,last_name) values(?,?,?)");
			preparedStatement.setInt(1, customer.getCustomerId());
			preparedStatement.setString(2, customer.getFirstName());
			preparedStatement.setString(3, customer.getLastName());
			preparedStatement.executeUpdate();
			System.out.println("Inserted Successfully.......");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public List<Customer> getCustomerById(int i) {
		List<Customer> list = new ArrayList<Customer>();
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement result = connection.prepareStatement("SELECT * FROM customer where customer_id=?");
			result.setInt(1, i);
			ResultSet resultList=result.executeQuery();
			while (resultList.next()) {
				list.add(new Customer(resultList.getInt(1), resultList.getString(2), resultList.getString(3)));
			}

		} catch (Exception e) {
			e.getStackTrace();
		}
		return list;
		
	}

	@Override
	public void deleteCustomerById(int i) {
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from customer where customer_id=?");
			preparedStatement.setInt(1, i);
			preparedStatement.execute();
			System.out.println("Customer Deleted Successfully....");
		}catch (Exception e) {
			e.getStackTrace();
		}
		
	}

	@Override
	public void updateCustomer(int id, String fname, String lname) {
		
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("update customer set first_name=?,last_name=? where customer_id=?");
			preparedStatement.setString(1, fname);
			preparedStatement.setString(2, lname);
			preparedStatement.setInt(3, id);
			preparedStatement.executeUpdate();
			System.out.println("Customer Updated Successfully....");
		}catch (Exception e) {
			e.getStackTrace();
		}
	}

}
