package com.example.employee.model;


public class ErrorModel {
	private int statusCode;
	private String errorMessage;
	private long errorReportingTime;
	
	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public long getErrorReportingTime() {
		return errorReportingTime;
	}

	public void setErrorReportingTime(long errorReportingTime) {
		this.errorReportingTime = errorReportingTime;
	}

	public ErrorModel(int statusCode, String errorMessage, long errorReportingTime) {
		super();
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
		this.errorReportingTime = errorReportingTime;
	}
	

}