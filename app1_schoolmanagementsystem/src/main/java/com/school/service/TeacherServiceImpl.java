package com.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.entity.Role;
import com.school.entity.Teacher;
import com.school.exception.UserNotFoundException;
import com.school.repository.TeacherRepository;
import com.school.utility.UserUtility;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	
	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	public Teacher registerTeacher(Teacher teacher) {
		teacher.setRole(Role.TEACHER);
		teacher.setTeacherCode(UserUtility.generateTeacherId());
		return teacherRepository.save(teacher);
	}

	@Override
	public List<Teacher> getAllTeachers() throws UserNotFoundException {
		List<Teacher> all = teacherRepository.findAll();
		if(all.isEmpty()) throw new UserNotFoundException("No Teachers Found...");
		return all;
	}

	@Override
	public Teacher updateTeacherById(Teacher teacher) throws UserNotFoundException {
		teacherRepository.findByTeacherCode(teacher.getTeacherCode()).orElseThrow(()->new UserNotFoundException("Invalid Teacher Id for updating.."));
		return teacherRepository.save(teacher);
	}

}
