package com.studup.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the student_university database table.
 * 
 */
@XmlRootElement
@Entity
@Table(name="student_university")
@NamedQuery(name="StudentUniversity.findAll", query="SELECT s FROM StudentUniversity s")
public class StudentUniversity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Student student;
	private UniversityCollege universityCollege;

	public StudentUniversity() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	//bi-directional many-to-one association to Student
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="student_id")
	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


	//bi-directional many-to-one association to UniversityCollege

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="university_college_id")
	public UniversityCollege getUniversityCollege() {
		return this.universityCollege;
	}

	public void setUniversityCollege(UniversityCollege universityCollege) {
		this.universityCollege = universityCollege;
	}

}