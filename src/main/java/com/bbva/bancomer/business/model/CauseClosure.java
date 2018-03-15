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
@Table(name = "thge053_causa_cier", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CD_CAUSA_CIERRE"})
        , @UniqueConstraint(columnNames = {"NB_CAUSA_CIERRE"})})
@NamedQueries({
        @NamedQuery(name = "CauseClosure.findAll", query = "SELECT t FROM CauseClosure t")})
public class CauseClosure implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_CONS_CAUSA_C", nullable = false)
    private Integer cdConsCausaC;
    @Basic(optional = false)
    @Column(name = "CD_CAUSA_CIERRE", nullable = false)
    private int cdCausaCierre;
    @Basic(optional = false)
    @Column(name = "NB_CAUSA_CIERRE", nullable = false, length = 25)
    private String nbCausaCierre;
    @OneToMany(mappedBy = "cdCausaCierre")
    private List<T955> t955List;

    public CauseClosure() {
    }

    public CauseClosure(Integer cdConsCausaC) {
        this.cdConsCausaC = cdConsCausaC;
    }

    public CauseClosure(Integer cdConsCausaC, int cdCausaCierre, String nbCausaCierre) {
        this.cdConsCausaC = cdConsCausaC;
        this.cdCausaCierre = cdCausaCierre;
        this.nbCausaCierre = nbCausaCierre;
    }

    public Integer getCdConsCausaC() {
        return cdConsCausaC;
    }

    public void setCdConsCausaC(Integer cdConsCausaC) {
        this.cdConsCausaC = cdConsCausaC;
    }

    public int getCdCausaCierre() {
        return cdCausaCierre;
    }

    public void setCdCausaCierre(int cdCausaCierre) {
        this.cdCausaCierre = cdCausaCierre;
    }

    public String getNbCausaCierre() {
        return nbCausaCierre;
    }

    public void setNbCausaCierre(String nbCausaCierre) {
        this.nbCausaCierre = nbCausaCierre;
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
        hash += (cdConsCausaC != null ? cdConsCausaC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CauseClosure)) {
            return false;
        }
        CauseClosure other = (CauseClosure) object;
        if ((this.cdConsCausaC == null && other.cdConsCausaC != null) || (this.cdConsCausaC != null && !this.cdConsCausaC.equals(other.cdConsCausaC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.CauseClosure[ cdConsCausaC=" + cdConsCausaC + " ]";
    }

}
