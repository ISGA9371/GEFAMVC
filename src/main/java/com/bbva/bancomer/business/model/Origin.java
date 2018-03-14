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
@Table(name = "thge019_origen", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_ORIGEN"})})
@NamedQueries({
        @NamedQuery(name = "Origin.findAll", query = "SELECT t FROM Origin t")})
public class Origin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_ORIGEN", nullable = false)
    private Integer cdOrigen;
    @Basic(optional = false)
    @Column(name = "NB_ORIGEN", nullable = false, length = 50)
    private String nbOrigen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdOrigen")
    private List<Modification> modificationList;

    public Origin() {
    }

    public Origin(Integer cdOrigen) {
        this.cdOrigen = cdOrigen;
    }

    public Origin(Integer cdOrigen, String nbOrigen) {
        this.cdOrigen = cdOrigen;
        this.nbOrigen = nbOrigen;
    }

    public Integer getCdOrigen() {
        return cdOrigen;
    }

    public void setCdOrigen(Integer cdOrigen) {
        this.cdOrigen = cdOrigen;
    }

    public String getNbOrigen() {
        return nbOrigen;
    }

    public void setNbOrigen(String nbOrigen) {
        this.nbOrigen = nbOrigen;
    }

    public List<Modification> getModificationList() {
        return modificationList;
    }

    public void setModificationList(List<Modification> modificationList) {
        this.modificationList = modificationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdOrigen != null ? cdOrigen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Origin)) {
            return false;
        }
        Origin other = (Origin) object;
        if ((this.cdOrigen == null && other.cdOrigen != null) || (this.cdOrigen != null && !this.cdOrigen.equals(other.cdOrigen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Origin[ cdOrigen=" + cdOrigen + " ]";
    }

}
