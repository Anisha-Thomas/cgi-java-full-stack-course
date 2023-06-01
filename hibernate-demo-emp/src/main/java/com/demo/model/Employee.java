package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="employee")
public class Employee {
	@Id
	@Column(name="employee_id")
	private int empId;
	@Column(name="first_name")
	private String first_name;
	@Column(name="last_name")
	private String lName;
	private String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public Employee(int empId, String first_name, String lName,String email) {
	
		this.empId = empId;
		this.first_name = first_name;
		this.lName = lName;
		this.email = email;
	}
	public Employee() {
	
	}
	
	
}
