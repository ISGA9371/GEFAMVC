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
@Table(name = "thge043_criticidad", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge043Criticidad.findAll", query = "SELECT t FROM Thge043Criticidad t")})
public class Thge043Criticidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_CRITICIDAD")
    private Integer cdCriticidad;
    @Basic(optional = false)
    @Column(name = "NB_CRITICIDAD")
    private String nbCriticidad;
    @OneToMany(mappedBy = "cdCriticidad")
    private List<Thge042T926> thge042T926List;

    public Thge043Criticidad() {
    }

    public Thge043Criticidad(Integer cdCriticidad) {
        this.cdCriticidad = cdCriticidad;
    }

    public Thge043Criticidad(Integer cdCriticidad, String nbCriticidad) {
        this.cdCriticidad = cdCriticidad;
        this.nbCriticidad = nbCriticidad;
    }

    public Integer getCdCriticidad() {
        return cdCriticidad;
    }

    public void setCdCriticidad(Integer cdCriticidad) {
        this.cdCriticidad = cdCriticidad;
    }

    public String getNbCriticidad() {
        return nbCriticidad;
    }

    public void setNbCriticidad(String nbCriticidad) {
        this.nbCriticidad = nbCriticidad;
    }

    public List<Thge042T926> getThge042T926List() {
        return thge042T926List;
    }

    public void setThge042T926List(List<Thge042T926> thge042T926List) {
        this.thge042T926List = thge042T926List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdCriticidad != null ? cdCriticidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge043Criticidad)) {
            return false;
        }
        Thge043Criticidad other = (Thge043Criticidad) object;
        if ((this.cdCriticidad == null && other.cdCriticidad != null) || (this.cdCriticidad != null && !this.cdCriticidad.equals(other.cdCriticidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge043Criticidad[ cdCriticidad=" + cdCriticidad + " ]";
    }
    
}
