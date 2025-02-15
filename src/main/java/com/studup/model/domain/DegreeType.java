//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.04.23 at 03:42:22 PM IST 
//


package com.studup.model.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for degreeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="degreeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="semesterYear" type="{http://www.example.org/Student}semesterYearType" maxOccurs="unbounded"/>
 *         &lt;element name="accreditation" type="{http://www.example.org/Student}accreditationType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="degreeName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "degreeType", propOrder = {
    "semesterYear",
    "accreditation"
})
public class DegreeType {

    @XmlElement(required = true)
    protected List<SemesterYearType> semesterYear;
    @XmlElement(required = true)
    protected AccreditationType accreditation;
    @XmlAttribute(name = "id")
    protected Integer id;
    @XmlAttribute(name = "degreeName")
    protected String degreeName;

    /**
     * Gets the value of the semesterYear property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the semesterYear property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSemesterYear().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SemesterYearType }
     * 
     * 
     */
    public List<SemesterYearType> getSemesterYear() {
        if (semesterYear == null) {
            semesterYear = new ArrayList<SemesterYearType>();
        }
        return this.semesterYear;
    }

    /**
     * Gets the value of the accreditation property.
     * 
     * @return
     *     possible object is
     *     {@link AccreditationType }
     *     
     */
    public AccreditationType getAccreditation() {
        return accreditation;
    }

    /**
     * Sets the value of the accreditation property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccreditationType }
     *     
     */
    public void setAccreditation(AccreditationType value) {
        this.accreditation = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the degreeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDegreeName() {
        return degreeName;
    }

    /**
     * Sets the value of the degreeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDegreeName(String value) {
        this.degreeName = value;
    }

}
