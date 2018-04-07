/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author manug
 */
@Entity
@Table(name = "thge062_eval_serv", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge062EvalServ.findAll", query = "SELECT t FROM Thge062EvalServ t")})
public class Thge062EvalServ implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Thge062EvalServPK thge062EvalServPK;
    @Basic(optional = false)
    @Column(name = "TO_CALIF")
    private String toCalif;
    @JoinColumn(name = "CD_TECNOLOGIA", referencedColumnName = "CD_TECNOLOGIA")
    @ManyToOne(optional = false)
    private Thge002Tecnologia cdTecnologia;
    @JoinColumn(name = "CD_EMPRESA", referencedColumnName = "CD_EMPRESA")
    @ManyToOne(optional = false)
    private Thge003Empresa cdEmpresa;

    public Thge062EvalServ() {
    }

    public Thge062EvalServ(Thge062EvalServPK thge062EvalServPK) {
        this.thge062EvalServPK = thge062EvalServPK;
    }

    public Thge062EvalServ(Thge062EvalServPK thge062EvalServPK, String toCalif) {
        this.thge062EvalServPK = thge062EvalServPK;
        this.toCalif = toCalif;
    }

    public Thge062EvalServ(Date fhInicio, Date fhFin) {
        this.thge062EvalServPK = new Thge062EvalServPK(fhInicio, fhFin);
    }

    public Thge062EvalServPK getThge062EvalServPK() {
        return thge062EvalServPK;
    }

    public void setThge062EvalServPK(Thge062EvalServPK thge062EvalServPK) {
        this.thge062EvalServPK = thge062EvalServPK;
    }

    public String getToCalif() {
        return toCalif;
    }

    public void setToCalif(String toCalif) {
        this.toCalif = toCalif;
    }

    public Thge002Tecnologia getCdTecnologia() {
        return cdTecnologia;
    }

    public void setCdTecnologia(Thge002Tecnologia cdTecnologia) {
        this.cdTecnologia = cdTecnologia;
    }

    public Thge003Empresa getCdEmpresa() {
        return cdEmpresa;
    }

    public void setCdEmpresa(Thge003Empresa cdEmpresa) {
        this.cdEmpresa = cdEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (thge062EvalServPK != null ? thge062EvalServPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge062EvalServ)) {
            return false;
        }
        Thge062EvalServ other = (Thge062EvalServ) object;
        if ((this.thge062EvalServPK == null && other.thge062EvalServPK != null) || (this.thge062EvalServPK != null && !this.thge062EvalServPK.equals(other.thge062EvalServPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge062EvalServ[ thge062EvalServPK=" + thge062EvalServPK + " ]";
    }
    
}
