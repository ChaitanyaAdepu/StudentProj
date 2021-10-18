package com.student.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.student.StudentRepository;
import com.student.bean.Student;
@Controller
@Transactional
@Configuration
public class StudentConfig {
	
/*	@Bean
	CommandLineRunner cmdRunner(
			StudentRepository repo
			) {
		return args -> {
			Student stu1 = new Student(
					"chaitanya",
					"A",
					"chaitanyonly@gmail.com",
					LocalDate.of(2000, Month.APRIL, 01),
					20
					);
			
			Student stu2 = new Student(
					"ram",
					"R",
					"ram@gmail.com",
					LocalDate.of(2000, Month.APRIL, 01),
					21
					);
			repo.saveAll(List.of(stu1,stu2));
		};
		
	}*/
	
}
