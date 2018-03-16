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
@Table(name = "thge054_res_verif", catalog = "gestion_factoria",  uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_RESULT_VERIF"})
        , @UniqueConstraint(columnNames = {"CD_RESULT_VERIF"})})
@NamedQueries({
        @NamedQuery(name = "VerificationResult.findAll", query = "SELECT t FROM VerificationResult t")})
public class VerificationResult implements Serializable {

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

    public VerificationResult() {
    }

    public VerificationResult(Integer cdConsResulVer) {
        this.cdConsResulVer = cdConsResulVer;
    }

    public VerificationResult(Integer cdConsResulVer, int cdResultVerif, String nbResultVerif) {
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
        if (!(object instanceof VerificationResult)) {
            return false;
        }
        VerificationResult other = (VerificationResult) object;
        if ((this.cdConsResulVer == null && other.cdConsResulVer != null) || (this.cdConsResulVer != null && !this.cdConsResulVer.equals(other.cdConsResulVer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.VerificationResult[ cdConsResulVer=" + cdConsResulVer + " ]";
    }

}
