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
@Table(name = "thge043_criticidad", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_CRITICIDAD"})})
@NamedQueries({
        @NamedQuery(name = "Criticidad.findAll", query = "SELECT t FROM Criticidad t")})
public class Criticidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_CRITICIDAD", nullable = false)
    private Integer cdCriticidad;
    @Basic(optional = false)
    @Column(name = "NB_CRITICIDAD", nullable = false, length = 10)
    private String nbCriticidad;
    @OneToMany(mappedBy = "cdCriticidad")
    private List<T926> t926List;

    public Criticidad() {
    }

    public Criticidad(Integer cdCriticidad) {
        this.cdCriticidad = cdCriticidad;
    }

    public Criticidad(Integer cdCriticidad, String nbCriticidad) {
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

    public List<T926> getT926List() {
        return t926List;
    }

    public void setT926List(List<T926> t926List) {
        this.t926List = t926List;
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
        if (!(object instanceof Criticidad)) {
            return false;
        }
        Criticidad other = (Criticidad) object;
        if ((this.cdCriticidad == null && other.cdCriticidad != null) || (this.cdCriticidad != null && !this.cdCriticidad.equals(other.cdCriticidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Criticidad[ cdCriticidad=" + cdCriticidad + " ]";
    }

}
