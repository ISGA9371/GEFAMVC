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
@Table(name = "thge004_tipo_nivel", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_TIPO_NIVEL"})})
@NamedQueries({
        @NamedQuery(name = "LevelType.findAll", query = "SELECT t FROM LevelType t")})
public class LevelType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_TIPO_NIVEL", nullable = false)
    private Integer cdTipoNivel;
    @Basic(optional = false)
    @Column(name = "NB_TIPO_NIVEL", nullable = false, length = 50)
    private String nbTipoNivel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTipoNivel")
    private List<Level> levelList;

    public LevelType() {
    }

    public LevelType(Integer cdTipoNivel) {
        this.cdTipoNivel = cdTipoNivel;
    }

    public LevelType(Integer cdTipoNivel, String nbTipoNivel) {
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

    public List<Level> getLevelList() {
        return levelList;
    }

    public void setLevelList(List<Level> levelList) {
        this.levelList = levelList;
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
        if (!(object instanceof LevelType)) {
            return false;
        }
        LevelType other = (LevelType) object;
        if ((this.cdTipoNivel == null && other.cdTipoNivel != null) || (this.cdTipoNivel != null && !this.cdTipoNivel.equals(other.cdTipoNivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.LevelType[ cdTipoNivel=" + cdTipoNivel + " ]";
    }

}
