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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author manug
 */
@Embeddable
public class Thge059HCMandoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "FH_INICIO")
    @Temporal(TemporalType.DATE)
    private Date fhInicio;
    @Basic(optional = false)
    @Column(name = "FH_FIN")
    @Temporal(TemporalType.DATE)
    private Date fhFin;

    public Thge059HCMandoPK() {
    }

    public Thge059HCMandoPK(Date fhInicio, Date fhFin) {
        this.fhInicio = fhInicio;
        this.fhFin = fhFin;
    }

    public Date getFhInicio() {
        return fhInicio;
    }

    public void setFhInicio(Date fhInicio) {
        this.fhInicio = fhInicio;
    }

    public Date getFhFin() {
        return fhFin;
    }

    public void setFhFin(Date fhFin) {
        this.fhFin = fhFin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fhInicio != null ? fhInicio.hashCode() : 0);
        hash += (fhFin != null ? fhFin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge059HCMandoPK)) {
            return false;
        }
        Thge059HCMandoPK other = (Thge059HCMandoPK) object;
        if ((this.fhInicio == null && other.fhInicio != null) || (this.fhInicio != null && !this.fhInicio.equals(other.fhInicio))) {
            return false;
        }
        if ((this.fhFin == null && other.fhFin != null) || (this.fhFin != null && !this.fhFin.equals(other.fhFin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge059HCMandoPK[ fhInicio=" + fhInicio + ", fhFin=" + fhFin + " ]";
    }
    
}
