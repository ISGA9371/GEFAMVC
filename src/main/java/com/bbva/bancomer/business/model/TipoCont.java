/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbva.bancomer.business.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Guevara
 */
@Entity
@Table(name = "thge032_tipo_cont", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_TIPO_CONTRATO"})})
@NamedQueries({
        @NamedQuery(name = "TipoCont.findAll", query = "SELECT t FROM TipoCont t")})
public class TipoCont implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_TIPO_CONTRATO", nullable = false)
    private Integer cdTipoContrato;
    @Basic(optional = false)
    @Column(name = "NB_TIPO_CONTRATO", nullable = false, length = 25)
    private String nbTipoContrato;

    public TipoCont() {
    }

    public TipoCont(Integer cdTipoContrato) {
        this.cdTipoContrato = cdTipoContrato;
    }

    public TipoCont(Integer cdTipoContrato, String nbTipoContrato) {
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
        if (!(object instanceof TipoCont)) {
            return false;
        }
        TipoCont other = (TipoCont) object;
        if ((this.cdTipoContrato == null && other.cdTipoContrato != null) || (this.cdTipoContrato != null && !this.cdTipoContrato.equals(other.cdTipoContrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.TipoCont[ cdTipoContrato=" + cdTipoContrato + " ]";
    }

}
