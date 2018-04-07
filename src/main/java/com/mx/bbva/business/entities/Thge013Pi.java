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
@Table(name = "thge013_pi", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge013Pi.findAll", query = "SELECT t FROM Thge013Pi t")})
public class Thge013Pi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_PI")
    private Integer cdPi;
    @Basic(optional = false)
    @Column(name = "NB_PI")
    private String nbPi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdPi")
    private List<Thge017Requerim> thge017RequerimList;
    @OneToMany(mappedBy = "cdPi")
    private List<Thge022Proyecto> thge022ProyectoList;

    public Thge013Pi() {
    }

    public Thge013Pi(Integer cdPi) {
        this.cdPi = cdPi;
    }

    public Thge013Pi(Integer cdPi, String nbPi) {
        this.cdPi = cdPi;
        this.nbPi = nbPi;
    }

    public Integer getCdPi() {
        return cdPi;
    }

    public void setCdPi(Integer cdPi) {
        this.cdPi = cdPi;
    }

    public String getNbPi() {
        return nbPi;
    }

    public void setNbPi(String nbPi) {
        this.nbPi = nbPi;
    }

    public List<Thge017Requerim> getThge017RequerimList() {
        return thge017RequerimList;
    }

    public void setThge017RequerimList(List<Thge017Requerim> thge017RequerimList) {
        this.thge017RequerimList = thge017RequerimList;
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
        hash += (cdPi != null ? cdPi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge013Pi)) {
            return false;
        }
        Thge013Pi other = (Thge013Pi) object;
        if ((this.cdPi == null && other.cdPi != null) || (this.cdPi != null && !this.cdPi.equals(other.cdPi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge013Pi[ cdPi=" + cdPi + " ]";
    }
    
}
