package org.demo.springjdbc.dao;

import java.util.List;

import org.demo.springjdbc.model.Customer;
public interface CustomerDao {
	public List<Customer> getAllCustomers();
	public Customer createCustomer(Customer customer);
	public List<Customer> getCustomerById(int i);
	public void deleteCustomerById(int i);
	public void updateCustomer(int id, String fname, String lname);
}
