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
@Table(name = "thge025_sede",  uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_SEDE"})})
public class Workplace implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_SEDE", nullable = false)
    private Integer workplaceId;
    @Basic(optional = false)
    @Column(name = "NB_SEDE", nullable = false, length = 25)
    private String workplaceName;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workplace")
    private List<com.mx.bbva.business.entity.Access> accessList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workplace")
    private List<ExternalUser> externalUsers;

    public Workplace() {
    }

    public Workplace(Integer workplaceId) {
        this.workplaceId = workplaceId;
    }

    public Workplace(Integer workplaceId, String workplaceName) {
        this.workplaceId = workplaceId;
        this.workplaceName = workplaceName;
    }

    public Integer getWorkplaceId() {
        return workplaceId;
    }

    public void setWorkplaceId(Integer workplaceId) {
        this.workplaceId = workplaceId;
    }

    public String getWorkplaceName() {
        return workplaceName;
    }

    public void setWorkplaceName(String workplaceName) {
        this.workplaceName = workplaceName;
    }

    public List<com.mx.bbva.business.entity.Access> getAccessList() {
        return accessList;
    }

    public void setAccessList(List<com.mx.bbva.business.entity.Access> accessList) {
        this.accessList = accessList;
    }

    public List<ExternalUser> getExternalUsers() {
        return externalUsers;
    }

    public void setExternalUsers(List<ExternalUser> externalUsers) {
        this.externalUsers = externalUsers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (workplaceId != null ? workplaceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Workplace)) {
            return false;
        }
        Workplace other = (Workplace) object;
        return (this.workplaceId != null || other.workplaceId == null) && (this.workplaceId == null || this.workplaceId.equals(other.workplaceId));
    }

    @Override
    public String toString() {
        return "com.bbva.Workplace[ workplaceId=" + workplaceId + " ]";
    }

}
