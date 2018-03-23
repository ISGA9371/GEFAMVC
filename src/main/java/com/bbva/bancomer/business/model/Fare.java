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
@Table(name = "THGE031_TARIFA")
public class Fare implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_TARIFA", nullable = false)
    private Integer fareId;
    @Basic(optional = false)
    @Column(name = "IM_TARIFA", nullable = false)
    private double fareValue;
    @Basic(optional = false)
    @Column(name = "NU_ANO_TARIFA", nullable = false)
    private int fareYear;
    @JoinColumn(name = "CD_TECNOLOGIA", referencedColumnName = "CD_TECNOLOGIA", nullable = false)
    @ManyToOne(optional = false)
    private Technology technology;
    @JoinColumn(name = "CD_EMPRESA", referencedColumnName = "CD_EMPRESA", nullable = false)
    @ManyToOne(optional = false)
    private Company company;
    @JoinColumn(name = "ST_TARIFA", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status status;
    @JoinColumn(name = "CD_AREA", referencedColumnName = "CD_AREA", nullable = false)
    @ManyToOne(optional = false)
    private Area area;

    public Fare() {
    }

    public Fare(Integer fareId) {
        this.fareId = fareId;
    }

    public Fare(Integer fareId, double fareValue, int fareYear) {
        this.fareId = fareId;
        this.fareValue = fareValue;
        this.fareYear = fareYear;
    }

    public Integer getFareId() {
        return fareId;
    }

    public void setFareId(Integer fareId) {
        this.fareId = fareId;
    }

    public double getFareValue() {
        return fareValue;
    }

    public void setFareValue(double fareValue) {
        this.fareValue = fareValue;
    }

    public int getFareYear() {
        return fareYear;
    }

    public void setFareYear(int fareYear) {
        this.fareYear = fareYear;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fareId != null ? fareId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Fare)) {
            return false;
        }
        Fare other = (Fare) object;
        return (this.fareId != null || other.fareId == null) && (this.fareId == null || this.fareId.equals(other.fareId));
    }

    @Override
    public String toString() {
        return "com.bbva.Fare[ fareId=" + fareId + " ]";
    }

}
