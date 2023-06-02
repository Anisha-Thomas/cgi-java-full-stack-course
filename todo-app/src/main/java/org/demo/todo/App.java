package org.demo.todo;

import java.util.Random;

import org.demo.todo.model.Todo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Todo.class).buildSessionFactory();
    	Session session=factory.openSession();
    	session.getTransaction().begin();
    	session.save(new Todo(new Random().nextInt(),"H.W",true));
    	System.out.println("Inserted Successfully..........");
    	session.getTransaction().commit();
    	
    }
}
