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
@Table(name = "thge056_canal", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge056Canal.findAll", query = "SELECT t FROM Thge056Canal t")})
public class Thge056Canal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_CANAL")
    private Integer cdCanal;
    @Basic(optional = false)
    @Column(name = "NB_CANAL")
    private String nbCanal;
    @OneToMany(mappedBy = "cdCanal")
    private List<Thge017Requerim> thge017RequerimList;

    public Thge056Canal() {
    }

    public Thge056Canal(Integer cdCanal) {
        this.cdCanal = cdCanal;
    }

    public Thge056Canal(Integer cdCanal, String nbCanal) {
        this.cdCanal = cdCanal;
        this.nbCanal = nbCanal;
    }

    public Integer getCdCanal() {
        return cdCanal;
    }

    public void setCdCanal(Integer cdCanal) {
        this.cdCanal = cdCanal;
    }

    public String getNbCanal() {
        return nbCanal;
    }

    public void setNbCanal(String nbCanal) {
        this.nbCanal = nbCanal;
    }

    public List<Thge017Requerim> getThge017RequerimList() {
        return thge017RequerimList;
    }

    public void setThge017RequerimList(List<Thge017Requerim> thge017RequerimList) {
        this.thge017RequerimList = thge017RequerimList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdCanal != null ? cdCanal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge056Canal)) {
            return false;
        }
        Thge056Canal other = (Thge056Canal) object;
        if ((this.cdCanal == null && other.cdCanal != null) || (this.cdCanal != null && !this.cdCanal.equals(other.cdCanal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge056Canal[ cdCanal=" + cdCanal + " ]";
    }
    
}
