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
@Table(name = "thge002_tecnologia", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge002Tecnologia.findAll", query = "SELECT t FROM Thge002Tecnologia t")})
public class Thge002Tecnologia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_TECNOLOGIA")
    private Integer cdTecnologia;
    @Basic(optional = false)
    @Column(name = "NB_TECNOLOGIA")
    private String nbTecnologia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTecnologia")
    private List<Thge062EvalServ> thge062EvalServList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTecnologia")
    private List<Thge031Tarifa> thge031TarifaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTecnologia")
    private List<Thge057Aplicacion> thge057AplicacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTecnologia")
    private List<Thge017Requerim> thge017RequerimList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTecnologia")
    private List<Thge036Contrato> thge036ContratoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTecnologia")
    private List<Thge059HCMando> thge059HCMandoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTecnologia")
    private List<Thge018Producto> thge018ProductoList;

    public Thge002Tecnologia() {
    }

    public Thge002Tecnologia(Integer cdTecnologia) {
        this.cdTecnologia = cdTecnologia;
    }

    public Thge002Tecnologia(Integer cdTecnologia, String nbTecnologia) {
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

    public List<Thge062EvalServ> getThge062EvalServList() {
        return thge062EvalServList;
    }

    public void setThge062EvalServList(List<Thge062EvalServ> thge062EvalServList) {
        this.thge062EvalServList = thge062EvalServList;
    }

    public List<Thge031Tarifa> getThge031TarifaList() {
        return thge031TarifaList;
    }

    public void setThge031TarifaList(List<Thge031Tarifa> thge031TarifaList) {
        this.thge031TarifaList = thge031TarifaList;
    }

    public List<Thge057Aplicacion> getThge057AplicacionList() {
        return thge057AplicacionList;
    }

    public void setThge057AplicacionList(List<Thge057Aplicacion> thge057AplicacionList) {
        this.thge057AplicacionList = thge057AplicacionList;
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

    public List<Thge059HCMando> getThge059HCMandoList() {
        return thge059HCMandoList;
    }

    public void setThge059HCMandoList(List<Thge059HCMando> thge059HCMandoList) {
        this.thge059HCMandoList = thge059HCMandoList;
    }

    public List<Thge018Producto> getThge018ProductoList() {
        return thge018ProductoList;
    }

    public void setThge018ProductoList(List<Thge018Producto> thge018ProductoList) {
        this.thge018ProductoList = thge018ProductoList;
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
        if (!(object instanceof Thge002Tecnologia)) {
            return false;
        }
        Thge002Tecnologia other = (Thge002Tecnologia) object;
        if ((this.cdTecnologia == null && other.cdTecnologia != null) || (this.cdTecnologia != null && !this.cdTecnologia.equals(other.cdTecnologia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge002Tecnologia[ cdTecnologia=" + cdTecnologia + " ]";
    }
    
}
