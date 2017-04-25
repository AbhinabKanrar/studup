package com.studup.service;

import java.util.List;

import com.studup.model.entity.Department;
import com.studup.model.entity.UniversityCollege;

public interface DepartmentService {

	String[] findByUniversityCollege(String universityCollegeName);
	
}
