package com.school.service;

import java.util.List;

import com.school.entity.Teacher;
import com.school.exception.UserNotFoundException;

public interface TeacherService {
	
	Teacher registerTeacher(Teacher teacher);
	List<Teacher> getAllTeachers()throws UserNotFoundException;
	Teacher updateTeacherById(Teacher teacher) throws UserNotFoundException;
}
