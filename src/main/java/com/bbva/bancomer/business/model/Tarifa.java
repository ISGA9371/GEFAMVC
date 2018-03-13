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
@Table(name = "thge031_tarifa", catalog = "gestion_factoria", schema = "")
@NamedQueries({
        @NamedQuery(name = "Tarifa.findAll", query = "SELECT t FROM Tarifa t")})
public class Tarifa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_TARIFA", nullable = false)
    private Integer cdTarifa;
    @Basic(optional = false)
    @Column(name = "IM_TARIFA", nullable = false)
    private double imTarifa;
    @Basic(optional = false)
    @Column(name = "NU_ANO_TARIFA", nullable = false)
    private int nuAnoTarifa;
    @JoinColumn(name = "CD_TECNOLOGIA", referencedColumnName = "CD_TECNOLOGIA", nullable = false)
    @ManyToOne(optional = false)
    private Tecnologia cdTecnologia;
    @JoinColumn(name = "CD_EMPRESA", referencedColumnName = "CD_EMPRESA", nullable = false)
    @ManyToOne(optional = false)
    private Company cdCompany;
    @JoinColumn(name = "ST_TARIFA", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Estado stTarifa;
    @JoinColumn(name = "CD_AREA", referencedColumnName = "CD_AREA", nullable = false)
    @ManyToOne(optional = false)
    private Area cdArea;

    public Tarifa() {
    }

    public Tarifa(Integer cdTarifa) {
        this.cdTarifa = cdTarifa;
    }

    public Tarifa(Integer cdTarifa, double imTarifa, int nuAnoTarifa) {
        this.cdTarifa = cdTarifa;
        this.imTarifa = imTarifa;
        this.nuAnoTarifa = nuAnoTarifa;
    }

    public Integer getCdTarifa() {
        return cdTarifa;
    }

    public void setCdTarifa(Integer cdTarifa) {
        this.cdTarifa = cdTarifa;
    }

    public double getImTarifa() {
        return imTarifa;
    }

    public void setImTarifa(double imTarifa) {
        this.imTarifa = imTarifa;
    }

    public int getNuAnoTarifa() {
        return nuAnoTarifa;
    }

    public void setNuAnoTarifa(int nuAnoTarifa) {
        this.nuAnoTarifa = nuAnoTarifa;
    }

    public Tecnologia getCdTecnologia() {
        return cdTecnologia;
    }

    public void setCdTecnologia(Tecnologia cdTecnologia) {
        this.cdTecnologia = cdTecnologia;
    }

    public Company getCdCompany() {
        return cdCompany;
    }

    public void setCdCompany(Company cdCompany) {
        this.cdCompany = cdCompany;
    }

    public Estado getStTarifa() {
        return stTarifa;
    }

    public void setStTarifa(Estado stTarifa) {
        this.stTarifa = stTarifa;
    }

    public Area getCdArea() {
        return cdArea;
    }

    public void setCdArea(Area cdArea) {
        this.cdArea = cdArea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdTarifa != null ? cdTarifa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarifa)) {
            return false;
        }
        Tarifa other = (Tarifa) object;
        if ((this.cdTarifa == null && other.cdTarifa != null) || (this.cdTarifa != null && !this.cdTarifa.equals(other.cdTarifa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Tarifa[ cdTarifa=" + cdTarifa + " ]";
    }

}
