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
@Table(name = "THGE033_tipo_asig", catalog = "gestion_factoria", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_TIPO_ASIG"})})
public class AssignationType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_TIPO_ASIG", nullable = false)
    private Integer assignationTypeId;
    @Basic(optional = false)
    @Column(name = "NB_TIPO_ASIG", nullable = false, length = 25)
    private String assignationTypeName;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assignationType")
    private List<ExternalUser> externalUsers;

    public AssignationType() {
    }

    public AssignationType(Integer assignationTypeId) {
        this.assignationTypeId = assignationTypeId;
    }

    public AssignationType(Integer assignationTypeId, String assignationTypeName) {
        this.assignationTypeId = assignationTypeId;
        this.assignationTypeName = assignationTypeName;
    }

    public Integer getAssignationTypeId() {
        return assignationTypeId;
    }

    public void setAssignationTypeId(Integer assignationTypeId) {
        this.assignationTypeId = assignationTypeId;
    }

    public String getAssignationTypeName() {
        return assignationTypeName;
    }

    public void setAssignationTypeName(String assignationTypeName) {
        this.assignationTypeName = assignationTypeName;
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
        hash += (assignationTypeId != null ? assignationTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AssignationType)) {
            return false;
        }
        AssignationType other = (AssignationType) object;
        return (this.assignationTypeId != null || other.assignationTypeId == null) && (this.assignationTypeId == null || this.assignationTypeId.equals(other.assignationTypeId));
    }

    @Override
    public String toString() {
        return "com.bbva.AssignationType[ assignationTypeId=" + assignationTypeId + " ]";
    }

}
