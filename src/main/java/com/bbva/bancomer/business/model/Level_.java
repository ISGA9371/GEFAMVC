/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbva.bancomer.business.model;

import com.google.appengine.repackaged.org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Guevara
 */
@Entity
@Table(name = "thge010_nivel", catalog = "gestion_factoria", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CD_NIVEL"})})
public class Level_ implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_CONSEC_NIVEL", nullable = false)
    private Integer levelSerial;
    @Basic(optional = false)
    @Column(name = "CD_NIVEL", nullable = false)
    private int levelId;
    @Basic(optional = false)
    @Column(name = "NB_NIVEL", nullable = false, length = 50)
    private String levelName;
    @OneToMany(mappedBy = "level")
    private List<Transfer> transfers;
    @OneToMany(mappedBy = "level")
    private List<User> users;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "level")
    private List<Requirement> requirements;
    @JoinColumn(name = "CD_TIPO_NIVEL", referencedColumnName = "CD_TIPO_NIVEL", nullable = false)
    @ManyToOne(optional = false)
    private LevelType_ levelType;
    @OneToMany(mappedBy = "levelSuperior")
    private List<Level_> levelList;
    @JsonIgnore
    @JoinColumn(name = "CD_NIVEL_SUPERIOR", referencedColumnName = "CD_NIVEL")
    @ManyToOne
    private Level_ levelSuperior;
    @JoinColumn(name = "CD_USUARIO_RESP", referencedColumnName = "CD_USUARIO_CORP", nullable = false)
    @ManyToOne(optional = false)
    private User user;

    public Level_() {
    }

    public Level_(Integer levelSerial) {
        this.levelSerial = levelSerial;
    }

    public Level_(Integer levelSerial, int levelId, String levelName) {
        this.levelSerial = levelSerial;
        this.levelId = levelId;
        this.levelName = levelName;
    }

    public Integer getLevelSerial() {
        return levelSerial;
    }

    public void setLevelSerial(Integer levelSerial) {
        this.levelSerial = levelSerial;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Requirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Requirement> requirements) {
        this.requirements = requirements;
    }

    public LevelType_ getLevelType() {
        return levelType;
    }

    public void setLevelType(LevelType_ levelType) {
        this.levelType = levelType;
    }

    public List<Level_> getLevelList() {
        return levelList;
    }

    public void setLevelList(List<Level_> levelList) {
        this.levelList = levelList;
    }

    public Level_ getLevelSuperior() {
        return levelSuperior;
    }

    public void setLevelSuperior(Level_ levelSuperior) {
        this.levelSuperior = levelSuperior;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (levelSerial != null ? levelSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Level_)) {
            return false;
        }
        Level_ other = (Level_) object;
        return (this.levelSerial != null || other.levelSerial == null) && (this.levelSerial == null || this.levelSerial.equals(other.levelSerial));
    }

    @Override
    public String toString() {
        return "com.bbva.Level_[ levelSerial=" + levelSerial + " ]";
    }

}
