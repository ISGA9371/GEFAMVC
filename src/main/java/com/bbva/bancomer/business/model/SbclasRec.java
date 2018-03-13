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
@Table(name = "thge021_sbclas_rec", catalog = "gestion_factoria", schema = "")
@NamedQueries({
        @NamedQuery(name = "SbclasRec.findAll", query = "SELECT t FROM SbclasRec t")})
public class SbclasRec implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_SBCLAS_REC", nullable = false)
    private Integer cdSbclasRec;
    @Basic(optional = false)
    @Column(name = "NB_SBCLAS_REC", nullable = false, length = 45)
    private String nbSbclasRec;
    @JoinColumn(name = "CD_CLASIF_REC", referencedColumnName = "CD_CLASIF_REC", nullable = false)
    @ManyToOne(optional = false)
    private ClasifRec cdClasifRec;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdSbclasRec")
    private List<CtrlExt> ctrlExtList;

    public SbclasRec() {
    }

    public SbclasRec(Integer cdSbclasRec) {
        this.cdSbclasRec = cdSbclasRec;
    }

    public SbclasRec(Integer cdSbclasRec, String nbSbclasRec) {
        this.cdSbclasRec = cdSbclasRec;
        this.nbSbclasRec = nbSbclasRec;
    }

    public Integer getCdSbclasRec() {
        return cdSbclasRec;
    }

    public void setCdSbclasRec(Integer cdSbclasRec) {
        this.cdSbclasRec = cdSbclasRec;
    }

    public String getNbSbclasRec() {
        return nbSbclasRec;
    }

    public void setNbSbclasRec(String nbSbclasRec) {
        this.nbSbclasRec = nbSbclasRec;
    }

    public ClasifRec getCdClasifRec() {
        return cdClasifRec;
    }

    public void setCdClasifRec(ClasifRec cdClasifRec) {
        this.cdClasifRec = cdClasifRec;
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
        hash += (cdSbclasRec != null ? cdSbclasRec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SbclasRec)) {
            return false;
        }
        SbclasRec other = (SbclasRec) object;
        if ((this.cdSbclasRec == null && other.cdSbclasRec != null) || (this.cdSbclasRec != null && !this.cdSbclasRec.equals(other.cdSbclasRec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.SbclasRec[ cdSbclasRec=" + cdSbclasRec + " ]";
    }

}
