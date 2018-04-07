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
@Table(name = "thge049_entorno", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge049Entorno.findAll", query = "SELECT t FROM Thge049Entorno t")})
public class Thge049Entorno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_ENTORNO")
    private Integer cdEntorno;
    @Basic(optional = false)
    @Column(name = "NB_ENTORNO")
    private String nbEntorno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdEntorno")
    private List<Thge048T955> thge048T955List;

    public Thge049Entorno() {
    }

    public Thge049Entorno(Integer cdEntorno) {
        this.cdEntorno = cdEntorno;
    }

    public Thge049Entorno(Integer cdEntorno, String nbEntorno) {
        this.cdEntorno = cdEntorno;
        this.nbEntorno = nbEntorno;
    }

    public Integer getCdEntorno() {
        return cdEntorno;
    }

    public void setCdEntorno(Integer cdEntorno) {
        this.cdEntorno = cdEntorno;
    }

    public String getNbEntorno() {
        return nbEntorno;
    }

    public void setNbEntorno(String nbEntorno) {
        this.nbEntorno = nbEntorno;
    }

    public List<Thge048T955> getThge048T955List() {
        return thge048T955List;
    }

    public void setThge048T955List(List<Thge048T955> thge048T955List) {
        this.thge048T955List = thge048T955List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdEntorno != null ? cdEntorno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge049Entorno)) {
            return false;
        }
        Thge049Entorno other = (Thge049Entorno) object;
        if ((this.cdEntorno == null && other.cdEntorno != null) || (this.cdEntorno != null && !this.cdEntorno.equals(other.cdEntorno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge049Entorno[ cdEntorno=" + cdEntorno + " ]";
    }
    
}
