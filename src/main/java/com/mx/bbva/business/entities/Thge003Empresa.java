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
@Table(name = "thge003_empresa", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge003Empresa.findAll", query = "SELECT t FROM Thge003Empresa t")})
public class Thge003Empresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_EMPRESA")
    private Integer cdEmpresa;
    @Basic(optional = false)
    @Column(name = "NB_COMERC_EMPRESA")
    private String nbComercEmpresa;
    @Basic(optional = false)
    @Column(name = "NB_RAZON_SOC_EMP")
    private String nbRazonSocEmp;
    @Basic(optional = false)
    @Column(name = "NU_PROVEEDOR")
    private String nuProveedor;
    @JoinColumn(name = "ST_EMPRESA", referencedColumnName = "CD_ESTADO")
    @ManyToOne(optional = false)
    private Thge005Estado stEmpresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdEmpresa")
    private List<Thge062EvalServ> thge062EvalServList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdEmpresa")
    private List<Thge031Tarifa> thge031TarifaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdEmpresa")
    private List<Thge017Requerim> thge017RequerimList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdEmpresa")
    private List<Thge036Contrato> thge036ContratoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdEmpresa")
    private List<Thge024CtrlExt> thge024CtrlExtList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdEmpresa")
    private List<Thge059HCMando> thge059HCMandoList;

    public Thge003Empresa() {
    }

    public Thge003Empresa(Integer cdEmpresa) {
        this.cdEmpresa = cdEmpresa;
    }

    public Thge003Empresa(Integer cdEmpresa, String nbComercEmpresa, String nbRazonSocEmp, String nuProveedor) {
        this.cdEmpresa = cdEmpresa;
        this.nbComercEmpresa = nbComercEmpresa;
        this.nbRazonSocEmp = nbRazonSocEmp;
        this.nuProveedor = nuProveedor;
    }

    public Integer getCdEmpresa() {
        return cdEmpresa;
    }

    public void setCdEmpresa(Integer cdEmpresa) {
        this.cdEmpresa = cdEmpresa;
    }

    public String getNbComercEmpresa() {
        return nbComercEmpresa;
    }

    public void setNbComercEmpresa(String nbComercEmpresa) {
        this.nbComercEmpresa = nbComercEmpresa;
    }

    public String getNbRazonSocEmp() {
        return nbRazonSocEmp;
    }

    public void setNbRazonSocEmp(String nbRazonSocEmp) {
        this.nbRazonSocEmp = nbRazonSocEmp;
    }

    public String getNuProveedor() {
        return nuProveedor;
    }

    public void setNuProveedor(String nuProveedor) {
        this.nuProveedor = nuProveedor;
    }

    public Thge005Estado getStEmpresa() {
        return stEmpresa;
    }

    public void setStEmpresa(Thge005Estado stEmpresa) {
        this.stEmpresa = stEmpresa;
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

    public List<Thge059HCMando> getThge059HCMandoList() {
        return thge059HCMandoList;
    }

    public void setThge059HCMandoList(List<Thge059HCMando> thge059HCMandoList) {
        this.thge059HCMandoList = thge059HCMandoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdEmpresa != null ? cdEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge003Empresa)) {
            return false;
        }
        Thge003Empresa other = (Thge003Empresa) object;
        if ((this.cdEmpresa == null && other.cdEmpresa != null) || (this.cdEmpresa != null && !this.cdEmpresa.equals(other.cdEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge003Empresa[ cdEmpresa=" + cdEmpresa + " ]";
    }
    
}
