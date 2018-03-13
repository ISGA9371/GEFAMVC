/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbva.bancomer.business.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Guevara
 */
@Entity
@Table(name = "thge027_duda", catalog = "gestion_factoria", schema = "")
@NamedQueries({
        @NamedQuery(name = "Duda.findAll", query = "SELECT t FROM Duda t")})
public class Duda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_DUDA", nullable = false)
    private Integer cdDuda;
    @Basic(optional = false)
    @Column(name = "FH_ALTA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fhAlta;
    @Basic(optional = false)
    @Column(name = "TX_VENTREGA", nullable = false, length = 9)
    private String txVentrega;
    @Basic(optional = false)
    @Column(name = "NB_DESC_DUDA_HIST", nullable = false, length = 600)
    private String nbDescDudaHist;
    @Column(name = "NB_DESC_RES_HIST", length = 600)
    private String nbDescResHist;
    @Column(name = "FH_RESOLUCION")
    @Temporal(TemporalType.DATE)
    private Date fhResolucion;
    @Column(name = "NU_RES_INCORR")
    private Integer nuResIncorr;
    @JoinColumn(name = "ST_DUDA", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Estado stDuda;
    @JoinColumn(name = "CD_COMPONENTE", referencedColumnName = "CD_COMPONENTE", nullable = false)
    @ManyToOne(optional = false)
    private Componente cdComponente;
    @JoinColumn(name = "CD_USU_PETICION", referencedColumnName = "CD_USUARIO_CORP", nullable = false)
    @ManyToOne(optional = false)
    private User cdUsuPeticion;
    @JoinColumn(name = "CD_USU_RESP", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne
    private User cdUsuResp;
    @JoinColumn(name = "CD_PRIORIDAD", referencedColumnName = "CD_PRIORIDAD", nullable = false)
    @ManyToOne(optional = false)
    private Prioridad cdPrioridad;
    @JoinColumn(name = "CD_TIPO_DUDA", referencedColumnName = "CD_TIPO_DUDA", nullable = false)
    @ManyToOne(optional = false)
    private TipoDuda cdTipoDuda;

    public Duda() {
    }

    public Duda(Integer cdDuda) {
        this.cdDuda = cdDuda;
    }

    public Duda(Integer cdDuda, Date fhAlta, String txVentrega, String nbDescDudaHist) {
        this.cdDuda = cdDuda;
        this.fhAlta = fhAlta;
        this.txVentrega = txVentrega;
        this.nbDescDudaHist = nbDescDudaHist;
    }

    public Integer getCdDuda() {
        return cdDuda;
    }

    public void setCdDuda(Integer cdDuda) {
        this.cdDuda = cdDuda;
    }

    public Date getFhAlta() {
        return fhAlta;
    }

    public void setFhAlta(Date fhAlta) {
        this.fhAlta = fhAlta;
    }

    public String getTxVentrega() {
        return txVentrega;
    }

    public void setTxVentrega(String txVentrega) {
        this.txVentrega = txVentrega;
    }

    public String getNbDescDudaHist() {
        return nbDescDudaHist;
    }

    public void setNbDescDudaHist(String nbDescDudaHist) {
        this.nbDescDudaHist = nbDescDudaHist;
    }

    public String getNbDescResHist() {
        return nbDescResHist;
    }

    public void setNbDescResHist(String nbDescResHist) {
        this.nbDescResHist = nbDescResHist;
    }

    public Date getFhResolucion() {
        return fhResolucion;
    }

    public void setFhResolucion(Date fhResolucion) {
        this.fhResolucion = fhResolucion;
    }

    public Integer getNuResIncorr() {
        return nuResIncorr;
    }

    public void setNuResIncorr(Integer nuResIncorr) {
        this.nuResIncorr = nuResIncorr;
    }

    public Estado getStDuda() {
        return stDuda;
    }

    public void setStDuda(Estado stDuda) {
        this.stDuda = stDuda;
    }

    public Componente getCdComponente() {
        return cdComponente;
    }

    public void setCdComponente(Componente cdComponente) {
        this.cdComponente = cdComponente;
    }

    public User getCdUsuPeticion() {
        return cdUsuPeticion;
    }

    public void setCdUsuPeticion(User cdUsuPeticion) {
        this.cdUsuPeticion = cdUsuPeticion;
    }

    public User getCdUsuResp() {
        return cdUsuResp;
    }

    public void setCdUsuResp(User cdUsuResp) {
        this.cdUsuResp = cdUsuResp;
    }

    public Prioridad getCdPrioridad() {
        return cdPrioridad;
    }

    public void setCdPrioridad(Prioridad cdPrioridad) {
        this.cdPrioridad = cdPrioridad;
    }

    public TipoDuda getCdTipoDuda() {
        return cdTipoDuda;
    }

    public void setCdTipoDuda(TipoDuda cdTipoDuda) {
        this.cdTipoDuda = cdTipoDuda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdDuda != null ? cdDuda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Duda)) {
            return false;
        }
        Duda other = (Duda) object;
        if ((this.cdDuda == null && other.cdDuda != null) || (this.cdDuda != null && !this.cdDuda.equals(other.cdDuda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Duda[ cdDuda=" + cdDuda + " ]";
    }

}
