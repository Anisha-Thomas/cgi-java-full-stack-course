package org.example.demo;

import java.util.Random;
import java.util.Scanner;

import org.example.demo.model.Student;
import org.example.demo.service.StudentService;
import org.example.demo.service.StudentServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
	static Scanner scanners = new Scanner(System.in);

	public static void main(String[] args) {
		StudentService studentService = new StudentServiceImpl();
		int choice = 0;
		do {
			System.out.println("1.Adding new Student");
			System.out.println("2.View All Students");
			System.out.println("3.Delete All Students");
			System.out.println("4.Delete Students By Id");
			System.out.println("5.Update Student Details");
			System.out.println("6.Find Student By Id");
			System.out.println("0.Exit");
			System.out.println("Enter your Choice");
			choice = scanners.nextInt();
			switch (choice) {
			case 1:
				System.out.println("First Name:");
				String fname = scanners.next();
				System.out.println("Last Name:");
				String lname = scanners.next();
				System.out.println("Email:");
				String email = scanners.next();
				studentService.createStudent(new Student(new Random().nextInt(), fname, lname, email));
				System.out.println("Inserted Successfully....");
				break;
			case 2:
				studentService.viewAllStudentDetails();
				break;
			case 3:
				studentService.deleteAllStudents();
				System.out.println("Deleted All Records..");
				break;
			case 4:
				System.out.println("Student Id");
				int studentId = scanners.nextInt();
				studentService.deleteStudentById(studentId);
				System.out.println("Deleted Successfully..");
				break;
			case 5:
				System.out.println("Student Id:");
				int studentId1 = scanners.nextInt();
				
					System.out.println("First Name:");
					String ufname = scanners.next();
					System.out.println("Last Name:");
					String ulname = scanners.next();
					System.out.println("Email:");
					String uemail = scanners.next();
					studentService.updateStudent(studentId1, new Student(studentId1, ufname, ulname, uemail));
				break;
			case 6:
				System.out.println("Student Id:");
				int stud1 = scanners.nextInt();
				Student stud11 = studentService.findStudentById(stud1);
				if (stud11 != null) {
					System.out.println("Student Details " + stud11);
				} else {
					System.out.println("No Result Found");
				}
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		} while (choice > 0);

	}
}
