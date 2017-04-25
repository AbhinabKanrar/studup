package com.studup.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Set;


/**
 * The persistent class for the university_college database table.
 * 
 */
@XmlRootElement
@Entity
@Table(name="university_college")
@NamedQuery(name="UniversityCollege.findAll", query="SELECT u FROM UniversityCollege u")
public class UniversityCollege implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String univorcollegename;
	private Set<Department> departments;
	private Set<StudentUniversity> studentUniversities;

	public UniversityCollege() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getUnivorcollegename() {
		return this.univorcollegename;
	}

	public void setUnivorcollegename(String univorcollegename) {
		this.univorcollegename = univorcollegename;
	}


	//bi-directional many-to-one association to Department
	
	@OneToMany(mappedBy="universityCollege")
	public Set<Department> getDepartments() {
		return this.departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

	public Department addDepartment(Department department) {
		getDepartments().add(department);
		department.setUniversityCollege(this);

		return department;
	}

	public Department removeDepartment(Department department) {
		getDepartments().remove(department);
		department.setUniversityCollege(null);

		return department;
	}


	//bi-directional many-to-one association to StudentUniversity
	
	@OneToMany(mappedBy="universityCollege")
	public Set<StudentUniversity> getStudentUniversities() {
		return this.studentUniversities;
	}

	public void setStudentUniversities(Set<StudentUniversity> studentUniversities) {
		this.studentUniversities = studentUniversities;
	}

	public StudentUniversity addStudentUniversity(StudentUniversity studentUniversity) {
		getStudentUniversities().add(studentUniversity);
		studentUniversity.setUniversityCollege(this);

		return studentUniversity;
	}

	public StudentUniversity removeStudentUniversity(StudentUniversity studentUniversity) {
		getStudentUniversities().remove(studentUniversity);
		studentUniversity.setUniversityCollege(null);

		return studentUniversity;
	}

}