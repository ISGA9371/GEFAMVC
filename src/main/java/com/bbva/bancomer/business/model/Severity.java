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
@Table(name = "thge050_severidad", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_SEVERIDAD"})})
@NamedQueries({
        @NamedQuery(name = "Severity.findAll", query = "SELECT t FROM Severity t")})
public class Severity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_SEVERIDAD", nullable = false)
    private Integer cdSeveridad;
    @Basic(optional = false)
    @Column(name = "NB_SEVERIDAD", nullable = false, length = 25)
    private String nbSeveridad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdSeveridad")
    private List<T955> t955List;

    public Severity() {
    }

    public Severity(Integer cdSeveridad) {
        this.cdSeveridad = cdSeveridad;
    }

    public Severity(Integer cdSeveridad, String nbSeveridad) {
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

    public List<T955> getT955List() {
        return t955List;
    }

    public void setT955List(List<T955> t955List) {
        this.t955List = t955List;
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
        if (!(object instanceof Severity)) {
            return false;
        }
        Severity other = (Severity) object;
        if ((this.cdSeveridad == null && other.cdSeveridad != null) || (this.cdSeveridad != null && !this.cdSeveridad.equals(other.cdSeveridad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Severity[ cdSeveridad=" + cdSeveridad + " ]";
    }

}
