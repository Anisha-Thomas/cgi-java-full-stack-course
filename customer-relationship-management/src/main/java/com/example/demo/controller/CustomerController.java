package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.CustomerDao;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@Controller
public class CustomerController {

	//private final CustomerService customerService;

//	public CustomerController(CustomerService customerService) {
//		super();
//		this.customerService = customerService;
//	}
	private final CustomerDao customerDao;
	
	public CustomerController(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}

	@GetMapping
	public String listCustomers(Model theModel) {
	//	List<Customer> theCustomers = customerService.getAllCustomers();
		List<Customer> theCustomers = customerDao.findAll();
		theModel.addAttribute("customers", theCustomers);
		return "list-customers";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(@ModelAttribute("customer") Customer customer, Model theModel) {
		//Customer theCustomer = customerService.createCustomer(customer);
		Customer theCustomer=customerDao.createCustomer(customer);
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		//customerService.createCustomer(theCustomer);
		customerDao.createCustomer(theCustomer);
		return "redirect:/";
	}

	@SuppressWarnings("deprecation")
	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		//Customer theCustomer = customerService.getCustomer(theId);
	
		Customer theCustomer=customerDao.getCustomer(theId);
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		//customerService.deleteCustomer(theId);
		customerDao.deleteById(theId);
		return "redirect:/";
	}
}
