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
@Table(name = "THGE003_EMPRESA")
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_EMPRESA", nullable = false)
    private Integer companyId;
    @Basic(optional = false)
    @Column(name = "NB_COMERC_EMPRESA", nullable = false, length = 45)
    private String companyName;
    @Basic(optional = false)
    @Column(name = "NB_RAZON_SOC_EMP", nullable = false, length = 45)
    private String companyBusinessName;
    @Basic(optional = false)
    @Column(name = "NU_PROVEEDOR", nullable = false, length = 6)
    private String companySupplierNumber;
    @Basic(optional = false)
    @Column(name = "CD_AREA", nullable = false)
    private int areaId;
    @JoinColumn(name = "ST_EMPRESA", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status status;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<Fare> fares;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<Requirement> requirements;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<Contract> contracts;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<ExternalUser> externalUsers;

    public Company() {
    }

    public Company(Integer companyId) {
        this.companyId = companyId;
    }

    public Company(Integer companyId, String companyName, String companyBusinessName, String companySupplierNumber, int areaId) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyBusinessName = companyBusinessName;
        this.companySupplierNumber = companySupplierNumber;
        this.areaId = areaId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyBusinessName() {
        return companyBusinessName;
    }

    public void setCompanyBusinessName(String companyBusinessName) {
        this.companyBusinessName = companyBusinessName;
    }

    public String getCompanySupplierNumber() {
        return companySupplierNumber;
    }

    public void setCompanySupplierNumber(String companySupplierNumber) {
        this.companySupplierNumber = companySupplierNumber;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
        hash += (companyId != null ? companyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        return (this.companyId != null || other.companyId == null) && (this.companyId == null || this.companyId.equals(other.companyId));
    }

    @Override
    public String toString() {
        return "com.bbva.Company[ companyId=" + companyId + " ]";
    }

}
