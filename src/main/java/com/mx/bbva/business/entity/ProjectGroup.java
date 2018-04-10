/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author manug
 */
@Entity
@Table(name = "thge065_nb_proy_ag")
public class ProjectGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "CD_PROY_AGRUP")
    private Integer projectGroupId;

    @Column(name = "NB_PROY_AGRUP")
    private String projectGroupName;

    public ProjectGroup() {
    }

    public ProjectGroup(Integer projectGroupId) {
        this.projectGroupId = projectGroupId;
    }

    public ProjectGroup(Integer projectGroupId, String projectGroupName) {
        this.projectGroupId = projectGroupId;
        this.projectGroupName = projectGroupName;
    }

    public Integer getProjectGroupId() {
        return projectGroupId;
    }

    public void setProjectGroupId(Integer projectGroupId) {
        this.projectGroupId = projectGroupId;
    }

    public String getProjectGroupName() {
        return projectGroupName;
    }

    public void setProjectGroupName(String projectGroupName) {
        this.projectGroupName = projectGroupName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectGroupId != null ? projectGroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectGroup)) {
            return false;
        }
        ProjectGroup other = (ProjectGroup) object;
        if ((this.projectGroupId == null && other.projectGroupId != null) || (this.projectGroupId != null && !this.projectGroupId.equals(other.projectGroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.ProjectGroup[ projectGroupId=" + projectGroupId + " ]";
    }

}
