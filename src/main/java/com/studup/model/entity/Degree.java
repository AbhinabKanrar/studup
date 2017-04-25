package com.studup.model.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the degree database table.
 * 
 */
@XmlRootElement
@Entity
@NamedQuery(name="Degree.findAll", query="SELECT d FROM Degree d")
public class Degree implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String degreeName;
	private Department department;
	private Set<StudentDegree> studentDegrees;
	private Set<SemesterYear> semesterYears;

	public Degree() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Column(name="degree_name")
	public String getDegreeName() {
		return this.degreeName;
	}

	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}


	//bi-directional many-to-one association to Department
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="department_id")
	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}


	//bi-directional many-to-one association to StudentDegree
	@OneToMany(mappedBy="degree")
	public Set<StudentDegree> getStudentDegrees() {
		return this.studentDegrees;
	}

	public void setStudentDegrees(Set<StudentDegree> studentDegrees) {
		this.studentDegrees = studentDegrees;
	}

	public StudentDegree addStudentDegree(StudentDegree studentDegree) {
		getStudentDegrees().add(studentDegree);
		studentDegree.setDegree(this);

		return studentDegree;
	}

	public StudentDegree removeStudentDegree(StudentDegree studentDegree) {
		getStudentDegrees().remove(studentDegree);
		studentDegree.setDegree(null);

		return studentDegree;
	}


	//bi-directional many-to-one association to SemesterYear
	
	@OneToMany(mappedBy="degree")
	public Set<SemesterYear> getSemesterYears() {
		return this.semesterYears;
	}

	public void setSemesterYears(Set<SemesterYear> semesterYears) {
		this.semesterYears = semesterYears;
	}

	public SemesterYear addSemesterYear(SemesterYear semesterYear) {
		getSemesterYears().add(semesterYear);
		semesterYear.setDegree(this);

		return semesterYear;
	}

	public SemesterYear removeSemesterYear(SemesterYear semesterYear) {
		getSemesterYears().remove(semesterYear);
		semesterYear.setDegree(null);

		return semesterYear;
	}

}