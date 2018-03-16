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
@Table(name = "thge016_perf_usu", catalog = "gestion_factoria", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_PERFIL"})})
public class ProfileType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_TIPO_PERFIL", nullable = false)
    private Integer profileTypeId;
    @Basic(optional = false)
    @Column(name = "NB_PERFIL", nullable = false, length = 25)
    private String profileTypeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profileType")
    private List<User> users;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profileType")
    private List<ExternalUser> externalUsers;

    public ProfileType() {
    }

    public ProfileType(Integer profileTypeId) {
        this.profileTypeId = profileTypeId;
    }

    public ProfileType(Integer profileTypeId, String profileTypeName) {
        this.profileTypeId = profileTypeId;
        this.profileTypeName = profileTypeName;
    }

    public Integer getProfileTypeId() {
        return profileTypeId;
    }

    public void setProfileTypeId(Integer profileTypeId) {
        this.profileTypeId = profileTypeId;
    }

    public String getProfileTypeName() {
        return profileTypeName;
    }

    public void setProfileTypeName(String profileTypeName) {
        this.profileTypeName = profileTypeName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<ExternalUser> getExternalUsers() {
        return externalUsers;
    }

    public void setExternalUsers(List<ExternalUser> externalUsers) {
        this.externalUsers = externalUsers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profileTypeId != null ? profileTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfileType)) {
            return false;
        }
        ProfileType other = (ProfileType) object;
        if ((this.profileTypeId == null && other.profileTypeId != null) || (this.profileTypeId != null && !this.profileTypeId.equals(other.profileTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.ProfileType[ profileTypeId=" + profileTypeId + " ]";
    }

}
