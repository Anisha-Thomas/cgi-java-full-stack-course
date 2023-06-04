package org.customer.controller;

import org.customer.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

	@GetMapping("/")
	public String showCustomer(Model theModel) {
		theModel.addAttribute("customer",new Customer());
		return "showCustomer";
	}
	
	@RequestMapping(path = "/processCustomer",method = RequestMethod.POST)
	public String processCustomer(@ModelAttribute("customer") Customer customer, Model theModel) {
		theModel.addAttribute("cu",customer);
		return "processCustomer";
	}
}
