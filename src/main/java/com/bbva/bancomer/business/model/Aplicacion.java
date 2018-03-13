/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbva.bancomer.business.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Guevara
 */
@Entity
@Table(name = "thge057_aplicacion", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CD_APLICACION"})
        , @UniqueConstraint(columnNames = {"NB_APLICACION"})})
@NamedQueries({
        @NamedQuery(name = "Aplicacion.findAll", query = "SELECT t FROM Aplicacion t")})
public class Aplicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_CONS_APLIC", nullable = false)
    private Integer cdConsAplic;
    @Basic(optional = false)
    @Column(name = "CD_APLICACION", nullable = false)
    private int cdAplicacion;
    @Basic(optional = false)
    @Column(name = "NB_APLICACION", nullable = false, length = 50)
    private String nbAplicacion;
    @JoinColumn(name = "CD_TECNOLOGIA", referencedColumnName = "CD_TECNOLOGIA", nullable = false)
    @ManyToOne(optional = false)
    private Tecnologia cdTecnologia;
    @OneToMany(mappedBy = "cdAplicacion")
    private List<Requerim> requerimList;

    public Aplicacion() {
    }

    public Aplicacion(Integer cdConsAplic) {
        this.cdConsAplic = cdConsAplic;
    }

    public Aplicacion(Integer cdConsAplic, int cdAplicacion, String nbAplicacion) {
        this.cdConsAplic = cdConsAplic;
        this.cdAplicacion = cdAplicacion;
        this.nbAplicacion = nbAplicacion;
    }

    public Integer getCdConsAplic() {
        return cdConsAplic;
    }

    public void setCdConsAplic(Integer cdConsAplic) {
        this.cdConsAplic = cdConsAplic;
    }

    public int getCdAplicacion() {
        return cdAplicacion;
    }

    public void setCdAplicacion(int cdAplicacion) {
        this.cdAplicacion = cdAplicacion;
    }

    public String getNbAplicacion() {
        return nbAplicacion;
    }

    public void setNbAplicacion(String nbAplicacion) {
        this.nbAplicacion = nbAplicacion;
    }

    public Tecnologia getCdTecnologia() {
        return cdTecnologia;
    }

    public void setCdTecnologia(Tecnologia cdTecnologia) {
        this.cdTecnologia = cdTecnologia;
    }

    public List<Requerim> getRequerimList() {
        return requerimList;
    }

    public void setRequerimList(List<Requerim> requerimList) {
        this.requerimList = requerimList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdConsAplic != null ? cdConsAplic.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aplicacion)) {
            return false;
        }
        Aplicacion other = (Aplicacion) object;
        if ((this.cdConsAplic == null && other.cdConsAplic != null) || (this.cdConsAplic != null && !this.cdConsAplic.equals(other.cdConsAplic))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Aplicacion[ cdConsAplic=" + cdConsAplic + " ]";
    }

}
