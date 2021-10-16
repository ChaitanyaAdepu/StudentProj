package com.student.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.student.StudentRepository;
import com.student.bean.Student;

@Service
@Component
public class StudentService {
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);
	
	@Autowired
	StudentRepository studentRepo;
	
	public StudentService() {
		
	} 
	public List<Student> getStudents() {
		return studentRepo.findAll();
	}
	
	public String getStudentById(String id) {
		return "Hello "+id;
	}
}
