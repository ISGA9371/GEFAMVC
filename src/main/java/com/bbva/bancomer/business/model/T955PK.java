/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbva.bancomer.business.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Guevara
 */
@Embeddable
public class T955PK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CD_DEFECTO", nullable = false)
    private int cdDefecto;
    @Basic(optional = false)
    @Column(name = "CD_REQUERIMIENTO", nullable = false)
    private int cdRequerimiento;

    public T955PK() {
    }

    public T955PK(int cdDefecto, int cdRequerimiento) {
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
        if (!(object instanceof T955PK)) {
            return false;
        }
        T955PK other = (T955PK) object;
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
        return "com.bbva.T955PK[ cdDefecto=" + cdDefecto + ", cdRequerimiento=" + cdRequerimiento + " ]";
    }

}
