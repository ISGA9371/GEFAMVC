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
@Table(name = "thge057_aplicacion", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge057Aplicacion.findAll", query = "SELECT t FROM Thge057Aplicacion t")})
public class Thge057Aplicacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_APLICACION")
    private Integer cdAplicacion;
    @Basic(optional = false)
    @Column(name = "NB_APLICACION")
    private String nbAplicacion;
    @JoinColumn(name = "CD_TECNOLOGIA", referencedColumnName = "CD_TECNOLOGIA")
    @ManyToOne(optional = false)
    private Thge002Tecnologia cdTecnologia;
    @OneToMany(mappedBy = "cdAplicacion")
    private List<Thge017Requerim> thge017RequerimList;

    public Thge057Aplicacion() {
    }

    public Thge057Aplicacion(Integer cdAplicacion) {
        this.cdAplicacion = cdAplicacion;
    }

    public Thge057Aplicacion(Integer cdAplicacion, String nbAplicacion) {
        this.cdAplicacion = cdAplicacion;
        this.nbAplicacion = nbAplicacion;
    }

    public Integer getCdAplicacion() {
        return cdAplicacion;
    }

    public void setCdAplicacion(Integer cdAplicacion) {
        this.cdAplicacion = cdAplicacion;
    }

    public String getNbAplicacion() {
        return nbAplicacion;
    }

    public void setNbAplicacion(String nbAplicacion) {
        this.nbAplicacion = nbAplicacion;
    }

    public Thge002Tecnologia getCdTecnologia() {
        return cdTecnologia;
    }

    public void setCdTecnologia(Thge002Tecnologia cdTecnologia) {
        this.cdTecnologia = cdTecnologia;
    }

    public List<Thge017Requerim> getThge017RequerimList() {
        return thge017RequerimList;
    }

    public void setThge017RequerimList(List<Thge017Requerim> thge017RequerimList) {
        this.thge017RequerimList = thge017RequerimList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdAplicacion != null ? cdAplicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge057Aplicacion)) {
            return false;
        }
        Thge057Aplicacion other = (Thge057Aplicacion) object;
        if ((this.cdAplicacion == null && other.cdAplicacion != null) || (this.cdAplicacion != null && !this.cdAplicacion.equals(other.cdAplicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge057Aplicacion[ cdAplicacion=" + cdAplicacion + " ]";
    }
    
}
