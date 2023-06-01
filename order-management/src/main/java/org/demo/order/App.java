package org.demo.order;

import java.util.Scanner;

import org.demo.order.config.SpringConfig;
import org.demo.order.model.User;
import org.demo.order.service.UserService;
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
			UserService userService = context.getBean("userService", UserService.class);
			int count = 0;
			do {
				System.out.println("Username: ");
				String uname = scanners.next();
				System.out.println("Password: ");
				String password = scanners.next();
				User user = userService.getUserVerified(uname, password);
				System.out.println(user);

			} while (count < 3);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
