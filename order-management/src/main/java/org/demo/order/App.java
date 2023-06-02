package org.demo.order;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.demo.order.config.SpringConfig;
import org.demo.order.model.OrderManagement;
import org.demo.order.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

/**
 * Hello world!
 *
 */
public class App {
	static Scanner scanners = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
			//UserService userService = context.getBean("userService", UserService.class);
			OrderService orderService = context.getBean("orderService", OrderService.class);
			int count = 0;
			//do {
//				System.out.println("Username: ");
//				String uname = scanners.next();
//				System.out.println("Password: ");
//				String password = scanners.next();
//				boolean user = userService.getUserVerified(uname, password);
//				if (user == true) {
					int choice = 0;
					do {
						System.out.println("1. Create the new order");
						System.out.println("2. View all orders");
						System.out.println("3. Find order by Id");
						System.out.println("4. Find max of order value");
						System.out.println("5. Find min of order value.");
						System.out.println("6. Delete all orders");
						System.out.println("7. Delete order by Id");
						System.out.println("8. Update order by Name");
						System.out.println("9. Update order by Price");
						System.out.println("0. Exit.");
						System.out.println("Enter your Choice");
						choice = scanners.nextInt();
						switch (choice) {
						case 1:
							System.out.println("Order Name");
							String oname = scanners.next();
							System.out.println("Price");
							String oprice = scanners.next();
							OrderManagement order = orderService
									.createOrder(new OrderManagement(new Random().nextInt(1000), oname, oprice));
							System.out.println("Order Created: " + order);
							break;
						case 2:
							List<OrderManagement> list = orderService.getAllOrders();
							for (OrderManagement c : list) {
								System.out.println(c);
							}
							break;
//						case 3:
//							System.out.println("Enter the Customer Id");
//							customerId = scanners.nextInt();
//							try {
//								customerService.deleteCustomerById(customerId);
//							} catch (InputMismatchException e) {
//								System.err.println("Invalid Input");
//							}
//							break;
//						case 4:
//							System.out.print("Enter Customer id: ");
//							id = scanners.nextInt();
//							List<Customer> employees = customerService.getCustomerById(id);
//							if (employees.size() > 0) {
//								System.out.println("Enter the first name");
//								String fname = scanners.next();
//								System.out.println("Enter the last name");
//								String lname = scanners.next();
//
//								customerService.updateCustomer(id, fname, lname);
//							} else {
//								System.out.println("Invalid Customer Id");
//							}
//							break;
//						case 5:
//							System.out.println("Enter the Customer Id");
//							Integer customerIds = scanners.nextInt();
//							List<Customer> listCustomer = customerService.getCustomerById(customerIds);
//							if (listCustomer.isEmpty()) {
//								System.out.println("Customer is not found");
//							} else {
//								for (Customer c : listCustomer) {
//									System.out.println(c);
//								}
//							}
//							break;

						default:
							System.out.println("No options available");
						}
					} while (choice > 0);
//				} else {
//					count = count + 1;
//				}
//
//			} while (count < 3);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
