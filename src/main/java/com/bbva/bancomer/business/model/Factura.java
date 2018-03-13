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
@Table(name = "thge039_factura", catalog = "gestion_factoria", schema = "")
@NamedQueries({
        @NamedQuery(name = "Factura.findAll", query = "SELECT t FROM Factura t")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_FACTURA", nullable = false)
    private Integer cdFactura;
    @Basic(optional = false)
    @Column(name = "FH_CORTE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fhCorte;
    @Basic(optional = false)
    @Column(name = "IM_TARIFA", nullable = false)
    private double imTarifa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "IM_MONTO", precision = 22)
    private Double imMonto;
    @Column(name = "TX_ACTIVO_FIJO", length = 12)
    private String txActivoFijo;
    @Column(name = "TX_AVISO_PROV", length = 50)
    private String txAvisoProv;
    @Column(name = "FH_ENVIO_IMPLANT")
    @Temporal(TemporalType.DATE)
    private Date fhEnvioImplant;
    @Column(name = "NB_GLG", length = 23)
    private String nbGlg;
    @Column(name = "FH_REG_PAGO_GEST")
    @Temporal(TemporalType.DATE)
    private Date fhRegPagoGest;
    @Column(name = "TX_OBSERVACION", length = 500)
    private String txObservacion;
    @Column(name = "NU_FACT_PROV", length = 50)
    private String nuFactProv;
    @Column(name = "IM_FACT", precision = 22)
    private Double imFact;
    @Column(name = "FH_INGRESO_FACT")
    @Temporal(TemporalType.DATE)
    private Date fhIngresoFact;
    @Column(name = "TX_VIA_INGRESO", length = 25)
    private String txViaIngreso;
    @Column(name = "TX_SEM_PRES_SUF")
    private Integer txSemPresSuf;
    @Column(name = "TX_SEM_PER_SUBD")
    private Integer txSemPerSubd;
    @Column(name = "TX_SEM_TP_PRES")
    private Integer txSemTpPres;
    @Column(name = "TX_SEM_SUBD_CORR")
    private Integer txSemSubdCorr;
    @JoinColumn(name = "ST_PEP_FACT", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Estado stPepFact;
    @JoinColumn(name = "ST_PAGO", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Estado stPago;
    @JoinColumn(name = "ST_FACT_HRS_PROY", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Estado stFactHrsProy;
    @JoinColumn(name = "CD_REQUERIMIENTO", referencedColumnName = "CD_REQUERIMIENTO", nullable = false)
    @ManyToOne(optional = false)
    private Requerim cdRequerimiento;
    @JoinColumn(name = "CD_PEP_REQ", referencedColumnName = "CD_PEP_REQ", nullable = false)
    @ManyToOne(optional = false)
    private PepReq cdPepReq;
    @JoinColumn(name = "CD_SEG_PAGO", referencedColumnName = "CD_SEG_PAGO")
    @ManyToOne
    private SegPago cdSegPago;
    @JoinColumn(name = "CD_CTA_OPER", referencedColumnName = "CD_CONS_CTA_OPER")
    @ManyToOne
    private CtaOper cdCtaOper;

    public Factura() {
    }

    public Factura(Integer cdFactura) {
        this.cdFactura = cdFactura;
    }

    public Factura(Integer cdFactura, Date fhCorte, double imTarifa) {
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

    public Estado getStPepFact() {
        return stPepFact;
    }

    public void setStPepFact(Estado stPepFact) {
        this.stPepFact = stPepFact;
    }

    public Estado getStPago() {
        return stPago;
    }

    public void setStPago(Estado stPago) {
        this.stPago = stPago;
    }

    public Estado getStFactHrsProy() {
        return stFactHrsProy;
    }

    public void setStFactHrsProy(Estado stFactHrsProy) {
        this.stFactHrsProy = stFactHrsProy;
    }

    public Requerim getCdRequerimiento() {
        return cdRequerimiento;
    }

    public void setCdRequerimiento(Requerim cdRequerimiento) {
        this.cdRequerimiento = cdRequerimiento;
    }

    public PepReq getCdPepReq() {
        return cdPepReq;
    }

    public void setCdPepReq(PepReq cdPepReq) {
        this.cdPepReq = cdPepReq;
    }

    public SegPago getCdSegPago() {
        return cdSegPago;
    }

    public void setCdSegPago(SegPago cdSegPago) {
        this.cdSegPago = cdSegPago;
    }

    public CtaOper getCdCtaOper() {
        return cdCtaOper;
    }

    public void setCdCtaOper(CtaOper cdCtaOper) {
        this.cdCtaOper = cdCtaOper;
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
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.cdFactura == null && other.cdFactura != null) || (this.cdFactura != null && !this.cdFactura.equals(other.cdFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Factura[ cdFactura=" + cdFactura + " ]";
    }

}
