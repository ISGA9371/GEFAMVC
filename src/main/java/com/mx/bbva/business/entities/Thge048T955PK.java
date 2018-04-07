/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author manug
 */
@Embeddable
public class Thge048T955PK implements Serializable {
    @Basic(optional = false)
    @Column(name = "CD_DEFECTO")
    private int cdDefecto;
    @Basic(optional = false)
    @Column(name = "CD_REQUERIMIENTO")
    private int cdRequerimiento;

    public Thge048T955PK() {
    }

    public Thge048T955PK(int cdDefecto, int cdRequerimiento) {
        this.cdDefecto = cdDefecto;
        this.cdRequerimiento = cdRequerimiento;
    }

    public int getCdDefecto() {
        return cdDefecto;
    }

    public void setCdDefecto(int cdDefecto) {
        this.cdDefecto = cdDefecto;
    }

    public int getCdRequerimiento() {
        return cdRequerimiento;
    }

    public void setCdRequerimiento(int cdRequerimiento) {
        this.cdRequerimiento = cdRequerimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cdDefecto;
        hash += (int) cdRequerimiento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge048T955PK)) {
            return false;
        }
        Thge048T955PK other = (Thge048T955PK) object;
        if (this.cdDefecto != other.cdDefecto) {
            return false;
        }
        if (this.cdRequerimiento != other.cdRequerimiento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge048T955PK[ cdDefecto=" + cdDefecto + ", cdRequerimiento=" + cdRequerimiento + " ]";
    }
    
}
