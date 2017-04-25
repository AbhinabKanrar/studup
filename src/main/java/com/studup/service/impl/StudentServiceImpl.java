package com.studup.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studup.model.domain.DegreeType;
import com.studup.model.domain.DepartmentType;
import com.studup.model.domain.StudentType;
import com.studup.model.domain.UniversityCollegeType;
import com.studup.model.entity.Degree;
import com.studup.model.entity.Department;
import com.studup.model.entity.Student;
import com.studup.model.entity.StudentDegree;
import com.studup.model.entity.UniversityCollege;
import com.studup.repository.StudentRepository;
import com.studup.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public StudentType findByEmailId(String emailId) {
		List<Student> students = studentRepository.findByEmailId(emailId);
		return (students != null && !students.isEmpty()) ? convert(students.get(0)) : null;
	}

	@Override
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public StudentType convert(Student student) {
		if (student != null) {
			StudentType studentType = new StudentType();
			studentType.setCity(student.getCity());
			studentType.setCountry(student.getCountry());
			studentType.setDob(null);
			studentType.setEmailId(student.getEmailId());
			studentType.setFirstname(student.getFirstname());
			studentType.setMidname(student.getMidname());
			studentType.setLastname(student.getLastname());
			studentType.setMobileNo(student.getMobileNo());
			studentType.setPermanentaddress(student.getPermanentaddress());	
			studentType.setState(student.getState());
			studentType.setTagline(student.getTagline());
			studentType.setZip(String.valueOf(student.getZip()));
			Set<StudentDegree> studentDegrees = student.getStudentDegrees();
			
			if (studentDegrees != null && !studentDegrees.isEmpty()) {
				
				UniversityCollegeType universityCollegeType;
				DepartmentType departmentType;
				DegreeType degreeType;
				
				for (StudentDegree studentDegree : studentDegrees) {
			
					Degree degree = studentDegree.getDegree();
					Department department = degree.getDepartment();
					UniversityCollege universityCollege = department.getUniversityCollege();
					
					degreeType = new DegreeType();
					degreeType.setId(degree.getId());
					degreeType.setDegreeName(degree.getDegreeName());
					
					departmentType = new DepartmentType();
					departmentType.setId(department.getId());
					departmentType.setDepttname(department.getDepttname());
					departmentType.setDegree(degreeType);
					
					universityCollegeType = new UniversityCollegeType();
					universityCollegeType.setId(universityCollege.getId());
					universityCollegeType.setUnivorcollegename(universityCollege.getUnivorcollegename());
					universityCollegeType.setDepartment(departmentType);
					
					studentType.getUniversityCollege().add(universityCollegeType);
					
				}
			}
			
			return studentType;
		}
		return new StudentType();
	}


//	@Override
//	public StudentType convert(Student student) {
//		StudentType studentType = null;
//		UniversityCollegeType universityCollegeType = null;
//		DepartmentType departmentType = null;
//		if (student != null) {
//			studentType = new StudentType();
//			studentType.setId(student.getId());
//			studentType.setCity(student.getCity());
//			studentType.setCountry(student.getCountry());
//			studentType.setDob(null);
//			studentType.setEmailId(student.getEmailId());
//			studentType.setFirstname(student.getFirstname());
//			studentType.setMidname(student.getMidname());
//			studentType.setLastname(student.getLastname());
//			studentType.setMobileNo(student.getMobileNo());
//			studentType.setPermanentaddress(student.getPermanentaddress());	
//			studentType.setState(student.getState());
//			studentType.setTagline(student.getTagline());
//			studentType.setZip(String.valueOf(student.getZip()));
//			
////			Set<StudentUniversity> studentUniversities = student.getStudentUniversities();
//			Set<StudentDegree> studentDegrees = student.getStudentDegrees();
//			
////			for (StudentUniversity studentUniversity : studentUniversities) {
////				universityCollegeType = new UniversityCollegeType();
////				UniversityCollege universityCollege = studentUniversity.getUniversityCollege();
////				universityCollegeType.setId(universityCollege.getId());
////				universityCollegeType.setUnivorcollegename(universityCollege.getUnivorcollegename());
////				
////				studentType.getUniversityCollege().add(universityCollegeType);
////				
////				
////			}
//			
//			for (StudentDegree studentDegree : studentDegrees) {
//				Degree degree = studentDegree.getDegree();
//				Department department = degree.getDepartment();
//				UniversityCollege universityCollege = department.getUniversityCollege();
//				universityCollegeType = new UniversityCollegeType();
//				
//			}
//			
//		}
//		return studentType;
//	}

}
