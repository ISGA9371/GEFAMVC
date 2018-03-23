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
@Table(name = "THGE020_clasif_rec",  uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_CLASIF_REC"})})
public class RequirementClassification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_CLASIF_REC", nullable = false)
    private Integer requirementClassificationId;
    @Basic(optional = false)
    @Column(name = "NB_CLASIF_REC", nullable = false, length = 50)
    private String requirementClassificationName;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requirementClassification")
    private List<RequirementSubClassification> requirementSubClassifications;

    public RequirementClassification() {
    }

    public RequirementClassification(Integer requirementClassificationId) {
        this.requirementClassificationId = requirementClassificationId;
    }

    public RequirementClassification(Integer requirementClassificationId, String requirementClassificationName) {
        this.requirementClassificationId = requirementClassificationId;
        this.requirementClassificationName = requirementClassificationName;
    }

    public Integer getRequirementClassificationId() {
        return requirementClassificationId;
    }

    public void setRequirementClassificationId(Integer requirementClassificationId) {
        this.requirementClassificationId = requirementClassificationId;
    }

    public String getRequirementClassificationName() {
        return requirementClassificationName;
    }

    public void setRequirementClassificationName(String requirementClassificationName) {
        this.requirementClassificationName = requirementClassificationName;
    }

    public List<RequirementSubClassification> getRequirementSubClassifications() {
        return requirementSubClassifications;
    }

    public void setRequirementSubClassifications(List<RequirementSubClassification> requirementSubClassifications) {
        this.requirementSubClassifications = requirementSubClassifications;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requirementClassificationId != null ? requirementClassificationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof RequirementClassification)) {
            return false;
        }
        RequirementClassification other = (RequirementClassification) object;
        return (this.requirementClassificationId != null || other.requirementClassificationId == null) && (this.requirementClassificationId == null || this.requirementClassificationId.equals(other.requirementClassificationId));
    }

    @Override
    public String toString() {
        return "com.bbva.RequirementClassification[ requirementClassificationId=" + requirementClassificationId + " ]";
    }

}
