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
@Table(name = "thge038_naturaleza", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_NATURALEZA"})})
@NamedQueries({
        @NamedQuery(name = "Nature.findAll", query = "SELECT t FROM Nature t")})
public class Nature implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_NATURALEZA", nullable = false)
    private Integer cdNaturaleza;
    @Basic(optional = false)
    @Column(name = "NB_NATURALEZA", nullable = false, length = 25)
    private String nbNaturaleza;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdNaturaleza")
    private List<Budget> pepList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdNaturaleza")
    private List<Contract> contractList;

    public Nature() {
    }

    public Nature(Integer cdNaturaleza) {
        this.cdNaturaleza = cdNaturaleza;
    }

    public Nature(Integer cdNaturaleza, String nbNaturaleza) {
        this.cdNaturaleza = cdNaturaleza;
        this.nbNaturaleza = nbNaturaleza;
    }

    public Integer getCdNaturaleza() {
        return cdNaturaleza;
    }

    public void setCdNaturaleza(Integer cdNaturaleza) {
        this.cdNaturaleza = cdNaturaleza;
    }

    public String getNbNaturaleza() {
        return nbNaturaleza;
    }

    public void setNbNaturaleza(String nbNaturaleza) {
        this.nbNaturaleza = nbNaturaleza;
    }

    public List<Budget> getPepList() {
        return pepList;
    }

    public void setPepList(List<Budget> pepList) {
        this.pepList = pepList;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdNaturaleza != null ? cdNaturaleza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nature)) {
            return false;
        }
        Nature other = (Nature) object;
        if ((this.cdNaturaleza == null && other.cdNaturaleza != null) || (this.cdNaturaleza != null && !this.cdNaturaleza.equals(other.cdNaturaleza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Nature[ cdNaturaleza=" + cdNaturaleza + " ]";
    }

}
