package com.studup.model.domain;

import java.io.Serializable;

public class StudentProfile implements Serializable {

	private static final long serialVersionUID = 906758743334323891L;

	private String firstname;
	private String lastname;
	private String midname;
	private String tagLine;
	private String collegeOrUniversity;
	private String department;
	private String highestDegree;

	public StudentProfile() {
	}

	public StudentProfile(String firstname, String lastname, String midname, String tagLine, String collegeOrUniversity,
			String department, String highestDegree) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.midname = midname;
		this.tagLine = tagLine;
		this.collegeOrUniversity = collegeOrUniversity;
		this.department = department;
		this.highestDegree = highestDegree;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMidname() {
		return midname;
	}

	public void setMidname(String midname) {
		this.midname = midname;
	}

	public String getTagLine() {
		return tagLine;
	}

	public void setTagLine(String tagLine) {
		this.tagLine = tagLine;
	}

	public String getCollegeOrUniversity() {
		return collegeOrUniversity;
	}

	public void setCollegeOrUniversity(String collegeOrUniversity) {
		this.collegeOrUniversity = collegeOrUniversity;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getHighestDegree() {
		return highestDegree;
	}

	public void setHighestDegree(String highestDegree) {
		this.highestDegree = highestDegree;
	}

}
