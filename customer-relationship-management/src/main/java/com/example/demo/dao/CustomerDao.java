package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;

@Repository
public interface CustomerDao {
//extends JpaRepository<Customer, Integer>


	List<Customer> findAll();
	Customer createCustomer(Customer customer);
	Customer getCustomer(int theId);
	void deleteById(Integer id);
}
