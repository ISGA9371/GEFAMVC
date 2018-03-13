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
@Table(name = "thge030_area", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_AREA"})})
@NamedQueries({
        @NamedQuery(name = "Area.findAll", query = "SELECT t FROM Area t")})
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_AREA", nullable = false)
    private Integer cdArea;
    @Basic(optional = false)
    @Column(name = "NB_AREA", nullable = false, length = 50)
    private String nbArea;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdArea")
    private List<Pep> pepList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdArea")
    private List<Tarifa> tarifaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdArea")
    private List<Requerim> requerimList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdArea")
    private List<Contrato> contratoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdArea")
    private List<CtrlExt> ctrlExtList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "thge030Area")
    private List<TipoServ> tipoServList;

    public Area() {
    }

    public Area(Integer cdArea) {
        this.cdArea = cdArea;
    }

    public Area(Integer cdArea, String nbArea) {
        this.cdArea = cdArea;
        this.nbArea = nbArea;
    }

    public Integer getCdArea() {
        return cdArea;
    }

    public void setCdArea(Integer cdArea) {
        this.cdArea = cdArea;
    }

    public String getNbArea() {
        return nbArea;
    }

    public void setNbArea(String nbArea) {
        this.nbArea = nbArea;
    }

    public List<Pep> getPepList() {
        return pepList;
    }

    public void setPepList(List<Pep> pepList) {
        this.pepList = pepList;
    }

    public List<Tarifa> getTarifaList() {
        return tarifaList;
    }

    public void setTarifaList(List<Tarifa> tarifaList) {
        this.tarifaList = tarifaList;
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

    public List<CtrlExt> getCtrlExtList() {
        return ctrlExtList;
    }

    public void setCtrlExtList(List<CtrlExt> ctrlExtList) {
        this.ctrlExtList = ctrlExtList;
    }

    public List<TipoServ> getTipoServList() {
        return tipoServList;
    }

    public void setTipoServList(List<TipoServ> tipoServList) {
        this.tipoServList = tipoServList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdArea != null ? cdArea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.cdArea == null && other.cdArea != null) || (this.cdArea != null && !this.cdArea.equals(other.cdArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Area[ cdArea=" + cdArea + " ]";
    }

}
