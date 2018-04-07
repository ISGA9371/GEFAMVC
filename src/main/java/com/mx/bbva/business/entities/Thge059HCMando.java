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
@Table(name = "thge059_h_c_mando", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge059HCMando.findAll", query = "SELECT t FROM Thge059HCMando t")})
public class Thge059HCMando implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Thge059HCMandoPK thge059HCMandoPK;
    @Basic(optional = false)
    @Column(name = "HM_MIL")
    private double hmMil;
    @Basic(optional = false)
    @Column(name = "TO_PUNT_ACT")
    private float toPuntAct;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TO_PUNT_METRICA")
    private Float toPuntMetrica;
    @JoinColumn(name = "CD_TECNOLOGIA", referencedColumnName = "CD_TECNOLOGIA")
    @ManyToOne(optional = false)
    private Thge002Tecnologia cdTecnologia;
    @JoinColumn(name = "CD_EMPRESA", referencedColumnName = "CD_EMPRESA")
    @ManyToOne(optional = false)
    private Thge003Empresa cdEmpresa;
    @JoinColumn(name = "CD_METRICA", referencedColumnName = "CD_METRICA")
    @ManyToOne(optional = false)
    private Thge061Metrica cdMetrica;

    public Thge059HCMando() {
    }

    public Thge059HCMando(Thge059HCMandoPK thge059HCMandoPK) {
        this.thge059HCMandoPK = thge059HCMandoPK;
    }

    public Thge059HCMando(Thge059HCMandoPK thge059HCMandoPK, double hmMil, float toPuntAct) {
        this.thge059HCMandoPK = thge059HCMandoPK;
        this.hmMil = hmMil;
        this.toPuntAct = toPuntAct;
    }

    public Thge059HCMando(Date fhInicio, Date fhFin) {
        this.thge059HCMandoPK = new Thge059HCMandoPK(fhInicio, fhFin);
    }

    public Thge059HCMandoPK getThge059HCMandoPK() {
        return thge059HCMandoPK;
    }

    public void setThge059HCMandoPK(Thge059HCMandoPK thge059HCMandoPK) {
        this.thge059HCMandoPK = thge059HCMandoPK;
    }

    public double getHmMil() {
        return hmMil;
    }

    public void setHmMil(double hmMil) {
        this.hmMil = hmMil;
    }

    public float getToPuntAct() {
        return toPuntAct;
    }

    public void setToPuntAct(float toPuntAct) {
        this.toPuntAct = toPuntAct;
    }

    public Float getToPuntMetrica() {
        return toPuntMetrica;
    }

    public void setToPuntMetrica(Float toPuntMetrica) {
        this.toPuntMetrica = toPuntMetrica;
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

    public Thge061Metrica getCdMetrica() {
        return cdMetrica;
    }

    public void setCdMetrica(Thge061Metrica cdMetrica) {
        this.cdMetrica = cdMetrica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (thge059HCMandoPK != null ? thge059HCMandoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge059HCMando)) {
            return false;
        }
        Thge059HCMando other = (Thge059HCMando) object;
        if ((this.thge059HCMandoPK == null && other.thge059HCMandoPK != null) || (this.thge059HCMandoPK != null && !this.thge059HCMandoPK.equals(other.thge059HCMandoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge059HCMando[ thge059HCMandoPK=" + thge059HCMandoPK + " ]";
    }
    
}
