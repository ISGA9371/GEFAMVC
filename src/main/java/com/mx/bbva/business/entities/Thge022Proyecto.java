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
@Table(name = "thge022_proyecto", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge022Proyecto.findAll", query = "SELECT t FROM Thge022Proyecto t")})
public class Thge022Proyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_SDA")
    private String cdSda;
    @Basic(optional = false)
    @Column(name = "NB_PROYECTO")
    private String nbProyecto;
    @OneToMany(mappedBy = "cdSda")
    private List<Thge017Requerim> thge017RequerimList;
    @JoinColumn(name = "CD_PI", referencedColumnName = "CD_PI")
    @ManyToOne
    private Thge013Pi cdPi;
    @JoinColumn(name = "CD_METODOLOGIA", referencedColumnName = "CD_METODOLOGIA")
    @ManyToOne
    private Thge035Metodologia cdMetodologia;

    public Thge022Proyecto() {
    }

    public Thge022Proyecto(String cdSda) {
        this.cdSda = cdSda;
    }

    public Thge022Proyecto(String cdSda, String nbProyecto) {
        this.cdSda = cdSda;
        this.nbProyecto = nbProyecto;
    }

    public String getCdSda() {
        return cdSda;
    }

    public void setCdSda(String cdSda) {
        this.cdSda = cdSda;
    }

    public String getNbProyecto() {
        return nbProyecto;
    }

    public void setNbProyecto(String nbProyecto) {
        this.nbProyecto = nbProyecto;
    }

    public List<Thge017Requerim> getThge017RequerimList() {
        return thge017RequerimList;
    }

    public void setThge017RequerimList(List<Thge017Requerim> thge017RequerimList) {
        this.thge017RequerimList = thge017RequerimList;
    }

    public Thge013Pi getCdPi() {
        return cdPi;
    }

    public void setCdPi(Thge013Pi cdPi) {
        this.cdPi = cdPi;
    }

    public Thge035Metodologia getCdMetodologia() {
        return cdMetodologia;
    }

    public void setCdMetodologia(Thge035Metodologia cdMetodologia) {
        this.cdMetodologia = cdMetodologia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdSda != null ? cdSda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge022Proyecto)) {
            return false;
        }
        Thge022Proyecto other = (Thge022Proyecto) object;
        if ((this.cdSda == null && other.cdSda != null) || (this.cdSda != null && !this.cdSda.equals(other.cdSda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge022Proyecto[ cdSda=" + cdSda + " ]";
    }
    
}
