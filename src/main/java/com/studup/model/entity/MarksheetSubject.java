package com.studup.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the marksheet_subject database table.
 * 
 */
@XmlRootElement
@Entity
@Table(name="marksheet_subject")
@NamedQuery(name="MarksheetSubject.findAll", query="SELECT m FROM MarksheetSubject m")
public class MarksheetSubject implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String earnedgrade;
	private Integer marksreceived;
	private Marksheet marksheet;
	private SubjectDetail subjectDetail;

	public MarksheetSubject() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getEarnedgrade() {
		return this.earnedgrade;
	}

	public void setEarnedgrade(String earnedgrade) {
		this.earnedgrade = earnedgrade;
	}


	public Integer getMarksreceived() {
		return this.marksreceived;
	}

	public void setMarksreceived(Integer marksreceived) {
		this.marksreceived = marksreceived;
	}


	//bi-directional many-to-one association to Marksheet
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="marksheet_id")
	public Marksheet getMarksheet() {
		return this.marksheet;
	}

	public void setMarksheet(Marksheet marksheet) {
		this.marksheet = marksheet;
	}


	//bi-directional many-to-one association to SubjectDetail
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="subject_details_id")
	public SubjectDetail getSubjectDetail() {
		return this.subjectDetail;
	}

	public void setSubjectDetail(SubjectDetail subjectDetail) {
		this.subjectDetail = subjectDetail;
	}

}