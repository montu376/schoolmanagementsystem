package com.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.entity.Student;
import com.school.entity.User;
import com.school.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/register")
	public ResponseEntity<Student> registerStudentHanlder(@Valid @RequestBody Student student){
		return new ResponseEntity<Student>(studentService.registerStudent(student) , HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Student>> getAllStudentHanlder(){
		return new ResponseEntity<List<Student>>(studentService.getAllStudent() , HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Student> updateStudentByStudentRollNumberHandler(@Valid @RequestBody Student student){
		return new ResponseEntity<Student>(studentService.updateStudentByRollNumber(student) , HttpStatus.CREATED);
	}
	
}
