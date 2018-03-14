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
@Table(name = "thge034_banca", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_BANCA"})})
@NamedQueries({
        @NamedQuery(name = "Banking.findAll", query = "SELECT t FROM Banking t")})
public class Banking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_BANCA", nullable = false)
    private Integer cdBanca;
    @Basic(optional = false)
    @Column(name = "NB_BANCA", nullable = false, length = 50)
    private String nbBanca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdBanca")
    private List<Budget> pepList;

    public Banking() {
    }

    public Banking(Integer cdBanca) {
        this.cdBanca = cdBanca;
    }

    public Banking(Integer cdBanca, String nbBanca) {
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

    public List<Budget> getPepList() {
        return pepList;
    }

    public void setPepList(List<Budget> pepList) {
        this.pepList = pepList;
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
        if (!(object instanceof Banking)) {
            return false;
        }
        Banking other = (Banking) object;
        if ((this.cdBanca == null && other.cdBanca != null) || (this.cdBanca != null && !this.cdBanca.equals(other.cdBanca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Banking[ cdBanca=" + cdBanca + " ]";
    }

}
