package com.example.demo;

import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.demo.model.Student;

/**
 * Hello world!
 *
 */
public class App 
{
	static Scanner scanners = new Scanner(System.in);
    public static void main( String[] args )
    {
        SessionFactory factory=new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        Session session=factory.openSession();
        session.getTransaction().begin();
      //  session.save(new Student("Anisha","Thomas","anisha@gmail.com"));
//        Query query=session.createQuery("from Student");
//        List<Student> list=query.getResultList();
//        for(Student s:list) {
//        	System.out.println(s);
//        }
        System.out.println("Enter Student Id:");
        int studentId=scanners.nextInt();
        Student student=session.find(Student.class, studentId);
        if(student==null) {
        	System.out.println("Not Found");
        }else {
        	System.out.println("Student Details:- "+student);
        }
        session.getTransaction().commit();
      //  System.out.println("Data Saved Successfully......");
        
    }
}
