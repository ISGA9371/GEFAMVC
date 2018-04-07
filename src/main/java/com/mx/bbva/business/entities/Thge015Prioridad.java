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
@Table(name = "thge015_prioridad", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge015Prioridad.findAll", query = "SELECT t FROM Thge015Prioridad t")})
public class Thge015Prioridad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_PRIORIDAD")
    private Integer cdPrioridad;
    @Basic(optional = false)
    @Column(name = "NB_PRIORIDAD")
    private String nbPrioridad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdPrioridadUsu")
    private List<Thge026Modif> thge026ModifList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdPrioridad")
    private List<Thge027Duda> thge027DudaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdPrioridad")
    private List<Thge029Incidencia> thge029IncidenciaList;

    public Thge015Prioridad() {
    }

    public Thge015Prioridad(Integer cdPrioridad) {
        this.cdPrioridad = cdPrioridad;
    }

    public Thge015Prioridad(Integer cdPrioridad, String nbPrioridad) {
        this.cdPrioridad = cdPrioridad;
        this.nbPrioridad = nbPrioridad;
    }

    public Integer getCdPrioridad() {
        return cdPrioridad;
    }

    public void setCdPrioridad(Integer cdPrioridad) {
        this.cdPrioridad = cdPrioridad;
    }

    public String getNbPrioridad() {
        return nbPrioridad;
    }

    public void setNbPrioridad(String nbPrioridad) {
        this.nbPrioridad = nbPrioridad;
    }

    public List<Thge026Modif> getThge026ModifList() {
        return thge026ModifList;
    }

    public void setThge026ModifList(List<Thge026Modif> thge026ModifList) {
        this.thge026ModifList = thge026ModifList;
    }

    public List<Thge027Duda> getThge027DudaList() {
        return thge027DudaList;
    }

    public void setThge027DudaList(List<Thge027Duda> thge027DudaList) {
        this.thge027DudaList = thge027DudaList;
    }

    public List<Thge029Incidencia> getThge029IncidenciaList() {
        return thge029IncidenciaList;
    }

    public void setThge029IncidenciaList(List<Thge029Incidencia> thge029IncidenciaList) {
        this.thge029IncidenciaList = thge029IncidenciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdPrioridad != null ? cdPrioridad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge015Prioridad)) {
            return false;
        }
        Thge015Prioridad other = (Thge015Prioridad) object;
        if ((this.cdPrioridad == null && other.cdPrioridad != null) || (this.cdPrioridad != null && !this.cdPrioridad.equals(other.cdPrioridad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge015Prioridad[ cdPrioridad=" + cdPrioridad + " ]";
    }
    
}
