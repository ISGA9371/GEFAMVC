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
@Table(name = "thge021_sbclas_rec", catalog = "gestion_factoria", schema = "")
public class RequirementSubClassification implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_SBCLAS_REC", nullable = false)
    private Integer requirementSubClassificationId;
    @Basic(optional = false)
    @Column(name = "NB_SBCLAS_REC", nullable = false, length = 45)
    private String requirementSubClassificationName;
    @JoinColumn(name = "CD_CLASIF_REC", referencedColumnName = "CD_CLASIF_REC", nullable = false)
    @ManyToOne(optional = false)
    private RequirementClassification requirementClassification;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requirementSubClassification")
    private List<ExternalUser> externalUsers;

    public RequirementSubClassification() {
    }

    public RequirementSubClassification(Integer requirementSubClassificationId) {
        this.requirementSubClassificationId = requirementSubClassificationId;
    }

    public RequirementSubClassification(Integer requirementSubClassificationId, String requirementSubClassificationName) {
        this.requirementSubClassificationId = requirementSubClassificationId;
        this.requirementSubClassificationName = requirementSubClassificationName;
    }

    public Integer getRequirementSubClassificationId() {
        return requirementSubClassificationId;
    }

    public void setRequirementSubClassificationId(Integer requirementSubClassificationId) {
        this.requirementSubClassificationId = requirementSubClassificationId;
    }

    public String getRequirementSubClassificationName() {
        return requirementSubClassificationName;
    }

    public void setRequirementSubClassificationName(String requirementSubClassificationName) {
        this.requirementSubClassificationName = requirementSubClassificationName;
    }

    public RequirementClassification getRequirementClassification() {
        return requirementClassification;
    }

    public void setRequirementClassification(RequirementClassification requirementClassification) {
        this.requirementClassification = requirementClassification;
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
        hash += (requirementSubClassificationId != null ? requirementSubClassificationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof RequirementSubClassification)) {
            return false;
        }
        RequirementSubClassification other = (RequirementSubClassification) object;
        return (this.requirementSubClassificationId != null || other.requirementSubClassificationId == null) && (this.requirementSubClassificationId == null || this.requirementSubClassificationId.equals(other.requirementSubClassificationId));
    }

    @Override
    public String toString() {
        return "com.bbva.RequirementSubClassification[ requirementSubClassificationId=" + requirementSubClassificationId + " ]";
    }

}
