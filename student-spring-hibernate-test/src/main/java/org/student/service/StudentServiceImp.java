package org.student.service;

import org.springframework.stereotype.Component;
import org.student.dao.StudentDao;

@Component("studentServices")
public class StudentServiceImp implements StudentService {

	public StudentDao studentDao;

	public void getAllStudents() {
		studentDao.getAllStudent();
	}

}
