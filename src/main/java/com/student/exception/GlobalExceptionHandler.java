package com.student.exception;

import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value= {StudentDataException.class})
	public ResponseEntity<Object> handleApiRequestException(StudentDataException exception) throws Exception{
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		StudentDataException stuException = new StudentDataException(exception.getMessage(), badRequest, ZonedDateTime.now());

		return new ResponseEntity<>(stuException,badRequest);
	}
}
