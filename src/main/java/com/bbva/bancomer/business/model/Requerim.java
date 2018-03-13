/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbva.bancomer.business.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Guevara
 */
@Entity
@Table(name = "thge017_requerim", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_REQUERIMIENTO"})})
@NamedQueries({
        @NamedQuery(name = "Requerim.findAll", query = "SELECT t FROM Requerim t")})
public class Requerim implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_REQUERIMIENTO", nullable = false)
    private Integer cdRequerimiento;
    @Basic(optional = false)
    @Column(name = "NB_REQUERIMIENTO", nullable = false, length = 100)
    private String nbRequerimiento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NU_HORA_REQ", precision = 22)
    private Double nuHoraReq;
    @Column(name = "NU_HRS_TOT")
    private Integer nuHrsTot;
    @Column(name = "NU_HRS_FACT")
    private Integer nuHrsFact;
    @Column(name = "NU_HRS_SIN_FACT")
    private Integer nuHrsSinFact;
    @Column(name = "ST_FACTURADO")
    private Short stFacturado;
    @Column(name = "TM_ALTA_REQ")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tmAltaReq;
    @Column(name = "NU_FACTURABLE")
    private Short nuFacturable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdRequerimiento")
    private List<Factura> facturaList;
    @JoinColumn(name = "CD_USUARIO_GESTOR", referencedColumnName = "CD_USUARIO_CORP", nullable = false)
    @ManyToOne(optional = false)
    private User cdUserGestor;
    @JoinColumn(name = "CD_TIPO_SERVICIO", referencedColumnName = "CD_TIPO_SERVICIO", nullable = false)
    @ManyToOne(optional = false)
    private TipoServ cdTipoServicio;
    @JoinColumn(name = "CD_TECNOLOGIA", referencedColumnName = "CD_TECNOLOGIA", nullable = false)
    @ManyToOne(optional = false)
    private Tecnologia cdTecnologia;
    @JoinColumn(name = "CD_EMPRESA", referencedColumnName = "CD_EMPRESA", nullable = false)
    @ManyToOne(optional = false)
    private Company cdCompany;
    @JoinColumn(name = "ST_REQUERIMIENTO", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Estado stRequerimiento;
    @JoinColumn(name = "CD_NIVEL", referencedColumnName = "CD_NIVEL", nullable = false)
    @ManyToOne(optional = false)
    private Nivel cdNivel;
    @JoinColumn(name = "CD_USUARIO_RESP", referencedColumnName = "CD_USUARIO_CORP", nullable = false)
    @ManyToOne(optional = false)
    private User cdUserResp;
    @JoinColumn(name = "CD_APLICACION", referencedColumnName = "CD_APLICACION")
    @ManyToOne
    private Aplicacion cdAplicacion;
    @JoinColumn(name = "CD_SCRUM", referencedColumnName = "CD_SCRUM")
    @ManyToOne
    private Pi cdScrum;
    @JoinColumn(name = "CD_AREA", referencedColumnName = "CD_AREA", nullable = false)
    @ManyToOne(optional = false)
    private Area cdArea;
    @JoinColumn(name = "CD_TIPO_PROY", referencedColumnName = "CD_TIPO_PROY", nullable = false)
    @ManyToOne(optional = false)
    private TipoProy cdTipoProy;
    @JoinColumn(name = "CD_CANAL", referencedColumnName = "CD_CANAL")
    @ManyToOne
    private Canal cdCanal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdRequerimiento")
    private List<PepReq> pepReqList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdRequerimiento")
    private List<T926> t926List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "thge017Requerim")
    private List<T955> t955List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdRequerimiento")
    private List<Componente> componenteList;

    public Requerim() {
    }

    public Requerim(Integer cdRequerimiento) {
        this.cdRequerimiento = cdRequerimiento;
    }

    public Requerim(Integer cdRequerimiento, String nbRequerimiento) {
        this.cdRequerimiento = cdRequerimiento;
        this.nbRequerimiento = nbRequerimiento;
    }

    public Integer getCdRequerimiento() {
        return cdRequerimiento;
    }

    public void setCdRequerimiento(Integer cdRequerimiento) {
        this.cdRequerimiento = cdRequerimiento;
    }

    public String getNbRequerimiento() {
        return nbRequerimiento;
    }

    public void setNbRequerimiento(String nbRequerimiento) {
        this.nbRequerimiento = nbRequerimiento;
    }

    public Double getNuHoraReq() {
        return nuHoraReq;
    }

    public void setNuHoraReq(Double nuHoraReq) {
        this.nuHoraReq = nuHoraReq;
    }

    public Integer getNuHrsTot() {
        return nuHrsTot;
    }

    public void setNuHrsTot(Integer nuHrsTot) {
        this.nuHrsTot = nuHrsTot;
    }

    public Integer getNuHrsFact() {
        return nuHrsFact;
    }

    public void setNuHrsFact(Integer nuHrsFact) {
        this.nuHrsFact = nuHrsFact;
    }

    public Integer getNuHrsSinFact() {
        return nuHrsSinFact;
    }

    public void setNuHrsSinFact(Integer nuHrsSinFact) {
        this.nuHrsSinFact = nuHrsSinFact;
    }

    public Short getStFacturado() {
        return stFacturado;
    }

    public void setStFacturado(Short stFacturado) {
        this.stFacturado = stFacturado;
    }

    public Date getTmAltaReq() {
        return tmAltaReq;
    }

    public void setTmAltaReq(Date tmAltaReq) {
        this.tmAltaReq = tmAltaReq;
    }

    public Short getNuFacturable() {
        return nuFacturable;
    }

    public void setNuFacturable(Short nuFacturable) {
        this.nuFacturable = nuFacturable;
    }

    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    public User getCdUserGestor() {
        return cdUserGestor;
    }

    public void setCdUserGestor(User cdUserGestor) {
        this.cdUserGestor = cdUserGestor;
    }

    public TipoServ getCdTipoServicio() {
        return cdTipoServicio;
    }

    public void setCdTipoServicio(TipoServ cdTipoServicio) {
        this.cdTipoServicio = cdTipoServicio;
    }

    public Tecnologia getCdTecnologia() {
        return cdTecnologia;
    }

    public void setCdTecnologia(Tecnologia cdTecnologia) {
        this.cdTecnologia = cdTecnologia;
    }

    public Company getCdCompany() {
        return cdCompany;
    }

    public void setCdCompany(Company cdCompany) {
        this.cdCompany = cdCompany;
    }

    public Estado getStRequerimiento() {
        return stRequerimiento;
    }

    public void setStRequerimiento(Estado stRequerimiento) {
        this.stRequerimiento = stRequerimiento;
    }

    public Nivel getCdNivel() {
        return cdNivel;
    }

    public void setCdNivel(Nivel cdNivel) {
        this.cdNivel = cdNivel;
    }

    public User getCdUserResp() {
        return cdUserResp;
    }

    public void setCdUserResp(User cdUserResp) {
        this.cdUserResp = cdUserResp;
    }

    public Aplicacion getCdAplicacion() {
        return cdAplicacion;
    }

    public void setCdAplicacion(Aplicacion cdAplicacion) {
        this.cdAplicacion = cdAplicacion;
    }

    public Pi getCdScrum() {
        return cdScrum;
    }

    public void setCdScrum(Pi cdScrum) {
        this.cdScrum = cdScrum;
    }

    public Area getCdArea() {
        return cdArea;
    }

    public void setCdArea(Area cdArea) {
        this.cdArea = cdArea;
    }

    public TipoProy getCdTipoProy() {
        return cdTipoProy;
    }

    public void setCdTipoProy(TipoProy cdTipoProy) {
        this.cdTipoProy = cdTipoProy;
    }

    public Canal getCdCanal() {
        return cdCanal;
    }

    public void setCdCanal(Canal cdCanal) {
        this.cdCanal = cdCanal;
    }

    public List<PepReq> getPepReqList() {
        return pepReqList;
    }

    public void setPepReqList(List<PepReq> pepReqList) {
        this.pepReqList = pepReqList;
    }

    public List<T926> getT926List() {
        return t926List;
    }

    public void setT926List(List<T926> t926List) {
        this.t926List = t926List;
    }

    public List<T955> getT955List() {
        return t955List;
    }

    public void setT955List(List<T955> t955List) {
        this.t955List = t955List;
    }

    public List<Componente> getComponenteList() {
        return componenteList;
    }

    public void setComponenteList(List<Componente> componenteList) {
        this.componenteList = componenteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdRequerimiento != null ? cdRequerimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requerim)) {
            return false;
        }
        Requerim other = (Requerim) object;
        if ((this.cdRequerimiento == null && other.cdRequerimiento != null) || (this.cdRequerimiento != null && !this.cdRequerimiento.equals(other.cdRequerimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Requerim[ cdRequerimiento=" + cdRequerimiento + " ]";
    }

}
