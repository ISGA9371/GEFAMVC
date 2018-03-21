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
@Table(name = "thge004_tipo_nivel", catalog = "gestion_factoria",  uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_TIPO_NIVEL"})})
public class LevelType_ implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_TIPO_NIVEL", nullable = false)
    private Integer levelTypeId;
    @Basic(optional = false)
    @Column(name = "NB_TIPO_NIVEL", nullable = false, length = 50)
    private String levelTypeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "levelType")
    private List<Level_> levels;

    public LevelType_() {
    }

    public LevelType_(Integer levelTypeId) {
        this.levelTypeId = levelTypeId;
    }

    public LevelType_(Integer levelTypeId, String levelTypeName) {
        this.levelTypeId = levelTypeId;
        this.levelTypeName = levelTypeName;
    }

    public Integer getLevelTypeId() {
        return levelTypeId;
    }

    public void setLevelTypeId(Integer levelTypeId) {
        this.levelTypeId = levelTypeId;
    }

    public String getLevelTypeName() {
        return levelTypeName;
    }

    public void setLevelTypeName(String levelTypeName) {
        this.levelTypeName = levelTypeName;
    }

    public List<Level_> getLevels() {
        return levels;
    }

    public void setLevels(List<Level_> levels) {
        this.levels = levels;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (levelTypeId != null ? levelTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof LevelType_)) {
            return false;
        }
        LevelType_ other = (LevelType_) object;
        return (this.levelTypeId != null || other.levelTypeId == null) && (this.levelTypeId == null || this.levelTypeId.equals(other.levelTypeId));
    }

    @Override
    public String toString() {
        return "com.bbva.LevelType_[ levelTypeId=" + levelTypeId + " ]";
    }

}
