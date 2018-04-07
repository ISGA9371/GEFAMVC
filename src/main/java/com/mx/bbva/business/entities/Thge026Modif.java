/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author manug
 */
@Entity
@Table(name = "thge026_modif", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge026Modif.findAll", query = "SELECT t FROM Thge026Modif t")})
public class Thge026Modif implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_MODIFICACION")
    private Integer cdModificacion;
    @Basic(optional = false)
    @Column(name = "TX_MOD_EN_VUELO")
    private String txModEnVuelo;
    @Column(name = "TX_MOD_RZDA_DYD")
    private String txModRzdaDyd;
    @Column(name = "NB_DESC_MODIF")
    private String nbDescModif;
    @Basic(optional = false)
    @Column(name = "FH_ENVIO")
    @Temporal(TemporalType.DATE)
    private Date fhEnvio;
    @Column(name = "FH_PREV_FINAL")
    @Temporal(TemporalType.DATE)
    private Date fhPrevFinal;
    @Column(name = "FH_RENEGOCIADA")
    @Temporal(TemporalType.DATE)
    private Date fhRenegociada;
    @Basic(optional = false)
    @Column(name = "FH_CIERRE")
    @Temporal(TemporalType.DATE)
    private Date fhCierre;
    @Column(name = "TX_COMENT_MOD")
    private String txComentMod;
    @Column(name = "TX_DIFICULTAD_INI")
    private Character txDificultadIni;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "IM_COSTE_INIC")
    private Double imCosteInic;
    @Column(name = "HM_INICIAL")
    private Double hmInicial;
    @Column(name = "TX_DIF_EMP")
    private Character txDifEmp;
    @Column(name = "IM_COSTE_EMP")
    private Double imCosteEmp;
    @Column(name = "HM_EMPR")
    private Double hmEmpr;
    @Column(name = "TX_COM_TIPIF_EMP")
    private String txComTipifEmp;
    @Basic(optional = false)
    @Column(name = "TX_FACT_S_N")
    private String txFactSN;
    @Column(name = "TX_COM_TIPIF_PROY")
    private String txComTipifProy;
    @JoinColumn(name = "CD_TIPOLOGIA_EMP", referencedColumnName = "CD_TIPOLOGIA")
    @ManyToOne
    private Thge006Tipologia cdTipologiaEmp;
    @JoinColumn(name = "ST_MODIFICACION", referencedColumnName = "CD_ESTADO")
    @ManyToOne(optional = false)
    private Thge005Estado stModificacion;
    @JoinColumn(name = "ST_TIPIF", referencedColumnName = "CD_ESTADO")
    @ManyToOne(optional = false)
    private Thge005Estado stTipif;
    @JoinColumn(name = "CD_TIPOLOGIA_INI", referencedColumnName = "CD_TIPOLOGIA")
    @ManyToOne
    private Thge006Tipologia cdTipologiaIni;
    @JoinColumn(name = "CD_COMPONENTE", referencedColumnName = "CD_COMPONENTE")
    @ManyToOne(optional = false)
    private Thge009Componente cdComponente;
    @JoinColumn(name = "CD_USU_PETICION", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne(optional = false)
    private Thge011Usuario cdUsuPeticion;
    @JoinColumn(name = "CD_RESP_RESOL", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne(optional = false)
    private Thge011Usuario cdRespResol;
    @JoinColumn(name = "CD_PRIORIDAD_USU", referencedColumnName = "CD_PRIORIDAD")
    @ManyToOne(optional = false)
    private Thge015Prioridad cdPrioridadUsu;
    @JoinColumn(name = "CD_ORIGEN", referencedColumnName = "CD_ORIGEN")
    @ManyToOne(optional = false)
    private Thge019Origen cdOrigen;

    public Thge026Modif() {
    }

    public Thge026Modif(Integer cdModificacion) {
        this.cdModificacion = cdModificacion;
    }

    public Thge026Modif(Integer cdModificacion, String txModEnVuelo, Date fhEnvio, Date fhCierre, String txFactSN) {
        this.cdModificacion = cdModificacion;
        this.txModEnVuelo = txModEnVuelo;
        this.fhEnvio = fhEnvio;
        this.fhCierre = fhCierre;
        this.txFactSN = txFactSN;
    }

    public Integer getCdModificacion() {
        return cdModificacion;
    }

    public void setCdModificacion(Integer cdModificacion) {
        this.cdModificacion = cdModificacion;
    }

    public String getTxModEnVuelo() {
        return txModEnVuelo;
    }

    public void setTxModEnVuelo(String txModEnVuelo) {
        this.txModEnVuelo = txModEnVuelo;
    }

    public String getTxModRzdaDyd() {
        return txModRzdaDyd;
    }

    public void setTxModRzdaDyd(String txModRzdaDyd) {
        this.txModRzdaDyd = txModRzdaDyd;
    }

    public String getNbDescModif() {
        return nbDescModif;
    }

    public void setNbDescModif(String nbDescModif) {
        this.nbDescModif = nbDescModif;
    }

    public Date getFhEnvio() {
        return fhEnvio;
    }

    public void setFhEnvio(Date fhEnvio) {
        this.fhEnvio = fhEnvio;
    }

    public Date getFhPrevFinal() {
        return fhPrevFinal;
    }

    public void setFhPrevFinal(Date fhPrevFinal) {
        this.fhPrevFinal = fhPrevFinal;
    }

    public Date getFhRenegociada() {
        return fhRenegociada;
    }

    public void setFhRenegociada(Date fhRenegociada) {
        this.fhRenegociada = fhRenegociada;
    }

    public Date getFhCierre() {
        return fhCierre;
    }

    public void setFhCierre(Date fhCierre) {
        this.fhCierre = fhCierre;
    }

    public String getTxComentMod() {
        return txComentMod;
    }

    public void setTxComentMod(String txComentMod) {
        this.txComentMod = txComentMod;
    }

    public Character getTxDificultadIni() {
        return txDificultadIni;
    }

    public void setTxDificultadIni(Character txDificultadIni) {
        this.txDificultadIni = txDificultadIni;
    }

    public Double getImCosteInic() {
        return imCosteInic;
    }

    public void setImCosteInic(Double imCosteInic) {
        this.imCosteInic = imCosteInic;
    }

    public Double getHmInicial() {
        return hmInicial;
    }

    public void setHmInicial(Double hmInicial) {
        this.hmInicial = hmInicial;
    }

    public Character getTxDifEmp() {
        return txDifEmp;
    }

    public void setTxDifEmp(Character txDifEmp) {
        this.txDifEmp = txDifEmp;
    }

    public Double getImCosteEmp() {
        return imCosteEmp;
    }

    public void setImCosteEmp(Double imCosteEmp) {
        this.imCosteEmp = imCosteEmp;
    }

    public Double getHmEmpr() {
        return hmEmpr;
    }

    public void setHmEmpr(Double hmEmpr) {
        this.hmEmpr = hmEmpr;
    }

    public String getTxComTipifEmp() {
        return txComTipifEmp;
    }

    public void setTxComTipifEmp(String txComTipifEmp) {
        this.txComTipifEmp = txComTipifEmp;
    }

    public String getTxFactSN() {
        return txFactSN;
    }

    public void setTxFactSN(String txFactSN) {
        this.txFactSN = txFactSN;
    }

    public String getTxComTipifProy() {
        return txComTipifProy;
    }

    public void setTxComTipifProy(String txComTipifProy) {
        this.txComTipifProy = txComTipifProy;
    }

    public Thge006Tipologia getCdTipologiaEmp() {
        return cdTipologiaEmp;
    }

    public void setCdTipologiaEmp(Thge006Tipologia cdTipologiaEmp) {
        this.cdTipologiaEmp = cdTipologiaEmp;
    }

    public Thge005Estado getStModificacion() {
        return stModificacion;
    }

    public void setStModificacion(Thge005Estado stModificacion) {
        this.stModificacion = stModificacion;
    }

    public Thge005Estado getStTipif() {
        return stTipif;
    }

    public void setStTipif(Thge005Estado stTipif) {
        this.stTipif = stTipif;
    }

    public Thge006Tipologia getCdTipologiaIni() {
        return cdTipologiaIni;
    }

    public void setCdTipologiaIni(Thge006Tipologia cdTipologiaIni) {
        this.cdTipologiaIni = cdTipologiaIni;
    }

    public Thge009Componente getCdComponente() {
        return cdComponente;
    }

    public void setCdComponente(Thge009Componente cdComponente) {
        this.cdComponente = cdComponente;
    }

    public Thge011Usuario getCdUsuPeticion() {
        return cdUsuPeticion;
    }

    public void setCdUsuPeticion(Thge011Usuario cdUsuPeticion) {
        this.cdUsuPeticion = cdUsuPeticion;
    }

    public Thge011Usuario getCdRespResol() {
        return cdRespResol;
    }

    public void setCdRespResol(Thge011Usuario cdRespResol) {
        this.cdRespResol = cdRespResol;
    }

    public Thge015Prioridad getCdPrioridadUsu() {
        return cdPrioridadUsu;
    }

    public void setCdPrioridadUsu(Thge015Prioridad cdPrioridadUsu) {
        this.cdPrioridadUsu = cdPrioridadUsu;
    }

    public Thge019Origen getCdOrigen() {
        return cdOrigen;
    }

    public void setCdOrigen(Thge019Origen cdOrigen) {
        this.cdOrigen = cdOrigen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdModificacion != null ? cdModificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge026Modif)) {
            return false;
        }
        Thge026Modif other = (Thge026Modif) object;
        if ((this.cdModificacion == null && other.cdModificacion != null) || (this.cdModificacion != null && !this.cdModificacion.equals(other.cdModificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge026Modif[ cdModificacion=" + cdModificacion + " ]";
    }
    
}
