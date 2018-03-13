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
@Table(name = "thge005_estado", catalog = "gestion_factoria", schema = "")
@NamedQueries({
        @NamedQuery(name = "Estado.findAll", query = "SELECT t FROM Estado t")})
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_ESTADO", nullable = false)
    private Integer cdEstado;
    @Basic(optional = false)
    @Column(name = "NB_ESTADO", nullable = false, length = 50)
    private String nbEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stEmpresa")
    private List<Company> companyList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stPep")
    private List<Pep> pepList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stDyd")
    private List<Pep> pepList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stTarifa")
    private List<Tarifa> tarifaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stEstadoUsuario")
    private List<User> userList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stPepFact")
    private List<Factura> facturaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stPago")
    private List<Factura> facturaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stFactHrsProy")
    private List<Factura> facturaList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stRequerimiento")
    private List<Requerim> requerimList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stModificacion")
    private List<Modif> modifList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stTipif")
    private List<Modif> modifList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stContrato")
    private List<Contrato> contratoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stAcceso")
    private List<CtrlAcc> ctrlAccList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stDuda")
    private List<Duda> dudaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stEstado")
    private List<Tipologia> tipologiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stRecExt")
    private List<CtrlExt> ctrlExtList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdEdoDefecto")
    private List<T955> t955List;
    @OneToMany(mappedBy = "stIncidencia")
    private List<Incidencia> incidenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stTipificacion")
    private List<Componente> componenteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stComponente")
    private List<Componente> componenteList1;
    @JoinColumn(name = "CD_TIPO_EDO", referencedColumnName = "CD_TIPO_EDO", nullable = false)
    @ManyToOne(optional = false)
    private TipoEdo cdTipoEdo;

    public Estado() {
    }

    public Estado(Integer cdEstado) {
        this.cdEstado = cdEstado;
    }

    public Estado(Integer cdEstado, String nbEstado) {
        this.cdEstado = cdEstado;
        this.nbEstado = nbEstado;
    }

    public Integer getCdEstado() {
        return cdEstado;
    }

    public void setCdEstado(Integer cdEstado) {
        this.cdEstado = cdEstado;
    }

    public String getNbEstado() {
        return nbEstado;
    }

    public void setNbEstado(String nbEstado) {
        this.nbEstado = nbEstado;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    public List<Pep> getPepList() {
        return pepList;
    }

    public void setPepList(List<Pep> pepList) {
        this.pepList = pepList;
    }

    public List<Pep> getPepList1() {
        return pepList1;
    }

    public void setPepList1(List<Pep> pepList1) {
        this.pepList1 = pepList1;
    }

    public List<Tarifa> getTarifaList() {
        return tarifaList;
    }

    public void setTarifaList(List<Tarifa> tarifaList) {
        this.tarifaList = tarifaList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    public List<Factura> getFacturaList1() {
        return facturaList1;
    }

    public void setFacturaList1(List<Factura> facturaList1) {
        this.facturaList1 = facturaList1;
    }

    public List<Factura> getFacturaList2() {
        return facturaList2;
    }

    public void setFacturaList2(List<Factura> facturaList2) {
        this.facturaList2 = facturaList2;
    }

    public List<Requerim> getRequerimList() {
        return requerimList;
    }

    public void setRequerimList(List<Requerim> requerimList) {
        this.requerimList = requerimList;
    }

    public List<Modif> getModifList() {
        return modifList;
    }

    public void setModifList(List<Modif> modifList) {
        this.modifList = modifList;
    }

    public List<Modif> getModifList1() {
        return modifList1;
    }

    public void setModifList1(List<Modif> modifList1) {
        this.modifList1 = modifList1;
    }

    public List<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList) {
        this.contratoList = contratoList;
    }

    public List<CtrlAcc> getCtrlAccList() {
        return ctrlAccList;
    }

    public void setCtrlAccList(List<CtrlAcc> ctrlAccList) {
        this.ctrlAccList = ctrlAccList;
    }

    public List<Duda> getDudaList() {
        return dudaList;
    }

    public void setDudaList(List<Duda> dudaList) {
        this.dudaList = dudaList;
    }

    public List<Tipologia> getTipologiaList() {
        return tipologiaList;
    }

    public void setTipologiaList(List<Tipologia> tipologiaList) {
        this.tipologiaList = tipologiaList;
    }

    public List<CtrlExt> getCtrlExtList() {
        return ctrlExtList;
    }

    public void setCtrlExtList(List<CtrlExt> ctrlExtList) {
        this.ctrlExtList = ctrlExtList;
    }

    public List<T955> getT955List() {
        return t955List;
    }

    public void setT955List(List<T955> t955List) {
        this.t955List = t955List;
    }

    public List<Incidencia> getIncidenciaList() {
        return incidenciaList;
    }

    public void setIncidenciaList(List<Incidencia> incidenciaList) {
        this.incidenciaList = incidenciaList;
    }

    public List<Componente> getComponenteList() {
        return componenteList;
    }

    public void setComponenteList(List<Componente> componenteList) {
        this.componenteList = componenteList;
    }

    public List<Componente> getComponenteList1() {
        return componenteList1;
    }

    public void setComponenteList1(List<Componente> componenteList1) {
        this.componenteList1 = componenteList1;
    }

    public TipoEdo getCdTipoEdo() {
        return cdTipoEdo;
    }

    public void setCdTipoEdo(TipoEdo cdTipoEdo) {
        this.cdTipoEdo = cdTipoEdo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdEstado != null ? cdEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.cdEstado == null && other.cdEstado != null) || (this.cdEstado != null && !this.cdEstado.equals(other.cdEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Estado[ cdEstado=" + cdEstado + " ]";
    }

}
