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
 * @author Guevara Manuel_
 */
@Entity
@Table(name = "thge030_area", uniqueConstraints = {@UniqueConstraint(columnNames = {"NB_AREA"})})
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_AREA", nullable = false)
    private Integer areaId;
    @Column(name = "NB_AREA", nullable = false, length = 50)
    private String areaName;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "area")
    private List<Budget> budgets;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "area")
    private List<Fare> fares;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "area")
    private List<Requirement> requirements;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "area")
    private List<Contract> contracts;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "area")
    private List<ExternalUser> externalUsers;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "area")
    private List<ServiceType> serviceTypes;

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

    public List<ServiceType> getServiceTypes() {
        return serviceTypes;
    }

    public void setServiceTypes(List<ServiceType> serviceTypes) {
        this.serviceTypes = serviceTypes;
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
