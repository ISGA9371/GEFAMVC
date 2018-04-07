/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author manug
 */
@Entity
@Table(name = "thge054_res_verif", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge054ResVerif.findAll", query = "SELECT t FROM Thge054ResVerif t")})
public class Thge054ResVerif implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_RESULT_VERIF")
    private Integer cdResultVerif;
    @Basic(optional = false)
    @Column(name = "NB_RESULT_VERIF")
    private String nbResultVerif;

    public Thge054ResVerif() {
    }

    public Thge054ResVerif(Integer cdResultVerif) {
        this.cdResultVerif = cdResultVerif;
    }

    public Thge054ResVerif(Integer cdResultVerif, String nbResultVerif) {
        this.cdResultVerif = cdResultVerif;
        this.nbResultVerif = nbResultVerif;
    }

    public Integer getCdResultVerif() {
        return cdResultVerif;
    }

    public void setCdResultVerif(Integer cdResultVerif) {
        this.cdResultVerif = cdResultVerif;
    }

    public String getNbResultVerif() {
        return nbResultVerif;
    }

    public void setNbResultVerif(String nbResultVerif) {
        this.nbResultVerif = nbResultVerif;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdResultVerif != null ? cdResultVerif.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge054ResVerif)) {
            return false;
        }
        Thge054ResVerif other = (Thge054ResVerif) object;
        if ((this.cdResultVerif == null && other.cdResultVerif != null) || (this.cdResultVerif != null && !this.cdResultVerif.equals(other.cdResultVerif))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge054ResVerif[ cdResultVerif=" + cdResultVerif + " ]";
    }
    
}
