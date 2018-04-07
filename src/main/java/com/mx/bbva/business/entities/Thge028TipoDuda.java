/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author manug
 */
@Entity
@Table(name = "thge028_tipo_duda", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge028TipoDuda.findAll", query = "SELECT t FROM Thge028TipoDuda t")})
public class Thge028TipoDuda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_TIPO_DUDA")
    private Integer cdTipoDuda;
    @Basic(optional = false)
    @Column(name = "NB_TIPO_DUDA")
    private String nbTipoDuda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTipoDuda")
    private List<Thge027Duda> thge027DudaList;

    public Thge028TipoDuda() {
    }

    public Thge028TipoDuda(Integer cdTipoDuda) {
        this.cdTipoDuda = cdTipoDuda;
    }

    public Thge028TipoDuda(Integer cdTipoDuda, String nbTipoDuda) {
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

    public List<Thge027Duda> getThge027DudaList() {
        return thge027DudaList;
    }

    public void setThge027DudaList(List<Thge027Duda> thge027DudaList) {
        this.thge027DudaList = thge027DudaList;
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
        if (!(object instanceof Thge028TipoDuda)) {
            return false;
        }
        Thge028TipoDuda other = (Thge028TipoDuda) object;
        if ((this.cdTipoDuda == null && other.cdTipoDuda != null) || (this.cdTipoDuda != null && !this.cdTipoDuda.equals(other.cdTipoDuda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge028TipoDuda[ cdTipoDuda=" + cdTipoDuda + " ]";
    }
    
}
