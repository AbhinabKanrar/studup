package com.studup.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the student_degree database table.
 * 
 */
@XmlRootElement
@Entity
@Table(name="student_degree")
@NamedQuery(name="StudentDegree.findAll", query="SELECT s FROM StudentDegree s")
public class StudentDegree implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Date attendedfrom;
	private Date attendedto;
	private Student student;
	private Degree degree;
	private Accreditation accreditation;

	public StudentDegree() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Temporal(TemporalType.DATE)
	public Date getAttendedfrom() {
		return this.attendedfrom;
	}

	public void setAttendedfrom(Date attendedfrom) {
		this.attendedfrom = attendedfrom;
	}


	@Temporal(TemporalType.DATE)
	public Date getAttendedto() {
		return this.attendedto;
	}

	public void setAttendedto(Date attendedto) {
		this.attendedto = attendedto;
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


	//bi-directional many-to-one association to Degree

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="degree_id")
	public Degree getDegree() {
		return this.degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}


	//bi-directional one-to-one association to Accreditation
	@OneToOne(mappedBy="studentDegree", fetch=FetchType.LAZY)
	public Accreditation getAccreditation() {
		return this.accreditation;
	}

	public void setAccreditation(Accreditation accreditation) {
		this.accreditation = accreditation;
	}

}