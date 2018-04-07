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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author manug
 */
@Entity
@Table(name = "thge036_contrato", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge036Contrato.findAll", query = "SELECT t FROM Thge036Contrato t")})
public class Thge036Contrato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_CONTRATO")
    private Integer cdContrato;
    @Column(name = "NU_POSICION")
    private Integer nuPosicion;
    @Basic(optional = false)
    @Column(name = "NU_ANO_CONTRATO")
    private int nuAnoContrato;
    @Column(name = "CD_PEDIDO")
    private String cdPedido;
    @JoinColumn(name = "CD_TECNOLOGIA", referencedColumnName = "CD_TECNOLOGIA")
    @ManyToOne(optional = false)
    private Thge002Tecnologia cdTecnologia;
    @JoinColumn(name = "CD_EMPRESA", referencedColumnName = "CD_EMPRESA")
    @ManyToOne(optional = false)
    private Thge003Empresa cdEmpresa;
    @JoinColumn(name = "ST_CONTRATO", referencedColumnName = "CD_ESTADO")
    @ManyToOne(optional = false)
    private Thge005Estado stContrato;
    @JoinColumn(name = "CD_AREA", referencedColumnName = "CD_AREA")
    @ManyToOne(optional = false)
    private Thge030Area cdArea;
    @JoinColumn(name = "CD_ENTIDAD", referencedColumnName = "CD_ENTIDAD")
    @ManyToOne(optional = false)
    private Thge037Entidad cdEntidad;
    @JoinColumn(name = "CD_NATURALEZA", referencedColumnName = "CD_NATURALEZA")
    @OneToOne(optional = false)
    private Thge038Naturaleza cdNaturaleza;

    public Thge036Contrato() {
    }

    public Thge036Contrato(Integer cdContrato) {
        this.cdContrato = cdContrato;
    }

    public Thge036Contrato(Integer cdContrato, int nuAnoContrato) {
        this.cdContrato = cdContrato;
        this.nuAnoContrato = nuAnoContrato;
    }

    public Integer getCdContrato() {
        return cdContrato;
    }

    public void setCdContrato(Integer cdContrato) {
        this.cdContrato = cdContrato;
    }

    public Integer getNuPosicion() {
        return nuPosicion;
    }

    public void setNuPosicion(Integer nuPosicion) {
        this.nuPosicion = nuPosicion;
    }

    public int getNuAnoContrato() {
        return nuAnoContrato;
    }

    public void setNuAnoContrato(int nuAnoContrato) {
        this.nuAnoContrato = nuAnoContrato;
    }

    public String getCdPedido() {
        return cdPedido;
    }

    public void setCdPedido(String cdPedido) {
        this.cdPedido = cdPedido;
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

    public Thge005Estado getStContrato() {
        return stContrato;
    }

    public void setStContrato(Thge005Estado stContrato) {
        this.stContrato = stContrato;
    }

    public Thge030Area getCdArea() {
        return cdArea;
    }

    public void setCdArea(Thge030Area cdArea) {
        this.cdArea = cdArea;
    }

    public Thge037Entidad getCdEntidad() {
        return cdEntidad;
    }

    public void setCdEntidad(Thge037Entidad cdEntidad) {
        this.cdEntidad = cdEntidad;
    }

    public Thge038Naturaleza getCdNaturaleza() {
        return cdNaturaleza;
    }

    public void setCdNaturaleza(Thge038Naturaleza cdNaturaleza) {
        this.cdNaturaleza = cdNaturaleza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdContrato != null ? cdContrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge036Contrato)) {
            return false;
        }
        Thge036Contrato other = (Thge036Contrato) object;
        if ((this.cdContrato == null && other.cdContrato != null) || (this.cdContrato != null && !this.cdContrato.equals(other.cdContrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge036Contrato[ cdContrato=" + cdContrato + " ]";
    }
    
}
