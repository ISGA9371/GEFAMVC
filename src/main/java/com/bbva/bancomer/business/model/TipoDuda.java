/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbva.bancomer.business.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Guevara
 */
@Entity
@Table(name = "thge028_tipo_duda", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_TIPO_DUDA"})})
@NamedQueries({
        @NamedQuery(name = "TipoDuda.findAll", query = "SELECT t FROM TipoDuda t")})
public class TipoDuda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_TIPO_DUDA", nullable = false)
    private Integer cdTipoDuda;
    @Basic(optional = false)
    @Column(name = "NB_TIPO_DUDA", nullable = false, length = 50)
    private String nbTipoDuda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTipoDuda")
    private List<Duda> dudaList;

    public TipoDuda() {
    }

    public TipoDuda(Integer cdTipoDuda) {
        this.cdTipoDuda = cdTipoDuda;
    }

    public TipoDuda(Integer cdTipoDuda, String nbTipoDuda) {
        this.cdTipoDuda = cdTipoDuda;
        this.nbTipoDuda = nbTipoDuda;
    }

    public Integer getCdTipoDuda() {
        return cdTipoDuda;
    }

    public void setCdTipoDuda(Integer cdTipoDuda) {
        this.cdTipoDuda = cdTipoDuda;
    }

    public String getNbTipoDuda() {
        return nbTipoDuda;
    }

    public void setNbTipoDuda(String nbTipoDuda) {
        this.nbTipoDuda = nbTipoDuda;
    }

    public List<Duda> getDudaList() {
        return dudaList;
    }

    public void setDudaList(List<Duda> dudaList) {
        this.dudaList = dudaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdTipoDuda != null ? cdTipoDuda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDuda)) {
            return false;
        }
        TipoDuda other = (TipoDuda) object;
        if ((this.cdTipoDuda == null && other.cdTipoDuda != null) || (this.cdTipoDuda != null && !this.cdTipoDuda.equals(other.cdTipoDuda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.TipoDuda[ cdTipoDuda=" + cdTipoDuda + " ]";
    }

}
