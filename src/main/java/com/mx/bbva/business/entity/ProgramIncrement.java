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
@Table(name = "thge013_pi")
public class ProgramIncrement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_PI", nullable = false)
    private Integer programIncrementId;
    @Basic(optional = false)
    @Column(name = "NB_PI", nullable = false, length = 25)
    private String ProgramIncrementName;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programIncrement")
    private List<Project> projects;
    @OneToMany(mappedBy = "programIncrement")
    private List<Requirement> requirements;

    public ProgramIncrement() {
    }

    public ProgramIncrement(Integer programIncrementId) {
        this.programIncrementId = programIncrementId;
    }

    public ProgramIncrement(Integer programIncrementId, String ProgramIncrementName) {
        this.programIncrementId = programIncrementId;
        this.ProgramIncrementName = ProgramIncrementName;
    }

    public Integer getProgramIncrementId() {
        return programIncrementId;
    }

    public void setProgramIncrementId(Integer programIncrementId) {
        this.programIncrementId = programIncrementId;
    }

    public String getProgramIncrementName() {
        return ProgramIncrementName;
    }

    public void setProgramIncrementName(String programIncrementName) {
        this.ProgramIncrementName = programIncrementName;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Requirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Requirement> requirements) {
        this.requirements = requirements;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programIncrementId != null ? programIncrementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ProgramIncrement)) {
            return false;
        }
        ProgramIncrement other = (ProgramIncrement) object;
        return (this.programIncrementId != null || other.programIncrementId == null) && (this.programIncrementId == null || this.programIncrementId.equals(other.programIncrementId));
    }

    @Override
    public String toString() {
        return "com.bbva.ProgramIncrementType[ programIncrementId=" + programIncrementId + " ]";
    }

}
