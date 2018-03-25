/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Guevara
 */
@Entity
@Table(name = "thge022_pi",  uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CD_SCRUM"})})
public class ProgramIncrement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_CONS_PI", nullable = false)
    private Integer programIncrementId;
    @Basic(optional = false)
    @Column(name = "CD_SCRUM", nullable = false)
    private int programIncrementScrumId;
    @Basic(optional = false)
    @Column(name = "NB_SCRUM", nullable = false, length = 100)
    private String programIncrementScrumName;
    @OneToMany(mappedBy = "programIncrementScrum")
    private List<Requirement> requirements;
    @JoinColumn(name = "CD_DUENO_PROD", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne
    private User userOwner;
    @JoinColumn(name = "CD_EXPERTO_SCRUM", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne
    private User userScrumMaster;
    @JoinColumn(name = "CD_TIPO_PI", referencedColumnName = "CD_TIPO_PI", nullable = false)
    @ManyToOne(optional = false)
    private ProgramIncrementType programIncrementType;
    @JoinColumn(name = "CD_PROGRAMA", referencedColumnName = "CD_PROGRAMA", nullable = false)
    @ManyToOne(optional = false)
    private Program program;

    public ProgramIncrement() {
    }

    public ProgramIncrement(Integer programIncrementId) {
        this.programIncrementId = programIncrementId;
    }

    public ProgramIncrement(Integer programIncrementId, int programIncrementScrumId, String programIncrementScrumName) {
        this.programIncrementId = programIncrementId;
        this.programIncrementScrumId = programIncrementScrumId;
        this.programIncrementScrumName = programIncrementScrumName;
    }

    public Integer getProgramIncrementId() {
        return programIncrementId;
    }

    public void setProgramIncrementId(Integer programIncrementId) {
        this.programIncrementId = programIncrementId;
    }

    public int getProgramIncrementScrumId() {
        return programIncrementScrumId;
    }

    public void setProgramIncrementScrumId(int programIncrementScrumId) {
        this.programIncrementScrumId = programIncrementScrumId;
    }

    public String getProgramIncrementScrumName() {
        return programIncrementScrumName;
    }

    public void setProgramIncrementScrumName(String programIncrementScrumName) {
        this.programIncrementScrumName = programIncrementScrumName;
    }

    public List<Requirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Requirement> requirements) {
        this.requirements = requirements;
    }

    public User getUserOwner() {
        return userOwner;
    }

    public void setUserOwner(User userOwner) {
        this.userOwner = userOwner;
    }

    public User getCdExpertoScrum() {
        return userScrumMaster;
    }

    public void setCdExpertoScrum(User cdExpertoScrum) {
        this.userScrumMaster = cdExpertoScrum;
    }

    public ProgramIncrementType getProgramIncrementType() {
        return programIncrementType;
    }

    public void setProgramIncrementType(ProgramIncrementType programIncrementType) {
        this.programIncrementType = programIncrementType;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
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
        return "com.bbva.ProgramIncrement[ programIncrementId=" + programIncrementId + " ]";
    }

}
