/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entity;

import com.google.appengine.repackaged.org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Guevara
 */
@Entity
@Table(name = "thge049_entorno",   uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_ENTORNO"})})
public class Environment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_ENTORNO", nullable = false)
    private Integer environmentId;
    @Basic(optional = false)
    @Column(name = "NB_ENTORNO", nullable = false, length = 25)
    private String environmentName;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "environment")
    private List<T955> t955List;

    public Environment() {
    }

    public Environment(Integer environmentId) {
        this.environmentId = environmentId;
    }

    public Environment(Integer environmentId, String environmentName) {
        this.environmentId = environmentId;
        this.environmentName = environmentName;
    }

    public Integer getEnvironmentId() {
        return environmentId;
    }

    public void setEnvironmentId(Integer environmentId) {
        this.environmentId = environmentId;
    }

    public String getEnvironmentName() {
        return environmentName;
    }

    public void setEnvironmentName(String environmentName) {
        this.environmentName = environmentName;
    }

    public List<T955> getT955List() {
        return t955List;
    }

    public void setT955List(List<T955> t955List) {
        this.t955List = t955List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (environmentId != null ? environmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Environment)) {
            return false;
        }
        Environment other = (Environment) object;
        return (this.environmentId != null || other.environmentId == null) && (this.environmentId == null || this.environmentId.equals(other.environmentId));
    }

    @Override
    public String toString() {
        return "com.bbva.Environment[ environmentId=" + environmentId + " ]";
    }

}
