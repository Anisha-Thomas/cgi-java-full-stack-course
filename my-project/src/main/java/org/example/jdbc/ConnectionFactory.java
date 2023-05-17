package org.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static Connection connection=null;
	
	
	public static Connection getMySqlConnection() throws SQLException {
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","root");
		return connection;
	}
}
