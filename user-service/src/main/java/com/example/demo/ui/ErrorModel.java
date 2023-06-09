package com.example.demo.ui;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ErrorModel {
	private int statusCode;
	private String errorMessage;
	private long errorReportingTime;
	public ErrorModel(int statusCode, String errorMessage, long errorReportingTime) {
		super();
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
		this.errorReportingTime = errorReportingTime;
	}
	

}
