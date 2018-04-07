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
@Table(name = "thge050_severidad", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge050Severidad.findAll", query = "SELECT t FROM Thge050Severidad t")})
public class Thge050Severidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_SEVERIDAD")
    private Integer cdSeveridad;
    @Basic(optional = false)
    @Column(name = "NB_SEVERIDAD")
    private String nbSeveridad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdSeveridad")
    private List<Thge048T955> thge048T955List;

    public Thge050Severidad() {
    }

    public Thge050Severidad(Integer cdSeveridad) {
        this.cdSeveridad = cdSeveridad;
    }

    public Thge050Severidad(Integer cdSeveridad, String nbSeveridad) {
        this.cdSeveridad = cdSeveridad;
        this.nbSeveridad = nbSeveridad;
    }

    public Integer getCdSeveridad() {
        return cdSeveridad;
    }

    public void setCdSeveridad(Integer cdSeveridad) {
        this.cdSeveridad = cdSeveridad;
    }

    public String getNbSeveridad() {
        return nbSeveridad;
    }

    public void setNbSeveridad(String nbSeveridad) {
        this.nbSeveridad = nbSeveridad;
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
        hash += (cdSeveridad != null ? cdSeveridad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge050Severidad)) {
            return false;
        }
        Thge050Severidad other = (Thge050Severidad) object;
        if ((this.cdSeveridad == null && other.cdSeveridad != null) || (this.cdSeveridad != null && !this.cdSeveridad.equals(other.cdSeveridad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge050Severidad[ cdSeveridad=" + cdSeveridad + " ]";
    }
    
}
