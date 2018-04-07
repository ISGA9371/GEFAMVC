/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author manug
 */
@Entity
@Table(name = "thge021_sbclas_rec", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge021SbclasRec.findAll", query = "SELECT t FROM Thge021SbclasRec t")})
public class Thge021SbclasRec implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_SBCLAS_REC")
    private Integer cdSbclasRec;
    @Basic(optional = false)
    @Column(name = "NB_SBCLAS_REC")
    private String nbSbclasRec;
    @JoinColumn(name = "CD_CLASIF_REC", referencedColumnName = "CD_CLASIF_REC")
    @ManyToOne(optional = false)
    private Thge020ClasifRec cdClasifRec;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdSbclasRec")
    private List<Thge024CtrlExt> thge024CtrlExtList;

    public Thge021SbclasRec() {
    }

    public Thge021SbclasRec(Integer cdSbclasRec) {
        this.cdSbclasRec = cdSbclasRec;
    }

    public Thge021SbclasRec(Integer cdSbclasRec, String nbSbclasRec) {
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

    public Thge020ClasifRec getCdClasifRec() {
        return cdClasifRec;
    }

    public void setCdClasifRec(Thge020ClasifRec cdClasifRec) {
        this.cdClasifRec = cdClasifRec;
    }

    public List<Thge024CtrlExt> getThge024CtrlExtList() {
        return thge024CtrlExtList;
    }

    public void setThge024CtrlExtList(List<Thge024CtrlExt> thge024CtrlExtList) {
        this.thge024CtrlExtList = thge024CtrlExtList;
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
        if (!(object instanceof Thge021SbclasRec)) {
            return false;
        }
        Thge021SbclasRec other = (Thge021SbclasRec) object;
        if ((this.cdSbclasRec == null && other.cdSbclasRec != null) || (this.cdSbclasRec != null && !this.cdSbclasRec.equals(other.cdSbclasRec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge021SbclasRec[ cdSbclasRec=" + cdSbclasRec + " ]";
    }
    
}
