package org.demo.customer;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.persistence.Query;

import org.demo.customer.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	static Scanner scanners = new Scanner(System.in);

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		int choice = 0;

		do {
			System.out.println("1. Create the new Customer");
			System.out.println("2. View all Customer");
			System.out.println("3. Get Customer By Id");
			System.out.println("0. Exit.");
			System.out.println("Select Choice:");
			choice = scanners.nextInt();
			switch (choice) {
			case 1:
				System.out.println("First Name:");
				String fname = scanners.next();
				System.out.println("Last Name:");
				String lname = scanners.next();
				session.save(new Customer(new Random().nextInt(1000), fname, lname));
				System.out.println("Inserted Successfully......");
				break;
			case 2:
				Query query = session.createQuery("from Customer");
				List<Customer> list = query.getResultList();
				for (Customer s : list) {
					System.out.println(s);
				}
				break;
			case 3:
				 System.out.println("Enter Customer Id:");
			        int customerId=scanners.nextInt();
			        Customer customer=session.find(Customer.class, customerId);
			        if(customer==null) {
			        	System.out.println("Not Found");
			        }else {
			        	System.out.println("Details:- "+customer);
			        }
			        break;
			default:
				System.out.println("Invalid Option");
				break;
				
			}
			
		} while (choice > 0);
		session.getTransaction().commit();
	}
}
