package org.test.module;

import java.sql.Connection;
import java.sql.SQLException;

import org.example.jdbc.ConnectionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try {
			Connection connection=ConnectionFactory.getMySqlConnection();
			System.out.println(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
