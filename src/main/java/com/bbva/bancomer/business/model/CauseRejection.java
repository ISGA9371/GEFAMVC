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
@Table(name = "thge052_causa_rech", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CD_CAUSA_RECHAZO"})
        , @UniqueConstraint(columnNames = {"NB_CAUSA_RECHAZO"})})
@NamedQueries({
        @NamedQuery(name = "CauseRejection.findAll", query = "SELECT t FROM CauseRejection t")})
public class CauseRejection implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_CONS_CAUSA_R", nullable = false)
    private Integer cdConsCausaR;
    @Basic(optional = false)
    @Column(name = "CD_CAUSA_RECHAZO", nullable = false)
    private int cdCausaRechazo;
    @Basic(optional = false)
    @Column(name = "NB_CAUSA_RECHAZO", nullable = false, length = 50)
    private String nbCausaRechazo;
    @OneToMany(mappedBy = "cdCausaRechazo")
    private List<T955> t955List;

    public CauseRejection() {
    }

    public CauseRejection(Integer cdConsCausaR) {
        this.cdConsCausaR = cdConsCausaR;
    }

    public CauseRejection(Integer cdConsCausaR, int cdCausaRechazo, String nbCausaRechazo) {
        this.cdConsCausaR = cdConsCausaR;
        this.cdCausaRechazo = cdCausaRechazo;
        this.nbCausaRechazo = nbCausaRechazo;
    }

    public Integer getCdConsCausaR() {
        return cdConsCausaR;
    }

    public void setCdConsCausaR(Integer cdConsCausaR) {
        this.cdConsCausaR = cdConsCausaR;
    }

    public int getCdCausaRechazo() {
        return cdCausaRechazo;
    }

    public void setCdCausaRechazo(int cdCausaRechazo) {
        this.cdCausaRechazo = cdCausaRechazo;
    }

    public String getNbCausaRechazo() {
        return nbCausaRechazo;
    }

    public void setNbCausaRechazo(String nbCausaRechazo) {
        this.nbCausaRechazo = nbCausaRechazo;
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
        hash += (cdConsCausaR != null ? cdConsCausaR.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CauseRejection)) {
            return false;
        }
        CauseRejection other = (CauseRejection) object;
        if ((this.cdConsCausaR == null && other.cdConsCausaR != null) || (this.cdConsCausaR != null && !this.cdConsCausaR.equals(other.cdConsCausaR))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.CauseRejection[ cdConsCausaR=" + cdConsCausaR + " ]";
    }

}
