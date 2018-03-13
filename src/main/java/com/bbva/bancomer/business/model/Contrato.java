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
@NamedQueries({
        @NamedQuery(name = "Contrato.findAll", query = "SELECT t FROM Contrato t")})
public class Contrato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_CONTRATO", nullable = false)
    private Integer cdContrato;
    @Column(name = "CD_PEDIDO", length = 10)
    private String cdPedido;
    @Column(name = "NU_POSICION")
    private Integer nuPosicion;
    @Basic(optional = false)
    @Column(name = "NU_ANO_CONTRATO", nullable = false)
    private int nuAnoContrato;
    @JoinColumn(name = "CD_TECNOLOGIA", referencedColumnName = "CD_TECNOLOGIA", nullable = false)
    @ManyToOne(optional = false)
    private Tecnologia cdTecnologia;
    @JoinColumn(name = "CD_EMPRESA", referencedColumnName = "CD_EMPRESA", nullable = false)
    @ManyToOne(optional = false)
    private Company cdCompany;
    @JoinColumn(name = "ST_CONTRATO", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Estado stContrato;
    @JoinColumn(name = "CD_AREA", referencedColumnName = "CD_AREA", nullable = false)
    @ManyToOne(optional = false)
    private Area cdArea;
    @JoinColumn(name = "CD_ENTIDAD", referencedColumnName = "CD_ENTIDAD", nullable = false)
    @ManyToOne(optional = false)
    private Entidad cdEntidad;
    @JoinColumn(name = "CD_NATURALEZA", referencedColumnName = "CD_NATURALEZA", nullable = false)
    @ManyToOne(optional = false)
    private Naturaleza cdNaturaleza;

    public Contrato() {
    }

    public Contrato(Integer cdContrato) {
        this.cdContrato = cdContrato;
    }

    public Contrato(Integer cdContrato, int nuAnoContrato) {
        this.cdContrato = cdContrato;
        this.nuAnoContrato = nuAnoContrato;
    }

    public Integer getCdContrato() {
        return cdContrato;
    }

    public void setCdContrato(Integer cdContrato) {
        this.cdContrato = cdContrato;
    }

    public String getCdPedido() {
        return cdPedido;
    }

    public void setCdPedido(String cdPedido) {
        this.cdPedido = cdPedido;
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

    public Estado getStContrato() {
        return stContrato;
    }

    public void setStContrato(Estado stContrato) {
        this.stContrato = stContrato;
    }

    public Area getCdArea() {
        return cdArea;
    }

    public void setCdArea(Area cdArea) {
        this.cdArea = cdArea;
    }

    public Entidad getCdEntidad() {
        return cdEntidad;
    }

    public void setCdEntidad(Entidad cdEntidad) {
        this.cdEntidad = cdEntidad;
    }

    public Naturaleza getCdNaturaleza() {
        return cdNaturaleza;
    }

    public void setCdNaturaleza(Naturaleza cdNaturaleza) {
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
        if (!(object instanceof Contrato)) {
            return false;
        }
        Contrato other = (Contrato) object;
        if ((this.cdContrato == null && other.cdContrato != null) || (this.cdContrato != null && !this.cdContrato.equals(other.cdContrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Contrato[ cdContrato=" + cdContrato + " ]";
    }

}
