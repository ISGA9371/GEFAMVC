/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author manug
 */
@Entity
@Table(name = "thge017_requerim", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge017Requerim.findAll", query = "SELECT t FROM Thge017Requerim t")})
public class Thge017Requerim implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_REQUERIMIENTO")
    private Integer cdRequerimiento;
    @Basic(optional = false)
    @Column(name = "NB_REQUERIMIENTO")
    private String nbRequerimiento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NU_HORA_REQ")
    private Double nuHoraReq;
    @Column(name = "NU_HRS_TOT")
    private Integer nuHrsTot;
    @Column(name = "NU_HRS_FACT")
    private Integer nuHrsFact;
    @Column(name = "NU_HRS_SIN_FACT")
    private Integer nuHrsSinFact;
    @Basic(optional = false)
    @Column(name = "ST_FACTURADO")
    private short stFacturado;
    @Column(name = "TM_ALTA_REQ")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tmAltaReq;
    @Column(name = "NU_FACTURABLE")
    private Short nuFacturable;
    @Column(name = "FH_INICIO_REQ")
    @Temporal(TemporalType.DATE)
    private Date fhInicioReq;
    @Column(name = "FH_FIN_REQ")
    @Temporal(TemporalType.DATE)
    private Date fhFinReq;
    @Column(name = "CD_PROYECTO")
    private Integer cdProyecto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdRequerimiento")
    private List<Thge039Factura> thge039FacturaList;
    @JoinColumn(name = "CD_TECNOLOGIA", referencedColumnName = "CD_TECNOLOGIA")
    @ManyToOne(optional = false)
    private Thge002Tecnologia cdTecnologia;
    @JoinColumn(name = "CD_TIPO_SERVICIO", referencedColumnName = "CD_TIPO_SERVICIO")
    @ManyToOne(optional = false)
    private Thge001TipoServ cdTipoServicio;
    @JoinColumn(name = "CD_EMPRESA", referencedColumnName = "CD_EMPRESA")
    @ManyToOne(optional = false)
    private Thge003Empresa cdEmpresa;
    @JoinColumn(name = "ST_REQUERIMIENTO", referencedColumnName = "CD_ESTADO")
    @ManyToOne(optional = false)
    private Thge005Estado stRequerimiento;
    @JoinColumn(name = "CD_NIVEL", referencedColumnName = "CD_NIVEL")
    @ManyToOne(optional = false)
    private Thge010Nivel cdNivel;
    @JoinColumn(name = "CD_USUARIO_RESP", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne(optional = false)
    private Thge011Usuario cdUsuarioResp;
    @JoinColumn(name = "CD_USUARIO_GESTOR", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne(optional = false)
    private Thge011Usuario cdUsuarioGestor;
    @JoinColumn(name = "CD_PI", referencedColumnName = "CD_PI")
    @ManyToOne(optional = false)
    private Thge013Pi cdPi;
    @JoinColumn(name = "CD_SDA", referencedColumnName = "CD_SDA")
    @ManyToOne
    private Thge022Proyecto cdSda;
    @JoinColumn(name = "CD_APLICACION", referencedColumnName = "CD_APLICACION")
    @ManyToOne
    private Thge057Aplicacion cdAplicacion;
    @JoinColumn(name = "CD_AREA", referencedColumnName = "CD_AREA")
    @ManyToOne(optional = false)
    private Thge030Area cdArea;
    @JoinColumn(name = "CD_CANAL", referencedColumnName = "CD_CANAL")
    @ManyToOne
    private Thge056Canal cdCanal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdRequerimiento")
    private List<Thge040PepReq> thge040PepReqList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdRequerimiento")
    private List<Thge042T926> thge042T926List;
    @OneToMany(mappedBy = "cdRequerimiento")
    private List<Thge071CtrlProy> thge071CtrlProyList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "thge017Requerim")
    private List<Thge048T955> thge048T955List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdRequerimiento")
    private List<Thge063SegReq> thge063SegReqList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdRequerimiento")
    private List<Thge009Componente> thge009ComponenteList;

    public Thge017Requerim() {
    }

    public Thge017Requerim(Integer cdRequerimiento) {
        this.cdRequerimiento = cdRequerimiento;
    }

    public Thge017Requerim(Integer cdRequerimiento, String nbRequerimiento, short stFacturado) {
        this.cdRequerimiento = cdRequerimiento;
        this.nbRequerimiento = nbRequerimiento;
        this.stFacturado = stFacturado;
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

    public short getStFacturado() {
        return stFacturado;
    }

    public void setStFacturado(short stFacturado) {
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

    public Date getFhInicioReq() {
        return fhInicioReq;
    }

    public void setFhInicioReq(Date fhInicioReq) {
        this.fhInicioReq = fhInicioReq;
    }

    public Date getFhFinReq() {
        return fhFinReq;
    }

    public void setFhFinReq(Date fhFinReq) {
        this.fhFinReq = fhFinReq;
    }

    public Integer getCdProyecto() {
        return cdProyecto;
    }

    public void setCdProyecto(Integer cdProyecto) {
        this.cdProyecto = cdProyecto;
    }

    public List<Thge039Factura> getThge039FacturaList() {
        return thge039FacturaList;
    }

    public void setThge039FacturaList(List<Thge039Factura> thge039FacturaList) {
        this.thge039FacturaList = thge039FacturaList;
    }

    public Thge002Tecnologia getCdTecnologia() {
        return cdTecnologia;
    }

    public void setCdTecnologia(Thge002Tecnologia cdTecnologia) {
        this.cdTecnologia = cdTecnologia;
    }

    public Thge001TipoServ getCdTipoServicio() {
        return cdTipoServicio;
    }

    public void setCdTipoServicio(Thge001TipoServ cdTipoServicio) {
        this.cdTipoServicio = cdTipoServicio;
    }

    public Thge003Empresa getCdEmpresa() {
        return cdEmpresa;
    }

    public void setCdEmpresa(Thge003Empresa cdEmpresa) {
        this.cdEmpresa = cdEmpresa;
    }

    public Thge005Estado getStRequerimiento() {
        return stRequerimiento;
    }

    public void setStRequerimiento(Thge005Estado stRequerimiento) {
        this.stRequerimiento = stRequerimiento;
    }

    public Thge010Nivel getCdNivel() {
        return cdNivel;
    }

    public void setCdNivel(Thge010Nivel cdNivel) {
        this.cdNivel = cdNivel;
    }

    public Thge011Usuario getCdUsuarioResp() {
        return cdUsuarioResp;
    }

    public void setCdUsuarioResp(Thge011Usuario cdUsuarioResp) {
        this.cdUsuarioResp = cdUsuarioResp;
    }

    public Thge011Usuario getCdUsuarioGestor() {
        return cdUsuarioGestor;
    }

    public void setCdUsuarioGestor(Thge011Usuario cdUsuarioGestor) {
        this.cdUsuarioGestor = cdUsuarioGestor;
    }

    public Thge013Pi getCdPi() {
        return cdPi;
    }

    public void setCdPi(Thge013Pi cdPi) {
        this.cdPi = cdPi;
    }

    public Thge022Proyecto getCdSda() {
        return cdSda;
    }

    public void setCdSda(Thge022Proyecto cdSda) {
        this.cdSda = cdSda;
    }

    public Thge057Aplicacion getCdAplicacion() {
        return cdAplicacion;
    }

    public void setCdAplicacion(Thge057Aplicacion cdAplicacion) {
        this.cdAplicacion = cdAplicacion;
    }

    public Thge030Area getCdArea() {
        return cdArea;
    }

    public void setCdArea(Thge030Area cdArea) {
        this.cdArea = cdArea;
    }

    public Thge056Canal getCdCanal() {
        return cdCanal;
    }

    public void setCdCanal(Thge056Canal cdCanal) {
        this.cdCanal = cdCanal;
    }

    public List<Thge040PepReq> getThge040PepReqList() {
        return thge040PepReqList;
    }

    public void setThge040PepReqList(List<Thge040PepReq> thge040PepReqList) {
        this.thge040PepReqList = thge040PepReqList;
    }

    public List<Thge042T926> getThge042T926List() {
        return thge042T926List;
    }

    public void setThge042T926List(List<Thge042T926> thge042T926List) {
        this.thge042T926List = thge042T926List;
    }

    public List<Thge071CtrlProy> getThge071CtrlProyList() {
        return thge071CtrlProyList;
    }

    public void setThge071CtrlProyList(List<Thge071CtrlProy> thge071CtrlProyList) {
        this.thge071CtrlProyList = thge071CtrlProyList;
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

    public List<Thge009Componente> getThge009ComponenteList() {
        return thge009ComponenteList;
    }

    public void setThge009ComponenteList(List<Thge009Componente> thge009ComponenteList) {
        this.thge009ComponenteList = thge009ComponenteList;
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
        if (!(object instanceof Thge017Requerim)) {
            return false;
        }
        Thge017Requerim other = (Thge017Requerim) object;
        if ((this.cdRequerimiento == null && other.cdRequerimiento != null) || (this.cdRequerimiento != null && !this.cdRequerimiento.equals(other.cdRequerimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge017Requerim[ cdRequerimiento=" + cdRequerimiento + " ]";
    }
    
}
