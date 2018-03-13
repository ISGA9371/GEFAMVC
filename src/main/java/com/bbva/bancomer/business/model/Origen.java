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
        @NamedQuery(name = "Origen.findAll", query = "SELECT t FROM Origen t")})
public class Origen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_ORIGEN", nullable = false)
    private Integer cdOrigen;
    @Basic(optional = false)
    @Column(name = "NB_ORIGEN", nullable = false, length = 50)
    private String nbOrigen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdOrigen")
    private List<Modif> modifList;

    public Origen() {
    }

    public Origen(Integer cdOrigen) {
        this.cdOrigen = cdOrigen;
    }

    public Origen(Integer cdOrigen, String nbOrigen) {
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

    public List<Modif> getModifList() {
        return modifList;
    }

    public void setModifList(List<Modif> modifList) {
        this.modifList = modifList;
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
        if (!(object instanceof Origen)) {
            return false;
        }
        Origen other = (Origen) object;
        if ((this.cdOrigen == null && other.cdOrigen != null) || (this.cdOrigen != null && !this.cdOrigen.equals(other.cdOrigen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Origen[ cdOrigen=" + cdOrigen + " ]";
    }

}
