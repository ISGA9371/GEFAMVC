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
@Table(name = "thge051_ac_res_cor", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CD_ACEPTA_RES_COR"})
        , @UniqueConstraint(columnNames = {"NB_ACEPTA_RES_COR"})})
@NamedQueries({
        @NamedQuery(name = "ResponsibleArea.findAll", query = "SELECT t FROM ResponsibleArea t")})
public class ResponsibleArea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_CONS_ACEPTA", nullable = false)
    private Integer cdConsAcepta;
    @Basic(optional = false)
    @Column(name = "CD_ACEPTA_RES_COR", nullable = false)
    private int cdAceptaResCor;
    @Basic(optional = false)
    @Column(name = "NB_ACEPTA_RES_COR", nullable = false, length = 25)
    private String nbAceptaResCor;
    @OneToMany(mappedBy = "cdAceptaResCor")
    private List<T955> t955List;

    public ResponsibleArea() {
    }

    public ResponsibleArea(Integer cdConsAcepta) {
        this.cdConsAcepta = cdConsAcepta;
    }

    public ResponsibleArea(Integer cdConsAcepta, int cdAceptaResCor, String nbAceptaResCor) {
        this.cdConsAcepta = cdConsAcepta;
        this.cdAceptaResCor = cdAceptaResCor;
        this.nbAceptaResCor = nbAceptaResCor;
    }

    public Integer getCdConsAcepta() {
        return cdConsAcepta;
    }

    public void setCdConsAcepta(Integer cdConsAcepta) {
        this.cdConsAcepta = cdConsAcepta;
    }

    public int getCdAceptaResCor() {
        return cdAceptaResCor;
    }

    public void setCdAceptaResCor(int cdAceptaResCor) {
        this.cdAceptaResCor = cdAceptaResCor;
    }

    public String getNbAceptaResCor() {
        return nbAceptaResCor;
    }

    public void setNbAceptaResCor(String nbAceptaResCor) {
        this.nbAceptaResCor = nbAceptaResCor;
    }

    public List<T955> getT955List() {
        return t955List;
    }

    public void setT955List(List<T955> t955List) {
        this.t955List = t955List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdConsAcepta != null ? cdConsAcepta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResponsibleArea)) {
            return false;
        }
        ResponsibleArea other = (ResponsibleArea) object;
        if ((this.cdConsAcepta == null && other.cdConsAcepta != null) || (this.cdConsAcepta != null && !this.cdConsAcepta.equals(other.cdConsAcepta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.ResponsibleArea[ cdConsAcepta=" + cdConsAcepta + " ]";
    }

}
