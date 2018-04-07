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
@Table(name = "thge030_area", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge030Area.findAll", query = "SELECT t FROM Thge030Area t")})
public class Thge030Area implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_AREA")
    private Integer cdArea;
    @Basic(optional = false)
    @Column(name = "NB_AREA")
    private String nbArea;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdArea")
    private List<Thge007Pep> thge007PepList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdArea")
    private List<Thge031Tarifa> thge031TarifaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdArea")
    private List<Thge017Requerim> thge017RequerimList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdArea")
    private List<Thge036Contrato> thge036ContratoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdArea")
    private List<Thge024CtrlExt> thge024CtrlExtList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdArea")
    private List<Thge001TipoServ> thge001TipoServList;

    public Thge030Area() {
    }

    public Thge030Area(Integer cdArea) {
        this.cdArea = cdArea;
    }

    public Thge030Area(Integer cdArea, String nbArea) {
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

    public List<Thge007Pep> getThge007PepList() {
        return thge007PepList;
    }

    public void setThge007PepList(List<Thge007Pep> thge007PepList) {
        this.thge007PepList = thge007PepList;
    }

    public List<Thge031Tarifa> getThge031TarifaList() {
        return thge031TarifaList;
    }

    public void setThge031TarifaList(List<Thge031Tarifa> thge031TarifaList) {
        this.thge031TarifaList = thge031TarifaList;
    }

    public List<Thge017Requerim> getThge017RequerimList() {
        return thge017RequerimList;
    }

    public void setThge017RequerimList(List<Thge017Requerim> thge017RequerimList) {
        this.thge017RequerimList = thge017RequerimList;
    }

    public List<Thge036Contrato> getThge036ContratoList() {
        return thge036ContratoList;
    }

    public void setThge036ContratoList(List<Thge036Contrato> thge036ContratoList) {
        this.thge036ContratoList = thge036ContratoList;
    }

    public List<Thge024CtrlExt> getThge024CtrlExtList() {
        return thge024CtrlExtList;
    }

    public void setThge024CtrlExtList(List<Thge024CtrlExt> thge024CtrlExtList) {
        this.thge024CtrlExtList = thge024CtrlExtList;
    }

    public List<Thge001TipoServ> getThge001TipoServList() {
        return thge001TipoServList;
    }

    public void setThge001TipoServList(List<Thge001TipoServ> thge001TipoServList) {
        this.thge001TipoServList = thge001TipoServList;
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
        if (!(object instanceof Thge030Area)) {
            return false;
        }
        Thge030Area other = (Thge030Area) object;
        if ((this.cdArea == null && other.cdArea != null) || (this.cdArea != null && !this.cdArea.equals(other.cdArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge030Area[ cdArea=" + cdArea + " ]";
    }
    
}
