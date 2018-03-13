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
@Table(name = "thge020_clasif_rec", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_CLASIF_REC"})})
@NamedQueries({
        @NamedQuery(name = "ClasifRec.findAll", query = "SELECT t FROM ClasifRec t")})
public class ClasifRec implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_CLASIF_REC", nullable = false)
    private Integer cdClasifRec;
    @Basic(optional = false)
    @Column(name = "NB_CLASIF_REC", nullable = false, length = 50)
    private String nbClasifRec;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdClasifRec")
    private List<SbclasRec> sbclasRecList;

    public ClasifRec() {
    }

    public ClasifRec(Integer cdClasifRec) {
        this.cdClasifRec = cdClasifRec;
    }

    public ClasifRec(Integer cdClasifRec, String nbClasifRec) {
        this.cdClasifRec = cdClasifRec;
        this.nbClasifRec = nbClasifRec;
    }

    public Integer getCdClasifRec() {
        return cdClasifRec;
    }

    public void setCdClasifRec(Integer cdClasifRec) {
        this.cdClasifRec = cdClasifRec;
    }

    public String getNbClasifRec() {
        return nbClasifRec;
    }

    public void setNbClasifRec(String nbClasifRec) {
        this.nbClasifRec = nbClasifRec;
    }

    public List<SbclasRec> getSbclasRecList() {
        return sbclasRecList;
    }

    public void setSbclasRecList(List<SbclasRec> sbclasRecList) {
        this.sbclasRecList = sbclasRecList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdClasifRec != null ? cdClasifRec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClasifRec)) {
            return false;
        }
        ClasifRec other = (ClasifRec) object;
        if ((this.cdClasifRec == null && other.cdClasifRec != null) || (this.cdClasifRec != null && !this.cdClasifRec.equals(other.cdClasifRec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.ClasifRec[ cdClasifRec=" + cdClasifRec + " ]";
    }

}
