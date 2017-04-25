package com.studup.service;

import com.studup.model.entity.Degree;
import com.studup.model.entity.UniversityCollege;

public interface DegreeService {

	String[] getDegreesByDepartment(String depttname);
	
	Degree findDegreeByDegreeName(UniversityCollege universityCollege, String degreeName);
	
}
