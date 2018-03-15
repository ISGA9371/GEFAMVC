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
@Table(name = "thge008_tipo_edo", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_TIPO_EDO"})})
@NamedQueries({
        @NamedQuery(name = "StatusType.findAll", query = "SELECT t FROM StatusType t")})
public class StatusType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_TIPO_EDO", nullable = false)
    private Integer cdTipoEdo;
    @Basic(optional = false)
    @Column(name = "NB_TIPO_EDO", nullable = false, length = 50)
    private String nbTipoEdo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdStatusType")
    private List<Status> statusList;

    public StatusType() {
    }

    public StatusType(Integer cdTipoEdo) {
        this.cdTipoEdo = cdTipoEdo;
    }

    public StatusType(Integer cdTipoEdo, String nbTipoEdo) {
        this.cdTipoEdo = cdTipoEdo;
        this.nbTipoEdo = nbTipoEdo;
    }

    public Integer getCdTipoEdo() {
        return cdTipoEdo;
    }

    public void setCdTipoEdo(Integer cdTipoEdo) {
        this.cdTipoEdo = cdTipoEdo;
    }

    public String getNbTipoEdo() {
        return nbTipoEdo;
    }

    public void setNbTipoEdo(String nbTipoEdo) {
        this.nbTipoEdo = nbTipoEdo;
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
        hash += (cdTipoEdo != null ? cdTipoEdo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StatusType)) {
            return false;
        }
        StatusType other = (StatusType) object;
        if ((this.cdTipoEdo == null && other.cdTipoEdo != null) || (this.cdTipoEdo != null && !this.cdTipoEdo.equals(other.cdTipoEdo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.StatusType[ cdTipoEdo=" + cdTipoEdo + " ]";
    }

}
