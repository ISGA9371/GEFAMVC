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
@Table(name = "thge019_origen", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge019Origen.findAll", query = "SELECT t FROM Thge019Origen t")})
public class Thge019Origen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_ORIGEN")
    private Integer cdOrigen;
    @Basic(optional = false)
    @Column(name = "NB_ORIGEN")
    private String nbOrigen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdOrigen")
    private List<Thge026Modif> thge026ModifList;
    @OneToMany(mappedBy = "cdOrigen")
    private List<Thge029Incidencia> thge029IncidenciaList;

    public Thge019Origen() {
    }

    public Thge019Origen(Integer cdOrigen) {
        this.cdOrigen = cdOrigen;
    }

    public Thge019Origen(Integer cdOrigen, String nbOrigen) {
        this.cdOrigen = cdOrigen;
        this.nbOrigen = nbOrigen;
    }

    public Integer getCdOrigen() {
        return cdOrigen;
    }

    public void setCdOrigen(Integer cdOrigen) {
        this.cdOrigen = cdOrigen;
    }

    public String getNbOrigen() {
        return nbOrigen;
    }

    public void setNbOrigen(String nbOrigen) {
        this.nbOrigen = nbOrigen;
    }

    public List<Thge026Modif> getThge026ModifList() {
        return thge026ModifList;
    }

    public void setThge026ModifList(List<Thge026Modif> thge026ModifList) {
        this.thge026ModifList = thge026ModifList;
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
        hash += (cdOrigen != null ? cdOrigen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge019Origen)) {
            return false;
        }
        Thge019Origen other = (Thge019Origen) object;
        if ((this.cdOrigen == null && other.cdOrigen != null) || (this.cdOrigen != null && !this.cdOrigen.equals(other.cdOrigen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge019Origen[ cdOrigen=" + cdOrigen + " ]";
    }
    
}
