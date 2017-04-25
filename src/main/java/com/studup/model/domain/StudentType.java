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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for StudentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StudentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="universityCollege" type="{http://www.example.org/Student}universityCollegeType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="city" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="country" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="dob" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="emailId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="firstname" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="lastname" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="midname" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="mobileNo" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="permanentaddress" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="state" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="tagline" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="zip" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StudentType", propOrder = {
    "universityCollege"
})
public class StudentType {

    @XmlElement(required = true)
    protected List<UniversityCollegeType> universityCollege;
    @XmlAttribute(name = "id")
    protected Integer id;
    @XmlAttribute(name = "city")
    protected String city;
    @XmlAttribute(name = "country")
    protected String country;
    @XmlAttribute(name = "dob")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dob;
    @XmlAttribute(name = "emailId")
    protected String emailId;
    @XmlAttribute(name = "firstname")
    protected String firstname;
    @XmlAttribute(name = "lastname")
    protected String lastname;
    @XmlAttribute(name = "midname")
    protected String midname;
    @XmlAttribute(name = "mobileNo")
    protected Integer mobileNo;
    @XmlAttribute(name = "permanentaddress")
    protected String permanentaddress;
    @XmlAttribute(name = "state")
    protected String state;
    @XmlAttribute(name = "tagline")
    protected String tagline;
    @XmlAttribute(name = "zip")
    protected String zip;

    /**
     * Gets the value of the universityCollege property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the universityCollege property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUniversityCollege().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UniversityCollegeType }
     * 
     * 
     */
    public List<UniversityCollegeType> getUniversityCollege() {
        if (universityCollege == null) {
            universityCollege = new ArrayList<UniversityCollegeType>();
        }
        return this.universityCollege;
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
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the dob property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDob() {
        return dob;
    }

    /**
     * Sets the value of the dob property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDob(XMLGregorianCalendar value) {
        this.dob = value;
    }

    /**
     * Gets the value of the emailId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * Sets the value of the emailId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailId(String value) {
        this.emailId = value;
    }

    /**
     * Gets the value of the firstname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the value of the firstname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstname(String value) {
        this.firstname = value;
    }

    /**
     * Gets the value of the lastname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the value of the lastname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastname(String value) {
        this.lastname = value;
    }

    /**
     * Gets the value of the midname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMidname() {
        return midname;
    }

    /**
     * Sets the value of the midname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMidname(String value) {
        this.midname = value;
    }

    /**
     * Gets the value of the mobileNo property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMobileNo() {
        return mobileNo;
    }

    /**
     * Sets the value of the mobileNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMobileNo(Integer value) {
        this.mobileNo = value;
    }

    /**
     * Gets the value of the permanentaddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPermanentaddress() {
        return permanentaddress;
    }

    /**
     * Sets the value of the permanentaddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPermanentaddress(String value) {
        this.permanentaddress = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the tagline property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTagline() {
        return tagline;
    }

    /**
     * Sets the value of the tagline property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTagline(String value) {
        this.tagline = value;
    }

    /**
     * Gets the value of the zip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZip() {
        return zip;
    }

    /**
     * Sets the value of the zip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZip(String value) {
        this.zip = value;
    }

}
