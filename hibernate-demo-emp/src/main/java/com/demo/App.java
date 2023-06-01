package com.demo;

import org.hibernate.cfg.Configuration;

import com.demo.model.Employee;

import java.util.Random;

import org.hibernate.Session;
import  org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory factory=new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
         Session session=factory.openSession();
         session.getTransaction().begin();
         session.save(new Employee(new Random().nextInt(1000),"Anisha","Thomas","anisha@gmail.com"));
         session.getTransaction().commit();
         System.out.println("Data Saved Successfully......");
    }
}
