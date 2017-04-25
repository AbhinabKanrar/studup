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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the semester_year database table.
 * 
 */
@XmlRootElement
@Entity
@Table(name="semester_year")
@NamedQuery(name="SemesterYear.findAll", query="SELECT s FROM SemesterYear s")
public class SemesterYear implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Boolean issemester;
	private Integer semyear;
	private Degree degree;
	private Marksheet marksheet;
	private Set<SubjectDetail> subjectDetails;

	public SemesterYear() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Boolean getIssemester() {
		return this.issemester;
	}

	public void setIssemester(Boolean issemester) {
		this.issemester = issemester;
	}


	public Integer getSemyear() {
		return this.semyear;
	}

	public void setSemyear(Integer semyear) {
		this.semyear = semyear;
	}


	//bi-directional many-to-one association to Degree
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="degree_id")
	public Degree getDegree() {
		return this.degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}


	//bi-directional one-to-one association to Marksheet
	@OneToOne(mappedBy="semesterYear", fetch=FetchType.LAZY)
	public Marksheet getMarksheet() {
		return this.marksheet;
	}

	public void setMarksheet(Marksheet marksheet) {
		this.marksheet = marksheet;
	}


	//bi-directional many-to-one association to SubjectDetail
	@OneToMany(mappedBy="semesterYear")
	public Set<SubjectDetail> getSubjectDetails() {
		return this.subjectDetails;
	}

	public void setSubjectDetails(Set<SubjectDetail> subjectDetails) {
		this.subjectDetails = subjectDetails;
	}

	public SubjectDetail addSubjectDetail(SubjectDetail subjectDetail) {
		getSubjectDetails().add(subjectDetail);
		subjectDetail.setSemesterYear(this);

		return subjectDetail;
	}

	public SubjectDetail removeSubjectDetail(SubjectDetail subjectDetail) {
		getSubjectDetails().remove(subjectDetail);
		subjectDetail.setSemesterYear(null);

		return subjectDetail;
	}

}