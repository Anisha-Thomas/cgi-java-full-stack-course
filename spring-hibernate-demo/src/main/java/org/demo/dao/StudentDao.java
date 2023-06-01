package org.demo.dao;

import java.util.List;

import org.demo.model.Student;

public interface StudentDao {

	void createStudent(Student student);

	List<Student> getAllStudents();

	void deleteStudent(int id);


	List<Student> findStudent(int id);

	void updateStudent(int id, String fname, String lname, String cemail);

}
