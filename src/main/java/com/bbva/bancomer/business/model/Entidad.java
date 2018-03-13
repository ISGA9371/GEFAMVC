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
@Table(name = "thge037_entidad", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_ENTIDAD"})})
@NamedQueries({
        @NamedQuery(name = "Entidad.findAll", query = "SELECT t FROM Entidad t")})
public class Entidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_ENTIDAD", nullable = false)
    private Integer cdEntidad;
    @Basic(optional = false)
    @Column(name = "NB_ENTIDAD", nullable = false, length = 25)
    private String nbEntidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdEntidad")
    private List<Pep> pepList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdEntidad")
    private List<Contrato> contratoList;

    public Entidad() {
    }

    public Entidad(Integer cdEntidad) {
        this.cdEntidad = cdEntidad;
    }

    public Entidad(Integer cdEntidad, String nbEntidad) {
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

    public List<Pep> getPepList() {
        return pepList;
    }

    public void setPepList(List<Pep> pepList) {
        this.pepList = pepList;
    }

    public List<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList) {
        this.contratoList = contratoList;
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
        if (!(object instanceof Entidad)) {
            return false;
        }
        Entidad other = (Entidad) object;
        if ((this.cdEntidad == null && other.cdEntidad != null) || (this.cdEntidad != null && !this.cdEntidad.equals(other.cdEntidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Entidad[ cdEntidad=" + cdEntidad + " ]";
    }

}
