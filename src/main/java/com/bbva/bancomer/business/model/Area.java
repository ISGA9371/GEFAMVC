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
@Table(name = "THGE030_AREA", uniqueConstraints = {@UniqueConstraint(columnNames = {"NB_AREA"})})
public class Area implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_AREA", nullable = false)
    private Integer areaId;
    @Basic(optional = false)
    @Column(name = "NB_AREA", nullable = false, length = 50)
    private String areaName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "area")
    private List<Budget> budgets;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "area")
    private List<Fare> fares;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "area")
    private List<Requirement> requirements;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "area")
    private List<Contract> contracts;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "area")
    private List<ExternalUser> externalUsers;

    public Area() {
    }

    public Area(Integer areaId) {
        this.areaId = areaId;
    }

    public Area(Integer areaId, String areaName) {
        this.areaId = areaId;
        this.areaName = areaName;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public List<Budget> getBudgets() {
        return budgets;
    }

    public void setBudgets(List<Budget> budgets) {
        this.budgets = budgets;
    }

    public List<Fare> getFares() {
        return fares;
    }

    public void setFares(List<Fare> fares) {
        this.fares = fares;
    }

    public List<Requirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Requirement> requirements) {
        this.requirements = requirements;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
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
        hash += (areaId != null ? areaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        return (this.areaId != null || other.areaId == null) && (this.areaId == null || this.areaId.equals(other.areaId));
    }

    @Override
    public String toString() {
        return "com.bbva.Area[ areaId=" + areaId + " ]";
    }

}
