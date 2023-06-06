package org.student;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.student.config.Config;
import org.student.service.StudentService;
import org.student.service.StudentServiceImp;

/**
 * Hello world!
 *
 */
public class App {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		StudentService studentService = context.getBean("studentServices", StudentServiceImp.class);

		int choice = 0;
		do {
			System.out.println("1.Get All Students");
			System.out.println("2.Create Student");
			System.out.println("3.Delete All Students");
			System.out.println("4.Delete By Student Id");
			System.out.println("5.Find By Student Id");
			System.out.println("6.Find By Date");
			System.out.println("7. Update By Student Id");
			System.out.println("8. Update By Student Name");
			System.out.println("9. find By Name");
			System.out.println("0.To Exit");
			System.out.print("Enter Option:");
			choice = scanner.nextInt();

			switch (choice) {
			case 0:
				System.out.println("Thank you..");
				break;
			case 1:
				studentService.getAllStudents();
				break;
//            	case 2:
//            		System.out.println("enter id");
//                    int id=s.nextInt();
//                    System.out.println("enter name");
//                    String name=s.next();
//                    System.out.println("enter date");
//                    String enteringDate=s.next();
//                    System.out.println("enter Nationality");
//                    String nationality=s.next();
//                    int code=new Random().nextInt(1000);
//                    Student theStudent=new Student(id,name,enteringDate,nationality,code);
//                    Student  stud=ss.createStudent(theStudent);
//                   
//                    System.out.println("created............");
//                    break;
//            	case 3:
//            		ss.deleteAll();
//            		break;
//            	case 4:
//            		System.out.print("Enter Id:");
//            		int id1=s.nextInt();
//            		ss.deleteById(id1);
//            		break;
//            	case 5:
//            		System.out.print("Enter Id:");
//            		int id2=s.nextInt();
//            		ss.findById(id2);
//            		break;
//            	case 6:
//            		System.out.print("Enter Date:");
//            		String date1=s.next();
////            		int i=Integer.valueOf(date1);
//            		ss.findByDate(date1);
//            		break;
//            	case 7:System.out.println("enter student id") ;
//            	 id = s.nextInt();
//            	System.out.println("enter name") ;
//            	 name = s.next();
//            	System.out.println("enter date") ;
//            	enteringDate = s.next();
//            	System.out.println("enter nationality") ;
//            	nationality = s.next();
//            	System.out.println("enter code") ;
//            	code = new Random().nextInt(1000);
//            	Student student = new Student(id,name, enteringDate, nationality, code);
//            	ss.updateById(id, student);
//        		break;
//            	case 8:System.out.println("enter old name") ;
//            	String oldName = s.next();
//            	System.out.println("enter name") ;
//            	 name = s.next();
//            	System.out.println("enter date") ;
//            	 enteringDate = s.next();
//            	System.out.println("enter nationality") ;
//            	 nationality =s.next();
//            	
//            	 code =new Random().nextInt(1000);
//            	Student thestudent = new Student(name, enteringDate, nationality, code);
//            	ss.updateByName(oldName, thestudent);
//       		break;
//            	case 9:
//            		System.out.print("Enter Name:");
//            		 name=s.next();
//            		ss.findByName(name);
//            		break;
//            		
			default:
				System.out.println("Invalid input");
			}

		} while (choice != 0);

	}
}
