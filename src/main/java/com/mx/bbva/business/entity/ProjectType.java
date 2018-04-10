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
 * @author manug
 */
@Entity
@Table(name = "thge066_tp_proy")
public class ProjectType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "CD_TP_PROYECTO")
    private Integer projectTypeId;

    @Column(name = "NB_TP_PROYECTO")
    private String projectTypeName;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectType")
    private List<ExternalUser> externalUsers;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectTypeGroup")
    private List<ExternalUser> externalUserList;

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

    public List<ExternalUser> getExternalUsers() {
        return externalUsers;
    }

    public void setExternalUsers(List<ExternalUser> externalUsers) {
        this.externalUsers = externalUsers;
    }

    public List<ExternalUser> getExternalUserList() {
        return externalUserList;
    }

    public void setExternalUserList(List<ExternalUser> externalUserList) {
        this.externalUserList = externalUserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectTypeId != null ? projectTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectType)) {
            return false;
        }
        ProjectType other = (ProjectType) object;
        if ((this.projectTypeId == null && other.projectTypeId != null) || (this.projectTypeId != null && !this.projectTypeId.equals(other.projectTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.ProjectType[ projectTypeId=" + projectTypeId + " ]";
    }

}
