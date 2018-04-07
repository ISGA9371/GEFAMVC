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
@Table(name = "thge058_ctrl_acc", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge058CtrlAcc.findAll", query = "SELECT t FROM Thge058CtrlAcc t")})
public class Thge058CtrlAcc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_ACCESO")
    private Integer cdAcceso;
    @Basic(optional = false)
    @Column(name = "CD_EXTERNO")
    private int cdExterno;
    @Basic(optional = false)
    @Column(name = "FH_VIG_ACC_LOG")
    @Temporal(TemporalType.DATE)
    private Date fhVigAccLog;
    @Basic(optional = false)
    @Column(name = "FH_VIG_ACC_FIS")
    @Temporal(TemporalType.DATE)
    private Date fhVigAccFis;
    @Basic(optional = false)
    @Column(name = "ST_ACCESO_FIS")
    private int stAccesoFis;
    @JoinColumn(name = "ST_ACCESO_LOG", referencedColumnName = "CD_ESTADO")
    @ManyToOne(optional = false)
    private Thge005Estado stAccesoLog;
    @JoinColumn(name = "CD_SEDE", referencedColumnName = "CD_SEDE")
    @ManyToOne(optional = false)
    private Thge025Sede cdSede;

    public Thge058CtrlAcc() {
    }

    public Thge058CtrlAcc(Integer cdAcceso) {
        this.cdAcceso = cdAcceso;
    }

    public Thge058CtrlAcc(Integer cdAcceso, int cdExterno, Date fhVigAccLog, Date fhVigAccFis, int stAccesoFis) {
        this.cdAcceso = cdAcceso;
        this.cdExterno = cdExterno;
        this.fhVigAccLog = fhVigAccLog;
        this.fhVigAccFis = fhVigAccFis;
        this.stAccesoFis = stAccesoFis;
    }

    public Integer getCdAcceso() {
        return cdAcceso;
    }

    public void setCdAcceso(Integer cdAcceso) {
        this.cdAcceso = cdAcceso;
    }

    public int getCdExterno() {
        return cdExterno;
    }

    public void setCdExterno(int cdExterno) {
        this.cdExterno = cdExterno;
    }

    public Date getFhVigAccLog() {
        return fhVigAccLog;
    }

    public void setFhVigAccLog(Date fhVigAccLog) {
        this.fhVigAccLog = fhVigAccLog;
    }

    public Date getFhVigAccFis() {
        return fhVigAccFis;
    }

    public void setFhVigAccFis(Date fhVigAccFis) {
        this.fhVigAccFis = fhVigAccFis;
    }

    public int getStAccesoFis() {
        return stAccesoFis;
    }

    public void setStAccesoFis(int stAccesoFis) {
        this.stAccesoFis = stAccesoFis;
    }

    public Thge005Estado getStAccesoLog() {
        return stAccesoLog;
    }

    public void setStAccesoLog(Thge005Estado stAccesoLog) {
        this.stAccesoLog = stAccesoLog;
    }

    public Thge025Sede getCdSede() {
        return cdSede;
    }

    public void setCdSede(Thge025Sede cdSede) {
        this.cdSede = cdSede;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdAcceso != null ? cdAcceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge058CtrlAcc)) {
            return false;
        }
        Thge058CtrlAcc other = (Thge058CtrlAcc) object;
        if ((this.cdAcceso == null && other.cdAcceso != null) || (this.cdAcceso != null && !this.cdAcceso.equals(other.cdAcceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge058CtrlAcc[ cdAcceso=" + cdAcceso + " ]";
    }
    
}
