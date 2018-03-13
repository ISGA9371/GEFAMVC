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
@Table(name = "thge015_prioridad", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_PRIORIDAD"})})
@NamedQueries({
        @NamedQuery(name = "Prioridad.findAll", query = "SELECT t FROM Prioridad t")})
public class Prioridad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_PRIORIDAD", nullable = false)
    private Integer cdPrioridad;
    @Basic(optional = false)
    @Column(name = "NB_PRIORIDAD", nullable = false, length = 25)
    private String nbPrioridad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdPrioridadUsu")
    private List<Modif> modifList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdPrioridad")
    private List<Duda> dudaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdPrioridad")
    private List<Incidencia> incidenciaList;

    public Prioridad() {
    }

    public Prioridad(Integer cdPrioridad) {
        this.cdPrioridad = cdPrioridad;
    }

    public Prioridad(Integer cdPrioridad, String nbPrioridad) {
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

    public List<Modif> getModifList() {
        return modifList;
    }

    public void setModifList(List<Modif> modifList) {
        this.modifList = modifList;
    }

    public List<Duda> getDudaList() {
        return dudaList;
    }

    public void setDudaList(List<Duda> dudaList) {
        this.dudaList = dudaList;
    }

    public List<Incidencia> getIncidenciaList() {
        return incidenciaList;
    }

    public void setIncidenciaList(List<Incidencia> incidenciaList) {
        this.incidenciaList = incidenciaList;
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
        if (!(object instanceof Prioridad)) {
            return false;
        }
        Prioridad other = (Prioridad) object;
        if ((this.cdPrioridad == null && other.cdPrioridad != null) || (this.cdPrioridad != null && !this.cdPrioridad.equals(other.cdPrioridad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Prioridad[ cdPrioridad=" + cdPrioridad + " ]";
    }

}
