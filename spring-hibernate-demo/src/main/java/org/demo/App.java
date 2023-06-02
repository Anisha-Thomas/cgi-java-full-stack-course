package org.demo;

import java.util.List;
import java.util.Scanner;

import org.demo.config.SpringConfig;
import org.demo.dao.StudentDao;
import org.demo.dao.StudentDaoImp;
import org.demo.model.Student;
import org.demo.service.StudentService;
import org.demo.service.StudentServiceImp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	static Scanner scanners = new Scanner(System.in);

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		StudentService studentService = context.getBean("studentService", StudentServiceImp.class);

		int choice = 0;
		do {
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
				studentService.createStudent(new Student(fName, lName, email));
				break;
			case 2:
				List<Student> list = studentService.getAllStudents();
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
				studentService.deleteStudent(id);
				break;
			case 4:

				System.out.print("Enter Customer id: ");
				id = scanners.nextInt();
				Student students = studentService.findStudent(id);
				if (students != null) {
					System.out.println("Which field need to update?");
					String field = scanners.next();
					System.out.println(field);
					switch (field) {
					case "first_name":
						System.out.println("Enter the first name");
						String fname = scanners.next();
						studentService.updateStudent(id, fname, students.getLastName(), students.getEmail());
						break;
					case "last_name":
						System.out.println("Enter the last name");
						String lname = scanners.next();
						studentService.updateStudent(id, students.getFirstName(), lname, students.getEmail());
						break;
					case "email":
						System.out.println("Enter the email");
						String cemail = scanners.next();
						studentService.updateStudent(id, students.getFirstName(), students.getLastName(), cemail);
						break;
					default:
						System.out.println("Option not available");
						break;
					}

				} else {
					System.out.println("Invalid Employee Id");
				}
				break;
			case 5:
				System.out.println("Enter the Student id");
				int sid = scanners.nextInt();
				Student studentlist = studentService.findStudent(sid);
				if (studentlist != null) {
					System.out.println(studentlist);
				} else {
					System.out.println("Invalid Student Id");
				}

				break;
			default:
				System.out.println("No options available");

			}
		} while (choice != 0);
	}
}
