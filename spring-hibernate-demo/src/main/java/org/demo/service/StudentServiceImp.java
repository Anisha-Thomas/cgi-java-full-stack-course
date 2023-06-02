package org.demo.service;

import java.util.List;

import org.demo.dao.StudentDao;
import org.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("studentService")
public class StudentServiceImp implements StudentService {

	public StudentDao studentDao;

	@Autowired
	public StudentServiceImp(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public void createStudent(Student student) {
		studentDao.createStudent(student);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentDao.getAllStudents();
	}

	@Override
	public void deleteStudent(int id) {
		studentDao.deleteStudent(id);

	}

	@Override
	public Student findStudent(int id) {
		return studentDao.findStudent(id);
	}

	@Override
	public void updateStudent(int id, String fname, String lastName, String email) {
		studentDao.updateStudent(id, fname, lastName, email);

	}

}
