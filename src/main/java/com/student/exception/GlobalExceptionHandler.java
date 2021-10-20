package com.student.exception;

import java.time.ZonedDateTime;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	@ExceptionHandler(StudentDataException.class)
	public ResponseEntity<?> resourceNotFoundHandling(StudentDataException exception, WebRequest request){
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		ErrorDetails errorDetails = 
				new ErrorDetails(new Date(), exception.getMessage(), badRequest, request.getDescription(false));
		LOGGER.info("errcode is>>>{}",exception.getErrCode());

		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	// handling global exception
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandling(Exception exception, WebRequest request){
		ErrorDetails errorDetails = 
				new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	/*
	@ExceptionHandler(value= {StudentDataException.class})
	public ResponseEntity<Object> handleApiRequestException(StudentDataException exception) throws Exception{
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		StudentDataException stuException = new StudentDataException(exception.getMessage(), badRequest, ZonedDateTime.now());

		return new ResponseEntity<>(stuException,badRequest);
	}*/
}
