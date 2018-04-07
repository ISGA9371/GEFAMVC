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
@Table(name = "thge047_result_obt", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge047ResultObt.findAll", query = "SELECT t FROM Thge047ResultObt t")})
public class Thge047ResultObt implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_RESUL_OBTENIDO")
    private Integer cdResulObtenido;
    @Basic(optional = false)
    @Column(name = "NB_RESUL_ONTENIDO")
    private String nbResulOntenido;
    @OneToMany(mappedBy = "cdResulObtenido")
    private List<Thge044C204> thge044C204List;

    public Thge047ResultObt() {
    }

    public Thge047ResultObt(Integer cdResulObtenido) {
        this.cdResulObtenido = cdResulObtenido;
    }

    public Thge047ResultObt(Integer cdResulObtenido, String nbResulOntenido) {
        this.cdResulObtenido = cdResulObtenido;
        this.nbResulOntenido = nbResulOntenido;
    }

    public Integer getCdResulObtenido() {
        return cdResulObtenido;
    }

    public void setCdResulObtenido(Integer cdResulObtenido) {
        this.cdResulObtenido = cdResulObtenido;
    }

    public String getNbResulOntenido() {
        return nbResulOntenido;
    }

    public void setNbResulOntenido(String nbResulOntenido) {
        this.nbResulOntenido = nbResulOntenido;
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
        hash += (cdResulObtenido != null ? cdResulObtenido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge047ResultObt)) {
            return false;
        }
        Thge047ResultObt other = (Thge047ResultObt) object;
        if ((this.cdResulObtenido == null && other.cdResulObtenido != null) || (this.cdResulObtenido != null && !this.cdResulObtenido.equals(other.cdResulObtenido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge047ResultObt[ cdResulObtenido=" + cdResulObtenido + " ]";
    }
    
}
