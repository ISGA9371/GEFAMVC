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
@Table(name = "thge034_banca", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge034Banca.findAll", query = "SELECT t FROM Thge034Banca t")})
public class Thge034Banca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_BANCA")
    private Integer cdBanca;
    @Basic(optional = false)
    @Column(name = "NB_BANCA")
    private String nbBanca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdBanca")
    private List<Thge007Pep> thge007PepList;

    public Thge034Banca() {
    }

    public Thge034Banca(Integer cdBanca) {
        this.cdBanca = cdBanca;
    }

    public Thge034Banca(Integer cdBanca, String nbBanca) {
        this.cdBanca = cdBanca;
        this.nbBanca = nbBanca;
    }

    public Integer getCdBanca() {
        return cdBanca;
    }

    public void setCdBanca(Integer cdBanca) {
        this.cdBanca = cdBanca;
    }

    public String getNbBanca() {
        return nbBanca;
    }

    public void setNbBanca(String nbBanca) {
        this.nbBanca = nbBanca;
    }

    public List<Thge007Pep> getThge007PepList() {
        return thge007PepList;
    }

    public void setThge007PepList(List<Thge007Pep> thge007PepList) {
        this.thge007PepList = thge007PepList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdBanca != null ? cdBanca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge034Banca)) {
            return false;
        }
        Thge034Banca other = (Thge034Banca) object;
        if ((this.cdBanca == null && other.cdBanca != null) || (this.cdBanca != null && !this.cdBanca.equals(other.cdBanca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge034Banca[ cdBanca=" + cdBanca + " ]";
    }
    
}
