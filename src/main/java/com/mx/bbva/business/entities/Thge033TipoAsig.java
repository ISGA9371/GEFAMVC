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
@Table(name = "thge033_tipo_asig", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge033TipoAsig.findAll", query = "SELECT t FROM Thge033TipoAsig t")})
public class Thge033TipoAsig implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_TIPO_ASIG")
    private Integer cdTipoAsig;
    @Basic(optional = false)
    @Column(name = "NB_TIPO_ASIG")
    private String nbTipoAsig;

    public Thge033TipoAsig() {
    }

    public Thge033TipoAsig(Integer cdTipoAsig) {
        this.cdTipoAsig = cdTipoAsig;
    }

    public Thge033TipoAsig(Integer cdTipoAsig, String nbTipoAsig) {
        this.cdTipoAsig = cdTipoAsig;
        this.nbTipoAsig = nbTipoAsig;
    }

    public Integer getCdTipoAsig() {
        return cdTipoAsig;
    }

    public void setCdTipoAsig(Integer cdTipoAsig) {
        this.cdTipoAsig = cdTipoAsig;
    }

    public String getNbTipoAsig() {
        return nbTipoAsig;
    }

    public void setNbTipoAsig(String nbTipoAsig) {
        this.nbTipoAsig = nbTipoAsig;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdTipoAsig != null ? cdTipoAsig.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge033TipoAsig)) {
            return false;
        }
        Thge033TipoAsig other = (Thge033TipoAsig) object;
        if ((this.cdTipoAsig == null && other.cdTipoAsig != null) || (this.cdTipoAsig != null && !this.cdTipoAsig.equals(other.cdTipoAsig))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge033TipoAsig[ cdTipoAsig=" + cdTipoAsig + " ]";
    }
    
}
