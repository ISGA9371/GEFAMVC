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
@Table(name = "thge055_cta_oper", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NU_CTA_OPERATIVA"})
        , @UniqueConstraint(columnNames = {"CD_CTA_OPER"})})
@NamedQueries({
        @NamedQuery(name = "CtaOper.findAll", query = "SELECT t FROM CtaOper t")})
public class CtaOper implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_CONS_CTA_OPER", nullable = false)
    private Integer cdConsCtaOper;
    @Basic(optional = false)
    @Column(name = "CD_CTA_OPER", nullable = false)
    private int cdCtaOper;
    @Basic(optional = false)
    @Column(name = "NU_CTA_OPERATIVA", nullable = false, length = 8)
    private String nuCtaOperativa;
    @OneToMany(mappedBy = "cdCtaOper")
    private List<Factura> facturaList;

    public CtaOper() {
    }

    public CtaOper(Integer cdConsCtaOper) {
        this.cdConsCtaOper = cdConsCtaOper;
    }

    public CtaOper(Integer cdConsCtaOper, int cdCtaOper, String nuCtaOperativa) {
        this.cdConsCtaOper = cdConsCtaOper;
        this.cdCtaOper = cdCtaOper;
        this.nuCtaOperativa = nuCtaOperativa;
    }

    public Integer getCdConsCtaOper() {
        return cdConsCtaOper;
    }

    public void setCdConsCtaOper(Integer cdConsCtaOper) {
        this.cdConsCtaOper = cdConsCtaOper;
    }

    public int getCdCtaOper() {
        return cdCtaOper;
    }

    public void setCdCtaOper(int cdCtaOper) {
        this.cdCtaOper = cdCtaOper;
    }

    public String getNuCtaOperativa() {
        return nuCtaOperativa;
    }

    public void setNuCtaOperativa(String nuCtaOperativa) {
        this.nuCtaOperativa = nuCtaOperativa;
    }

    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdConsCtaOper != null ? cdConsCtaOper.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CtaOper)) {
            return false;
        }
        CtaOper other = (CtaOper) object;
        if ((this.cdConsCtaOper == null && other.cdConsCtaOper != null) || (this.cdConsCtaOper != null && !this.cdConsCtaOper.equals(other.cdConsCtaOper))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.CtaOper[ cdConsCtaOper=" + cdConsCtaOper + " ]";
    }

}
