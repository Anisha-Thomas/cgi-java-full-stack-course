package org.example.demo.service;

import org.example.demo.dao.StudentDao;
import org.example.demo.dao.StudentDaoImpl;
import org.example.demo.model.Student;

public class StudentServiceImpl implements StudentService {
	
	private StudentDao studentDao;
	
	{
		studentDao=new StudentDaoImpl();
	}

	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.createStudent(student);
	}

	@Override
	public void deleteStudentById(int studentId) {
		studentDao.deleteStudentById(studentId);
		
	}

	@Override
	public void deleteAllStudents() {
		// TODO Auto-generated method stub
		studentDao.deleteAllStudents();
		
	}

	@Override
	public Student updateStudent(int studentId, Student student) {
		// TODO Auto-generated method stub
		return studentDao.updateStudent(studentId, student);
	}

	@Override
	public Student findStudentById(int studentId1) {
		return studentDao.findStudentById(studentId1);
		
	}

	@Override
	public void viewAllStudentDetails() {
		 studentDao.viewAllStudentDetails();
		
	}

}
