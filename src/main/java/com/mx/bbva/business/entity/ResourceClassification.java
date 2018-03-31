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
@Table(name = "thge020_clasif_rec", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_CLASIF_REC"})})
public class ResourceClassification implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_CLASIF_REC", nullable = false)
    private Integer resourceClassificationId;
    @Basic(optional = false)
    @Column(name = "NB_CLASIF_REC", nullable = false, length = 50)
    private String resourceClassificationName;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resourceClassification")
    private List<ResourceSubClassification> resourceSubClassifications;

    public ResourceClassification() {
    }

    public ResourceClassification(Integer resourceClassificationId) {
        this.resourceClassificationId = resourceClassificationId;
    }

    public ResourceClassification(Integer resourceClassificationId, String resourceClassificationName) {
        this.resourceClassificationId = resourceClassificationId;
        this.resourceClassificationName = resourceClassificationName;
    }

    public Integer getResourceClassificationId() {
        return resourceClassificationId;
    }

    public void setResourceClassificationId(Integer resourceClassificationId) {
        this.resourceClassificationId = resourceClassificationId;
    }

    public String getResourceClassificationName() {
        return resourceClassificationName;
    }

    public void setResourceClassificationName(String resourceClassificationName) {
        this.resourceClassificationName = resourceClassificationName;
    }

    public List<ResourceSubClassification> getResourceSubClassifications() {
        return resourceSubClassifications;
    }

    public void setResourceSubClassifications(List<ResourceSubClassification> resourceSubClassifications) {
        this.resourceSubClassifications = resourceSubClassifications;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resourceClassificationId != null ? resourceClassificationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ResourceClassification)) {
            return false;
        }
        ResourceClassification other = (ResourceClassification) object;
        return (this.resourceClassificationId != null || other.resourceClassificationId == null) && (this.resourceClassificationId == null || this.resourceClassificationId.equals(other.resourceClassificationId));
    }

    @Override
    public String toString() {
        return "com.bbva.ResourceClassification[ resourceClassificationId=" + resourceClassificationId + " ]";
    }

}
