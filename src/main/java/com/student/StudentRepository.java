package com.student;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.bean.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	@Query(value="SELECT s from Student s WHERE s.email = ?1")
	Optional<Student> findByEmail(String email);
	
	@Query(value="SELECT s from Student s WHERE s.id = ?1")
	List<Student> findStudentById(Long id);
}
