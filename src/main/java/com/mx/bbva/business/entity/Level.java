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
 * @author Guevara M
 */
@Entity
@Table(name = "thge010_nivel", uniqueConstraints = {@UniqueConstraint(columnNames = {"CD_NIVEL"})})
public class Level implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_NIVEL", nullable = false)
    private Integer levelId;
    @Basic(optional = false)
    @Column(name = "NB_NIVEL", nullable = false, length = 50)
    private String levelName;
    @JoinColumn(name = "CD_TIPO_NIVEL", referencedColumnName = "CD_TIPO_NIVEL", nullable = false)
    @ManyToOne(optional = false)
    private LevelType levelType;
    @JoinColumn(name = "CD_NIVEL_SUPERIOR", referencedColumnName = "CD_NIVEL")
    @ManyToOne
    private Level levelSuperior;
    @JoinColumn(name = "CD_USUARIO_RESP", referencedColumnName = "CD_USUARIO_CORP", nullable = false)
    @ManyToOne(optional = false)
    private User user;
    @JsonIgnore
    @OneToMany(mappedBy = "level")
    private List<Transfer> transfers;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "level")
    private List<Requirement> requirements;
    @JsonIgnore
    @OneToMany(mappedBy = "levelSuperior")
    private List<Level> levelList;

    public Level() {
    }

    public Level(Integer levelId) {
        this.levelId = levelId;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }

    public List<Requirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Requirement> requirements) {
        this.requirements = requirements;
    }

    public LevelType getLevelType() {
        return levelType;
    }

    public void setLevelType(LevelType levelType) {
        this.levelType = levelType;
    }

    public List<Level> getLevelList() {
        return levelList;
    }

    public void setLevelList(List<Level> levelList) {
        this.levelList = levelList;
    }

    public Level getLevelSuperior() {
        return levelSuperior;
    }

    public void setLevelSuperior(Level levelSuperior) {
        this.levelSuperior = levelSuperior;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Level level = (Level) o;

        return levelId.equals(level.levelId);
    }

    @Override
    public int hashCode() {
        return levelId.hashCode();
    }

    @Override
    public String toString() {
        return "Level{" +
                "levelId=" + levelId +
                '}';
    }
}
