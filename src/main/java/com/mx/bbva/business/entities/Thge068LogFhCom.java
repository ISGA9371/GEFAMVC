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
@Table(name = "thge068_log_fh_com", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge068LogFhCom.findAll", query = "SELECT t FROM Thge068LogFhCom t")})
public class Thge068LogFhCom implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_CAMBIO")
    private Integer cdCambio;
    @Column(name = "CD_COMPONENTE")
    private Integer cdComponente;
    @Column(name = "TM_FH_MODIFICADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tmFhModificada;
    @Basic(optional = false)
    @Column(name = "FH_ANTERIOR")
    @Temporal(TemporalType.DATE)
    private Date fhAnterior;
    @Basic(optional = false)
    @Column(name = "FH_ACTUAL")
    @Temporal(TemporalType.DATE)
    private Date fhActual;
    @JoinColumn(name = "CD_TP_FH", referencedColumnName = "CD_TP_FH")
    @ManyToOne
    private Thge070TpFh cdTpFh;

    public Thge068LogFhCom() {
    }

    public Thge068LogFhCom(Integer cdCambio) {
        this.cdCambio = cdCambio;
    }

    public Thge068LogFhCom(Integer cdCambio, Date fhAnterior, Date fhActual) {
        this.cdCambio = cdCambio;
        this.fhAnterior = fhAnterior;
        this.fhActual = fhActual;
    }

    public Integer getCdCambio() {
        return cdCambio;
    }

    public void setCdCambio(Integer cdCambio) {
        this.cdCambio = cdCambio;
    }

    public Integer getCdComponente() {
        return cdComponente;
    }

    public void setCdComponente(Integer cdComponente) {
        this.cdComponente = cdComponente;
    }

    public Date getTmFhModificada() {
        return tmFhModificada;
    }

    public void setTmFhModificada(Date tmFhModificada) {
        this.tmFhModificada = tmFhModificada;
    }

    public Date getFhAnterior() {
        return fhAnterior;
    }

    public void setFhAnterior(Date fhAnterior) {
        this.fhAnterior = fhAnterior;
    }

    public Date getFhActual() {
        return fhActual;
    }

    public void setFhActual(Date fhActual) {
        this.fhActual = fhActual;
    }

    public Thge070TpFh getCdTpFh() {
        return cdTpFh;
    }

    public void setCdTpFh(Thge070TpFh cdTpFh) {
        this.cdTpFh = cdTpFh;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdCambio != null ? cdCambio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge068LogFhCom)) {
            return false;
        }
        Thge068LogFhCom other = (Thge068LogFhCom) object;
        if ((this.cdCambio == null && other.cdCambio != null) || (this.cdCambio != null && !this.cdCambio.equals(other.cdCambio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge068LogFhCom[ cdCambio=" + cdCambio + " ]";
    }
    
}
