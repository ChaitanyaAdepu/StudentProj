package com.student.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.student.StudentRepository;
import com.student.bean.Student;
import com.student.exception.ErrorCode;
import com.student.exception.ExceptionCode;
import com.student.exception.StudentDataExceptions;

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
		return "Hello "+ErrorCode.EMAIL_ALREADY_EXIST;
	}
	@Transactional
	public void addStudent(Student student) throws StudentDataExceptions {
		String email = student.getEmail();
		if(studentRepo.findByEmail(email).isPresent()) {// || !studentRepo.findByEmail(email).isEmpty()){
			LOGGER.info("email>>>>{}",email);
			throw new IllegalArgumentException("email taken");
			//StudentDataExceptions(ExceptionCode.GENERIC_ERROR, ErrorCode.EMAIL_ALREADY_EXIST);
		}
		studentRepo.save(student);
	
	}
}
