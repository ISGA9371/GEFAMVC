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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author manug
 */
@Entity
@Table(name = "thge020_clasif_rec", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge020ClasifRec.findAll", query = "SELECT t FROM Thge020ClasifRec t")})
public class Thge020ClasifRec implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_CLASIF_REC")
    private Integer cdClasifRec;
    @Basic(optional = false)
    @Column(name = "NB_CLASIF_REC")
    private String nbClasifRec;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdClasifRec")
    private List<Thge021SbclasRec> thge021SbclasRecList;

    public Thge020ClasifRec() {
    }

    public Thge020ClasifRec(Integer cdClasifRec) {
        this.cdClasifRec = cdClasifRec;
    }

    public Thge020ClasifRec(Integer cdClasifRec, String nbClasifRec) {
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

    public List<Thge021SbclasRec> getThge021SbclasRecList() {
        return thge021SbclasRecList;
    }

    public void setThge021SbclasRecList(List<Thge021SbclasRec> thge021SbclasRecList) {
        this.thge021SbclasRecList = thge021SbclasRecList;
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
        if (!(object instanceof Thge020ClasifRec)) {
            return false;
        }
        Thge020ClasifRec other = (Thge020ClasifRec) object;
        if ((this.cdClasifRec == null && other.cdClasifRec != null) || (this.cdClasifRec != null && !this.cdClasifRec.equals(other.cdClasifRec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge020ClasifRec[ cdClasifRec=" + cdClasifRec + " ]";
    }
    
}
