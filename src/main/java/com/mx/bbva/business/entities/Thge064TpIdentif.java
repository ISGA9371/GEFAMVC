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
@Table(name = "thge064_tp_identif", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge064TpIdentif.findAll", query = "SELECT t FROM Thge064TpIdentif t")})
public class Thge064TpIdentif implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_IDENTIFICACION")
    private Integer cdIdentificacion;
    @Basic(optional = false)
    @Column(name = "NB_IDENTIFICACION")
    private String nbIdentificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tpIdentif")
    private List<Thge024CtrlExt> thge024CtrlExtList;

    public Thge064TpIdentif() {
    }

    public Thge064TpIdentif(Integer cdIdentificacion) {
        this.cdIdentificacion = cdIdentificacion;
    }

    public Thge064TpIdentif(Integer cdIdentificacion, String nbIdentificacion) {
        this.cdIdentificacion = cdIdentificacion;
        this.nbIdentificacion = nbIdentificacion;
    }

    public Integer getCdIdentificacion() {
        return cdIdentificacion;
    }

    public void setCdIdentificacion(Integer cdIdentificacion) {
        this.cdIdentificacion = cdIdentificacion;
    }

    public String getNbIdentificacion() {
        return nbIdentificacion;
    }

    public void setNbIdentificacion(String nbIdentificacion) {
        this.nbIdentificacion = nbIdentificacion;
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
        hash += (cdIdentificacion != null ? cdIdentificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge064TpIdentif)) {
            return false;
        }
        Thge064TpIdentif other = (Thge064TpIdentif) object;
        if ((this.cdIdentificacion == null && other.cdIdentificacion != null) || (this.cdIdentificacion != null && !this.cdIdentificacion.equals(other.cdIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge064TpIdentif[ cdIdentificacion=" + cdIdentificacion + " ]";
    }
    
}
