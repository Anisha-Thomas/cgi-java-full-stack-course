package com.example.employee.exception;

public class MyException {
	private String message;

	public MyException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
