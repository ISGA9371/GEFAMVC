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
@Table(name = "thge067_esq_pago", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge067EsqPago.findAll", query = "SELECT t FROM Thge067EsqPago t")})
public class Thge067EsqPago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_ESQUEMA_PAGO")
    private Integer cdEsquemaPago;
    @Basic(optional = false)
    @Column(name = "NB_ESQ_PAGO")
    private String nbEsqPago;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdEsquemaPago")
    private List<Thge024CtrlExt> thge024CtrlExtList;

    public Thge067EsqPago() {
    }

    public Thge067EsqPago(Integer cdEsquemaPago) {
        this.cdEsquemaPago = cdEsquemaPago;
    }

    public Thge067EsqPago(Integer cdEsquemaPago, String nbEsqPago) {
        this.cdEsquemaPago = cdEsquemaPago;
        this.nbEsqPago = nbEsqPago;
    }

    public Integer getCdEsquemaPago() {
        return cdEsquemaPago;
    }

    public void setCdEsquemaPago(Integer cdEsquemaPago) {
        this.cdEsquemaPago = cdEsquemaPago;
    }

    public String getNbEsqPago() {
        return nbEsqPago;
    }

    public void setNbEsqPago(String nbEsqPago) {
        this.nbEsqPago = nbEsqPago;
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
        hash += (cdEsquemaPago != null ? cdEsquemaPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge067EsqPago)) {
            return false;
        }
        Thge067EsqPago other = (Thge067EsqPago) object;
        if ((this.cdEsquemaPago == null && other.cdEsquemaPago != null) || (this.cdEsquemaPago != null && !this.cdEsquemaPago.equals(other.cdEsquemaPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge067EsqPago[ cdEsquemaPago=" + cdEsquemaPago + " ]";
    }
    
}
