package com.studup.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the accreditation database table.
 * 
 */
@XmlRootElement
@Entity
@NamedQuery(name="Accreditation.findAll", query="SELECT a FROM Accreditation a")
public class Accreditation implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer cgpamax;
	private Boolean cgpaorpercentageHide;
	private Integer cgpareceived;
	private Integer classrank;
	private Boolean classrankhide;
	private Integer depttrank;
	private Boolean depttrankhide;
	private Integer percentage;
	private StudentDegree studentDegree;

	public Accreditation() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getCgpamax() {
		return this.cgpamax;
	}

	public void setCgpamax(Integer cgpamax) {
		this.cgpamax = cgpamax;
	}


	@Column(name="cgpaorpercentage_hide")
	public Boolean getCgpaorpercentageHide() {
		return this.cgpaorpercentageHide;
	}

	public void setCgpaorpercentageHide(Boolean cgpaorpercentageHide) {
		this.cgpaorpercentageHide = cgpaorpercentageHide;
	}


	public Integer getCgpareceived() {
		return this.cgpareceived;
	}

	public void setCgpareceived(Integer cgpareceived) {
		this.cgpareceived = cgpareceived;
	}


	public Integer getClassrank() {
		return this.classrank;
	}

	public void setClassrank(Integer classrank) {
		this.classrank = classrank;
	}


	public Boolean getClassrankhide() {
		return this.classrankhide;
	}

	public void setClassrankhide(Boolean classrankhide) {
		this.classrankhide = classrankhide;
	}


	public Integer getDepttrank() {
		return this.depttrank;
	}

	public void setDepttrank(Integer depttrank) {
		this.depttrank = depttrank;
	}


	public Boolean getDepttrankhide() {
		return this.depttrankhide;
	}

	public void setDepttrankhide(Boolean depttrankhide) {
		this.depttrankhide = depttrankhide;
	}


	public Integer getPercentage() {
		return this.percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}


	//bi-directional one-to-one association to StudentDegree
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="student_degree_id")
	public StudentDegree getStudentDegree() {
		return this.studentDegree;
	}

	public void setStudentDegree(StudentDegree studentDegree) {
		this.studentDegree = studentDegree;
	}

}