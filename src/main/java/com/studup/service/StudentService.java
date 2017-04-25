package com.studup.service;

import com.studup.model.domain.StudentType;
import com.studup.model.entity.Student;

public interface StudentService {

	StudentType findByEmailId(String emailId);
	Student createStudent(Student student);
	
	StudentType convert(Student student);
	
}
