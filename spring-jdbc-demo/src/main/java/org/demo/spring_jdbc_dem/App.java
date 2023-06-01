package org.demo.spring_jdbc_dem;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try {

			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			DataSource dataSource = context.getBean("dataSource", DriverManagerDataSource.class);

			Connection connection = dataSource.getConnection();
			PreparedStatement sql=connection.prepareStatement("* from employee");
			System.out.println(connection);
			System.out.println("connection succeed");
			System.out.println(sql);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
