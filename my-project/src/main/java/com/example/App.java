package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.example.jdbc.ConnectionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
        	DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        	Connection connection=ConnectionFactory.getMySqlConnection();
        	System.out.println(connection);
        	System.out.println("Connection Sucessful.............");
        	Statement statement=connection.createStatement();
        	ResultSet resultset=statement.executeQuery("select first_name,last_name from employees limit 10");
        	System.out.println("First Name Last Name");
        	while(resultset.next()){
        		System.out.println(resultset.getString("first_name")+" " +resultset.getString("last_name"));
        	}
        	
        	
        }catch(Exception e) {
        	System.out.println("Connection Failed.............");
        }
    }
}
