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
@Table(name = "thge008_tipo_edo", catalog = "gestion_factoria", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_TIPO_EDO"})})
public class StatusType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_TIPO_EDO", nullable = false)
    private Integer statusTypeId;
    @Basic(optional = false)
    @Column(name = "NB_TIPO_EDO", nullable = false, length = 50)
    private String statusTypeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusType")
    private List<Status> statusList;

    public StatusType() {
    }

    public StatusType(Integer statusTypeId) {
        this.statusTypeId = statusTypeId;
    }

    public StatusType(Integer statusTypeId, String statusTypeName) {
        this.statusTypeId = statusTypeId;
        this.statusTypeName = statusTypeName;
    }

    public Integer getStatusTypeId() {
        return statusTypeId;
    }

    public void setStatusTypeId(Integer statusTypeId) {
        this.statusTypeId = statusTypeId;
    }

    public String getStatusTypeName() {
        return statusTypeName;
    }

    public void setStatusTypeName(String statusTypeName) {
        this.statusTypeName = statusTypeName;
    }

    public List<Status> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<Status> statusList) {
        this.statusList = statusList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statusTypeId != null ? statusTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof StatusType)) {
            return false;
        }
        StatusType other = (StatusType) object;
        return (this.statusTypeId != null || other.statusTypeId == null) && (this.statusTypeId == null || this.statusTypeId.equals(other.statusTypeId));
    }

    @Override
    public String toString() {
        return "com.bbva.StatusType[ statusTypeId=" + statusTypeId + " ]";
    }

}
