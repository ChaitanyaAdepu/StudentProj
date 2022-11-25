package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.bean.AuthBean;
import com.student.exception.StudentDataException;
import com.student.service.StudentService;

@RestController

public class HomeController {
	@Autowired
	StudentService stuService;
	@GetMapping("/")
	public String hello() {
		return "hello";
	}
	@PostMapping("/auth")
	 public String authStudent(@RequestBody AuthBean auth) throws StudentDataException {
		return stuService.authStudent(auth); 
	 }
}
