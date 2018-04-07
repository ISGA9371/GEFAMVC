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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author manug
 */
@Entity
@Table(name = "thge001_tipo_serv", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge001TipoServ.findAll", query = "SELECT t FROM Thge001TipoServ t")})
public class Thge001TipoServ implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_TIPO_SERVICIO")
    private Integer cdTipoServicio;
    @Basic(optional = false)
    @Column(name = "NB_TIPO_SERVICIO")
    private String nbTipoServicio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTipoServicio")
    private List<Thge017Requerim> thge017RequerimList;
    @JoinColumn(name = "CD_AREA", referencedColumnName = "CD_AREA")
    @ManyToOne(optional = false)
    private Thge030Area cdArea;

    public Thge001TipoServ() {
    }

    public Thge001TipoServ(Integer cdTipoServicio) {
        this.cdTipoServicio = cdTipoServicio;
    }

    public Thge001TipoServ(Integer cdTipoServicio, String nbTipoServicio) {
        this.cdTipoServicio = cdTipoServicio;
        this.nbTipoServicio = nbTipoServicio;
    }

    public Integer getCdTipoServicio() {
        return cdTipoServicio;
    }

    public void setCdTipoServicio(Integer cdTipoServicio) {
        this.cdTipoServicio = cdTipoServicio;
    }

    public String getNbTipoServicio() {
        return nbTipoServicio;
    }

    public void setNbTipoServicio(String nbTipoServicio) {
        this.nbTipoServicio = nbTipoServicio;
    }

    public List<Thge017Requerim> getThge017RequerimList() {
        return thge017RequerimList;
    }

    public void setThge017RequerimList(List<Thge017Requerim> thge017RequerimList) {
        this.thge017RequerimList = thge017RequerimList;
    }

    public Thge030Area getCdArea() {
        return cdArea;
    }

    public void setCdArea(Thge030Area cdArea) {
        this.cdArea = cdArea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdTipoServicio != null ? cdTipoServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge001TipoServ)) {
            return false;
        }
        Thge001TipoServ other = (Thge001TipoServ) object;
        if ((this.cdTipoServicio == null && other.cdTipoServicio != null) || (this.cdTipoServicio != null && !this.cdTipoServicio.equals(other.cdTipoServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge001TipoServ[ cdTipoServicio=" + cdTipoServicio + " ]";
    }
    
}
