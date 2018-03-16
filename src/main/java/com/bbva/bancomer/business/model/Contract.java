/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbva.bancomer.business.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Guevara
 */
@Entity
@Table(name = "thge036_contrato", catalog = "gestion_factoria", schema = "")
public class Contract implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_CONTRATO", nullable = false)
    private Integer contractId;
    @Column(name = "CD_PEDIDO", length = 10)
    private String orderId;
    @Column(name = "NU_POSICION")
    private Integer contractPosition;
    @Basic(optional = false)
    @Column(name = "NU_ANO_CONTRATO", nullable = false)
    private int contractYear;
    @JoinColumn(name = "CD_TECNOLOGIA", referencedColumnName = "CD_TECNOLOGIA", nullable = false)
    @ManyToOne(optional = false)
    private Technology technology;
    @JoinColumn(name = "CD_EMPRESA", referencedColumnName = "CD_EMPRESA", nullable = false)
    @ManyToOne(optional = false)
    private Company company;
    @JoinColumn(name = "ST_CONTRATO", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status status;
    @JoinColumn(name = "CD_AREA", referencedColumnName = "CD_AREA", nullable = false)
    @ManyToOne(optional = false)
    private Area area;
    @JoinColumn(name = "CD_ENTIDAD", referencedColumnName = "CD_ENTIDAD", nullable = false)
    @ManyToOne(optional = false)
    private Corporation corporation;
    @JoinColumn(name = "CD_NATURALEZA", referencedColumnName = "CD_NATURALEZA", nullable = false)
    @ManyToOne(optional = false)
    private Nature nature;

    public Contract() {
    }

    public Contract(Integer contractId) {
        this.contractId = contractId;
    }

    public Contract(Integer contractId, int contractYear) {
        this.contractId = contractId;
        this.contractYear = contractYear;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getContractPosition() {
        return contractPosition;
    }

    public void setContractPosition(Integer contractPosition) {
        this.contractPosition = contractPosition;
    }

    public int getContractYear() {
        return contractYear;
    }

    public void setContractYear(int contractYear) {
        this.contractYear = contractYear;
    }

    public Technology getTechnology() {
        return technology;
    }

    public void setTechnology(Technology technology) {
        this.technology = technology;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Corporation getCorporation() {
        return corporation;
    }

    public void setCorporation(Corporation corporation) {
        this.corporation = corporation;
    }

    public Nature getNature() {
        return nature;
    }

    public void setNature(Nature nature) {
        this.nature = nature;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contractId != null ? contractId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Contract)) {
            return false;
        }
        Contract other = (Contract) object;
        return (this.contractId != null || other.contractId == null) && (this.contractId == null || this.contractId.equals(other.contractId));
    }

    @Override
    public String toString() {
        return "com.bbva.Contract[ contractId=" + contractId + " ]";
    }

}
