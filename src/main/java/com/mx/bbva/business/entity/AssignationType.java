/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Guevara Manuel
 */
@Entity
@Table(name = "thge033_tipo_asig", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_TIPO_ASIG"})})
public class AssignationType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_TIPO_ASIG", nullable = false)
    private Integer assignationTypeId;
    @Basic(optional = false)
    @Column(name = "NB_TIPO_ASIG", nullable = false, length = 25)
    private String assignationTypeName;

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
