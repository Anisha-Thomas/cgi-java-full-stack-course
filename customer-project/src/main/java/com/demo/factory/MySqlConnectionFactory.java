package com.demo.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySqlConnectionFactory {
	
	public Connection connection=null;
	public static Connection getMySqlConnection() throws SQLException {
		Properties properties=new Properties();
		properties.put("url","jdbc:mysql://localhost:3306/db1");
		properties.put("userName", "root");
		properties.put("password", "root");
		return DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("userName"),properties.getProperty("password"));
		
	}
}
