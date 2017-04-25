package com.studup.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studup.model.entity.Degree;
import com.studup.model.entity.Department;
import com.studup.model.entity.UniversityCollege;
import com.studup.repository.DegreeRepository;
import com.studup.repository.DepartmentRepository;
import com.studup.service.DegreeService;
import com.studup.service.UniversityCollegeService;

@Service
public class DegreeServiceImpl implements DegreeService {

	@Autowired
	private UniversityCollegeService universityCollegeService;
	
	@Autowired
	private DegreeRepository degreeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	

	@Override
	public String[] getDegreesByDepartment(String depttname) {
		List<Department> departments = departmentRepository.findByDepttname(depttname);
		if (departments != null && !departments.isEmpty()) {
			Department department = departments.get(0);
			List<Degree> degrees  = degreeRepository.findByDepartment(department);
			if (degrees != null && !degrees.isEmpty()) {
				List<String> degreeNames = new ArrayList<String>();
				for (Degree degree : degrees) {
					if (!degreeNames.contains(degree.getDegreeName())) {
						degreeNames.add(degree.getDegreeName());
					}
				}
				return degreeNames.toArray(new String[0]);
			}
		}
		return new String[0];
	}
	
//	@Override
//	public String[] getDegreesByUniversityCollege(String universityCollegeName) {
//		UniversityCollege universityCollege = universityCollegeService.findByUnivorcollegename(universityCollegeName);
//		if (universityCollege != null) {
//			List<String> degreeNames = new ArrayList<String>();
//			for(Department department  : universityCollege.getDepartments()) {
//				for(Degree degree : department.getDegrees()) {
//					if (!degreeNames.contains(degree.getDegreeName())) {
//						degreeNames.add(degree.getDegreeName());
//					}
//				}
//			}
//			return degreeNames.toArray(new String[0]);
//		}
//		return new String[0];
//	}

	@Override
	public Degree findDegreeByDegreeName(UniversityCollege universityCollege, String degreeName) {
		
		List<Department> departments = departmentRepository.findByUniversityCollege(universityCollege);
		
		if (departments != null && !departments.isEmpty()) {
			for (Department department : departments) {
				if (universityCollege.getId() == department.getUniversityCollege().getId()) {
					List<Degree> degrees = degreeRepository.findByDepartment(department);
					if (degrees != null && !degrees.isEmpty()) {
						for (Degree degree : degrees) {
							if (degree.getDegreeName().equalsIgnoreCase(degreeName)) {
								return degree;
							}
						}
					}
				}
			}
		}
		
		return null;
	}

}
