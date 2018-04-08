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
@Table(name = "thge071_ctrl_proy")
public class ProjectControl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_CTRL_PROY")
    private Integer projectControlId;
    @JoinColumn(name = "CD_REQUERIMIENTO", referencedColumnName = "CD_REQUERIMIENTO")
    @ManyToOne
    private Requirement requirement;
    @JoinColumn(name = "CD_EXTERNO", referencedColumnName = "CD_EXTERNO_CORP")
    @ManyToOne
    private ExternalUser externalUser;

    public ProjectControl() {
    }

    public ProjectControl(Integer projectControlId) {
        this.projectControlId = projectControlId;
    }

    public Integer getProjectControlId() {
        return projectControlId;
    }

    public void setProjectControlId(Integer projectControlId) {
        this.projectControlId = projectControlId;
    }

    public Requirement getRequirement() {
        return requirement;
    }

    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }

    public ExternalUser getExternalUser() {
        return externalUser;
    }

    public void setExternalUser(ExternalUser externalUser) {
        this.externalUser = externalUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectControlId != null ? projectControlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectControl)) {
            return false;
        }
        ProjectControl other = (ProjectControl) object;
        if ((this.projectControlId == null && other.projectControlId != null) || (this.projectControlId != null && !this.projectControlId.equals(other.projectControlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.ProjectControl[ projectControlId=" + projectControlId + " ]";
    }

}
