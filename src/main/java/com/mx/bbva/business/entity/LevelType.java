/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Guevara Manuel
 */
@Entity
@Table(name = "thge004_tipo_nivel", uniqueConstraints = {@UniqueConstraint(columnNames = {"NB_TIPO_NIVEL"})})
public class LevelType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_TIPO_NIVEL", nullable = false)
    private Integer levelTypeId;
    @Basic(optional = false)
    @Column(name = "NB_TIPO_NIVEL", nullable = false, length = 50)
    private String levelTypeName;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "levelType")
    private List<Level> levels;

    public LevelType() {
    }

    public LevelType(Integer levelTypeId) {
        this.levelTypeId = levelTypeId;
    }

    public LevelType(Integer levelTypeId, String levelTypeName) {
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

    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(List<Level> levels) {
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
        if (!(object instanceof LevelType)) {
            return false;
        }
        LevelType other = (LevelType) object;
        return (this.levelTypeId != null || other.levelTypeId == null) && (this.levelTypeId == null || this.levelTypeId.equals(other.levelTypeId));
    }

    @Override
    public String toString() {
        return "com.bbva.LevelType[ levelTypeId=" + levelTypeId + " ]";
    }

}
