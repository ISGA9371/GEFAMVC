/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Guevara
 */
@Entity
@Table(name = "thge035_metodologia", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_METODOLOGIA"})})
public class Methodology implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_METODOLOGIA", nullable = false)
    private Integer methodologyId;
    @Basic(optional = false)
    @Column(name = "NB_METODOLOGIA", nullable = false, length = 25)
    private String methodologyName;
    @JsonIgnore
    @OneToMany(mappedBy = "methodology")
    private List<Project> projects;

    public Methodology() {
    }

    public Methodology(Integer methodologyId) {
        this.methodologyId = methodologyId;
    }

    public Methodology(Integer methodologyId, String methodologyName) {
        this.methodologyId = methodologyId;
        this.methodologyName = methodologyName;
    }

    public Integer getMethodologyId() {
        return methodologyId;
    }

    public void setMethodologyId(Integer methodologyId) {
        this.methodologyId = methodologyId;
    }

    public String getMethodologyName() {
        return methodologyName;
    }

    public void setMethodologyName(String methodologyName) {
        this.methodologyName = methodologyName;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (methodologyId != null ? methodologyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Methodology)) {
            return false;
        }
        Methodology other = (Methodology) object;
        return (this.methodologyId != null || other.methodologyId == null) && (this.methodologyId == null || this.methodologyId.equals(other.methodologyId));
    }

    @Override
    public String toString() {
        return "com.bbva.Methodology[ methodologyId=" + methodologyId + " ]";
    }

}
