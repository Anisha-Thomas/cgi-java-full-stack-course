package org.demo.springjdbc.service;

import java.util.List;

import org.demo.springjdbc.dao.CustomerDao;
import org.demo.springjdbc.model.Customer;
import org.springframework.stereotype.Component;
@Component("customerService")
public class CustomerServiceImp implements CustomerService {

private CustomerDao customerDao = null;
	

	public  CustomerServiceImp(CustomerDao customerDao) {

		this.customerDao = customerDao;
	}


	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerDao.getAllCustomers();
	}

	public Customer createCustomer(Customer customer) {
		return customerDao.createCustomer(customer);
	}


	@Override
	public List<Customer> getCustomerById(int i) {
		return customerDao.getCustomerById(i);
		
	}
	public void deleteCustomerById(int i) {
		 customerDao.deleteCustomerById(i);
	}
	public void updateCustomer(int id, String fname, String lname) {
		customerDao.updateCustomer(id, fname, lname);
	}
}
