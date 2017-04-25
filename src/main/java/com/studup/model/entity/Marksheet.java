package com.studup.model.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the marksheet database table.
 * 
 */
@XmlRootElement
@Entity
@NamedQuery(name="Marksheet.findAll", query="SELECT m FROM Marksheet m")
public class Marksheet implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Boolean isverified;
	private String marksheetpdf;
	private SemesterYear semesterYear;
	private Student student;
	private Set<MarksheetSubject> marksheetSubjects;

	public Marksheet() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Boolean getIsverified() {
		return this.isverified;
	}

	public void setIsverified(Boolean isverified) {
		this.isverified = isverified;
	}


	public String getMarksheetpdf() {
		return this.marksheetpdf;
	}

	public void setMarksheetpdf(String marksheetpdf) {
		this.marksheetpdf = marksheetpdf;
	}


	//bi-directional one-to-one association to SemesterYear
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="semester_year_id")
	public SemesterYear getSemesterYear() {
		return this.semesterYear;
	}

	public void setSemesterYear(SemesterYear semesterYear) {
		this.semesterYear = semesterYear;
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


	//bi-directional many-to-one association to MarksheetSubject
	
	@OneToMany(mappedBy="marksheet")
	public Set<MarksheetSubject> getMarksheetSubjects() {
		return this.marksheetSubjects;
	}

	public void setMarksheetSubjects(Set<MarksheetSubject> marksheetSubjects) {
		this.marksheetSubjects = marksheetSubjects;
	}

	public MarksheetSubject addMarksheetSubject(MarksheetSubject marksheetSubject) {
		getMarksheetSubjects().add(marksheetSubject);
		marksheetSubject.setMarksheet(this);

		return marksheetSubject;
	}

	public MarksheetSubject removeMarksheetSubject(MarksheetSubject marksheetSubject) {
		getMarksheetSubjects().remove(marksheetSubject);
		marksheetSubject.setMarksheet(null);

		return marksheetSubject;
	}

}