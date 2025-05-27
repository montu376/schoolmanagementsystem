package com.school.service;

import java.util.List;

import com.school.entity.Student;
import com.school.entity.User;
import com.school.exception.UserNotFoundException;

public interface StudentService {
	
	Student registerStudent(Student student);
	List<Student> getAllStudent() throws UserNotFoundException;
	Student updateStudentByRollNumber(Student student) throws UserNotFoundException;
	

}
