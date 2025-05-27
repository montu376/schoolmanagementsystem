package com.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.entity.Role;
import com.school.entity.Student;
import com.school.exception.UserNotFoundException;
import com.school.repository.StudentRepository;
import com.school.utility.UserUtility;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student registerStudent(Student student) {
	    String rollNumber;
	    do {
	        rollNumber = UserUtility.generateStudentRollNumber();
	    } while (studentRepository.existsByStudentRollNumber(rollNumber));

	    student.setStudentRollNumber(rollNumber);
	    student.setRole(Role.STUDENT);
	    return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudent() throws UserNotFoundException {
		return studentRepository.findAll();
	}

	@Override
	public Student updateStudentByRollNumber(Student student) throws UserNotFoundException {
		studentRepository.findByStudentRollNumber(student.getStudentRollNumber()).
				orElseThrow(()->new UserNotFoundException("Invalid Student Roll Number to Update, Please try again with valid."));
		return studentRepository.save(student);
	}
	

}
