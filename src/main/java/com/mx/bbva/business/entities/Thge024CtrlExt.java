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
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "thge024_ctrl_ext", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge024CtrlExt.findAll", query = "SELECT t FROM Thge024CtrlExt t")})
public class Thge024CtrlExt implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_EXTERNO_CORP")
    private String cdExternoCorp;
    @Basic(optional = false)
    @Column(name = "NB_REC_EXTERNO")
    private String nbRecExterno;
    @Basic(optional = false)
    @Column(name = "NB_APELL_PAT")
    private String nbApellPat;
    @Column(name = "NB_APELL_MAT")
    private String nbApellMat;
    @Column(name = "TX_RFC")
    private String txRfc;
    @Column(name = "TX_CURP")
    private String txCurp;
    @Column(name = "TX_NSS")
    private String txNss;
    @Column(name = "FH_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fhNacimiento;
    @Basic(optional = false)
    @Column(name = "CD_GENERO")
    private Character cdGenero;
    @Column(name = "TX_IDENTIFICACION")
    private String txIdentificacion;
    @Column(name = "TX_DIR_SCRUM")
    private String txDirScrum;
    @Column(name = "NB_PROY_EXT")
    private String nbProyExt;
    @Column(name = "FH_INIC_PROY")
    @Temporal(TemporalType.DATE)
    private Date fhInicProy;
    @Column(name = "FH_FIN_PROY")
    @Temporal(TemporalType.DATE)
    private Date fhFinProy;
    @Column(name = "TX_HOST")
    private String txHost;
    @Column(name = "TX_VPN")
    private String txVpn;
    @Column(name = "FH_VIGENCIA_TOKEN")
    @Temporal(TemporalType.DATE)
    private Date fhVigenciaToken;
    @Column(name = "NU_PISO")
    private Integer nuPiso;
    @Column(name = "TX_ESTACION")
    private String txEstacion;
    @Column(name = "TX_CORREO_ELECTR")
    private String txCorreoElectr;
    @Column(name = "TX_HORARIO")
    private String txHorario;
    @Column(name = "FH_ALTA")
    @Temporal(TemporalType.DATE)
    private Date fhAlta;
    @Column(name = "FH_BAJA")
    @Temporal(TemporalType.DATE)
    private Date fhBaja;
    @OneToMany(mappedBy = "cdExterno")
    private List<Thge071CtrlProy> thge071CtrlProyList;
    @JoinColumn(name = "CD_USUARIO_GESTOR", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne
    private Thge011Usuario cdUsuarioGestor;
    @JoinColumn(name = "CD_EMPRESA", referencedColumnName = "CD_EMPRESA")
    @ManyToOne(optional = false)
    private Thge003Empresa cdEmpresa;
    @JoinColumn(name = "ST_REC_EXT", referencedColumnName = "CD_ESTADO")
    @ManyToOne(optional = false)
    private Thge005Estado stRecExt;
    @JoinColumn(name = "CD_ESQUEMA_PAGO", referencedColumnName = "CD_ESQUEMA_PAGO")
    @ManyToOne(optional = false)
    private Thge067EsqPago cdEsquemaPago;
    @JoinColumn(name = "CD_USUARIO_RESP", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne(optional = false)
    private Thge011Usuario cdUsuarioResp;
    @JoinColumn(name = "CD_PAIS", referencedColumnName = "CD_PAIS")
    @ManyToOne(optional = false)
    private Thge014Pais cdPais;
    @JoinColumn(name = "CD_TP_PROYECTO", referencedColumnName = "CD_TP_PROYECTO")
    @ManyToOne(optional = false)
    private Thge066TpProy cdTpProyecto;
    @JoinColumn(name = "CD_PERFIL_REC", referencedColumnName = "CD_TIPO_PERFIL")
    @ManyToOne(optional = false)
    private Thge016PerfUsu cdPerfilRec;
    @JoinColumn(name = "CD_SBCLAS_REC", referencedColumnName = "CD_SBCLAS_REC")
    @ManyToOne(optional = false)
    private Thge021SbclasRec cdSbclasRec;
    @JoinColumn(name = "CD_SEDE", referencedColumnName = "CD_SEDE")
    @ManyToOne(optional = false)
    private Thge025Sede cdSede;
    @JoinColumn(name = "CD_AREA", referencedColumnName = "CD_AREA")
    @ManyToOne(optional = false)
    private Thge030Area cdArea;
    @JoinColumn(name = "TP_IDENTIF", referencedColumnName = "CD_IDENTIFICACION")
    @ManyToOne(optional = false)
    private Thge064TpIdentif tpIdentif;
    @JoinColumn(name = "CD_PROYECTO_AG", referencedColumnName = "CD_TP_PROYECTO")
    @ManyToOne(optional = false)
    private Thge066TpProy cdProyectoAg;

    public Thge024CtrlExt() {
    }

    public Thge024CtrlExt(String cdExternoCorp) {
        this.cdExternoCorp = cdExternoCorp;
    }

    public Thge024CtrlExt(String cdExternoCorp, String nbRecExterno, String nbApellPat, Character cdGenero) {
        this.cdExternoCorp = cdExternoCorp;
        this.nbRecExterno = nbRecExterno;
        this.nbApellPat = nbApellPat;
        this.cdGenero = cdGenero;
    }

    public String getCdExternoCorp() {
        return cdExternoCorp;
    }

    public void setCdExternoCorp(String cdExternoCorp) {
        this.cdExternoCorp = cdExternoCorp;
    }

    public String getNbRecExterno() {
        return nbRecExterno;
    }

    public void setNbRecExterno(String nbRecExterno) {
        this.nbRecExterno = nbRecExterno;
    }

    public String getNbApellPat() {
        return nbApellPat;
    }

    public void setNbApellPat(String nbApellPat) {
        this.nbApellPat = nbApellPat;
    }

    public String getNbApellMat() {
        return nbApellMat;
    }

    public void setNbApellMat(String nbApellMat) {
        this.nbApellMat = nbApellMat;
    }

    public String getTxRfc() {
        return txRfc;
    }

    public void setTxRfc(String txRfc) {
        this.txRfc = txRfc;
    }

    public String getTxCurp() {
        return txCurp;
    }

    public void setTxCurp(String txCurp) {
        this.txCurp = txCurp;
    }

    public String getTxNss() {
        return txNss;
    }

    public void setTxNss(String txNss) {
        this.txNss = txNss;
    }

    public Date getFhNacimiento() {
        return fhNacimiento;
    }

    public void setFhNacimiento(Date fhNacimiento) {
        this.fhNacimiento = fhNacimiento;
    }

    public Character getCdGenero() {
        return cdGenero;
    }

    public void setCdGenero(Character cdGenero) {
        this.cdGenero = cdGenero;
    }

    public String getTxIdentificacion() {
        return txIdentificacion;
    }

    public void setTxIdentificacion(String txIdentificacion) {
        this.txIdentificacion = txIdentificacion;
    }

    public String getTxDirScrum() {
        return txDirScrum;
    }

    public void setTxDirScrum(String txDirScrum) {
        this.txDirScrum = txDirScrum;
    }

    public String getNbProyExt() {
        return nbProyExt;
    }

    public void setNbProyExt(String nbProyExt) {
        this.nbProyExt = nbProyExt;
    }

    public Date getFhInicProy() {
        return fhInicProy;
    }

    public void setFhInicProy(Date fhInicProy) {
        this.fhInicProy = fhInicProy;
    }

    public Date getFhFinProy() {
        return fhFinProy;
    }

    public void setFhFinProy(Date fhFinProy) {
        this.fhFinProy = fhFinProy;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public String getTxVpn() {
        return txVpn;
    }

    public void setTxVpn(String txVpn) {
        this.txVpn = txVpn;
    }

    public Date getFhVigenciaToken() {
        return fhVigenciaToken;
    }

    public void setFhVigenciaToken(Date fhVigenciaToken) {
        this.fhVigenciaToken = fhVigenciaToken;
    }

    public Integer getNuPiso() {
        return nuPiso;
    }

    public void setNuPiso(Integer nuPiso) {
        this.nuPiso = nuPiso;
    }

    public String getTxEstacion() {
        return txEstacion;
    }

    public void setTxEstacion(String txEstacion) {
        this.txEstacion = txEstacion;
    }

    public String getTxCorreoElectr() {
        return txCorreoElectr;
    }

    public void setTxCorreoElectr(String txCorreoElectr) {
        this.txCorreoElectr = txCorreoElectr;
    }

    public String getTxHorario() {
        return txHorario;
    }

    public void setTxHorario(String txHorario) {
        this.txHorario = txHorario;
    }

    public Date getFhAlta() {
        return fhAlta;
    }

    public void setFhAlta(Date fhAlta) {
        this.fhAlta = fhAlta;
    }

    public Date getFhBaja() {
        return fhBaja;
    }

    public void setFhBaja(Date fhBaja) {
        this.fhBaja = fhBaja;
    }

    public List<Thge071CtrlProy> getThge071CtrlProyList() {
        return thge071CtrlProyList;
    }

    public void setThge071CtrlProyList(List<Thge071CtrlProy> thge071CtrlProyList) {
        this.thge071CtrlProyList = thge071CtrlProyList;
    }

    public Thge011Usuario getCdUsuarioGestor() {
        return cdUsuarioGestor;
    }

    public void setCdUsuarioGestor(Thge011Usuario cdUsuarioGestor) {
        this.cdUsuarioGestor = cdUsuarioGestor;
    }

    public Thge003Empresa getCdEmpresa() {
        return cdEmpresa;
    }

    public void setCdEmpresa(Thge003Empresa cdEmpresa) {
        this.cdEmpresa = cdEmpresa;
    }

    public Thge005Estado getStRecExt() {
        return stRecExt;
    }

    public void setStRecExt(Thge005Estado stRecExt) {
        this.stRecExt = stRecExt;
    }

    public Thge067EsqPago getCdEsquemaPago() {
        return cdEsquemaPago;
    }

    public void setCdEsquemaPago(Thge067EsqPago cdEsquemaPago) {
        this.cdEsquemaPago = cdEsquemaPago;
    }

    public Thge011Usuario getCdUsuarioResp() {
        return cdUsuarioResp;
    }

    public void setCdUsuarioResp(Thge011Usuario cdUsuarioResp) {
        this.cdUsuarioResp = cdUsuarioResp;
    }

    public Thge014Pais getCdPais() {
        return cdPais;
    }

    public void setCdPais(Thge014Pais cdPais) {
        this.cdPais = cdPais;
    }

    public Thge066TpProy getCdTpProyecto() {
        return cdTpProyecto;
    }

    public void setCdTpProyecto(Thge066TpProy cdTpProyecto) {
        this.cdTpProyecto = cdTpProyecto;
    }

    public Thge016PerfUsu getCdPerfilRec() {
        return cdPerfilRec;
    }

    public void setCdPerfilRec(Thge016PerfUsu cdPerfilRec) {
        this.cdPerfilRec = cdPerfilRec;
    }

    public Thge021SbclasRec getCdSbclasRec() {
        return cdSbclasRec;
    }

    public void setCdSbclasRec(Thge021SbclasRec cdSbclasRec) {
        this.cdSbclasRec = cdSbclasRec;
    }

    public Thge025Sede getCdSede() {
        return cdSede;
    }

    public void setCdSede(Thge025Sede cdSede) {
        this.cdSede = cdSede;
    }

    public Thge030Area getCdArea() {
        return cdArea;
    }

    public void setCdArea(Thge030Area cdArea) {
        this.cdArea = cdArea;
    }

    public Thge064TpIdentif getTpIdentif() {
        return tpIdentif;
    }

    public void setTpIdentif(Thge064TpIdentif tpIdentif) {
        this.tpIdentif = tpIdentif;
    }

    public Thge066TpProy getCdProyectoAg() {
        return cdProyectoAg;
    }

    public void setCdProyectoAg(Thge066TpProy cdProyectoAg) {
        this.cdProyectoAg = cdProyectoAg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdExternoCorp != null ? cdExternoCorp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge024CtrlExt)) {
            return false;
        }
        Thge024CtrlExt other = (Thge024CtrlExt) object;
        if ((this.cdExternoCorp == null && other.cdExternoCorp != null) || (this.cdExternoCorp != null && !this.cdExternoCorp.equals(other.cdExternoCorp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge024CtrlExt[ cdExternoCorp=" + cdExternoCorp + " ]";
    }
    
}
