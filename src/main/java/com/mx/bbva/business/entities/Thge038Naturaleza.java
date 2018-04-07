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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author manug
 */
@Entity
@Table(name = "thge038_naturaleza", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge038Naturaleza.findAll", query = "SELECT t FROM Thge038Naturaleza t")})
public class Thge038Naturaleza implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_NATURALEZA")
    private Integer cdNaturaleza;
    @Basic(optional = false)
    @Column(name = "NB_NATURALEZA")
    private String nbNaturaleza;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdNaturaleza")
    private List<Thge007Pep> thge007PepList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cdNaturaleza")
    private Thge036Contrato thge036Contrato;

    public Thge038Naturaleza() {
    }

    public Thge038Naturaleza(Integer cdNaturaleza) {
        this.cdNaturaleza = cdNaturaleza;
    }

    public Thge038Naturaleza(Integer cdNaturaleza, String nbNaturaleza) {
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

    public List<Thge007Pep> getThge007PepList() {
        return thge007PepList;
    }

    public void setThge007PepList(List<Thge007Pep> thge007PepList) {
        this.thge007PepList = thge007PepList;
    }

    public Thge036Contrato getThge036Contrato() {
        return thge036Contrato;
    }

    public void setThge036Contrato(Thge036Contrato thge036Contrato) {
        this.thge036Contrato = thge036Contrato;
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
        if (!(object instanceof Thge038Naturaleza)) {
            return false;
        }
        Thge038Naturaleza other = (Thge038Naturaleza) object;
        if ((this.cdNaturaleza == null && other.cdNaturaleza != null) || (this.cdNaturaleza != null && !this.cdNaturaleza.equals(other.cdNaturaleza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge038Naturaleza[ cdNaturaleza=" + cdNaturaleza + " ]";
    }
    
}
