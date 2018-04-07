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
@Table(name = "thge066_tp_proy", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge066TpProy.findAll", query = "SELECT t FROM Thge066TpProy t")})
public class Thge066TpProy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_TP_PROYECTO")
    private Integer cdTpProyecto;
    @Basic(optional = false)
    @Column(name = "NB_TP_PROYECTO")
    private String nbTpProyecto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTpProyecto")
    private List<Thge024CtrlExt> thge024CtrlExtList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdProyectoAg")
    private List<Thge024CtrlExt> thge024CtrlExtList1;

    public Thge066TpProy() {
    }

    public Thge066TpProy(Integer cdTpProyecto) {
        this.cdTpProyecto = cdTpProyecto;
    }

    public Thge066TpProy(Integer cdTpProyecto, String nbTpProyecto) {
        this.cdTpProyecto = cdTpProyecto;
        this.nbTpProyecto = nbTpProyecto;
    }

    public Integer getCdTpProyecto() {
        return cdTpProyecto;
    }

    public void setCdTpProyecto(Integer cdTpProyecto) {
        this.cdTpProyecto = cdTpProyecto;
    }

    public String getNbTpProyecto() {
        return nbTpProyecto;
    }

    public void setNbTpProyecto(String nbTpProyecto) {
        this.nbTpProyecto = nbTpProyecto;
    }

    public List<Thge024CtrlExt> getThge024CtrlExtList() {
        return thge024CtrlExtList;
    }

    public void setThge024CtrlExtList(List<Thge024CtrlExt> thge024CtrlExtList) {
        this.thge024CtrlExtList = thge024CtrlExtList;
    }

    public List<Thge024CtrlExt> getThge024CtrlExtList1() {
        return thge024CtrlExtList1;
    }

    public void setThge024CtrlExtList1(List<Thge024CtrlExt> thge024CtrlExtList1) {
        this.thge024CtrlExtList1 = thge024CtrlExtList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdTpProyecto != null ? cdTpProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge066TpProy)) {
            return false;
        }
        Thge066TpProy other = (Thge066TpProy) object;
        if ((this.cdTpProyecto == null && other.cdTpProyecto != null) || (this.cdTpProyecto != null && !this.cdTpProyecto.equals(other.cdTpProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge066TpProy[ cdTpProyecto=" + cdTpProyecto + " ]";
    }
    
}
