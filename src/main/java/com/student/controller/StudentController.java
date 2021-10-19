package com.student.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.bean.Student;
import com.student.exception.StudentDataException;
import com.student.service.StudentService;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
	//private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	StudentService stuService;
	
	public void setStudentService(StudentService stuService) {
	    this.stuService = stuService;
	}

	
	@GetMapping
	public List<Student> getStudents() {
		return stuService.getStudents();
	}
	
	 @GetMapping("/{id}") 
	 public List<Student> getStudentById(@PathVariable Long id) throws StudentDataException {
	     return stuService.getStudentById(id); 
	 }
	 @PostMapping
	 public void addStudent(@RequestBody Student student) throws StudentDataException {
		stuService.addStudent(student); 
	 }
	 @DeleteMapping("/{id}")
	 public void deleteStudentById(@PathVariable Long id) throws StudentDataException {
		 stuService.deleteStudentById(id);
	 }
	 @PutMapping("/{id}")
	 public void updateStudentById(@PathVariable Long id,@RequestParam(name="firstName",required = false) String fname,@RequestParam(name="lastName",required = false) String lname) throws StudentDataException {
		 stuService.updateStudentById(id,fname,lname);
	 }
	 
}
