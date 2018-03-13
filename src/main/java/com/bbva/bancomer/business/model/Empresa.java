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
@Table(name = "thge003_empresa", catalog = "gestion_factoria", schema = "")
@NamedQueries({
        @NamedQuery(name = "Empresa.findAll", query = "SELECT t FROM Empresa t")})
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_EMPRESA", nullable = false)
    private Integer cdEmpresa;
    @Basic(optional = false)
    @Column(name = "NB_COMERC_EMPRESA", nullable = false, length = 45)
    private String nbComercEmpresa;
    @Basic(optional = false)
    @Column(name = "NB_RAZON_SOC_EMP", nullable = false, length = 45)
    private String nbRazonSocEmp;
    @Basic(optional = false)
    @Column(name = "NU_PROVEEDOR", nullable = false, length = 6)
    private String nuProveedor;
    @Basic(optional = false)
    @Column(name = "CD_AREA", nullable = false)
    private int cdArea;
    @JoinColumn(name = "ST_EMPRESA", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Estado stEmpresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdEmpresa")
    private List<Tarifa> tarifaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdEmpresa")
    private List<Requerim> requerimList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdEmpresa")
    private List<Contrato> contratoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdEmpresa")
    private List<CtrlExt> ctrlExtList;

    public Empresa() {
    }

    public Empresa(Integer cdEmpresa) {
        this.cdEmpresa = cdEmpresa;
    }

    public Empresa(Integer cdEmpresa, String nbComercEmpresa, String nbRazonSocEmp, String nuProveedor, int cdArea) {
        this.cdEmpresa = cdEmpresa;
        this.nbComercEmpresa = nbComercEmpresa;
        this.nbRazonSocEmp = nbRazonSocEmp;
        this.nuProveedor = nuProveedor;
        this.cdArea = cdArea;
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

    public int getCdArea() {
        return cdArea;
    }

    public void setCdArea(int cdArea) {
        this.cdArea = cdArea;
    }

    public Estado getStEmpresa() {
        return stEmpresa;
    }

    public void setStEmpresa(Estado stEmpresa) {
        this.stEmpresa = stEmpresa;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdEmpresa != null ? cdEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.cdEmpresa == null && other.cdEmpresa != null) || (this.cdEmpresa != null && !this.cdEmpresa.equals(other.cdEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Empresa[ cdEmpresa=" + cdEmpresa + " ]";
    }

}
