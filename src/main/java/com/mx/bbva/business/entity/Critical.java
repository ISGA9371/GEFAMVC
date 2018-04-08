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
 * @author Guevara Manuel
 */
@Entity
@Table(name = "thge043_criticidad", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_CRITICIDAD"})})
public class Critical implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_CRITICIDAD", nullable = false)
    private Integer criticalId;
    @Basic(optional = false)
    @Column(name = "NB_CRITICIDAD", nullable = false, length = 10)
    private String criticalName;
    @JsonIgnore
    @OneToMany(mappedBy = "critical")
    private List<T926> t926List;

    public Critical() {
    }

    public Critical(Integer criticalId) {
        this.criticalId = criticalId;
    }

    public Critical(Integer criticalId, String criticalName) {
        this.criticalId = criticalId;
        this.criticalName = criticalName;
    }

    public Integer getCriticalId() {
        return criticalId;
    }

    public void setCriticalId(Integer criticalId) {
        this.criticalId = criticalId;
    }

    public String getCriticalName() {
        return criticalName;
    }

    public void setCriticalName(String criticalName) {
        this.criticalName = criticalName;
    }

    public List<T926> getT926List() {
        return t926List;
    }

    public void setT926List(List<T926> t926List) {
        this.t926List = t926List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (criticalId != null ? criticalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Critical)) {
            return false;
        }
        Critical other = (Critical) object;
        return (this.criticalId != null || other.criticalId == null) && (this.criticalId == null || this.criticalId.equals(other.criticalId));
    }

    @Override
    public String toString() {
        return "com.bbva.Critical[ criticalId=" + criticalId + " ]";
    }

}
