/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author manug
 */
@Entity
@Table(name = "thge027_duda", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge027Duda.findAll", query = "SELECT t FROM Thge027Duda t")})
public class Thge027Duda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_DUDA")
    private Integer cdDuda;
    @Basic(optional = false)
    @Column(name = "FH_ALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fhAlta;
    @Basic(optional = false)
    @Column(name = "TX_VENTREGA")
    private String txVentrega;
    @Basic(optional = false)
    @Column(name = "NB_DESC_DUDA_HIST")
    private String nbDescDudaHist;
    @Column(name = "NB_DESC_RES_HIST")
    private String nbDescResHist;
    @Lob
    @Column(name = "TX_DOC_DUDA")
    private byte[] txDocDuda;
    @Column(name = "FH_RESOLUCION")
    @Temporal(TemporalType.DATE)
    private Date fhResolucion;
    @Column(name = "NU_RES_INCORR")
    private Integer nuResIncorr;
    @JoinColumn(name = "ST_DUDA", referencedColumnName = "CD_ESTADO")
    @ManyToOne(optional = false)
    private Thge005Estado stDuda;
    @JoinColumn(name = "CD_COMPONENTE", referencedColumnName = "CD_COMPONENTE")
    @ManyToOne(optional = false)
    private Thge009Componente cdComponente;
    @JoinColumn(name = "CD_USU_PETICION", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne(optional = false)
    private Thge011Usuario cdUsuPeticion;
    @JoinColumn(name = "CD_USU_RESP", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne
    private Thge011Usuario cdUsuResp;
    @JoinColumn(name = "CD_PRIORIDAD", referencedColumnName = "CD_PRIORIDAD")
    @ManyToOne(optional = false)
    private Thge015Prioridad cdPrioridad;
    @JoinColumn(name = "CD_TIPO_DUDA", referencedColumnName = "CD_TIPO_DUDA")
    @ManyToOne(optional = false)
    private Thge028TipoDuda cdTipoDuda;

    public Thge027Duda() {
    }

    public Thge027Duda(Integer cdDuda) {
        this.cdDuda = cdDuda;
    }

    public Thge027Duda(Integer cdDuda, Date fhAlta, String txVentrega, String nbDescDudaHist) {
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

    public byte[] getTxDocDuda() {
        return txDocDuda;
    }

    public void setTxDocDuda(byte[] txDocDuda) {
        this.txDocDuda = txDocDuda;
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

    public Thge005Estado getStDuda() {
        return stDuda;
    }

    public void setStDuda(Thge005Estado stDuda) {
        this.stDuda = stDuda;
    }

    public Thge009Componente getCdComponente() {
        return cdComponente;
    }

    public void setCdComponente(Thge009Componente cdComponente) {
        this.cdComponente = cdComponente;
    }

    public Thge011Usuario getCdUsuPeticion() {
        return cdUsuPeticion;
    }

    public void setCdUsuPeticion(Thge011Usuario cdUsuPeticion) {
        this.cdUsuPeticion = cdUsuPeticion;
    }

    public Thge011Usuario getCdUsuResp() {
        return cdUsuResp;
    }

    public void setCdUsuResp(Thge011Usuario cdUsuResp) {
        this.cdUsuResp = cdUsuResp;
    }

    public Thge015Prioridad getCdPrioridad() {
        return cdPrioridad;
    }

    public void setCdPrioridad(Thge015Prioridad cdPrioridad) {
        this.cdPrioridad = cdPrioridad;
    }

    public Thge028TipoDuda getCdTipoDuda() {
        return cdTipoDuda;
    }

    public void setCdTipoDuda(Thge028TipoDuda cdTipoDuda) {
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
        if (!(object instanceof Thge027Duda)) {
            return false;
        }
        Thge027Duda other = (Thge027Duda) object;
        if ((this.cdDuda == null && other.cdDuda != null) || (this.cdDuda != null && !this.cdDuda.equals(other.cdDuda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge027Duda[ cdDuda=" + cdDuda + " ]";
    }
    
}
