/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbva.bancomer.business.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Guevara
 */
@Entity
@Table(name = "THGE035_tipo_proy", catalog = "gestion_factoria", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_TIPO_PROY"})})
public class ProjectType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_TIPO_PROY", nullable = false)
    private Integer projectTypeId;
    @Basic(optional = false)
    @Column(name = "NB_TIPO_PROY", nullable = false, length = 25)
    private String projectTypeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectType")
    private List<Requirement> requirements;

    public ProjectType() {
    }

    public ProjectType(Integer projectTypeId) {
        this.projectTypeId = projectTypeId;
    }

    public ProjectType(Integer projectTypeId, String projectTypeName) {
        this.projectTypeId = projectTypeId;
        this.projectTypeName = projectTypeName;
    }

    public Integer getProjectTypeId() {
        return projectTypeId;
    }

    public void setProjectTypeId(Integer projectTypeId) {
        this.projectTypeId = projectTypeId;
    }

    public String getProjectTypeName() {
        return projectTypeName;
    }

    public void setProjectTypeName(String projectTypeName) {
        this.projectTypeName = projectTypeName;
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
        hash += (projectTypeId != null ? projectTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ProjectType)) {
            return false;
        }
        ProjectType other = (ProjectType) object;
        return (this.projectTypeId != null || other.projectTypeId == null) && (this.projectTypeId == null || this.projectTypeId.equals(other.projectTypeId));
    }

    @Override
    public String toString() {
        return "com.bbva.ProjectType[ projectTypeId=" + projectTypeId + " ]";
    }

}
