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

import com.school.entity.Teacher;
import com.school.service.TeacherService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@PostMapping("/register")
	public ResponseEntity<Teacher> registerTeacherHanlder(@Valid @RequestBody Teacher teacher){
		return new ResponseEntity<Teacher>(teacherService.registerTeacher(teacher) , HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Teacher>> getAllTeachersHandler(){
		return new ResponseEntity<List<Teacher>>(teacherService.getAllTeachers() , HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Teacher> updateTeacherByTeacherId(@Valid @RequestBody Teacher teacher){
		return new ResponseEntity<Teacher>(teacherService.updateTeacherById(teacher) , HttpStatus.CREATED);
	}

}
