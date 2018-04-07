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
@Table(name = "thge039_factura", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge039Factura.findAll", query = "SELECT t FROM Thge039Factura t")})
public class Thge039Factura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_FACTURA")
    private Integer cdFactura;
    @Basic(optional = false)
    @Column(name = "FH_CORTE")
    @Temporal(TemporalType.DATE)
    private Date fhCorte;
    @Basic(optional = false)
    @Column(name = "IM_TARIFA")
    private double imTarifa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "IM_MONTO")
    private Double imMonto;
    @Column(name = "TX_ACTIVO_FIJO")
    private String txActivoFijo;
    @Column(name = "CD_CTA_OPER")
    private Integer cdCtaOper;
    @Column(name = "TX_AVISO_PROV")
    private String txAvisoProv;
    @Column(name = "FH_ENVIO_IMPLANT")
    @Temporal(TemporalType.DATE)
    private Date fhEnvioImplant;
    @Column(name = "NB_GLG")
    private String nbGlg;
    @Column(name = "FH_REG_PAGO_GEST")
    @Temporal(TemporalType.DATE)
    private Date fhRegPagoGest;
    @Column(name = "TX_OBSERVACION")
    private String txObservacion;
    @Column(name = "NU_FACT_PROV")
    private String nuFactProv;
    @Column(name = "IM_FACT")
    private Double imFact;
    @Column(name = "FH_INGRESO_FACT")
    @Temporal(TemporalType.DATE)
    private Date fhIngresoFact;
    @Column(name = "TX_VIA_INGRESO")
    private String txViaIngreso;
    @Column(name = "TX_SEM_PRES_SUF")
    private Integer txSemPresSuf;
    @Column(name = "TX_SEM_PER_SUBD")
    private Integer txSemPerSubd;
    @Column(name = "TX_SEM_TP_PRES")
    private Integer txSemTpPres;
    @Column(name = "TX_SEM_SUBD_CORR")
    private Integer txSemSubdCorr;
    @JoinColumn(name = "ST_PEP_FACT", referencedColumnName = "CD_ESTADO")
    @ManyToOne(optional = false)
    private Thge005Estado stPepFact;
    @JoinColumn(name = "ST_PAGO", referencedColumnName = "CD_ESTADO")
    @ManyToOne(optional = false)
    private Thge005Estado stPago;
    @JoinColumn(name = "ST_FACT_HRS_PROY", referencedColumnName = "CD_ESTADO")
    @ManyToOne(optional = false)
    private Thge005Estado stFactHrsProy;
    @JoinColumn(name = "CD_REQUERIMIENTO", referencedColumnName = "CD_REQUERIMIENTO")
    @ManyToOne(optional = false)
    private Thge017Requerim cdRequerimiento;
    @JoinColumn(name = "CD_PEP_REQ", referencedColumnName = "CD_PEP_REQ")
    @ManyToOne(optional = false)
    private Thge040PepReq cdPepReq;
    @JoinColumn(name = "CD_SEG_PAGO", referencedColumnName = "CD_SEG_PAGO")
    @ManyToOne
    private Thge041SegPago cdSegPago;

    public Thge039Factura() {
    }

    public Thge039Factura(Integer cdFactura) {
        this.cdFactura = cdFactura;
    }

    public Thge039Factura(Integer cdFactura, Date fhCorte, double imTarifa) {
        this.cdFactura = cdFactura;
        this.fhCorte = fhCorte;
        this.imTarifa = imTarifa;
    }

    public Integer getCdFactura() {
        return cdFactura;
    }

    public void setCdFactura(Integer cdFactura) {
        this.cdFactura = cdFactura;
    }

    public Date getFhCorte() {
        return fhCorte;
    }

    public void setFhCorte(Date fhCorte) {
        this.fhCorte = fhCorte;
    }

    public double getImTarifa() {
        return imTarifa;
    }

    public void setImTarifa(double imTarifa) {
        this.imTarifa = imTarifa;
    }

    public Double getImMonto() {
        return imMonto;
    }

    public void setImMonto(Double imMonto) {
        this.imMonto = imMonto;
    }

    public String getTxActivoFijo() {
        return txActivoFijo;
    }

    public void setTxActivoFijo(String txActivoFijo) {
        this.txActivoFijo = txActivoFijo;
    }

    public Integer getCdCtaOper() {
        return cdCtaOper;
    }

    public void setCdCtaOper(Integer cdCtaOper) {
        this.cdCtaOper = cdCtaOper;
    }

    public String getTxAvisoProv() {
        return txAvisoProv;
    }

    public void setTxAvisoProv(String txAvisoProv) {
        this.txAvisoProv = txAvisoProv;
    }

    public Date getFhEnvioImplant() {
        return fhEnvioImplant;
    }

    public void setFhEnvioImplant(Date fhEnvioImplant) {
        this.fhEnvioImplant = fhEnvioImplant;
    }

    public String getNbGlg() {
        return nbGlg;
    }

    public void setNbGlg(String nbGlg) {
        this.nbGlg = nbGlg;
    }

    public Date getFhRegPagoGest() {
        return fhRegPagoGest;
    }

    public void setFhRegPagoGest(Date fhRegPagoGest) {
        this.fhRegPagoGest = fhRegPagoGest;
    }

    public String getTxObservacion() {
        return txObservacion;
    }

    public void setTxObservacion(String txObservacion) {
        this.txObservacion = txObservacion;
    }

    public String getNuFactProv() {
        return nuFactProv;
    }

    public void setNuFactProv(String nuFactProv) {
        this.nuFactProv = nuFactProv;
    }

    public Double getImFact() {
        return imFact;
    }

    public void setImFact(Double imFact) {
        this.imFact = imFact;
    }

    public Date getFhIngresoFact() {
        return fhIngresoFact;
    }

    public void setFhIngresoFact(Date fhIngresoFact) {
        this.fhIngresoFact = fhIngresoFact;
    }

    public String getTxViaIngreso() {
        return txViaIngreso;
    }

    public void setTxViaIngreso(String txViaIngreso) {
        this.txViaIngreso = txViaIngreso;
    }

    public Integer getTxSemPresSuf() {
        return txSemPresSuf;
    }

    public void setTxSemPresSuf(Integer txSemPresSuf) {
        this.txSemPresSuf = txSemPresSuf;
    }

    public Integer getTxSemPerSubd() {
        return txSemPerSubd;
    }

    public void setTxSemPerSubd(Integer txSemPerSubd) {
        this.txSemPerSubd = txSemPerSubd;
    }

    public Integer getTxSemTpPres() {
        return txSemTpPres;
    }

    public void setTxSemTpPres(Integer txSemTpPres) {
        this.txSemTpPres = txSemTpPres;
    }

    public Integer getTxSemSubdCorr() {
        return txSemSubdCorr;
    }

    public void setTxSemSubdCorr(Integer txSemSubdCorr) {
        this.txSemSubdCorr = txSemSubdCorr;
    }

    public Thge005Estado getStPepFact() {
        return stPepFact;
    }

    public void setStPepFact(Thge005Estado stPepFact) {
        this.stPepFact = stPepFact;
    }

    public Thge005Estado getStPago() {
        return stPago;
    }

    public void setStPago(Thge005Estado stPago) {
        this.stPago = stPago;
    }

    public Thge005Estado getStFactHrsProy() {
        return stFactHrsProy;
    }

    public void setStFactHrsProy(Thge005Estado stFactHrsProy) {
        this.stFactHrsProy = stFactHrsProy;
    }

    public Thge017Requerim getCdRequerimiento() {
        return cdRequerimiento;
    }

    public void setCdRequerimiento(Thge017Requerim cdRequerimiento) {
        this.cdRequerimiento = cdRequerimiento;
    }

    public Thge040PepReq getCdPepReq() {
        return cdPepReq;
    }

    public void setCdPepReq(Thge040PepReq cdPepReq) {
        this.cdPepReq = cdPepReq;
    }

    public Thge041SegPago getCdSegPago() {
        return cdSegPago;
    }

    public void setCdSegPago(Thge041SegPago cdSegPago) {
        this.cdSegPago = cdSegPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdFactura != null ? cdFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge039Factura)) {
            return false;
        }
        Thge039Factura other = (Thge039Factura) object;
        if ((this.cdFactura == null && other.cdFactura != null) || (this.cdFactura != null && !this.cdFactura.equals(other.cdFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge039Factura[ cdFactura=" + cdFactura + " ]";
    }
    
}
