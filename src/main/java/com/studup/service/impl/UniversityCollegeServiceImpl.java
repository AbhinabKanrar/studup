package com.studup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.studup.model.entity.Degree;
import com.studup.model.entity.Department;
import com.studup.model.entity.UniversityCollege;
import com.studup.repository.UniversityCollegeRepository;
import com.studup.service.UniversityCollegeService;

@Service
public class UniversityCollegeServiceImpl implements UniversityCollegeService {

	@Autowired
	private UniversityCollegeRepository universityCollegeRepository;
	
	@Override
	public UniversityCollege findByUnivorcollegename(String univorcollegename) {
		return universityCollegeRepository.findByUnivorcollegename(univorcollegename);
	}

	@Override
	public List<UniversityCollege> findAll() {
		Iterable<UniversityCollege> universities = universityCollegeRepository.findAll();
		if (universities != null) {
			List<UniversityCollege> collegeOrUniversityList = Lists.newArrayList(universities);
			for (UniversityCollege universityCollege : collegeOrUniversityList) {
				System.out.println(universityCollege.getUnivorcollegename());
				for(Department department : universityCollege.getDepartments()) {
					System.out.println(department.getDepttname());
					for (Degree degree : department.getDegrees()) {
						System.out.println(degree.getDegreeName());
					}
				}
			}
		}
		return null;
	}

}
