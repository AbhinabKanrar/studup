package com.studup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studup.model.entity.StudentDegree;
import com.studup.repository.StudentDegreeRepository;
import com.studup.service.StudentDegreeService;

@Service
public class StudentDegreeServiceImpl implements StudentDegreeService {

	@Autowired
	private StudentDegreeRepository studentDegreeRepository;
	
	@Override
	public StudentDegree save(StudentDegree studentDegree) {
		return studentDegreeRepository.save(studentDegree);
	}

}
