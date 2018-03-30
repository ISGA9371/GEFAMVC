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
@Table(name = "thge050_severidad", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_SEVERIDAD"})})
public class Severity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_SEVERIDAD", nullable = false)
    private Integer severityId;
    @Basic(optional = false)
    @Column(name = "NB_SEVERIDAD", nullable = false, length = 25)
    private String severityName;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "severity")
    private List<T955> t955List;

    public Severity() {
    }

    public Severity(Integer severityId) {
        this.severityId = severityId;
    }

    public Severity(Integer severityId, String severityName) {
        this.severityId = severityId;
        this.severityName = severityName;
    }

    public Integer getSeverityId() {
        return severityId;
    }

    public void setSeverityId(Integer severityId) {
        this.severityId = severityId;
    }

    public String getSeverityName() {
        return severityName;
    }

    public void setSeverityName(String severityName) {
        this.severityName = severityName;
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
        hash += (severityId != null ? severityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Severity)) {
            return false;
        }
        Severity other = (Severity) object;
        return (this.severityId != null || other.severityId == null) && (this.severityId == null || this.severityId.equals(other.severityId));
    }

    @Override
    public String toString() {
        return "com.bbva.Severity[ severityId=" + severityId + " ]";
    }

}
