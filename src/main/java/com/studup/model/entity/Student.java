package com.studup.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * The persistent class for the student database table.
 * 
 */
@XmlRootElement
@Entity
@NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String city;
	private String country;
	private Date dob;
	private String emailId;
	private String firstname;
	private String lastname;
	private String midname;
	private Integer mobileNo;
	private String permanentaddress;
	private String state;
	private String tagline;
	private Integer zip;
	private Set<StudentUniversity> studentUniversities;
	private Set<StudentDegree> studentDegrees;
	private Set<Marksheet> marksheets;

	public Student() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Temporal(TemporalType.DATE)
	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Column(name = "email_id")
	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMidname() {
		return this.midname;
	}

	public void setMidname(String midname) {
		this.midname = midname;
	}

	@Column(name = "mobile_no")
	public Integer getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(Integer mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPermanentaddress() {
		return this.permanentaddress;
	}

	public void setPermanentaddress(String permanentaddress) {
		this.permanentaddress = permanentaddress;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTagline() {
		return this.tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public Integer getZip() {
		return this.zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	// bi-directional many-to-one association to StudentUniversity
	
	@OneToMany(mappedBy = "student")
	public Set<StudentUniversity> getStudentUniversities() {
		return this.studentUniversities;
	}

	public void setStudentUniversities(Set<StudentUniversity> studentUniversities) {
		this.studentUniversities = studentUniversities;
	}

	public StudentUniversity addStudentUniversity(StudentUniversity studentUniversity) {
		getStudentUniversities().add(studentUniversity);
		studentUniversity.setStudent(this);

		return studentUniversity;
	}

	public StudentUniversity removeStudentUniversity(StudentUniversity studentUniversity) {
		getStudentUniversities().remove(studentUniversity);
		studentUniversity.setStudent(null);

		return studentUniversity;
	}

	// bi-directional many-to-one association to StudentDegree
	
	@OneToMany(mappedBy = "student")
	public Set<StudentDegree> getStudentDegrees() {
		return this.studentDegrees;
	}

	public void setStudentDegrees(Set<StudentDegree> studentDegrees) {
		this.studentDegrees = studentDegrees;
	}

	public StudentDegree addStudentDegree(StudentDegree studentDegree) {
		getStudentDegrees().add(studentDegree);
		studentDegree.setStudent(this);

		return studentDegree;
	}

	public StudentDegree removeStudentDegree(StudentDegree studentDegree) {
		getStudentDegrees().remove(studentDegree);
		studentDegree.setStudent(null);

		return studentDegree;
	}

	// bi-directional many-to-one association to Marksheet
	
	@OneToMany(mappedBy = "student")
	public Set<Marksheet> getMarksheets() {
		return this.marksheets;
	}

	public void setMarksheets(Set<Marksheet> marksheets) {
		this.marksheets = marksheets;
	}

	public Marksheet addMarksheet(Marksheet marksheet) {
		getMarksheets().add(marksheet);
		marksheet.setStudent(this);

		return marksheet;
	}

	public Marksheet removeMarksheet(Marksheet marksheet) {
		getMarksheets().remove(marksheet);
		marksheet.setStudent(null);

		return marksheet;
	}

}