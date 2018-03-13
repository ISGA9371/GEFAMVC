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
        @NamedQuery(name = "Nivel.findAll", query = "SELECT t FROM Nivel t")})
public class Nivel implements Serializable {

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
    private List<Traspaso> traspasoList;
    @OneToMany(mappedBy = "cdNivel")
    private List<User> userList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdNivel")
    private List<Requerim> requerimList;
    @JoinColumn(name = "CD_TIPO_NIVEL", referencedColumnName = "CD_TIPO_NIVEL", nullable = false)
    @ManyToOne(optional = false)
    private TipoNivel cdTipoNivel;
    @OneToMany(mappedBy = "cdNivelSuperior")
    private List<Nivel> nivelList;
    @JoinColumn(name = "CD_NIVEL_SUPERIOR", referencedColumnName = "CD_NIVEL")
    @ManyToOne
    private Nivel cdNivelSuperior;
    @JoinColumn(name = "CD_USUARIO_RESP", referencedColumnName = "CD_USUARIO_CORP", nullable = false)
    @ManyToOne(optional = false)
    private User cdUserResp;

    public Nivel() {
    }

    public Nivel(Integer cdConsecNivel) {
        this.cdConsecNivel = cdConsecNivel;
    }

    public Nivel(Integer cdConsecNivel, int cdNivel, String nbNivel) {
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

    public List<Traspaso> getTraspasoList() {
        return traspasoList;
    }

    public void setTraspasoList(List<Traspaso> traspasoList) {
        this.traspasoList = traspasoList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Requerim> getRequerimList() {
        return requerimList;
    }

    public void setRequerimList(List<Requerim> requerimList) {
        this.requerimList = requerimList;
    }

    public TipoNivel getCdTipoNivel() {
        return cdTipoNivel;
    }

    public void setCdTipoNivel(TipoNivel cdTipoNivel) {
        this.cdTipoNivel = cdTipoNivel;
    }

    public List<Nivel> getNivelList() {
        return nivelList;
    }

    public void setNivelList(List<Nivel> nivelList) {
        this.nivelList = nivelList;
    }

    public Nivel getCdNivelSuperior() {
        return cdNivelSuperior;
    }

    public void setCdNivelSuperior(Nivel cdNivelSuperior) {
        this.cdNivelSuperior = cdNivelSuperior;
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
        if (!(object instanceof Nivel)) {
            return false;
        }
        Nivel other = (Nivel) object;
        if ((this.cdConsecNivel == null && other.cdConsecNivel != null) || (this.cdConsecNivel != null && !this.cdConsecNivel.equals(other.cdConsecNivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Nivel[ cdConsecNivel=" + cdConsecNivel + " ]";
    }

}
