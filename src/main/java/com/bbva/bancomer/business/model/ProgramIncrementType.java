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
        @NamedQuery(name = "ProgramIncrementType.findAll", query = "SELECT t FROM ProgramIncrementType t")})
public class ProgramIncrementType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_TIPO_PI", nullable = false)
    private Integer cdTipoPi;
    @Basic(optional = false)
    @Column(name = "NB_PI", nullable = false, length = 25)
    private String nbPi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTipoPi")
    private List<ProgramIncrement> programIncrementList;

    public ProgramIncrementType() {
    }

    public ProgramIncrementType(Integer cdTipoPi) {
        this.cdTipoPi = cdTipoPi;
    }

    public ProgramIncrementType(Integer cdTipoPi, String nbPi) {
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

    public List<ProgramIncrement> getProgramIncrementList() {
        return programIncrementList;
    }

    public void setProgramIncrementList(List<ProgramIncrement> programIncrementList) {
        this.programIncrementList = programIncrementList;
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
        if (!(object instanceof ProgramIncrementType)) {
            return false;
        }
        ProgramIncrementType other = (ProgramIncrementType) object;
        if ((this.cdTipoPi == null && other.cdTipoPi != null) || (this.cdTipoPi != null && !this.cdTipoPi.equals(other.cdTipoPi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.ProgramIncrementType[ cdTipoPi=" + cdTipoPi + " ]";
    }

}
