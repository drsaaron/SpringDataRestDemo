/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.springdatarestdemo;

import java.io.Serializable;
import java.util.Date;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author scott
 */
@Entity
@Table(name = "JobRole")
@NamedQueries({
    @NamedQuery(name = "JobRole_1.findAll", query = "SELECT j FROM JobRole_1 j"),
    @NamedQuery(name = "JobRole_1.findById", query = "SELECT j FROM JobRole_1 j WHERE j.id = :id"),
    @NamedQuery(name = "JobRole_1.findByStartDate", query = "SELECT j FROM JobRole_1 j WHERE j.startDate = :startDate"),
    @NamedQuery(name = "JobRole_1.findByEndDate", query = "SELECT j FROM JobRole_1 j WHERE j.endDate = :endDate"),
    @NamedQuery(name = "JobRole_1.findByRoleType", query = "SELECT j FROM JobRole_1 j WHERE j.roleType = :roleType")})
public class JobRole_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "roleType")
    private String roleType;
    @JoinColumn(name = "personId", referencedColumnName = "id")
    @ManyToOne
    private Person_1 personId;

    public JobRole_1() {
    }

    public JobRole_1(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
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
        if (!(object instanceof JobRole_1)) {
            return false;
        }
        JobRole_1 other = (JobRole_1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.blazartech.springdatarestdemo.JobRole_1[ id=" + id + " ]";
    }
    
}
