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
@Table(name = "thge003_empresa", catalog = "gestion_factoria", schema = "")
@NamedQueries({
        @NamedQuery(name = "Company.findAll", query = "SELECT t FROM Company t")})
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_EMPRESA", nullable = false)
    private Integer companyId;
    @Basic(optional = false)
    @Column(name = "NB_COMERC_EMPRESA", nullable = false, length = 45)
    private String nbComercEmpresa;
    @Basic(optional = false)
    @Column(name = "NB_RAZON_SOC_EMP", nullable = false, length = 45)
    private String nbRazonSocEmp;
    @Basic(optional = false)
    @Column(name = "NU_PROVEEDOR", nullable = false, length = 6)
    private String nuProveedor;
    @Basic(optional = false)
    @Column(name = "CD_AREA", nullable = false)
    private int cdArea;
    @JoinColumn(name = "ST_EMPRESA", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status stEmpresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdCompany")
    private List<Fare> fareList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdCompany")
    private List<Requirement> requirementList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdCompany")
    private List<Contract> contractList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdCompany")
    private List<ExternalUser> externalUserList;

    public Company() {
    }

    public Company(Integer companyId) {
        this.companyId = companyId;
    }

    public Company(Integer companyId, String nbComercEmpresa, String nbRazonSocEmp, String nuProveedor, int cdArea) {
        this.companyId = companyId;
        this.nbComercEmpresa = nbComercEmpresa;
        this.nbRazonSocEmp = nbRazonSocEmp;
        this.nuProveedor = nuProveedor;
        this.cdArea = cdArea;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getNbComercEmpresa() {
        return nbComercEmpresa;
    }

    public void setNbComercEmpresa(String nbComercEmpresa) {
        this.nbComercEmpresa = nbComercEmpresa;
    }

    public String getNbRazonSocEmp() {
        return nbRazonSocEmp;
    }

    public void setNbRazonSocEmp(String nbRazonSocEmp) {
        this.nbRazonSocEmp = nbRazonSocEmp;
    }

    public String getNuProveedor() {
        return nuProveedor;
    }

    public void setNuProveedor(String nuProveedor) {
        this.nuProveedor = nuProveedor;
    }

    public int getCdArea() {
        return cdArea;
    }

    public void setCdArea(int cdArea) {
        this.cdArea = cdArea;
    }

    public Status getStEmpresa() {
        return stEmpresa;
    }

    public void setStEmpresa(Status stEmpresa) {
        this.stEmpresa = stEmpresa;
    }

    public List<Fare> getFareList() {
        return fareList;
    }

    public void setFareList(List<Fare> fareList) {
        this.fareList = fareList;
    }

    public List<Requirement> getRequirementList() {
        return requirementList;
    }

    public void setRequirementList(List<Requirement> requirementList) {
        this.requirementList = requirementList;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public List<ExternalUser> getExternalUserList() {
        return externalUserList;
    }

    public void setExternalUserList(List<ExternalUser> externalUserList) {
        this.externalUserList = externalUserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyId != null ? companyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.companyId == null && other.companyId != null) || (this.companyId != null && !this.companyId.equals(other.companyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Company[ companyId=" + companyId + " ]";
    }

}
