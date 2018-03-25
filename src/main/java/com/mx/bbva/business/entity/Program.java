/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entity;

import com.google.appengine.repackaged.org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Guevara
 */
@Entity
@Table(name = "thge023_programa",  uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_PROGRAMA"})})
public class Program implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_PROGRAMA", nullable = false)
    private Integer programId;
    @Basic(optional = false)
    @Column(name = "NB_PROGRAMA", nullable = false, length = 50)
    private String programName;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "program")
    private List<ProgramIncrement> programIncrements;

    public Program() {
    }

    public Program(Integer programId) {
        this.programId = programId;
    }

    public Program(Integer programId, String programName) {
        this.programId = programId;
        this.programName = programName;
    }

    public Integer getProgramId() {
        return programId;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public List<ProgramIncrement> getProgramIncrements() {
        return programIncrements;
    }

    public void setProgramIncrements(List<ProgramIncrement> programIncrements) {
        this.programIncrements = programIncrements;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programId != null ? programId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Program)) {
            return false;
        }
        Program other = (Program) object;
        return (this.programId != null || other.programId == null) && (this.programId == null || this.programId.equals(other.programId));
    }

    @Override
    public String toString() {
        return "com.bbva.Program[ programId=" + programId + " ]";
    }

}
