package com.school.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	Optional<Student> findByStudentRollNumber(String studentRollNumber);
	boolean existsByStudentRollNumber(String rollNumber);

}
