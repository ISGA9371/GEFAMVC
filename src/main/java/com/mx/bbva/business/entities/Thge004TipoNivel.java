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
@Table(name = "thge004_tipo_nivel", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge004TipoNivel.findAll", query = "SELECT t FROM Thge004TipoNivel t")})
public class Thge004TipoNivel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_TIPO_NIVEL")
    private Integer cdTipoNivel;
    @Basic(optional = false)
    @Column(name = "NB_TIPO_NIVEL")
    private String nbTipoNivel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTipoNivel")
    private List<Thge010Nivel> thge010NivelList;

    public Thge004TipoNivel() {
    }

    public Thge004TipoNivel(Integer cdTipoNivel) {
        this.cdTipoNivel = cdTipoNivel;
    }

    public Thge004TipoNivel(Integer cdTipoNivel, String nbTipoNivel) {
        this.cdTipoNivel = cdTipoNivel;
        this.nbTipoNivel = nbTipoNivel;
    }

    public Integer getCdTipoNivel() {
        return cdTipoNivel;
    }

    public void setCdTipoNivel(Integer cdTipoNivel) {
        this.cdTipoNivel = cdTipoNivel;
    }

    public String getNbTipoNivel() {
        return nbTipoNivel;
    }

    public void setNbTipoNivel(String nbTipoNivel) {
        this.nbTipoNivel = nbTipoNivel;
    }

    public List<Thge010Nivel> getThge010NivelList() {
        return thge010NivelList;
    }

    public void setThge010NivelList(List<Thge010Nivel> thge010NivelList) {
        this.thge010NivelList = thge010NivelList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdTipoNivel != null ? cdTipoNivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge004TipoNivel)) {
            return false;
        }
        Thge004TipoNivel other = (Thge004TipoNivel) object;
        if ((this.cdTipoNivel == null && other.cdTipoNivel != null) || (this.cdTipoNivel != null && !this.cdTipoNivel.equals(other.cdTipoNivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge004TipoNivel[ cdTipoNivel=" + cdTipoNivel + " ]";
    }
    
}
