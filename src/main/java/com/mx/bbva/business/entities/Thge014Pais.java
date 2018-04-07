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
@Table(name = "thge014_pais", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge014Pais.findAll", query = "SELECT t FROM Thge014Pais t")})
public class Thge014Pais implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_PAIS")
    private Integer cdPais;
    @Basic(optional = false)
    @Column(name = "NB_PAIS")
    private String nbPais;
    @Basic(optional = false)
    @Column(name = "NB_NACIONALIDAD")
    private String nbNacionalidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdPais")
    private List<Thge024CtrlExt> thge024CtrlExtList;

    public Thge014Pais() {
    }

    public Thge014Pais(Integer cdPais) {
        this.cdPais = cdPais;
    }

    public Thge014Pais(Integer cdPais, String nbPais, String nbNacionalidad) {
        this.cdPais = cdPais;
        this.nbPais = nbPais;
        this.nbNacionalidad = nbNacionalidad;
    }

    public Integer getCdPais() {
        return cdPais;
    }

    public void setCdPais(Integer cdPais) {
        this.cdPais = cdPais;
    }

    public String getNbPais() {
        return nbPais;
    }

    public void setNbPais(String nbPais) {
        this.nbPais = nbPais;
    }

    public String getNbNacionalidad() {
        return nbNacionalidad;
    }

    public void setNbNacionalidad(String nbNacionalidad) {
        this.nbNacionalidad = nbNacionalidad;
    }

    public List<Thge024CtrlExt> getThge024CtrlExtList() {
        return thge024CtrlExtList;
    }

    public void setThge024CtrlExtList(List<Thge024CtrlExt> thge024CtrlExtList) {
        this.thge024CtrlExtList = thge024CtrlExtList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdPais != null ? cdPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge014Pais)) {
            return false;
        }
        Thge014Pais other = (Thge014Pais) object;
        if ((this.cdPais == null && other.cdPais != null) || (this.cdPais != null && !this.cdPais.equals(other.cdPais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge014Pais[ cdPais=" + cdPais + " ]";
    }
    
}
