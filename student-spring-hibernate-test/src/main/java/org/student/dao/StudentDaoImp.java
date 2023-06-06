package org.student.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.student.model.Student;

public class StudentDaoImp implements StudentDao {
	
	public SessionFactory sessionfactory;

	public void getAllStudent() {
		Session session=sessionfactory.openSession();
		session.beginTransaction().begin();
		System.out.println("Details 1..");
		Query query=session.createQuery("from Student",Student.class);
		@SuppressWarnings("unchecked")
		List<Student> result=query.getResultList();
		System.out.println("Details 2..");
		if(result.isEmpty()==false) {
			System.out.println("Student Details...");
			for (Student student : result) {
				System.out.println(student);
			}
		}else {
			System.out.println("Student Table is Empty");
		}
		
	}

}
