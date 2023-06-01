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
		super();
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
		return list;
	}

	@Override
	public void deleteStudent(int id) {
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("delete Student where studentId = :ID");
		query.setParameter("ID", id);
		 
		System.out.println("Student Deleted Successfully..." +query);
	}

	@Override
	public List<Student> findStudent(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStudent(int id, String fname, String lname, String cemail) {
		// TODO Auto-generated method stub

	}

}
