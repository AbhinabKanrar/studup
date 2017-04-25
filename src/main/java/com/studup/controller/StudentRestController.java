package com.studup.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.studup.model.domain.StudentProfile;
import com.studup.model.domain.StudentType;
import com.studup.model.domain.UniversityCollegeType;
import com.studup.model.entity.Degree;
import com.studup.model.entity.Student;
import com.studup.model.entity.StudentDegree;
import com.studup.model.entity.StudentUniversity;
import com.studup.model.entity.UniversityCollege;
import com.studup.service.DegreeService;
import com.studup.service.StudentDegreeService;
import com.studup.service.StudentService;
import com.studup.service.StudentUniversityService;
import com.studup.service.UniversityCollegeService;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private UniversityCollegeService universityCollegeService;
	
	@Autowired
	private StudentUniversityService studentUniversityService;
	
	@Autowired
	private DegreeService degreeService;
	
	@Autowired
	private StudentDegreeService studentDegreeService;
	
	@PostMapping(value = "/v0.1/ListStudentByEmailId", headers = "Accept=application/xml", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<StudentType> getStudentByEmailId(Principal principal){
//		return new ResponseEntity<Student>(studentService.findByEmailId(principal.getName()),HttpStatus.OK);
//		return new ResponseEntity<StudentType>(
//				studentService.convert(
//						studentService.findByEmailId("abhinabkanrar@gmail.com")),
//				HttpStatus.OK);
		return new ResponseEntity<StudentType>(studentService.findByEmailId("abhinabkanrar@gmail.com"),HttpStatus.OK);
	}
	
	@PostMapping(value = "/v0.1/UpdateStudent", headers = "Accept=application/xml", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> createStudentByEmailId(@ModelAttribute("studentProfile") StudentProfile studentProfile, Principal principal){
		try {
			Student student = new Student();
			student.setFirstname(studentProfile.getFirstname());
			student.setMidname(studentProfile.getMidname());
			student.setLastname(studentProfile.getLastname());
//			student.setEmailId(principal.getName());
			student.setEmailId("abhinabkanrar@gmail.com");
			student.setTagline(studentProfile.getTagLine());

			student = studentService.createStudent(student);
			
			UniversityCollege universityCollege = universityCollegeService.findByUnivorcollegename(studentProfile.getCollegeOrUniversity());
			if (universityCollege != null) {
				StudentUniversity studentUniversity = new StudentUniversity();
				studentUniversity.setStudent(student);
				studentUniversity.setUniversityCollege(universityCollege);
				studentUniversity = studentUniversityService.save(studentUniversity);
				
				Degree degree = degreeService.findDegreeByDegreeName(universityCollege, studentProfile.getHighestDegree());
				
				StudentDegree studentDegree = new StudentDegree();
				studentDegree.setDegree(degree);
				studentDegree.setStudent(student);
				studentDegree = studentDegreeService.save(studentDegree);
			}
			
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
		}
	}
	
}
