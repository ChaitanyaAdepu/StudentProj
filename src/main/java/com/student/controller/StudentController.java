package com.student.controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.bean.Student;
import com.student.exception.StudentDataExceptions;
import com.student.service.StudentService;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	StudentService stuService;
	
	public void setStudentService(StudentService stuService) {
	    this.stuService = stuService;
	}

	
	@GetMapping
	public List<Student> getStudents() {
		 LOGGER.info("test");
		return stuService.getStudents();
	}
	
	 @GetMapping("/{id}") 
	 public String getStudentById(@PathVariable String id) {
		 LOGGER.debug("test");
	     return stuService.getStudentById(id); 
	 }
	 @PostMapping
	 public void addStudent(@RequestBody Student student) throws StudentDataExceptions {
		 LOGGER.debug("test");
		 LOGGER.debug("id>>>{}",student.getEmail());
		stuService.addStudent(student); 
	 }
	 @DeleteMapping("/{id}")
	 public void deleteStudentById(@PathVariable Long id) {
		 LOGGER.info("id>>>{}",id);
		 stuService.deleteStudentById(id);
	 }
	/* @PutMapping("/{id}")
	 public void updateStudentById(@PathVariable Long id,@RequestParam(required = false) String fname,@RequestParam(required = false) String lname) {
		 LOGGER.info("id>>>{}",id);
		 LOGGER.info("fname{}>>>lname{}",fname,lname);
		 stuService.updateStudentById(id,fname,lname);
	 }*/
}
