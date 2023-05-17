package com.demo;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.demo.dao.CustomerDao;
import com.demo.dao.CustomerDaoImp;
import com.demo.model.Customer;

public class App {
	static Scanner scanners = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {

		CustomerDao customerDao = new CustomerDaoImp();
		int choice = 0;
		System.out.println("1. Create the new customer");
		System.out.println("2. View all Customers");
		System.out.println("3. Delete Customer");
		System.out.println("4. Update A Customer By Customer ID.");
		System.out.println("5. Find A Customer By Customer ID.");
		System.out.println("0. Exit.");
		System.out.println("Enter your Choice");
		choice = scanners.nextInt();

		switch (choice) {
		case 1:
			System.out.println("Enter the first name");
			String fName = scanners.next();
			System.out.println("Enter the last name");
			String lName = scanners.next();
			System.out.println("Enter the email");
			String email = scanners.next();

			Customer customer = customerDao.createCustomer(new Customer(new Random().nextInt(1000), fName, lName, email));
			System.out.println("Customer Created: " + customer);
			break;
		case 2:
			List<Customer> list = customerDao.getAllCustomer();
			if (list.isEmpty()) {
				System.out.println("customer table is empty.");
			}

			else {
				for (Customer c : list) {
					System.out.println(c);
				}
			}
			break;
		case 3:
			System.out.println("Enter the customer id");
			int id = scanners.nextInt();
			customerDao.deleteCustomer(id);
			System.out.println("Deletion Successfull..");
			break;
		case 4:
			System.out.print("Enter Customer id: ");
			id = scanners.nextInt();
			System.out.println("Enter the first name");
			String fname = scanners.next();
			System.out.println("Enter the last name");
			String lname = scanners.next();
			System.out.println("Enter the email");
			String cemail = scanners.next();
			customerDao.updateCustomer(id, fname, lname, cemail);
			break;
		case 5:
			System.out.println("Enter the customer id");
			int customerId = scanners.nextInt();
			System.out.println(customerDao.findCustomer(customerId));
			
			break;
		default:
			System.out.println("No options available");

		}
	}

}
