package com.demo.dao;

import java.sql.SQLException;
import java.util.List;

import com.demo.model.Customer;

public interface CustomerDao {

	public Customer createCustomer(Customer customer) throws SQLException;

	public List<Customer> getAllCustomer() throws SQLException;

	public void deleteCustomer(int customerId) throws SQLException;

	public void updateCustomer(int id, String fname, String lname, String cemail) throws SQLException;

	public List<Customer> findCustomer(int customerId) throws SQLException;
}
