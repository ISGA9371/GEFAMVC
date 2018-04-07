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
@Table(name = "thge005_estado", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge005Estado.findAll", query = "SELECT t FROM Thge005Estado t")})
public class Thge005Estado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_ESTADO")
    private Integer cdEstado;
    @Basic(optional = false)
    @Column(name = "NB_ESTADO")
    private String nbEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stEmpresa")
    private List<Thge003Empresa> thge003EmpresaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stPep")
    private List<Thge007Pep> thge007PepList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stDyd")
    private List<Thge007Pep> thge007PepList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stTarifa")
    private List<Thge031Tarifa> thge031TarifaList;
    @OneToMany(mappedBy = "stUsuario")
    private List<Thge011Usuario> thge011UsuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stPepFact")
    private List<Thge039Factura> thge039FacturaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stPago")
    private List<Thge039Factura> thge039FacturaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stFactHrsProy")
    private List<Thge039Factura> thge039FacturaList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stRequerimiento")
    private List<Thge017Requerim> thge017RequerimList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stModificacion")
    private List<Thge026Modif> thge026ModifList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stTipif")
    private List<Thge026Modif> thge026ModifList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stContrato")
    private List<Thge036Contrato> thge036ContratoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stAccesoLog")
    private List<Thge058CtrlAcc> thge058CtrlAccList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stDuda")
    private List<Thge027Duda> thge027DudaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stEstado")
    private List<Thge006Tipologia> thge006TipologiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stRecExt")
    private List<Thge024CtrlExt> thge024CtrlExtList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdEdoDefecto")
    private List<Thge048T955> thge048T955List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stSegReq")
    private List<Thge063SegReq> thge063SegReqList;
    @OneToMany(mappedBy = "stIncidencia")
    private List<Thge029Incidencia> thge029IncidenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stTipificacion")
    private List<Thge009Componente> thge009ComponenteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stComponente")
    private List<Thge009Componente> thge009ComponenteList1;
    @JoinColumn(name = "CD_TIPO_EDO", referencedColumnName = "CD_TIPO_EDO")
    @ManyToOne(optional = false)
    private Thge008TipoEdo cdTipoEdo;

    public Thge005Estado() {
    }

    public Thge005Estado(Integer cdEstado) {
        this.cdEstado = cdEstado;
    }

    public Thge005Estado(Integer cdEstado, String nbEstado) {
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

    public List<Thge003Empresa> getThge003EmpresaList() {
        return thge003EmpresaList;
    }

    public void setThge003EmpresaList(List<Thge003Empresa> thge003EmpresaList) {
        this.thge003EmpresaList = thge003EmpresaList;
    }

    public List<Thge007Pep> getThge007PepList() {
        return thge007PepList;
    }

    public void setThge007PepList(List<Thge007Pep> thge007PepList) {
        this.thge007PepList = thge007PepList;
    }

    public List<Thge007Pep> getThge007PepList1() {
        return thge007PepList1;
    }

    public void setThge007PepList1(List<Thge007Pep> thge007PepList1) {
        this.thge007PepList1 = thge007PepList1;
    }

    public List<Thge031Tarifa> getThge031TarifaList() {
        return thge031TarifaList;
    }

    public void setThge031TarifaList(List<Thge031Tarifa> thge031TarifaList) {
        this.thge031TarifaList = thge031TarifaList;
    }

    public List<Thge011Usuario> getThge011UsuarioList() {
        return thge011UsuarioList;
    }

    public void setThge011UsuarioList(List<Thge011Usuario> thge011UsuarioList) {
        this.thge011UsuarioList = thge011UsuarioList;
    }

    public List<Thge039Factura> getThge039FacturaList() {
        return thge039FacturaList;
    }

    public void setThge039FacturaList(List<Thge039Factura> thge039FacturaList) {
        this.thge039FacturaList = thge039FacturaList;
    }

    public List<Thge039Factura> getThge039FacturaList1() {
        return thge039FacturaList1;
    }

    public void setThge039FacturaList1(List<Thge039Factura> thge039FacturaList1) {
        this.thge039FacturaList1 = thge039FacturaList1;
    }

    public List<Thge039Factura> getThge039FacturaList2() {
        return thge039FacturaList2;
    }

    public void setThge039FacturaList2(List<Thge039Factura> thge039FacturaList2) {
        this.thge039FacturaList2 = thge039FacturaList2;
    }

    public List<Thge017Requerim> getThge017RequerimList() {
        return thge017RequerimList;
    }

    public void setThge017RequerimList(List<Thge017Requerim> thge017RequerimList) {
        this.thge017RequerimList = thge017RequerimList;
    }

    public List<Thge026Modif> getThge026ModifList() {
        return thge026ModifList;
    }

    public void setThge026ModifList(List<Thge026Modif> thge026ModifList) {
        this.thge026ModifList = thge026ModifList;
    }

    public List<Thge026Modif> getThge026ModifList1() {
        return thge026ModifList1;
    }

    public void setThge026ModifList1(List<Thge026Modif> thge026ModifList1) {
        this.thge026ModifList1 = thge026ModifList1;
    }

    public List<Thge036Contrato> getThge036ContratoList() {
        return thge036ContratoList;
    }

    public void setThge036ContratoList(List<Thge036Contrato> thge036ContratoList) {
        this.thge036ContratoList = thge036ContratoList;
    }

    public List<Thge058CtrlAcc> getThge058CtrlAccList() {
        return thge058CtrlAccList;
    }

    public void setThge058CtrlAccList(List<Thge058CtrlAcc> thge058CtrlAccList) {
        this.thge058CtrlAccList = thge058CtrlAccList;
    }

    public List<Thge027Duda> getThge027DudaList() {
        return thge027DudaList;
    }

    public void setThge027DudaList(List<Thge027Duda> thge027DudaList) {
        this.thge027DudaList = thge027DudaList;
    }

    public List<Thge006Tipologia> getThge006TipologiaList() {
        return thge006TipologiaList;
    }

    public void setThge006TipologiaList(List<Thge006Tipologia> thge006TipologiaList) {
        this.thge006TipologiaList = thge006TipologiaList;
    }

    public List<Thge024CtrlExt> getThge024CtrlExtList() {
        return thge024CtrlExtList;
    }

    public void setThge024CtrlExtList(List<Thge024CtrlExt> thge024CtrlExtList) {
        this.thge024CtrlExtList = thge024CtrlExtList;
    }

    public List<Thge048T955> getThge048T955List() {
        return thge048T955List;
    }

    public void setThge048T955List(List<Thge048T955> thge048T955List) {
        this.thge048T955List = thge048T955List;
    }

    public List<Thge063SegReq> getThge063SegReqList() {
        return thge063SegReqList;
    }

    public void setThge063SegReqList(List<Thge063SegReq> thge063SegReqList) {
        this.thge063SegReqList = thge063SegReqList;
    }

    public List<Thge029Incidencia> getThge029IncidenciaList() {
        return thge029IncidenciaList;
    }

    public void setThge029IncidenciaList(List<Thge029Incidencia> thge029IncidenciaList) {
        this.thge029IncidenciaList = thge029IncidenciaList;
    }

    public List<Thge009Componente> getThge009ComponenteList() {
        return thge009ComponenteList;
    }

    public void setThge009ComponenteList(List<Thge009Componente> thge009ComponenteList) {
        this.thge009ComponenteList = thge009ComponenteList;
    }

    public List<Thge009Componente> getThge009ComponenteList1() {
        return thge009ComponenteList1;
    }

    public void setThge009ComponenteList1(List<Thge009Componente> thge009ComponenteList1) {
        this.thge009ComponenteList1 = thge009ComponenteList1;
    }

    public Thge008TipoEdo getCdTipoEdo() {
        return cdTipoEdo;
    }

    public void setCdTipoEdo(Thge008TipoEdo cdTipoEdo) {
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
        if (!(object instanceof Thge005Estado)) {
            return false;
        }
        Thge005Estado other = (Thge005Estado) object;
        if ((this.cdEstado == null && other.cdEstado != null) || (this.cdEstado != null && !this.cdEstado.equals(other.cdEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge005Estado[ cdEstado=" + cdEstado + " ]";
    }
    
}
