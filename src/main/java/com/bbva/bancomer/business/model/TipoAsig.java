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
@Table(name = "thge033_tipo_asig", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_TIPO_ASIG"})})
@NamedQueries({
        @NamedQuery(name = "TipoAsig.findAll", query = "SELECT t FROM TipoAsig t")})
public class TipoAsig implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_TIPO_ASIG", nullable = false)
    private Integer cdTipoAsig;
    @Basic(optional = false)
    @Column(name = "NB_TIPO_ASIG", nullable = false, length = 25)
    private String nbTipoAsig;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTipoAsig")
    private List<CtrlExt> ctrlExtList;

    public TipoAsig() {
    }

    public TipoAsig(Integer cdTipoAsig) {
        this.cdTipoAsig = cdTipoAsig;
    }

    public TipoAsig(Integer cdTipoAsig, String nbTipoAsig) {
        this.cdTipoAsig = cdTipoAsig;
        this.nbTipoAsig = nbTipoAsig;
    }

    public Integer getCdTipoAsig() {
        return cdTipoAsig;
    }

    public void setCdTipoAsig(Integer cdTipoAsig) {
        this.cdTipoAsig = cdTipoAsig;
    }

    public String getNbTipoAsig() {
        return nbTipoAsig;
    }

    public void setNbTipoAsig(String nbTipoAsig) {
        this.nbTipoAsig = nbTipoAsig;
    }

    public List<CtrlExt> getCtrlExtList() {
        return ctrlExtList;
    }

    public void setCtrlExtList(List<CtrlExt> ctrlExtList) {
        this.ctrlExtList = ctrlExtList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdTipoAsig != null ? cdTipoAsig.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAsig)) {
            return false;
        }
        TipoAsig other = (TipoAsig) object;
        if ((this.cdTipoAsig == null && other.cdTipoAsig != null) || (this.cdTipoAsig != null && !this.cdTipoAsig.equals(other.cdTipoAsig))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.TipoAsig[ cdTipoAsig=" + cdTipoAsig + " ]";
    }

}
