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
@Table(name = "thge054_res_verif", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_RESULT_VERIF"})
        , @UniqueConstraint(columnNames = {"CD_RESULT_VERIF"})})
@NamedQueries({
        @NamedQuery(name = "ResVerif.findAll", query = "SELECT t FROM ResVerif t")})
public class ResVerif implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_CONS_RESUL_VER", nullable = false)
    private Integer cdConsResulVer;
    @Basic(optional = false)
    @Column(name = "CD_RESULT_VERIF", nullable = false)
    private int cdResultVerif;
    @Basic(optional = false)
    @Column(name = "NB_RESULT_VERIF", nullable = false, length = 25)
    private String nbResultVerif;
    @OneToMany(mappedBy = "cdResultVerif")
    private List<T955> t955List;

    public ResVerif() {
    }

    public ResVerif(Integer cdConsResulVer) {
        this.cdConsResulVer = cdConsResulVer;
    }

    public ResVerif(Integer cdConsResulVer, int cdResultVerif, String nbResultVerif) {
        this.cdConsResulVer = cdConsResulVer;
        this.cdResultVerif = cdResultVerif;
        this.nbResultVerif = nbResultVerif;
    }

    public Integer getCdConsResulVer() {
        return cdConsResulVer;
    }

    public void setCdConsResulVer(Integer cdConsResulVer) {
        this.cdConsResulVer = cdConsResulVer;
    }

    public int getCdResultVerif() {
        return cdResultVerif;
    }

    public void setCdResultVerif(int cdResultVerif) {
        this.cdResultVerif = cdResultVerif;
    }

    public String getNbResultVerif() {
        return nbResultVerif;
    }

    public void setNbResultVerif(String nbResultVerif) {
        this.nbResultVerif = nbResultVerif;
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
        hash += (cdConsResulVer != null ? cdConsResulVer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResVerif)) {
            return false;
        }
        ResVerif other = (ResVerif) object;
        if ((this.cdConsResulVer == null && other.cdConsResulVer != null) || (this.cdConsResulVer != null && !this.cdConsResulVer.equals(other.cdConsResulVer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.ResVerif[ cdConsResulVer=" + cdConsResulVer + " ]";
    }

}
