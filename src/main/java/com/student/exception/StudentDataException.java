package com.student.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class StudentDataException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 ErrorCode errCode;
	 String message;
	 Throwable exception;
	 HttpStatus httpStatus;
	 ZonedDateTime timeStamp;


	public StudentDataException(ErrorCode errCode, String message) {
		super();
		this.errCode = errCode;
		this.message = message;
	}

	public StudentDataException(ErrorCode errCode, String message, HttpStatus httpStatus, ZonedDateTime timeStamp) {
		super();
		this.errCode = errCode;
		this.message = message;
		this.httpStatus = httpStatus;
		this.timeStamp = timeStamp;
	}
 

	public ErrorCode getErrCode() {
		return errCode;
	}
	
	public String getMessage() {
		return message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public ZonedDateTime getTimeStamp() {
		return timeStamp;
	}


}
