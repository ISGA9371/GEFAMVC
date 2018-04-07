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
@Table(name = "thge070_tp_fh", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge070TpFh.findAll", query = "SELECT t FROM Thge070TpFh t")})
public class Thge070TpFh implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_TP_FH")
    private Integer cdTpFh;
    @Basic(optional = false)
    @Column(name = "TP_FH")
    private String tpFh;
    @OneToMany(mappedBy = "cdTpFh")
    private List<Thge068LogFhCom> thge068LogFhComList;

    public Thge070TpFh() {
    }

    public Thge070TpFh(Integer cdTpFh) {
        this.cdTpFh = cdTpFh;
    }

    public Thge070TpFh(Integer cdTpFh, String tpFh) {
        this.cdTpFh = cdTpFh;
        this.tpFh = tpFh;
    }

    public Integer getCdTpFh() {
        return cdTpFh;
    }

    public void setCdTpFh(Integer cdTpFh) {
        this.cdTpFh = cdTpFh;
    }

    public String getTpFh() {
        return tpFh;
    }

    public void setTpFh(String tpFh) {
        this.tpFh = tpFh;
    }

    public List<Thge068LogFhCom> getThge068LogFhComList() {
        return thge068LogFhComList;
    }

    public void setThge068LogFhComList(List<Thge068LogFhCom> thge068LogFhComList) {
        this.thge068LogFhComList = thge068LogFhComList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdTpFh != null ? cdTpFh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge070TpFh)) {
            return false;
        }
        Thge070TpFh other = (Thge070TpFh) object;
        if ((this.cdTpFh == null && other.cdTpFh != null) || (this.cdTpFh != null && !this.cdTpFh.equals(other.cdTpFh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge070TpFh[ cdTpFh=" + cdTpFh + " ]";
    }
    
}
