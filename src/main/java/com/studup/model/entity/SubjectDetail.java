package com.studup.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Set;


/**
 * The persistent class for the subject_details database table.
 * 
 */
@XmlRootElement
@Entity
@Table(name="subject_details")
@NamedQuery(name="SubjectDetail.findAll", query="SELECT s FROM SubjectDetail s")
public class SubjectDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer marksmax;
	private String subjcode;
	private String subjname;
	private String subjtag;
	private SemesterYear semesterYear;
	private Set<MarksheetSubject> marksheetSubjects;

	public SubjectDetail() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getMarksmax() {
		return this.marksmax;
	}

	public void setMarksmax(Integer marksmax) {
		this.marksmax = marksmax;
	}


	public String getSubjcode() {
		return this.subjcode;
	}

	public void setSubjcode(String subjcode) {
		this.subjcode = subjcode;
	}


	public String getSubjname() {
		return this.subjname;
	}

	public void setSubjname(String subjname) {
		this.subjname = subjname;
	}


	public String getSubjtag() {
		return this.subjtag;
	}

	public void setSubjtag(String subjtag) {
		this.subjtag = subjtag;
	}


	//bi-directional many-to-one association to SemesterYear
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="semester_year_id")
	public SemesterYear getSemesterYear() {
		return this.semesterYear;
	}

	public void setSemesterYear(SemesterYear semesterYear) {
		this.semesterYear = semesterYear;
	}


	//bi-directional many-to-one association to MarksheetSubject
	@OneToMany(mappedBy="subjectDetail")
	public Set<MarksheetSubject> getMarksheetSubjects() {
		return this.marksheetSubjects;
	}

	public void setMarksheetSubjects(Set<MarksheetSubject> marksheetSubjects) {
		this.marksheetSubjects = marksheetSubjects;
	}

	public MarksheetSubject addMarksheetSubject(MarksheetSubject marksheetSubject) {
		getMarksheetSubjects().add(marksheetSubject);
		marksheetSubject.setSubjectDetail(this);

		return marksheetSubject;
	}

	public MarksheetSubject removeMarksheetSubject(MarksheetSubject marksheetSubject) {
		getMarksheetSubjects().remove(marksheetSubject);
		marksheetSubject.setSubjectDetail(null);

		return marksheetSubject;
	}

}