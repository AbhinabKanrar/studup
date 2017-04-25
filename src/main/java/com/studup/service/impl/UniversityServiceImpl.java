package com.studup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.studup.model.entity.UniversityCollege;
import com.studup.repository.UniversityCollegeRepository;
import com.studup.service.UniversityService;

@Service
public class UniversityServiceImpl implements UniversityService {

	@Autowired
	private UniversityCollegeRepository universityCollegeRepository;
	
	@Override
	public String[] retrieveUniversities() {
		Iterable<UniversityCollege> universities = universityCollegeRepository.findAll();
		
		if (universities != null) {
			List<UniversityCollege> collegeOrUniversityList = Lists.newArrayList(universities);
			String[] collegeOrUniversity = new String[collegeOrUniversityList.size()];
			for (int i = 0; i < collegeOrUniversityList.size(); i++) {
				collegeOrUniversity[i] = collegeOrUniversityList.get(i).getUnivorcollegename();
			}
			return collegeOrUniversity;
		}
		
		return null;
		
	}

}
