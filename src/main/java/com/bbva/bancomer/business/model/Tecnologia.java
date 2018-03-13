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
@Table(name = "thge002_tecnologia", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_TECNOLOGIA"})})
@NamedQueries({
        @NamedQuery(name = "Tecnologia.findAll", query = "SELECT t FROM Tecnologia t")})
public class Tecnologia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_TECNOLOGIA", nullable = false)
    private Integer cdTecnologia;
    @Basic(optional = false)
    @Column(name = "NB_TECNOLOGIA", nullable = false, length = 25)
    private String nbTecnologia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTecnologia")
    private List<Tarifa> tarifaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTecnologia")
    private List<Aplicacion> aplicacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTecnologia")
    private List<Requerim> requerimList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTecnologia")
    private List<Contrato> contratoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTecnologia")
    private List<Producto> productoList;

    public Tecnologia() {
    }

    public Tecnologia(Integer cdTecnologia) {
        this.cdTecnologia = cdTecnologia;
    }

    public Tecnologia(Integer cdTecnologia, String nbTecnologia) {
        this.cdTecnologia = cdTecnologia;
        this.nbTecnologia = nbTecnologia;
    }

    public Integer getCdTecnologia() {
        return cdTecnologia;
    }

    public void setCdTecnologia(Integer cdTecnologia) {
        this.cdTecnologia = cdTecnologia;
    }

    public String getNbTecnologia() {
        return nbTecnologia;
    }

    public void setNbTecnologia(String nbTecnologia) {
        this.nbTecnologia = nbTecnologia;
    }

    public List<Tarifa> getTarifaList() {
        return tarifaList;
    }

    public void setTarifaList(List<Tarifa> tarifaList) {
        this.tarifaList = tarifaList;
    }

    public List<Aplicacion> getAplicacionList() {
        return aplicacionList;
    }

    public void setAplicacionList(List<Aplicacion> aplicacionList) {
        this.aplicacionList = aplicacionList;
    }

    public List<Requerim> getRequerimList() {
        return requerimList;
    }

    public void setRequerimList(List<Requerim> requerimList) {
        this.requerimList = requerimList;
    }

    public List<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList) {
        this.contratoList = contratoList;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdTecnologia != null ? cdTecnologia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tecnologia)) {
            return false;
        }
        Tecnologia other = (Tecnologia) object;
        if ((this.cdTecnologia == null && other.cdTecnologia != null) || (this.cdTecnologia != null && !this.cdTecnologia.equals(other.cdTecnologia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Tecnologia[ cdTecnologia=" + cdTecnologia + " ]";
    }

}
