/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "thge035_metodologia", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge035Metodologia.findAll", query = "SELECT t FROM Thge035Metodologia t")})
public class Thge035Metodologia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_METODOLOGIA")
    private Integer cdMetodologia;
    @Basic(optional = false)
    @Column(name = "NB_METODOLOGIA")
    private String nbMetodologia;
    @OneToMany(mappedBy = "cdMetodologia")
    private List<Thge022Proyecto> thge022ProyectoList;

    public Thge035Metodologia() {
    }

    public Thge035Metodologia(Integer cdMetodologia) {
        this.cdMetodologia = cdMetodologia;
    }

    public Thge035Metodologia(Integer cdMetodologia, String nbMetodologia) {
        this.cdMetodologia = cdMetodologia;
        this.nbMetodologia = nbMetodologia;
    }

    public Integer getCdMetodologia() {
        return cdMetodologia;
    }

    public void setCdMetodologia(Integer cdMetodologia) {
        this.cdMetodologia = cdMetodologia;
    }

    public String getNbMetodologia() {
        return nbMetodologia;
    }

    public void setNbMetodologia(String nbMetodologia) {
        this.nbMetodologia = nbMetodologia;
    }

    public List<Thge022Proyecto> getThge022ProyectoList() {
        return thge022ProyectoList;
    }

    public void setThge022ProyectoList(List<Thge022Proyecto> thge022ProyectoList) {
        this.thge022ProyectoList = thge022ProyectoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdMetodologia != null ? cdMetodologia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge035Metodologia)) {
            return false;
        }
        Thge035Metodologia other = (Thge035Metodologia) object;
        if ((this.cdMetodologia == null && other.cdMetodologia != null) || (this.cdMetodologia != null && !this.cdMetodologia.equals(other.cdMetodologia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge035Metodologia[ cdMetodologia=" + cdMetodologia + " ]";
    }
    
}
