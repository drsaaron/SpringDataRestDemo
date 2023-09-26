/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.springdatarestdemo;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 *
 * @author scott
 */
@Entity
@Table(name = "PersonAddress")
@NamedQueries({
    @NamedQuery(name = "PersonAddress.findAll", query = "SELECT p FROM PersonAddress p"),
    @NamedQuery(name = "PersonAddress.findById", query = "SELECT p FROM PersonAddress p WHERE p.id = :id"),
    @NamedQuery(name = "PersonAddress.findByStreetName", query = "SELECT p FROM PersonAddress p WHERE p.streetName = :streetName"),
    @NamedQuery(name = "PersonAddress.findByStateName", query = "SELECT p FROM PersonAddress p WHERE p.stateName = :stateName"),
    @NamedQuery(name = "PersonAddress.findByZipCode", query = "SELECT p FROM PersonAddress p WHERE p.zipCode = :zipCode")})
public class PersonAddress implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "streetName")
    private String streetName;
    @Column(name = "stateName")
    private String stateName;
    @Column(name = "zipCode")
    private String zipCode;
    @JoinColumn(name = "personId", referencedColumnName = "id")
    @ManyToOne
    private Person_1 personId;

    public PersonAddress() {
    }

    public PersonAddress(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Person_1 getPersonId() {
        return personId;
    }

    public void setPersonId(Person_1 personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonAddress)) {
            return false;
        }
        PersonAddress other = (PersonAddress) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.blazartech.springdatarestdemo.PersonAddress[ id=" + id + " ]";
    }
    
}
