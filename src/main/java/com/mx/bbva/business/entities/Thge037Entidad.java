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
@Table(name = "thge037_entidad", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge037Entidad.findAll", query = "SELECT t FROM Thge037Entidad t")})
public class Thge037Entidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_ENTIDAD")
    private Integer cdEntidad;
    @Basic(optional = false)
    @Column(name = "NB_ENTIDAD")
    private String nbEntidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdEntidad")
    private List<Thge007Pep> thge007PepList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdEntidad")
    private List<Thge036Contrato> thge036ContratoList;

    public Thge037Entidad() {
    }

    public Thge037Entidad(Integer cdEntidad) {
        this.cdEntidad = cdEntidad;
    }

    public Thge037Entidad(Integer cdEntidad, String nbEntidad) {
        this.cdEntidad = cdEntidad;
        this.nbEntidad = nbEntidad;
    }

    public Integer getCdEntidad() {
        return cdEntidad;
    }

    public void setCdEntidad(Integer cdEntidad) {
        this.cdEntidad = cdEntidad;
    }

    public String getNbEntidad() {
        return nbEntidad;
    }

    public void setNbEntidad(String nbEntidad) {
        this.nbEntidad = nbEntidad;
    }

    public List<Thge007Pep> getThge007PepList() {
        return thge007PepList;
    }

    public void setThge007PepList(List<Thge007Pep> thge007PepList) {
        this.thge007PepList = thge007PepList;
    }

    public List<Thge036Contrato> getThge036ContratoList() {
        return thge036ContratoList;
    }

    public void setThge036ContratoList(List<Thge036Contrato> thge036ContratoList) {
        this.thge036ContratoList = thge036ContratoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdEntidad != null ? cdEntidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge037Entidad)) {
            return false;
        }
        Thge037Entidad other = (Thge037Entidad) object;
        if ((this.cdEntidad == null && other.cdEntidad != null) || (this.cdEntidad != null && !this.cdEntidad.equals(other.cdEntidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge037Entidad[ cdEntidad=" + cdEntidad + " ]";
    }
    
}
