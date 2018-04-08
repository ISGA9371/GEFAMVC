/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author manug
 */
@Entity
@Table(name = "thge064_tp_identif")
public class IdentificationType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_IDENTIFICACION")
    private Integer identificationTypeId;
    @Basic(optional = false)
    @Column(name = "NB_IDENTIFICACION")
    private String identificationTypeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "identificationType")
    private List<ExternalUser> externalUsers;

    public IdentificationType() {
    }

    public IdentificationType(Integer identificationTypeId) {
        this.identificationTypeId = identificationTypeId;
    }

    public IdentificationType(Integer identificationTypeId, String identificationTypeName) {
        this.identificationTypeId = identificationTypeId;
        this.identificationTypeName = identificationTypeName;
    }

    public Integer getIdentificationTypeId() {
        return identificationTypeId;
    }

    public void setIdentificationTypeId(Integer identificationTypeId) {
        this.identificationTypeId = identificationTypeId;
    }

    public String getIdentificationTypeName() {
        return identificationTypeName;
    }

    public void setIdentificationTypeName(String identificationTypeName) {
        this.identificationTypeName = identificationTypeName;
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
        hash += (identificationTypeId != null ? identificationTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdentificationType)) {
            return false;
        }
        IdentificationType other = (IdentificationType) object;
        if ((this.identificationTypeId == null && other.identificationTypeId != null) || (this.identificationTypeId != null && !this.identificationTypeId.equals(other.identificationTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.IdentificationType[ identificationTypeId=" + identificationTypeId + " ]";
    }

}
