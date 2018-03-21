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
@Table(name = "thge002_tecnologia", catalog = "gestion_factoria",  uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_TECNOLOGIA"})})
public class Technology_ implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_TECNOLOGIA", nullable = false)
    private Integer technologyId;
    @Basic(optional = false)
    @Column(name = "NB_TECNOLOGIA", nullable = false, length = 25)
    private String technologyName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "technology")
    private List<Fare> fares;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "technology")
    private List<Application> applications;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "technology")
    private List<Requirement> requirements;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "technology")
    private List<Contract> contracts;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "technology")
    private List<Product> products;

    public Technology_() {
    }

    public Technology_(Integer technologyId) {
        this.technologyId = technologyId;
    }

    public Technology_(Integer technologyId, String technologyName) {
        this.technologyId = technologyId;
        this.technologyName = technologyName;
    }

    public Integer getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(Integer technologyId) {
        this.technologyId = technologyId;
    }

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }

    public List<Fare> getFares() {
        return fares;
    }

    public void setFares(List<Fare> fares) {
        this.fares = fares;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (technologyId != null ? technologyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Technology_)) {
            return false;
        }
        Technology_ other = (Technology_) object;
        return (this.technologyId != null || other.technologyId == null) && (this.technologyId == null || this.technologyId.equals(other.technologyId));
    }

    @Override
    public String toString() {
        return "com.bbva.Technology_[ technologyId=" + technologyId + " ]";
    }

}