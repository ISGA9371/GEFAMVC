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
@Table(name = "thge023_programa", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge023Programa.findAll", query = "SELECT t FROM Thge023Programa t")})
public class Thge023Programa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_PROGRAMA")
    private Integer cdPrograma;
    @Basic(optional = false)
    @Column(name = "NB_PROGRAMA")
    private String nbPrograma;

    public Thge023Programa() {
    }

    public Thge023Programa(Integer cdPrograma) {
        this.cdPrograma = cdPrograma;
    }

    public Thge023Programa(Integer cdPrograma, String nbPrograma) {
        this.cdPrograma = cdPrograma;
        this.nbPrograma = nbPrograma;
    }

    public Integer getCdPrograma() {
        return cdPrograma;
    }

    public void setCdPrograma(Integer cdPrograma) {
        this.cdPrograma = cdPrograma;
    }

    public String getNbPrograma() {
        return nbPrograma;
    }

    public void setNbPrograma(String nbPrograma) {
        this.nbPrograma = nbPrograma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdPrograma != null ? cdPrograma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge023Programa)) {
            return false;
        }
        Thge023Programa other = (Thge023Programa) object;
        if ((this.cdPrograma == null && other.cdPrograma != null) || (this.cdPrograma != null && !this.cdPrograma.equals(other.cdPrograma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge023Programa[ cdPrograma=" + cdPrograma + " ]";
    }
    
}
