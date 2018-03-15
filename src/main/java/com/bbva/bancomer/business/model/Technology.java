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
@Table(name = "thge002_tecnologia", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_TECNOLOGIA"})})
@NamedQueries({
        @NamedQuery(name = "Technology.findAll", query = "SELECT t FROM Technology t")})
public class Technology implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_TECNOLOGIA", nullable = false)
    private Integer cdTecnologia;
    @Basic(optional = false)
    @Column(name = "NB_TECNOLOGIA", nullable = false, length = 25)
    private String nbTecnologia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTechnology")
    private List<Fare> fareList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTechnology")
    private List<Application> applicationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTechnology")
    private List<Requirement> requirementList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTechnology")
    private List<Contract> contractList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTechnology")
    private List<Product> productList;

    public Technology() {
    }

    public Technology(Integer cdTecnologia) {
        this.cdTecnologia = cdTecnologia;
    }

    public Technology(Integer cdTecnologia, String nbTecnologia) {
        this.cdTecnologia = cdTecnologia;
        this.nbTecnologia = nbTecnologia;
    }

    public Integer getCdTecnologia() {
        return cdTecnologia;
    }

    public void setCdTecnologia(Integer cdTecnologia) {
        this.cdTecnologia = cdTecnologia;
    }

    public String getNbTecnologia() {
        return nbTecnologia;
    }

    public void setNbTecnologia(String nbTecnologia) {
        this.nbTecnologia = nbTecnologia;
    }

    public List<Fare> getFareList() {
        return fareList;
    }

    public void setFareList(List<Fare> fareList) {
        this.fareList = fareList;
    }

    public List<Application> getApplicationList() {
        return applicationList;
    }

    public void setApplicationList(List<Application> applicationList) {
        this.applicationList = applicationList;
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

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdTecnologia != null ? cdTecnologia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Technology)) {
            return false;
        }
        Technology other = (Technology) object;
        if ((this.cdTecnologia == null && other.cdTecnologia != null) || (this.cdTecnologia != null && !this.cdTecnologia.equals(other.cdTecnologia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Technology[ cdTecnologia=" + cdTecnologia + " ]";
    }

}
