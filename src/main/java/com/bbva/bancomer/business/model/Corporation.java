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
@Table(name = "thge037_entidad", uniqueConstraints = {@UniqueConstraint(columnNames = {"NB_ENTIDAD"})})
public class Corporation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_ENTIDAD", nullable = false)
    private Integer corporationId;
    @Basic(optional = false)
    @Column(name = "NB_ENTIDAD", nullable = false, length = 25)
    private String corporationName;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "corporation")
    private List<Budget> budgets;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "corporation")
    private List<Contract> contracts;

    public Corporation() {
    }

    public Corporation(Integer corporationId) {
        this.corporationId = corporationId;
    }

    public Corporation(Integer corporationId, String corporationName) {
        this.corporationId = corporationId;
        this.corporationName = corporationName;
    }

    public Integer getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(Integer corporationId) {
        this.corporationId = corporationId;
    }

    public String getCorporationName() {
        return corporationName;
    }

    public void setCorporationName(String corporationName) {
        this.corporationName = corporationName;
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
        hash += (corporationId != null ? corporationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Corporation)) {
            return false;
        }
        Corporation other = (Corporation) object;
        return (this.corporationId != null || other.corporationId == null) && (this.corporationId == null || this.corporationId.equals(other.corporationId));
    }

    @Override
    public String toString() {
        return "com.bbva.Corporation[ corporationId=" + corporationId + " ]";
    }

}
