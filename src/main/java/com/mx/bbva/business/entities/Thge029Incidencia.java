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
@Table(name = "thge029_incidencia", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge029Incidencia.findAll", query = "SELECT t FROM Thge029Incidencia t")})
public class Thge029Incidencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_INCIDENCIA")
    private Integer cdIncidencia;
    @Basic(optional = false)
    @Column(name = "FH_ALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fhAlta;
    @Basic(optional = false)
    @Column(name = "NB_DESC_INC_HIST")
    private String nbDescIncHist;
    @Column(name = "NB_DESC_RESOL_INC")
    private String nbDescResolInc;
    @Lob
    @Column(name = "TX_DOC_INCIDENCIA")
    private byte[] txDocIncidencia;
    @Column(name = "TX_INC_RLTA_DYD")
    private String txIncRltaDyd;
    @Column(name = "FH_RESOLUCION")
    @Temporal(TemporalType.DATE)
    private Date fhResolucion;
    @Column(name = "NU_RES_INCORR")
    private Integer nuResIncorr;
    @JoinColumn(name = "ST_INCIDENCIA", referencedColumnName = "CD_ESTADO")
    @ManyToOne
    private Thge005Estado stIncidencia;
    @JoinColumn(name = "CD_COMPONENTE", referencedColumnName = "CD_COMPONENTE")
    @ManyToOne(optional = false)
    private Thge009Componente cdComponente;
    @JoinColumn(name = "CD_USU_PETICION", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne(optional = false)
    private Thge011Usuario cdUsuPeticion;
    @JoinColumn(name = "CD_PRIORIDAD", referencedColumnName = "CD_PRIORIDAD")
    @ManyToOne(optional = false)
    private Thge015Prioridad cdPrioridad;
    @JoinColumn(name = "CD_ORIGEN", referencedColumnName = "CD_ORIGEN")
    @ManyToOne
    private Thge019Origen cdOrigen;

    public Thge029Incidencia() {
    }

    public Thge029Incidencia(Integer cdIncidencia) {
        this.cdIncidencia = cdIncidencia;
    }

    public Thge029Incidencia(Integer cdIncidencia, Date fhAlta, String nbDescIncHist) {
        this.cdIncidencia = cdIncidencia;
        this.fhAlta = fhAlta;
        this.nbDescIncHist = nbDescIncHist;
    }

    public Integer getCdIncidencia() {
        return cdIncidencia;
    }

    public void setCdIncidencia(Integer cdIncidencia) {
        this.cdIncidencia = cdIncidencia;
    }

    public Date getFhAlta() {
        return fhAlta;
    }

    public void setFhAlta(Date fhAlta) {
        this.fhAlta = fhAlta;
    }

    public String getNbDescIncHist() {
        return nbDescIncHist;
    }

    public void setNbDescIncHist(String nbDescIncHist) {
        this.nbDescIncHist = nbDescIncHist;
    }

    public String getNbDescResolInc() {
        return nbDescResolInc;
    }

    public void setNbDescResolInc(String nbDescResolInc) {
        this.nbDescResolInc = nbDescResolInc;
    }

    public byte[] getTxDocIncidencia() {
        return txDocIncidencia;
    }

    public void setTxDocIncidencia(byte[] txDocIncidencia) {
        this.txDocIncidencia = txDocIncidencia;
    }

    public String getTxIncRltaDyd() {
        return txIncRltaDyd;
    }

    public void setTxIncRltaDyd(String txIncRltaDyd) {
        this.txIncRltaDyd = txIncRltaDyd;
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

    public Thge005Estado getStIncidencia() {
        return stIncidencia;
    }

    public void setStIncidencia(Thge005Estado stIncidencia) {
        this.stIncidencia = stIncidencia;
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

    public Thge015Prioridad getCdPrioridad() {
        return cdPrioridad;
    }

    public void setCdPrioridad(Thge015Prioridad cdPrioridad) {
        this.cdPrioridad = cdPrioridad;
    }

    public Thge019Origen getCdOrigen() {
        return cdOrigen;
    }

    public void setCdOrigen(Thge019Origen cdOrigen) {
        this.cdOrigen = cdOrigen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdIncidencia != null ? cdIncidencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge029Incidencia)) {
            return false;
        }
        Thge029Incidencia other = (Thge029Incidencia) object;
        if ((this.cdIncidencia == null && other.cdIncidencia != null) || (this.cdIncidencia != null && !this.cdIncidencia.equals(other.cdIncidencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge029Incidencia[ cdIncidencia=" + cdIncidencia + " ]";
    }
    
}
