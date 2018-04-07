/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author manug
 */
@Entity
@Table(name = "thge053_causa_cier", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge053CausaCier.findAll", query = "SELECT t FROM Thge053CausaCier t")})
public class Thge053CausaCier implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_CAUSA_CIERRE")
    private Integer cdCausaCierre;
    @Basic(optional = false)
    @Column(name = "NB_CAUSA_CIERRE")
    private String nbCausaCierre;

    public Thge053CausaCier() {
    }

    public Thge053CausaCier(Integer cdCausaCierre) {
        this.cdCausaCierre = cdCausaCierre;
    }

    public Thge053CausaCier(Integer cdCausaCierre, String nbCausaCierre) {
        this.cdCausaCierre = cdCausaCierre;
        this.nbCausaCierre = nbCausaCierre;
    }

    public Integer getCdCausaCierre() {
        return cdCausaCierre;
    }

    public void setCdCausaCierre(Integer cdCausaCierre) {
        this.cdCausaCierre = cdCausaCierre;
    }

    public String getNbCausaCierre() {
        return nbCausaCierre;
    }

    public void setNbCausaCierre(String nbCausaCierre) {
        this.nbCausaCierre = nbCausaCierre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdCausaCierre != null ? cdCausaCierre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge053CausaCier)) {
            return false;
        }
        Thge053CausaCier other = (Thge053CausaCier) object;
        if ((this.cdCausaCierre == null && other.cdCausaCierre != null) || (this.cdCausaCierre != null && !this.cdCausaCierre.equals(other.cdCausaCierre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge053CausaCier[ cdCausaCierre=" + cdCausaCierre + " ]";
    }
    
}
