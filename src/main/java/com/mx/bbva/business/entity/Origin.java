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
@Table(name = "thge019_origen", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_ORIGEN"})})
public class Origin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_ORIGEN", nullable = false)
    private Integer originId;
    @Basic(optional = false)
    @Column(name = "NB_ORIGEN", nullable = false, length = 50)
    private String originName;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "origin")
    private List<Modification> modifications;

    public Origin() {
    }

    public Origin(Integer originId) {
        this.originId = originId;
    }

    public Origin(Integer originId, String originName) {
        this.originId = originId;
        this.originName = originName;
    }

    public Integer getOriginId() {
        return originId;
    }

    public void setOriginId(Integer originId) {
        this.originId = originId;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public List<Modification> getModifications() {
        return modifications;
    }

    public void setModifications(List<Modification> modifications) {
        this.modifications = modifications;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (originId != null ? originId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Origin)) {
            return false;
        }
        Origin other = (Origin) object;
        return (this.originId != null || other.originId == null) && (this.originId == null || this.originId.equals(other.originId));
    }

    @Override
    public String toString() {
        return "com.bbva.Origin[ originId=" + originId + " ]";
    }

}
