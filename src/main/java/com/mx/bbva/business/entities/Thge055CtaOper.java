/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author manug
 */
@Entity
@Table(name = "thge055_cta_oper", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge055CtaOper.findAll", query = "SELECT t FROM Thge055CtaOper t")})
public class Thge055CtaOper implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_CTA_OPER")
    private Integer cdCtaOper;
    @Basic(optional = false)
    @Column(name = "NU_CTA_OPERATIVA")
    private String nuCtaOperativa;

    public Thge055CtaOper() {
    }

    public Thge055CtaOper(Integer cdCtaOper) {
        this.cdCtaOper = cdCtaOper;
    }

    public Thge055CtaOper(Integer cdCtaOper, String nuCtaOperativa) {
        this.cdCtaOper = cdCtaOper;
        this.nuCtaOperativa = nuCtaOperativa;
    }

    public Integer getCdCtaOper() {
        return cdCtaOper;
    }

    public void setCdCtaOper(Integer cdCtaOper) {
        this.cdCtaOper = cdCtaOper;
    }

    public String getNuCtaOperativa() {
        return nuCtaOperativa;
    }

    public void setNuCtaOperativa(String nuCtaOperativa) {
        this.nuCtaOperativa = nuCtaOperativa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdCtaOper != null ? cdCtaOper.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge055CtaOper)) {
            return false;
        }
        Thge055CtaOper other = (Thge055CtaOper) object;
        if ((this.cdCtaOper == null && other.cdCtaOper != null) || (this.cdCtaOper != null && !this.cdCtaOper.equals(other.cdCtaOper))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge055CtaOper[ cdCtaOper=" + cdCtaOper + " ]";
    }
    
}
