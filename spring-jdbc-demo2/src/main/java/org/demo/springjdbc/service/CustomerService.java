package org.demo.springjdbc.service;

import java.util.List;

import org.demo.springjdbc.model.Customer;

public interface CustomerService {
	public List<Customer> getAllCustomers(); 
	public Customer createCustomer(Customer customer);
	public List<Customer> getCustomerById(int i);
	public void deleteCustomerById(int i);
	public void updateCustomer(int id, String fname, String lname);
}
