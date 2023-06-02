package org.demo.service;

import java.util.List;

import org.demo.model.Student;

public interface StudentService {

	void createStudent(Student student);

	List<Student> getAllStudents();

	void deleteStudent(int id);

	Student findStudent(int id);

	void updateStudent(int id, String fname, String lastName, String email);

}
