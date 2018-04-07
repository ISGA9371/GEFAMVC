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
@Table(name = "thge045_prioridad_cp", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge045PrioridadCp.findAll", query = "SELECT t FROM Thge045PrioridadCp t")})
public class Thge045PrioridadCp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_PRIORIDAD_CP")
    private Integer cdPrioridadCp;
    @Basic(optional = false)
    @Column(name = "NB_PRIORIDAD_CP")
    private String nbPrioridadCp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdPrioridadCp")
    private List<Thge044C204> thge044C204List;

    public Thge045PrioridadCp() {
    }

    public Thge045PrioridadCp(Integer cdPrioridadCp) {
        this.cdPrioridadCp = cdPrioridadCp;
    }

    public Thge045PrioridadCp(Integer cdPrioridadCp, String nbPrioridadCp) {
        this.cdPrioridadCp = cdPrioridadCp;
        this.nbPrioridadCp = nbPrioridadCp;
    }

    public Integer getCdPrioridadCp() {
        return cdPrioridadCp;
    }

    public void setCdPrioridadCp(Integer cdPrioridadCp) {
        this.cdPrioridadCp = cdPrioridadCp;
    }

    public String getNbPrioridadCp() {
        return nbPrioridadCp;
    }

    public void setNbPrioridadCp(String nbPrioridadCp) {
        this.nbPrioridadCp = nbPrioridadCp;
    }

    public List<Thge044C204> getThge044C204List() {
        return thge044C204List;
    }

    public void setThge044C204List(List<Thge044C204> thge044C204List) {
        this.thge044C204List = thge044C204List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdPrioridadCp != null ? cdPrioridadCp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge045PrioridadCp)) {
            return false;
        }
        Thge045PrioridadCp other = (Thge045PrioridadCp) object;
        if ((this.cdPrioridadCp == null && other.cdPrioridadCp != null) || (this.cdPrioridadCp != null && !this.cdPrioridadCp.equals(other.cdPrioridadCp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge045PrioridadCp[ cdPrioridadCp=" + cdPrioridadCp + " ]";
    }
    
}
