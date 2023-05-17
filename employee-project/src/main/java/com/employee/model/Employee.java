package com.employee.model;

public class Employee {

	private int employeeId;
	private String fName;
	private String lName;
	private String email;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Employee(int employeeId, String fName, String lName, String email) {
		this.employeeId = employeeId;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
	}
	public Employee() {
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", fName=" + fName + ", lName=" + lName + ", email=" + email
				+ "]";
	}
	
}
