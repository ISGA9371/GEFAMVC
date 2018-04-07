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
@Table(name = "thge032_tipo_cont", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge032TipoCont.findAll", query = "SELECT t FROM Thge032TipoCont t")})
public class Thge032TipoCont implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_TIPO_CONTRATO")
    private Integer cdTipoContrato;
    @Basic(optional = false)
    @Column(name = "NB_TIPO_CONTRATO")
    private String nbTipoContrato;

    public Thge032TipoCont() {
    }

    public Thge032TipoCont(Integer cdTipoContrato) {
        this.cdTipoContrato = cdTipoContrato;
    }

    public Thge032TipoCont(Integer cdTipoContrato, String nbTipoContrato) {
        this.cdTipoContrato = cdTipoContrato;
        this.nbTipoContrato = nbTipoContrato;
    }

    public Integer getCdTipoContrato() {
        return cdTipoContrato;
    }

    public void setCdTipoContrato(Integer cdTipoContrato) {
        this.cdTipoContrato = cdTipoContrato;
    }

    public String getNbTipoContrato() {
        return nbTipoContrato;
    }

    public void setNbTipoContrato(String nbTipoContrato) {
        this.nbTipoContrato = nbTipoContrato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdTipoContrato != null ? cdTipoContrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge032TipoCont)) {
            return false;
        }
        Thge032TipoCont other = (Thge032TipoCont) object;
        if ((this.cdTipoContrato == null && other.cdTipoContrato != null) || (this.cdTipoContrato != null && !this.cdTipoContrato.equals(other.cdTipoContrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge032TipoCont[ cdTipoContrato=" + cdTipoContrato + " ]";
    }
    
}
