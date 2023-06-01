package org.demo.springjdbc;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.demo.springjdbc.config.SpringConfig;
import org.demo.springjdbc.dao.CustomerDao;
import org.demo.springjdbc.model.Customer;
import org.demo.springjdbc.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	static Scanner scanners = new Scanner(System.in);

	public static void main(String[] args) {
		try {

			ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

			CustomerService customerService = context.getBean("customerService",CustomerService.class);
			int choice = 0;
			do {
				System.out.println("1. Create the new customer");
				System.out.println("2. View all customer");
				System.out.println("3. Delete customer");
				System.out.println("4. Update A customer By customer ID.");
				System.out.println("5. Find A customer By customer ID.");
				System.out.println("0. Exit.");
				System.out.println("Enter your Choice");
				choice = scanners.nextInt();
				int id;
				int customerId;
				switch (choice) {
				case 1:
					System.out.println("Enter the first name");
					String fName = scanners.next();
					System.out.println("Enter the last name");
					String lName = scanners.next();
					Customer customer = customerService
							.createCustomer(new Customer(new Random().nextInt(1000), fName, lName));
					System.out.println("Customer Created: " + customer);
					break;
				case 2:
					List<Customer> list = customerService.getAllCustomers();
					for (Customer c : list) {
						System.out.println(c);
					}
					break;
				case 3:
					System.out.println("Enter the Customer Id");
					customerId = scanners.nextInt();
					try {
						customerService.deleteCustomerById(customerId);
					} catch (InputMismatchException e) {
						System.err.println("Invalid Input");
					}
					break;
				case 4:
					System.out.print("Enter Customer id: ");
					id = scanners.nextInt();
					List<Customer> employees = customerService.getCustomerById(id);
					if (employees.size() > 0) {
						System.out.println("Enter the first name");
						String fname = scanners.next();
						System.out.println("Enter the last name");
						String lname = scanners.next();

						customerService.updateCustomer(id, fname, lname);
					} else {
						System.out.println("Invalid Customer Id");
					}
					break;
				case 5:
					System.out.println("Enter the Customer Id");
					Integer customerIds = scanners.nextInt();
					List<Customer> listCustomer = customerService.getCustomerById(customerIds);
					if (listCustomer.isEmpty()) {
						System.out.println("Customer is not found");
					} else {
						for (Customer c : listCustomer) {
							System.out.println(c);
						}
					}
					break;

				default:
					System.out.println("No options available");
				}
			} while (choice > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
