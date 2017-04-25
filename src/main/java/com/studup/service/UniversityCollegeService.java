package com.studup.service;

import java.util.List;

import com.studup.model.entity.UniversityCollege;

public interface UniversityCollegeService {

	UniversityCollege findByUnivorcollegename(String univorcollegename);
	List<UniversityCollege> findAll();
	
}
