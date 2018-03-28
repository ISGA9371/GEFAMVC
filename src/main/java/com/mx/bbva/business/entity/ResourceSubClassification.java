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
@Table(name = "thge021_sbclas_rec")
public class ResourceSubClassification implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_SBCLAS_REC", nullable = false)
    private Integer resourceSubClassificationId;
    @Basic(optional = false)
    @Column(name = "NB_SBCLAS_REC", nullable = false, length = 45)
    private String resourceSubClassificationName;
    @JsonIgnore
    @JoinColumn(name = "CD_CLASIF_REC", referencedColumnName = "CD_CLASIF_REC", nullable = false)
    @ManyToOne(optional = false)
    private ResourceClassification resourceClassification;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resourceSubClassification")
    private List<ExternalUser> externalUsers;

    public ResourceSubClassification() {
    }

    public ResourceSubClassification(Integer resourceSubClassificationId) {
        this.resourceSubClassificationId = resourceSubClassificationId;
    }

    public ResourceSubClassification(Integer resourceSubClassificationId, String resourceSubClassificationName) {
        this.resourceSubClassificationId = resourceSubClassificationId;
        this.resourceSubClassificationName = resourceSubClassificationName;
    }

    public Integer getResourceSubClassificationId() {
        return resourceSubClassificationId;
    }

    public void setResourceSubClassificationId(Integer resourceSubClassificationId) {
        this.resourceSubClassificationId = resourceSubClassificationId;
    }

    public String getResourceSubClassificationName() {
        return resourceSubClassificationName;
    }

    public void setResourceSubClassificationName(String resourceSubClassificationName) {
        this.resourceSubClassificationName = resourceSubClassificationName;
    }

    public ResourceClassification getResourceClassification() {
        return resourceClassification;
    }

    public void setResourceClassification(ResourceClassification resourceClassification) {
        this.resourceClassification = resourceClassification;
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
        hash += (resourceSubClassificationId != null ? resourceSubClassificationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ResourceSubClassification)) {
            return false;
        }
        ResourceSubClassification other = (ResourceSubClassification) object;
        return (this.resourceSubClassificationId != null || other.resourceSubClassificationId == null) && (this.resourceSubClassificationId == null || this.resourceSubClassificationId.equals(other.resourceSubClassificationId));
    }

    @Override
    public String toString() {
        return "com.bbva.ResourceSubClassification[ resourceSubClassificationId=" + resourceSubClassificationId + " ]";
    }

}
