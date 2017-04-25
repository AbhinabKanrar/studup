package com.studup.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studup.model.entity.Department;
import com.studup.model.entity.UniversityCollege;
import com.studup.repository.DepartmentRepository;
import com.studup.service.DepartmentService;
import com.studup.service.UniversityCollegeService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private UniversityCollegeService universityCollegeService;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public String[] findByUniversityCollege(String universityCollegeName) {
		
		UniversityCollege universityCollege = universityCollegeService.findByUnivorcollegename(universityCollegeName);
		
		if (universityCollege != null) {
			List<Department> departments = departmentRepository.findByUniversityCollege(universityCollege);
			if (departments != null  && !departments.isEmpty()) {
				List<String> departmentNames = new ArrayList<String>();
				for (Department department : departments) {
					if (!departmentNames.contains(department.getDepttname())) {
						departmentNames.add(department.getDepttname());
					}
				}
				return departmentNames.toArray(new String[0]);
			}
		}
		
		return new String[0];
	}

}
