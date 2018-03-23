/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbva.bancomer.business.model;

import com.google.appengine.repackaged.org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Guevara
 */
@Entity
@Table(name = "THGE013_tipo_pi")
public class ProgramIncrementType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_TIPO_PI", nullable = false)
    private Integer programIncrementTypeId;
    @Basic(optional = false)
    @Column(name = "NB_PI", nullable = false, length = 25)
    private String ProgramIncrementTypeName;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programIncrementType")
    private List<ProgramIncrement> programIncrements;

    public ProgramIncrementType() {
    }

    public ProgramIncrementType(Integer programIncrementTypeId) {
        this.programIncrementTypeId = programIncrementTypeId;
    }

    public ProgramIncrementType(Integer programIncrementTypeId, String ProgramIncrementTypeName) {
        this.programIncrementTypeId = programIncrementTypeId;
        this.ProgramIncrementTypeName = ProgramIncrementTypeName;
    }

    public Integer getProgramIncrementTypeId() {
        return programIncrementTypeId;
    }

    public void setProgramIncrementTypeId(Integer programIncrementTypeId) {
        this.programIncrementTypeId = programIncrementTypeId;
    }

    public String getProgramIncrementTypeName() {
        return ProgramIncrementTypeName;
    }

    public void setProgramIncrementTypeName(String programIncrementTypeName) {
        this.ProgramIncrementTypeName = programIncrementTypeName;
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
        hash += (programIncrementTypeId != null ? programIncrementTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ProgramIncrementType)) {
            return false;
        }
        ProgramIncrementType other = (ProgramIncrementType) object;
        return (this.programIncrementTypeId != null || other.programIncrementTypeId == null) && (this.programIncrementTypeId == null || this.programIncrementTypeId.equals(other.programIncrementTypeId));
    }

    @Override
    public String toString() {
        return "com.bbva.ProgramIncrementType[ programIncrementTypeId=" + programIncrementTypeId + " ]";
    }

}
