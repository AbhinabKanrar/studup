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
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the department database table.
 * 
 */
@XmlRootElement
@Entity
@NamedQuery(name="Department.findAll", query="SELECT d FROM Department d")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String depttname;
	private UniversityCollege universityCollege;
	private Set<Degree> degrees;

	public Department() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getDepttname() {
		return this.depttname;
	}

	public void setDepttname(String depttname) {
		this.depttname = depttname;
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


	//bi-directional many-to-one association to Degree
	@OneToMany(mappedBy="department")
	public Set<Degree> getDegrees() {
		return this.degrees;
	}

	public void setDegrees(Set<Degree> degrees) {
		this.degrees = degrees;
	}

	public Degree addDegree(Degree degree) {
		getDegrees().add(degree);
		degree.setDepartment(this);

		return degree;
	}

	public Degree removeDegree(Degree degree) {
		getDegrees().remove(degree);
		degree.setDepartment(null);

		return degree;
	}

}