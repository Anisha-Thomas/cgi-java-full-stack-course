package com.employee.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySqlConnectionFactory {

	public Connection connection=null;
	public static Connection getConnection() throws SQLException {
		Properties properties=new Properties();
		properties.setProperty("url", "jdbc:mysql://localhost:3306/db1");
		properties.setProperty("username", "root");
		properties.setProperty("password", "root");

		return DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("username"),properties.getProperty("password"));
	}
}
