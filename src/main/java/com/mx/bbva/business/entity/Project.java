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
@Table(name = "thge022_proyecto", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CD_SDA"})})
public class Project implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_PROYECTO", nullable = false)
    private Integer projectId;
    @Basic(optional = false)
    @Column(name = "CD_SDA", nullable = false)
    private String projectScrumId;
    @JoinColumn(name = "CD_PI", referencedColumnName = "CD_PI", nullable = false)
    @ManyToOne(optional = false)
    private ProgramIncrement programIncrement;
    @JoinColumn(name = "CD_METODOLOGIA", referencedColumnName = "CD_METODOLOGIA", nullable = false)
    @ManyToOne(optional = false)
    private Methodology methodology;
    @OneToMany(mappedBy = "project")
    private List<Requirement> requirements;

    public Project() {
    }

    public Project(Integer projectId) {
        this.projectId = projectId;
    }

    public Project(Integer projectId, String projectScrumId) {
        this.projectId = projectId;
        this.projectScrumId = projectScrumId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectScrumId() {
        return projectScrumId;
    }

    public void setProjectScrumId(String projectScrumId) {
        this.projectScrumId = projectScrumId;
    }

    public ProgramIncrement getProgramIncrement() {
        return programIncrement;
    }

    public void setProgramIncrement(ProgramIncrement programIncrement) {
        this.programIncrement = programIncrement;
    }

    public Methodology getMethodology() {
        return methodology;
    }

    public void setMethodology(Methodology methodology) {
        this.methodology = methodology;
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
        hash += (projectId != null ? projectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        return (this.projectId != null || other.projectId == null) && (this.projectId == null || this.projectId.equals(other.projectId));
    }

    @Override
    public String toString() {
        return "com.bbva.ProgramIncrement[ projectId=" + projectId + " ]";
    }

}
