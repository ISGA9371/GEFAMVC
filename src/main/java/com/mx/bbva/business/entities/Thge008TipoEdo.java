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
@Table(name = "thge008_tipo_edo", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge008TipoEdo.findAll", query = "SELECT t FROM Thge008TipoEdo t")})
public class Thge008TipoEdo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_TIPO_EDO")
    private Integer cdTipoEdo;
    @Basic(optional = false)
    @Column(name = "NB_TIPO_EDO")
    private String nbTipoEdo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTipoEdo")
    private List<Thge005Estado> thge005EstadoList;

    public Thge008TipoEdo() {
    }

    public Thge008TipoEdo(Integer cdTipoEdo) {
        this.cdTipoEdo = cdTipoEdo;
    }

    public Thge008TipoEdo(Integer cdTipoEdo, String nbTipoEdo) {
        this.cdTipoEdo = cdTipoEdo;
        this.nbTipoEdo = nbTipoEdo;
    }

    public Integer getCdTipoEdo() {
        return cdTipoEdo;
    }

    public void setCdTipoEdo(Integer cdTipoEdo) {
        this.cdTipoEdo = cdTipoEdo;
    }

    public String getNbTipoEdo() {
        return nbTipoEdo;
    }

    public void setNbTipoEdo(String nbTipoEdo) {
        this.nbTipoEdo = nbTipoEdo;
    }

    public List<Thge005Estado> getThge005EstadoList() {
        return thge005EstadoList;
    }

    public void setThge005EstadoList(List<Thge005Estado> thge005EstadoList) {
        this.thge005EstadoList = thge005EstadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdTipoEdo != null ? cdTipoEdo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge008TipoEdo)) {
            return false;
        }
        Thge008TipoEdo other = (Thge008TipoEdo) object;
        if ((this.cdTipoEdo == null && other.cdTipoEdo != null) || (this.cdTipoEdo != null && !this.cdTipoEdo.equals(other.cdTipoEdo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge008TipoEdo[ cdTipoEdo=" + cdTipoEdo + " ]";
    }
    
}
