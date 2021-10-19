package com.student.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.student.StudentRepository;
import com.student.bean.Student;
import com.student.exception.ErrorCode;
import com.student.exception.ExceptionCode;
import com.student.exception.StudentDataExceptions;

@Service
@Component
@Transactional
public class StudentService {
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);
	
	@Autowired
	StudentRepository studentRepo;
	
	public StudentService() {
   // use later
 } 
	public List<Student> getStudents() {
		return studentRepo.findAll();
	}
	
	public String getStudentById(String id) {
		return "Hello "+ErrorCode.EMAIL_ALREADY_TAKEN;
	}
	@ResponseStatus(HttpStatus.OK)
	public void addStudent(Student student) throws StudentDataExceptions {
		String email = student.getEmail();
		if(studentRepo.findByEmail(email).isPresent()) {// || !studentRepo.findByEmail(email).isEmpty()){
			LOGGER.info("email>>>>{}",email);
			throw new StudentDataExceptions(ExceptionCode.GENERIC_ERROR, "email already taken");
			//throw new StudentDataExceptions(ExceptionCode.GENERIC_ERROR, ErrorCode.EMAIL_ALREADY_TAKEN);
		}
		studentRepo.save(student);
	
	}
	
	public void deleteStudentById(Long id) {
		if(id!=null) {
			boolean isExist = studentRepo.existsById(id);
			if(!isExist) {
				throw new IllegalArgumentException("student with"+id+ " does not exist");
			}
			studentRepo.deleteById(id);
		}
		if(id==null) {
		throw new IllegalArgumentException("ID can not be null");
		}
	}
	@Transactional
	public void updateStudentById(Long id,String fname,String lname) {
		if(id!=null) {
			boolean isExist = studentRepo.existsById(id);
			if(!isExist) {
				throw new IllegalArgumentException("student with"+id+ " does not exist");
			}
			Student student = studentRepo.findById(id).orElseThrow(()->new IllegalStateException("student with ID "+id+" doesnot exist"));
            student.setFirstName(fname);
            student.setLastName(lname);
			//studentRepo.save(student);
		}
		//throw new IllegalArgumentException("ID can not be null");
	}
}
