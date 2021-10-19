package com.student.exception;

public class ErrorMessage {
	String errCode;
	String msg;
	public ErrorMessage(String errCode, String msg) {
		// TODO Auto-generated constructor stub
		this.errCode = errCode;
		this.msg = msg;
	}
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
