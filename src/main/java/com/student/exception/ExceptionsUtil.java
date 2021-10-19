package com.student.exception;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ExceptionsUtil {
	/*
	@Autowired
	MessageSource msgSource;
	final ObjectMapper mapper = new ObjectMapper();
	public String getErrorMessage(StudentDataExceptions exception) {
		String msg = exception.getMessage();
		ErrorMessage resBody = null;
		new ErrorMessage("urm",msg);
		String errCode = exception.getErrCode().name();
		msg = msgSource.getMessage(errCode, null, Locale.getDefault());
		resBody = new ErrorMessage(errCode,msg);
		resBody = new ErrorMessage("urm",msg);
		try {
			return mapper.writeValueAsString(resBody);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
*/
}
