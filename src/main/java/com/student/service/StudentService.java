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
import com.student.exception.StudentDataException;

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
		LOGGER.info("inside getstudntsmethod");
		return studentRepo.findAll();
	}
	
	public List<Student> getStudentById(Long id) throws StudentDataException {
		if(studentRepo.findById(id).isPresent()) {
			return studentRepo.findStudentById(id);
		}
	throw new StudentDataException(ErrorCode.DATA_DOES_NOT_EXIST, "student with ID "+id+ " does not exist");
	}
	@ResponseStatus(HttpStatus.OK)
	public void addStudent(Student student) throws StudentDataException {
		String email = student.getEmail();
		if(studentRepo.findByEmail(email).isPresent()) {
			throw new StudentDataException(ErrorCode.EMAIL_ALREADY_TAKEN, "Requested "+email+" email already taken");
		}
		studentRepo.save(student);
	
	}
	
	public void deleteStudentById(Long id) throws StudentDataException {
		if(id!=null) {
			boolean isExist = studentRepo.existsById(id);
			if(!isExist) {
				throw new StudentDataException(ErrorCode.DATA_DOES_NOT_EXIST, "student with ID "+id+ " does not exist");
			}
			studentRepo.deleteById(id);
		}
		if(id==null) {
		throw new IllegalArgumentException("ID can not be null");
		}
	}
	@Transactional
	public void updateStudentById(Long id,String fname,String lname) throws StudentDataException {
		if(id!=null) {
			boolean isExist = studentRepo.existsById(id);
			if(!isExist) {
				throw new IllegalArgumentException("student with"+id+ " does not exist");
			}
			Student student = studentRepo.findById(id).orElseThrow(()->new IllegalStateException("student with ID "+id+" "+ErrorCode.DATA_DOES_NOT_EXIST));
            student.setFirstName(fname);
            student.setLastName(lname);
		}
		if(id==null || String.valueOf(id).equals("")) {
			throw new StudentDataException(ErrorCode.DATA_DOES_NOT_EXIST, "ID can not be null");
		}
		}
}
