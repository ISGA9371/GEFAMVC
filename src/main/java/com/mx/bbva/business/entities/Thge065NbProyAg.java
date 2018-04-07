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
@Table(name = "thge065_nb_proy_ag", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge065NbProyAg.findAll", query = "SELECT t FROM Thge065NbProyAg t")})
public class Thge065NbProyAg implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_PROY_AGRUP")
    private Integer cdProyAgrup;
    @Basic(optional = false)
    @Column(name = "NB_PROY_AGRUP")
    private String nbProyAgrup;

    public Thge065NbProyAg() {
    }

    public Thge065NbProyAg(Integer cdProyAgrup) {
        this.cdProyAgrup = cdProyAgrup;
    }

    public Thge065NbProyAg(Integer cdProyAgrup, String nbProyAgrup) {
        this.cdProyAgrup = cdProyAgrup;
        this.nbProyAgrup = nbProyAgrup;
    }

    public Integer getCdProyAgrup() {
        return cdProyAgrup;
    }

    public void setCdProyAgrup(Integer cdProyAgrup) {
        this.cdProyAgrup = cdProyAgrup;
    }

    public String getNbProyAgrup() {
        return nbProyAgrup;
    }

    public void setNbProyAgrup(String nbProyAgrup) {
        this.nbProyAgrup = nbProyAgrup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdProyAgrup != null ? cdProyAgrup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge065NbProyAg)) {
            return false;
        }
        Thge065NbProyAg other = (Thge065NbProyAg) object;
        if ((this.cdProyAgrup == null && other.cdProyAgrup != null) || (this.cdProyAgrup != null && !this.cdProyAgrup.equals(other.cdProyAgrup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge065NbProyAg[ cdProyAgrup=" + cdProyAgrup + " ]";
    }
    
}
