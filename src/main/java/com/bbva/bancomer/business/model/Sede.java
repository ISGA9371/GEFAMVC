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
@Table(name = "thge025_sede", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_SEDE"})})
@NamedQueries({
        @NamedQuery(name = "Sede.findAll", query = "SELECT t FROM Sede t")})
public class Sede implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_SEDE", nullable = false)
    private Integer cdSede;
    @Basic(optional = false)
    @Column(name = "NB_SEDE", nullable = false, length = 25)
    private String nbSede;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdSede")
    private List<CtrlAcc> ctrlAccList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdSede")
    private List<CtrlExt> ctrlExtList;

    public Sede() {
    }

    public Sede(Integer cdSede) {
        this.cdSede = cdSede;
    }

    public Sede(Integer cdSede, String nbSede) {
        this.cdSede = cdSede;
        this.nbSede = nbSede;
    }

    public Integer getCdSede() {
        return cdSede;
    }

    public void setCdSede(Integer cdSede) {
        this.cdSede = cdSede;
    }

    public String getNbSede() {
        return nbSede;
    }

    public void setNbSede(String nbSede) {
        this.nbSede = nbSede;
    }

    public List<CtrlAcc> getCtrlAccList() {
        return ctrlAccList;
    }

    public void setCtrlAccList(List<CtrlAcc> ctrlAccList) {
        this.ctrlAccList = ctrlAccList;
    }

    public List<CtrlExt> getCtrlExtList() {
        return ctrlExtList;
    }

    public void setCtrlExtList(List<CtrlExt> ctrlExtList) {
        this.ctrlExtList = ctrlExtList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdSede != null ? cdSede.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sede)) {
            return false;
        }
        Sede other = (Sede) object;
        if ((this.cdSede == null && other.cdSede != null) || (this.cdSede != null && !this.cdSede.equals(other.cdSede))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Sede[ cdSede=" + cdSede + " ]";
    }

}
