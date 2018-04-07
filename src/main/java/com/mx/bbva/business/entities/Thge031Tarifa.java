/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author manug
 */
@Entity
@Table(name = "thge031_tarifa", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge031Tarifa.findAll", query = "SELECT t FROM Thge031Tarifa t")})
public class Thge031Tarifa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_TARIFA")
    private Integer cdTarifa;
    @Basic(optional = false)
    @Column(name = "IM_TARIFA")
    private double imTarifa;
    @Basic(optional = false)
    @Column(name = "NU_ANO_TARIFA")
    private int nuAnoTarifa;
    @JoinColumn(name = "CD_TECNOLOGIA", referencedColumnName = "CD_TECNOLOGIA")
    @ManyToOne(optional = false)
    private Thge002Tecnologia cdTecnologia;
    @JoinColumn(name = "CD_EMPRESA", referencedColumnName = "CD_EMPRESA")
    @ManyToOne(optional = false)
    private Thge003Empresa cdEmpresa;
    @JoinColumn(name = "ST_TARIFA", referencedColumnName = "CD_ESTADO")
    @ManyToOne(optional = false)
    private Thge005Estado stTarifa;
    @JoinColumn(name = "CD_AREA", referencedColumnName = "CD_AREA")
    @ManyToOne(optional = false)
    private Thge030Area cdArea;

    public Thge031Tarifa() {
    }

    public Thge031Tarifa(Integer cdTarifa) {
        this.cdTarifa = cdTarifa;
    }

    public Thge031Tarifa(Integer cdTarifa, double imTarifa, int nuAnoTarifa) {
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

    public Thge002Tecnologia getCdTecnologia() {
        return cdTecnologia;
    }

    public void setCdTecnologia(Thge002Tecnologia cdTecnologia) {
        this.cdTecnologia = cdTecnologia;
    }

    public Thge003Empresa getCdEmpresa() {
        return cdEmpresa;
    }

    public void setCdEmpresa(Thge003Empresa cdEmpresa) {
        this.cdEmpresa = cdEmpresa;
    }

    public Thge005Estado getStTarifa() {
        return stTarifa;
    }

    public void setStTarifa(Thge005Estado stTarifa) {
        this.stTarifa = stTarifa;
    }

    public Thge030Area getCdArea() {
        return cdArea;
    }

    public void setCdArea(Thge030Area cdArea) {
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
        if (!(object instanceof Thge031Tarifa)) {
            return false;
        }
        Thge031Tarifa other = (Thge031Tarifa) object;
        if ((this.cdTarifa == null && other.cdTarifa != null) || (this.cdTarifa != null && !this.cdTarifa.equals(other.cdTarifa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge031Tarifa[ cdTarifa=" + cdTarifa + " ]";
    }
    
}
