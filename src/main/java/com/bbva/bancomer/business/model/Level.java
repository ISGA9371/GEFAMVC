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
@Table(name = "thge010_nivel", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CD_NIVEL"})})
@NamedQueries({
        @NamedQuery(name = "Level.findAll", query = "SELECT t FROM Level t")})
public class Level implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_CONSEC_NIVEL", nullable = false)
    private Integer cdConsecNivel;
    @Basic(optional = false)
    @Column(name = "CD_NIVEL", nullable = false)
    private int cdNivel;
    @Basic(optional = false)
    @Column(name = "NB_NIVEL", nullable = false, length = 50)
    private String nbNivel;
    @OneToMany(mappedBy = "cdNivelSubdir")
    private List<Transfer> transferList;
    @OneToMany(mappedBy = "cdNivel")
    private List<User> userList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdNivel")
    private List<Requirement> requirementList;
    @JoinColumn(name = "CD_TIPO_NIVEL", referencedColumnName = "CD_TIPO_NIVEL", nullable = false)
    @ManyToOne(optional = false)
    private LevelType cdLevelType;
    @OneToMany(mappedBy = "cdLevelSuperior")
    private List<Level> levelList;
    @JoinColumn(name = "CD_NIVEL_SUPERIOR", referencedColumnName = "CD_NIVEL")
    @ManyToOne
    private Level cdLevelSuperior;
    @JoinColumn(name = "CD_USUARIO_RESP", referencedColumnName = "CD_USUARIO_CORP", nullable = false)
    @ManyToOne(optional = false)
    private User cdUserResp;

    public Level() {
    }

    public Level(Integer cdConsecNivel) {
        this.cdConsecNivel = cdConsecNivel;
    }

    public Level(Integer cdConsecNivel, int cdNivel, String nbNivel) {
        this.cdConsecNivel = cdConsecNivel;
        this.cdNivel = cdNivel;
        this.nbNivel = nbNivel;
    }

    public Integer getCdConsecNivel() {
        return cdConsecNivel;
    }

    public void setCdConsecNivel(Integer cdConsecNivel) {
        this.cdConsecNivel = cdConsecNivel;
    }

    public int getCdNivel() {
        return cdNivel;
    }

    public void setCdNivel(int cdNivel) {
        this.cdNivel = cdNivel;
    }

    public String getNbNivel() {
        return nbNivel;
    }

    public void setNbNivel(String nbNivel) {
        this.nbNivel = nbNivel;
    }

    public List<Transfer> getTransferList() {
        return transferList;
    }

    public void setTransferList(List<Transfer> transferList) {
        this.transferList = transferList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Requirement> getRequirementList() {
        return requirementList;
    }

    public void setRequirementList(List<Requirement> requirementList) {
        this.requirementList = requirementList;
    }

    public LevelType getCdLevelType() {
        return cdLevelType;
    }

    public void setCdLevelType(LevelType cdLevelType) {
        this.cdLevelType = cdLevelType;
    }

    public List<Level> getLevelList() {
        return levelList;
    }

    public void setLevelList(List<Level> levelList) {
        this.levelList = levelList;
    }

    public Level getCdLevelSuperior() {
        return cdLevelSuperior;
    }

    public void setCdLevelSuperior(Level cdLevelSuperior) {
        this.cdLevelSuperior = cdLevelSuperior;
    }

    public User getCdUserResp() {
        return cdUserResp;
    }

    public void setCdUserResp(User cdUserResp) {
        this.cdUserResp = cdUserResp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdConsecNivel != null ? cdConsecNivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Level)) {
            return false;
        }
        Level other = (Level) object;
        if ((this.cdConsecNivel == null && other.cdConsecNivel != null) || (this.cdConsecNivel != null && !this.cdConsecNivel.equals(other.cdConsecNivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Level[ cdConsecNivel=" + cdConsecNivel + " ]";
    }

}
