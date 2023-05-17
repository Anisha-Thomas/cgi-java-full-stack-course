package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
public class Tester {
public static void main(String[] args) {

try {

Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","root");

if(connection!=null)

{

System.out.println("sucessfully connected...");

}

} catch (Exception e) {

e.printStackTrace();

}
}
}