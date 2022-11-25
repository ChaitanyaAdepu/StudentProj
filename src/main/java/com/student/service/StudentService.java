package com.student.service;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.http.HttpStatus;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.student.bean.AuthBean;
import com.student.bean.Student;
import com.student.exception.ErrorCode;
import com.student.exception.StudentDataException;
import com.student.repo.StudentRepo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class StudentService {
	
private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);
	
	@Autowired
	StudentRepo studentRepo;
	static Map<String,String> userSession = new HashMap<>();
	public String authStudent(AuthBean auth) {
		userSession.put(auth.getUsername(),getJwt(auth.getUsername()));
		return getJwt(auth.getUsername());
	}
	private String getJwt(String username) {
		   Claims claims= Jwts.claims();
	        claims.put("email", username);
	        claims.setIssuedAt(new Date());
	        
	        String token = Jwts.builder()
	                .setClaims(claims)
	                .signWith(SignatureAlgorithm.HS512, "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddasfdddddddddasfafsasfasdfasdfasfafdsasfdsa")
	                .compact();
	        
	        return token;
	}
	public boolean checkSession(String token) {
		return userSession.containsValue(token);		
		
	}
	@Cacheable(value="students")
	public List<Student> getStudents() {
		LOGGER.info("GET ALL USERS FROM DB");
		return studentRepo.findAll();
	}
	public List<Student> getStudentById(Long id) throws StudentDataException {
		if(studentRepo.findById(id).isPresent()) {
			return studentRepo.findStudentById(id);
		}
		throw new StudentDataException("student with ID "+id+ " does not exist");
	}
	@CacheEvict(cacheNames = "students",allEntries = true) 
	@ResponseStatus(HttpStatus.OK)
	public void addStudent(Student student) throws StudentDataException {
		String email = student.getEmail();
		if(studentRepo.findByEmail(email).isPresent()) {
			throw new StudentDataException(ErrorCode.EMAIL_ALREADY_TAKEN, "Requested "+email+" email already taken");
		}
		studentRepo.save(student);
	
	}
	
	public List<Student> addStudentAndReturnList(Student student) throws ExecutionException, InterruptedException{
		
		CompletableFuture<List<Student>> listStudentCF = CompletableFuture.runAsync(
				()->addStudent(student)).thenApply(data->getStudents());
					
					
				
		return listStudentCF.get();
	}
	
	public void deleteStudentById(Long id) throws StudentDataException {
		if(id!=null) {
			boolean isExist = studentRepo.existsById(id);
			if(!isExist) {
				throw new StudentDataException("student with ID "+id+ " does not exist");
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
				throw new StudentDataException("student with ID "+id+ " does not exist");
			}
			Student student = studentRepo.findById(id).orElseThrow(()-> new StudentDataException("student with ID "+id+ " does not exist"));
            student.setFirstName(fname);
            student.setLastName(lname);
		}
		if(id==null || String.valueOf(id).equals("")) {
			throw new StudentDataException("ID can not be null");

		}
	}
//	public Page<Student> findPaginated(int pageNo,int pageSize){
//		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
//		return this.studentRepo.findAll(pageable);
//	}
}
class MultithreadingDemo implements Runnable {
    public void run()
    {
        try {
            // Displaying the thread that is running
            System.out.println(
                "Thread " + Thread.currentThread().getId()
                + " is running");
        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
}