package org.demo.dao;

import java.util.List;

import org.demo.model.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("studentDao")
public class StudentDaoImp implements StudentDao {
	private SessionFactory sessionFactory;

	@Autowired
	public StudentDaoImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void createStudent(Student student) {
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(student);
		session.getTransaction().commit();
		System.out.println("Student Created Successfully...");
	}

	@Override
	public List<Student> getAllStudents() {
		String hql = "from Student";
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery(hql);  
		List<Student> list=query.list();
		session.getTransaction().commit();
		return list;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteStudent(int id) {
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		Object student = (Student)session.load(Student.class,id);
	    session.delete(student);

	    //This makes the pending delete to be done
	    session.flush() ;
		System.out.println("Student Deleted Successfully..." );
		session.getTransaction().commit();
	}

	@Override
	public Student findStudent(int id) {
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		Student list=session.find(Student.class, id);	
		session.getTransaction().commit();
		return list;
	}

	@Override
	public void updateStudent(int id, String fname, String lname, String cemail) {
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		Student s = session.get(Student.class, id);
		s.setFirstName(fname);
		s.setLastName(lname);
		s.setEmail(cemail);
		session.merge(s);
		session.getTransaction().commit();
	}

}
