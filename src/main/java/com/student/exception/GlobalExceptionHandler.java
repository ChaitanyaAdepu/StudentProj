package com.student.exception;

import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value= {StudentDataException.class})
	public ResponseEntity<Object> handleApiRequestException(StudentDataException exception){
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		//ErrorDetails errDetails = new ErrorDetails(new Date(), exception.getMessage(),req.getDescription(false));
		StudentDataException stuException = new StudentDataException(exception.getErrCode(), exception.getMessage(), badRequest, ZonedDateTime.now());
		//StudentDataException stuException = new StudentDataException(exception.getMessage(), exception,badRequest, ZonedDateTime.now());

		return new ResponseEntity<>(stuException,badRequest);
	}
}
