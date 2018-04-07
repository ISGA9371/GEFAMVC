/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author manug
 */
@Entity
@Table(name = "thge025_sede", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge025Sede.findAll", query = "SELECT t FROM Thge025Sede t")})
public class Thge025Sede implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_SEDE")
    private Integer cdSede;
    @Basic(optional = false)
    @Column(name = "NB_SEDE")
    private String nbSede;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdSede")
    private List<Thge058CtrlAcc> thge058CtrlAccList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdSede")
    private List<Thge024CtrlExt> thge024CtrlExtList;

    public Thge025Sede() {
    }

    public Thge025Sede(Integer cdSede) {
        this.cdSede = cdSede;
    }

    public Thge025Sede(Integer cdSede, String nbSede) {
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

    public List<Thge058CtrlAcc> getThge058CtrlAccList() {
        return thge058CtrlAccList;
    }

    public void setThge058CtrlAccList(List<Thge058CtrlAcc> thge058CtrlAccList) {
        this.thge058CtrlAccList = thge058CtrlAccList;
    }

    public List<Thge024CtrlExt> getThge024CtrlExtList() {
        return thge024CtrlExtList;
    }

    public void setThge024CtrlExtList(List<Thge024CtrlExt> thge024CtrlExtList) {
        this.thge024CtrlExtList = thge024CtrlExtList;
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
        if (!(object instanceof Thge025Sede)) {
            return false;
        }
        Thge025Sede other = (Thge025Sede) object;
        if ((this.cdSede == null && other.cdSede != null) || (this.cdSede != null && !this.cdSede.equals(other.cdSede))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge025Sede[ cdSede=" + cdSede + " ]";
    }
    
}
