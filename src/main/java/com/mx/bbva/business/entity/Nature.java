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
@Table(name = "thge038_naturaleza", uniqueConstraints = {@UniqueConstraint(columnNames = {"NB_NATURALEZA"})})
public class Nature implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_NATURALEZA", nullable = false)
    private Integer natureId;
    @Basic(optional = false)
    @Column(name = "NB_NATURALEZA", nullable = false, length = 25)
    private String natureName;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nature")
    private List<Budget> budgets;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nature")
    private List<Contract> contracts;

    public Nature() {
    }

    public Nature(Integer natureId) {
        this.natureId = natureId;
    }

    public Nature(Integer natureId, String natureName) {
        this.natureId = natureId;
        this.natureName = natureName;
    }

    public Integer getNatureId() {
        return natureId;
    }

    public void setNatureId(Integer natureId) {
        this.natureId = natureId;
    }

    public String getNatureName() {
        return natureName;
    }

    public void setNatureName(String natureName) {
        this.natureName = natureName;
    }

    public List<Budget> getBudgets() {
        return budgets;
    }

    public void setBudgets(List<Budget> budgets) {
        this.budgets = budgets;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (natureId != null ? natureId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Nature)) {
            return false;
        }
        Nature other = (Nature) object;
        return (this.natureId != null || other.natureId == null) && (this.natureId == null || this.natureId.equals(other.natureId));
    }

    @Override
    public String toString() {
        return "com.bbva.Nature[ natureId=" + natureId + " ]";
    }

}
