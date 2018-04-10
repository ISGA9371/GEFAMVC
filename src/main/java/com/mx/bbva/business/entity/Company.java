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
@Table(name = "thge003_empresa")
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_EMPRESA", nullable = false)
    private Integer companyId;
    @Column(name = "NB_COMERC_EMPRESA", nullable = false, length = 45)
    private String companyName;
    @Column(name = "NB_RAZON_SOC_EMP", nullable = false, length = 45)
    private String companyBusinessName;
    @Column(name = "NU_PROVEEDOR", nullable = false, length = 6)
    private String companySupplierNumber;
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
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<EvaluationService> evaluationServices;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<Evaluation> evaluations;

    public Company() {
    }

    public Company(Integer companyId) {
        this.companyId = companyId;
    }

    public Company(Integer companyId, String companyName) {
        this.companyId = companyId;
        this.companyName = companyName;
    }

    public Company(Integer companyId, String companyName, String companyBusinessName, String companySupplierNumber) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyBusinessName = companyBusinessName;
        this.companySupplierNumber = companySupplierNumber;
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

    public List<EvaluationService> getEvaluationServices() {
        return evaluationServices;
    }

    public void setEvaluationServices(List<EvaluationService> evaluationServices) {
        this.evaluationServices = evaluationServices;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
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
