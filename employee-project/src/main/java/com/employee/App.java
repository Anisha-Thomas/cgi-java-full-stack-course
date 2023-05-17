package com.employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.employee.dao.EmployeeDao;
import com.employee.dao.EmployeeDaoImp;
import com.employee.model.Employee;

/**
 * Hello world!
 *
 */
public class App {

	static Scanner scanners = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		EmployeeDao employeeDao = new EmployeeDaoImp();
		int choice = 0;
		System.out.println("1. Create the new employee");
		System.out.println("2. View all Employees");
		System.out.println("3. Delete Employees");
		System.out.println("4. Update A Employees By Employees ID.");
		System.out.println("5. Find A Employees By Employees ID.");
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

			Employee employee = employeeDao
					.createEmployee(new Employee(new Random().nextInt(1000), fName, lName, email));
			System.out.println("Customer Created: " + employee);
			break;
		case 2:
			List<Employee> list = employeeDao.getAllEmployee();
			if (list.isEmpty()) {
				System.out.println("Employee table is empty.");
			}

			else {
				for (Employee c : list) {
					System.out.println(c);
				}
			}
			break;
		case 3:
			System.out.println("Enter the customer id");
			int id = scanners.nextInt();
			employeeDao.deleteEmployee(id);
			break;
		case 4:

			System.out.print("Enter Customer id: ");
			id = scanners.nextInt();
			List<Employee> employees = employeeDao.findEmployee(id);
			if (employees.size() > 0) {
				System.out.println("Enter the first name");
				String fname = scanners.next();
				System.out.println("Enter the last name");
				String lname = scanners.next();
				System.out.println("Enter the email");
				String cemail = scanners.next();
				employeeDao.updateEmployee(id, fname, lname, cemail);
			} else {
				System.out.println("Invalid Employee Id");
			}
			break;
		case 5:
			System.out.println("Enter the Employee id");
			int empId = scanners.nextInt();
			List<Employee> employeelist =employeeDao.findEmployee(empId);
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
