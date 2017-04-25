package com.studup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studup.model.entity.StudentUniversity;
import com.studup.repository.StudentUniversityRepository;
import com.studup.service.StudentUniversityService;

@Service
public class StudentUniversityServiceImpl implements StudentUniversityService {

	@Autowired
	private StudentUniversityRepository studentUniversityRepository;
	
	@Override
	public StudentUniversity save(StudentUniversity studentUniversity) {
		return studentUniversityRepository.save(studentUniversity);
	}

}
