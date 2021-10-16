package com.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.bean.Student;

@SpringBootApplication
@RestController
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}
	@GetMapping
	public List<Student> hello() {
		return List.of(
				new Student(
					1L,
					"chaitanya",
					"adepu",
					"chai@gmail.com",
					LocalDate.of(2000, Month.JANUARY, 1),
					21
					)
				);
	}
}
