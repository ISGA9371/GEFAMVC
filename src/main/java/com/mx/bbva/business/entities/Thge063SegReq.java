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
@Table(name = "thge063_seg_req", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge063SegReq.findAll", query = "SELECT t FROM Thge063SegReq t")})
public class Thge063SegReq implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_SEG_REQ")
    private Integer cdSegReq;
    @Basic(optional = false)
    @Column(name = "TM_SEG_REQ")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tmSegReq;
    @Column(name = "NB_DEPENDENCIA")
    private String nbDependencia;
    @Column(name = "NB_OBSERVACION")
    private String nbObservacion;
    @JoinColumn(name = "ST_SEG_REQ", referencedColumnName = "CD_ESTADO")
    @ManyToOne(optional = false)
    private Thge005Estado stSegReq;
    @JoinColumn(name = "CD_REQUERIMIENTO", referencedColumnName = "CD_REQUERIMIENTO")
    @ManyToOne(optional = false)
    private Thge017Requerim cdRequerimiento;

    public Thge063SegReq() {
    }

    public Thge063SegReq(Integer cdSegReq) {
        this.cdSegReq = cdSegReq;
    }

    public Thge063SegReq(Integer cdSegReq, Date tmSegReq) {
        this.cdSegReq = cdSegReq;
        this.tmSegReq = tmSegReq;
    }

    public Integer getCdSegReq() {
        return cdSegReq;
    }

    public void setCdSegReq(Integer cdSegReq) {
        this.cdSegReq = cdSegReq;
    }

    public Date getTmSegReq() {
        return tmSegReq;
    }

    public void setTmSegReq(Date tmSegReq) {
        this.tmSegReq = tmSegReq;
    }

    public String getNbDependencia() {
        return nbDependencia;
    }

    public void setNbDependencia(String nbDependencia) {
        this.nbDependencia = nbDependencia;
    }

    public String getNbObservacion() {
        return nbObservacion;
    }

    public void setNbObservacion(String nbObservacion) {
        this.nbObservacion = nbObservacion;
    }

    public Thge005Estado getStSegReq() {
        return stSegReq;
    }

    public void setStSegReq(Thge005Estado stSegReq) {
        this.stSegReq = stSegReq;
    }

    public Thge017Requerim getCdRequerimiento() {
        return cdRequerimiento;
    }

    public void setCdRequerimiento(Thge017Requerim cdRequerimiento) {
        this.cdRequerimiento = cdRequerimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdSegReq != null ? cdSegReq.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge063SegReq)) {
            return false;
        }
        Thge063SegReq other = (Thge063SegReq) object;
        if ((this.cdSegReq == null && other.cdSegReq != null) || (this.cdSegReq != null && !this.cdSegReq.equals(other.cdSegReq))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge063SegReq[ cdSegReq=" + cdSegReq + " ]";
    }
    
}
