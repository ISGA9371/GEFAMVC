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
@Table(name = "thge016_perf_usu", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_PERFIL"})})
@NamedQueries({
        @NamedQuery(name = "ProfileType.findAll", query = "SELECT t FROM ProfileType t")})
public class ProfileType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_TIPO_PERFIL", nullable = false)
    private Integer cdTipoPerfil;
    @Basic(optional = false)
    @Column(name = "NB_PERFIL", nullable = false, length = 25)
    private String nbPerfil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdPerfUsu")
    private List<User> userList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdPerfilRec")
    private List<ExternalUser> externalUserList;

    public ProfileType() {
    }

    public ProfileType(Integer cdTipoPerfil) {
        this.cdTipoPerfil = cdTipoPerfil;
    }

    public ProfileType(Integer cdTipoPerfil, String nbPerfil) {
        this.cdTipoPerfil = cdTipoPerfil;
        this.nbPerfil = nbPerfil;
    }

    public Integer getCdTipoPerfil() {
        return cdTipoPerfil;
    }

    public void setCdTipoPerfil(Integer cdTipoPerfil) {
        this.cdTipoPerfil = cdTipoPerfil;
    }

    public String getNbPerfil() {
        return nbPerfil;
    }

    public void setNbPerfil(String nbPerfil) {
        this.nbPerfil = nbPerfil;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<ExternalUser> getExternalUserList() {
        return externalUserList;
    }

    public void setExternalUserList(List<ExternalUser> externalUserList) {
        this.externalUserList = externalUserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdTipoPerfil != null ? cdTipoPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfileType)) {
            return false;
        }
        ProfileType other = (ProfileType) object;
        if ((this.cdTipoPerfil == null && other.cdTipoPerfil != null) || (this.cdTipoPerfil != null && !this.cdTipoPerfil.equals(other.cdTipoPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.ProfileType[ cdTipoPerfil=" + cdTipoPerfil + " ]";
    }

}
