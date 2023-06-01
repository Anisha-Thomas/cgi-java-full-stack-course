package org.demo;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.demo.config.SpringConfig;
import org.demo.dao.StudentDao;
import org.demo.dao.StudentDaoImp;
import org.demo.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	static Scanner scanners = new Scanner(System.in);

	public static void main(String[] args) {
		
		ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
		StudentDao studentDao=context.getBean("studentDao",StudentDaoImp.class);
		int choice = 0;
		System.out.println("1. Create the new Student");
		System.out.println("2. View all Students");
		System.out.println("3. Delete Employees");
		System.out.println("4. Update A Student By Student ID.");
		System.out.println("5. Find A Student By Student ID.");
		System.out.println("0. Exit.");
		System.out.println("Enter your Choice");
		choice = scanners.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter the first name");
			String fName = scanners.next();
			System.out.println("Enter the last name");
			String lName = scanners.next();
			System.out.println("Enter the email");
			String email = scanners.next();
			studentDao.createStudent(new Student(fName, lName, email));
			break;
	case 2:
		List<Student> list = studentDao.getAllStudents();
		if (list.isEmpty()) {
			System.out.println("Student table is empty.");
		}

		else {
			for (Student c : list) {
				System.out.println(c);
			}
		}
		break;
	case 3:
		System.out.println("Enter the customer id");
		int id = scanners.nextInt();
		studentDao.deleteStudent(id);
		break;
	case 4:

		System.out.print("Enter Customer id: ");
		id = scanners.nextInt();
		List<Student> employees = studentDao.findStudent(id);
		if (employees.size() > 0) {
			System.out.println("Which field need to update?");
			String field = scanners.next();
			if(field=="first name") {
			System.out.println("Enter the first name");
			String fname = scanners.next();
			}
			else if(field=="last name") {
			System.out.println("Enter the last name");
			String lname = scanners.next();
			}
			else if(field=="email"){
			System.out.println("Enter the email");
			String cemail = scanners.next();
			}else {
				System.out.println("Option not available");
			}
		//	studentDao.updateStudent(id, fname, lname, cemail);
		} else {
			System.out.println("Invalid Employee Id");
		}
		break;
	case 5:
		System.out.println("Enter the Employee id");
		int sid = scanners.nextInt();
		List<Student> employeelist =studentDao.findStudent(sid);
		if(employeelist.size()>0) {
			System.out.println(employeelist);
		}else {
			System.out.println("Invalid Employee Id");
		}

		break;
	default:
		System.out.println("No options available");

	}
	}
}
