package com.student.exception;

import java.time.ZonedDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;


public class StudentDataException extends Exception{
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentDataException.class);

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ErrorCode errCode;
	 String message;
	 HttpStatus httpStatus;
	 ZonedDateTime timeStamp;
	 @Override
	    public synchronized Throwable fillInStackTrace() {
	        return this;
	    }
	 public StudentDataException(String message) {
		 super(message);
		 LOGGER.warn(message);
	 }

	public StudentDataException(ErrorCode errCode, String message) {
		super();
		this.errCode = errCode;
		this.message = message;
	}

	public StudentDataException(String message, HttpStatus httpStatus, ZonedDateTime timeStamp) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
		this.timeStamp = timeStamp;
	}
	
	@Override
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
