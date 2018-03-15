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
@Table(name = "thge030_area", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_AREA"})})
@NamedQueries({
        @NamedQuery(name = "Area.findAll", query = "SELECT t FROM Area t")})
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_AREA", nullable = false)
    private Integer cdArea;
    @Basic(optional = false)
    @Column(name = "NB_AREA", nullable = false, length = 50)
    private String nbArea;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdArea")
    private List<Budget> pepList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdArea")
    private List<Fare> fareList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdArea")
    private List<Requirement> requirementList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdArea")
    private List<Contract> contractList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdArea")
    private List<ExternalUser> externalUserList;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "thge030Area")
    private List<ServiceType_> serviceTypeList;*/

    public Area() {
    }

    public Area(Integer cdArea) {
        this.cdArea = cdArea;
    }

    public Area(Integer cdArea, String nbArea) {
        this.cdArea = cdArea;
        this.nbArea = nbArea;
    }

    public Integer getCdArea() {
        return cdArea;
    }

    public void setCdArea(Integer cdArea) {
        this.cdArea = cdArea;
    }

    public String getNbArea() {
        return nbArea;
    }

    public void setNbArea(String nbArea) {
        this.nbArea = nbArea;
    }

    public List<Budget> getPepList() {
        return pepList;
    }

    public void setPepList(List<Budget> pepList) {
        this.pepList = pepList;
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
    /*
    public List<ServiceType_> getServiceTypeList() {
        return serviceTypeList;
    }

    public void setServiceTypeList(List<ServiceType_> serviceTypeList) {
        this.serviceTypeList = serviceTypeList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdArea != null ? cdArea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.cdArea == null && other.cdArea != null) || (this.cdArea != null && !this.cdArea.equals(other.cdArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Area[ cdArea=" + cdArea + " ]";
    }

}
