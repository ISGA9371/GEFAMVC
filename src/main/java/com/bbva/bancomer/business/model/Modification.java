/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbva.bancomer.business.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Guevara
 */
@Entity
@Table(name = "thge026_modif", catalog = "gestion_factoria", schema = "")
@NamedQueries({
        @NamedQuery(name = "Modification.findAll", query = "SELECT t FROM Modification t")})
public class Modification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_MODIFICACION", nullable = false)
    private Integer cdModificacion;
    @Basic(optional = false)
    @Column(name = "TX_MOD_EN_VUELO", nullable = false, length = 2)
    private String txModEnVuelo;
    @Basic(optional = false)
    @Column(name = "TX_MOD_RZDA_DYD", nullable = false, length = 2)
    private String txModRzdaDyd;
    @Column(name = "NB_DESC_MODIF", length = 1000)
    private String nbDescModif;
    @Basic(optional = false)
    @Column(name = "FH_ENVIO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fhEnvio;
    @Column(name = "FH_PREV_FINAL")
    @Temporal(TemporalType.DATE)
    private Date fhPrevFinal;
    @Column(name = "FH_RENEGOCIADA")
    @Temporal(TemporalType.DATE)
    private Date fhRenegociada;
    @Basic(optional = false)
    @Column(name = "FH_CIERRE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fhCierre;
    @Column(name = "TX_COMENT_MOD", length = 250)
    private String txComentMod;
    @Column(name = "TX_DIFICULTAD_INI")
    private Character txDificultadIni;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "IM_COSTE_INIC", precision = 22)
    private Double imCosteInic;
    @Column(name = "CT_HORAS_INIC", precision = 22)
    private Double ctHorasInic;
    @Column(name = "TX_DIF_EMP")
    private Character txDifEmp;
    @Column(name = "IM_COSTE_EMP", precision = 22)
    private Double imCosteEmp;
    @Column(name = "CT_HORAS_EMP", precision = 22)
    private Double ctHorasEmp;
    @Column(name = "THGE026_MODIFcol", length = 45)
    private String tHGE026MODIFcol;
    @Column(name = "TX_COM_TIPIF_EMP", length = 500)
    private String txComTipifEmp;
    @Column(name = "TX_COM_TIPIF_PROY", length = 500)
    private String txComTipifProy;
    @Basic(optional = false)
    @Column(name = "TX_FACT_S_N", nullable = false, length = 2)
    private String txFactSN;
    @Column(name = "TX_MES_FACT", length = 10)
    private String txMesFact;
    @Column(name = "NU_ANO_FACT")
    private Integer nuAnoFact;
    @JoinColumn(name = "ST_MODIFICACION", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status stModificacion;
    @JoinColumn(name = "ST_TIPIF", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status stTipif;
    @JoinColumn(name = "CD_COMPONENTE", referencedColumnName = "CD_COMPONENTE", nullable = false)
    @ManyToOne(optional = false)
    private Component cdComponent;
    @JoinColumn(name = "CD_USU_PETICION", referencedColumnName = "CD_USUARIO_CORP", nullable = false)
    @ManyToOne(optional = false)
    private User cdUsuPeticion;
    @JoinColumn(name = "CD_RESP_RESOL", referencedColumnName = "CD_USUARIO_CORP", nullable = false)
    @ManyToOne(optional = false)
    private User cdRespResol;
    @JoinColumn(name = "CD_PRIORIDAD_USU", referencedColumnName = "CD_PRIORIDAD", nullable = false)
    @ManyToOne(optional = false)
    private Priority cdPriorityUsu;
    @JoinColumn(name = "CD_ORIGEN", referencedColumnName = "CD_ORIGEN", nullable = false)
    @ManyToOne(optional = false)
    private Origin cdOrigin;

    public Modification() {
    }

    public Modification(Integer cdModificacion) {
        this.cdModificacion = cdModificacion;
    }

    public Modification(Integer cdModificacion, String txModEnVuelo, String txModRzdaDyd, Date fhEnvio, Date fhCierre, String txFactSN) {
        this.cdModificacion = cdModificacion;
        this.txModEnVuelo = txModEnVuelo;
        this.txModRzdaDyd = txModRzdaDyd;
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

    public Double getCtHorasInic() {
        return ctHorasInic;
    }

    public void setCtHorasInic(Double ctHorasInic) {
        this.ctHorasInic = ctHorasInic;
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

    public Double getCtHorasEmp() {
        return ctHorasEmp;
    }

    public void setCtHorasEmp(Double ctHorasEmp) {
        this.ctHorasEmp = ctHorasEmp;
    }

    public String getTHGE026MODIFcol() {
        return tHGE026MODIFcol;
    }

    public void setTHGE026MODIFcol(String tHGE026MODIFcol) {
        this.tHGE026MODIFcol = tHGE026MODIFcol;
    }

    public String getTxComTipifEmp() {
        return txComTipifEmp;
    }

    public void setTxComTipifEmp(String txComTipifEmp) {
        this.txComTipifEmp = txComTipifEmp;
    }

    public String getTxComTipifProy() {
        return txComTipifProy;
    }

    public void setTxComTipifProy(String txComTipifProy) {
        this.txComTipifProy = txComTipifProy;
    }

    public String getTxFactSN() {
        return txFactSN;
    }

    public void setTxFactSN(String txFactSN) {
        this.txFactSN = txFactSN;
    }

    public String getTxMesFact() {
        return txMesFact;
    }

    public void setTxMesFact(String txMesFact) {
        this.txMesFact = txMesFact;
    }

    public Integer getNuAnoFact() {
        return nuAnoFact;
    }

    public void setNuAnoFact(Integer nuAnoFact) {
        this.nuAnoFact = nuAnoFact;
    }

    public Status getStModificacion() {
        return stModificacion;
    }

    public void setStModificacion(Status stModificacion) {
        this.stModificacion = stModificacion;
    }

    public Status getStTipif() {
        return stTipif;
    }

    public void setStTipif(Status stTipif) {
        this.stTipif = stTipif;
    }

    public Component getCdComponent() {
        return cdComponent;
    }

    public void setCdComponent(Component cdComponent) {
        this.cdComponent = cdComponent;
    }

    public User getCdUsuPeticion() {
        return cdUsuPeticion;
    }

    public void setCdUsuPeticion(User cdUsuPeticion) {
        this.cdUsuPeticion = cdUsuPeticion;
    }

    public User getCdRespResol() {
        return cdRespResol;
    }

    public void setCdRespResol(User cdRespResol) {
        this.cdRespResol = cdRespResol;
    }

    public Priority getCdPriorityUsu() {
        return cdPriorityUsu;
    }

    public void setCdPriorityUsu(Priority cdPriorityUsu) {
        this.cdPriorityUsu = cdPriorityUsu;
    }

    public Origin getCdOrigin() {
        return cdOrigin;
    }

    public void setCdOrigin(Origin cdOrigin) {
        this.cdOrigin = cdOrigin;
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
        if (!(object instanceof Modification)) {
            return false;
        }
        Modification other = (Modification) object;
        if ((this.cdModificacion == null && other.cdModificacion != null) || (this.cdModificacion != null && !this.cdModificacion.equals(other.cdModificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Modification[ cdModificacion=" + cdModificacion + " ]";
    }

}
