package com.student.controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.bean.Student;
import com.student.service.StudentService;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

	@Autowired
	StudentService stuService;

	/*
	 * @RequestMapping("/") public String home() { return "Welcome to Students App";
	 * }
	 */
	@GetMapping
	public List<Student> getStudents() {
		return stuService.getStudents();
	}
	
	 @GetMapping("/{id}") 
	 public String getStudentById(@PathVariable String id) {
	     return stuService.getStudentById(id); 
	 }
	 
}
