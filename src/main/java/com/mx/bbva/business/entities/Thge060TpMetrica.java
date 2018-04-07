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
@Table(name = "thge060_tp_metrica", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge060TpMetrica.findAll", query = "SELECT t FROM Thge060TpMetrica t")})
public class Thge060TpMetrica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_TP_METRICA")
    private Integer cdTpMetrica;
    @Basic(optional = false)
    @Column(name = "NB_TP_METRICA")
    private String nbTpMetrica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTpMetrica")
    private List<Thge061Metrica> thge061MetricaList;

    public Thge060TpMetrica() {
    }

    public Thge060TpMetrica(Integer cdTpMetrica) {
        this.cdTpMetrica = cdTpMetrica;
    }

    public Thge060TpMetrica(Integer cdTpMetrica, String nbTpMetrica) {
        this.cdTpMetrica = cdTpMetrica;
        this.nbTpMetrica = nbTpMetrica;
    }

    public Integer getCdTpMetrica() {
        return cdTpMetrica;
    }

    public void setCdTpMetrica(Integer cdTpMetrica) {
        this.cdTpMetrica = cdTpMetrica;
    }

    public String getNbTpMetrica() {
        return nbTpMetrica;
    }

    public void setNbTpMetrica(String nbTpMetrica) {
        this.nbTpMetrica = nbTpMetrica;
    }

    public List<Thge061Metrica> getThge061MetricaList() {
        return thge061MetricaList;
    }

    public void setThge061MetricaList(List<Thge061Metrica> thge061MetricaList) {
        this.thge061MetricaList = thge061MetricaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdTpMetrica != null ? cdTpMetrica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge060TpMetrica)) {
            return false;
        }
        Thge060TpMetrica other = (Thge060TpMetrica) object;
        if ((this.cdTpMetrica == null && other.cdTpMetrica != null) || (this.cdTpMetrica != null && !this.cdTpMetrica.equals(other.cdTpMetrica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge060TpMetrica[ cdTpMetrica=" + cdTpMetrica + " ]";
    }
    
}
