/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "thge052_causa_rech", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge052CausaRech.findAll", query = "SELECT t FROM Thge052CausaRech t")})
public class Thge052CausaRech implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_CAUSA_RECHAZO")
    private Integer cdCausaRechazo;
    @Basic(optional = false)
    @Column(name = "NB_CAUSA_RECHAZO")
    private String nbCausaRechazo;
    @OneToMany(mappedBy = "cdCausaRechazo")
    private List<Thge048T955> thge048T955List;

    public Thge052CausaRech() {
    }

    public Thge052CausaRech(Integer cdCausaRechazo) {
        this.cdCausaRechazo = cdCausaRechazo;
    }

    public Thge052CausaRech(Integer cdCausaRechazo, String nbCausaRechazo) {
        this.cdCausaRechazo = cdCausaRechazo;
        this.nbCausaRechazo = nbCausaRechazo;
    }

    public Integer getCdCausaRechazo() {
        return cdCausaRechazo;
    }

    public void setCdCausaRechazo(Integer cdCausaRechazo) {
        this.cdCausaRechazo = cdCausaRechazo;
    }

    public String getNbCausaRechazo() {
        return nbCausaRechazo;
    }

    public void setNbCausaRechazo(String nbCausaRechazo) {
        this.nbCausaRechazo = nbCausaRechazo;
    }

    public List<Thge048T955> getThge048T955List() {
        return thge048T955List;
    }

    public void setThge048T955List(List<Thge048T955> thge048T955List) {
        this.thge048T955List = thge048T955List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdCausaRechazo != null ? cdCausaRechazo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge052CausaRech)) {
            return false;
        }
        Thge052CausaRech other = (Thge052CausaRech) object;
        if ((this.cdCausaRechazo == null && other.cdCausaRechazo != null) || (this.cdCausaRechazo != null && !this.cdCausaRechazo.equals(other.cdCausaRechazo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge052CausaRech[ cdCausaRechazo=" + cdCausaRechazo + " ]";
    }
    
}
