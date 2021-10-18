package com.student.exception;

public class StudentDataExceptions extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ExceptionCode exceptionCode;
	ErrorCode errCode;
	public StudentDataExceptions(ExceptionCode exceptionCode, ErrorCode errCode) {
		this.exceptionCode = exceptionCode;
		this.errCode = errCode;
	}
	public ExceptionCode getExceptionCode() {
		return exceptionCode;
	}
	public void setExceptionCode(ExceptionCode exceptionCode) {
		this.exceptionCode = exceptionCode;
	}
	public ErrorCode getErrCode() {
		return errCode;
	}
	public void setErrCode(ErrorCode errCode) {
		this.errCode = errCode;
	}
	
}
