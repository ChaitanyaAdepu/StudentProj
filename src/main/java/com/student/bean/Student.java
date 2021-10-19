package com.student.bean;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import org.hibernate.annotations.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.student.service.StudentService;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(appliesTo = "student")
public class Student {
	private static final Logger LOGGER = LoggerFactory.getLogger(Student.class);

	@Id
	@SequenceGenerator(
			name = "student_sequence",
			sequenceName = "student_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
	        strategy = GenerationType.SEQUENCE,
	        generator = "student_sequence"
	)
	@Column(name = "id")
	private Long id;
	
	@JsonProperty("firstName")
	@Column(name = "first_name")
	private String firstName;

	@JsonProperty("lastName")
	@Column(name = "last_name")
	private String lastName;
	
	@JsonProperty("email")
	@Column(name = "email")
	private String email;
	
	@JsonProperty("dob")
	@Column(name = "dob")
	private LocalDate dob;
	@Transient
	private Integer age;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(Long id, String firstName, String lastName, String email, LocalDate dob) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
	}

	public Student(String firstName, String lastName, String email, LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob; 
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
