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
@Table(name = "thge013_tipo_pi", catalog = "gestion_factoria", schema = "")
@NamedQueries({
        @NamedQuery(name = "TipoPi.findAll", query = "SELECT t FROM TipoPi t")})
public class TipoPi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_TIPO_PI", nullable = false)
    private Integer cdTipoPi;
    @Basic(optional = false)
    @Column(name = "NB_PI", nullable = false, length = 25)
    private String nbPi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTipoPi")
    private List<Pi> piList;

    public TipoPi() {
    }

    public TipoPi(Integer cdTipoPi) {
        this.cdTipoPi = cdTipoPi;
    }

    public TipoPi(Integer cdTipoPi, String nbPi) {
        this.cdTipoPi = cdTipoPi;
        this.nbPi = nbPi;
    }

    public Integer getCdTipoPi() {
        return cdTipoPi;
    }

    public void setCdTipoPi(Integer cdTipoPi) {
        this.cdTipoPi = cdTipoPi;
    }

    public String getNbPi() {
        return nbPi;
    }

    public void setNbPi(String nbPi) {
        this.nbPi = nbPi;
    }

    public List<Pi> getPiList() {
        return piList;
    }

    public void setPiList(List<Pi> piList) {
        this.piList = piList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdTipoPi != null ? cdTipoPi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPi)) {
            return false;
        }
        TipoPi other = (TipoPi) object;
        if ((this.cdTipoPi == null && other.cdTipoPi != null) || (this.cdTipoPi != null && !this.cdTipoPi.equals(other.cdTipoPi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.TipoPi[ cdTipoPi=" + cdTipoPi + " ]";
    }

}
