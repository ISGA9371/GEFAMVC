/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Guevara Manuel
 */
@Entity
@Table(name = "thge039_factura")
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_FACTURA", nullable = false)
    private Integer invoiceId;
    @Column(name = "FH_CORTE", nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date invoiceCutDate;
    @Column(name = "IM_TARIFA", nullable = false)
    private double invoiceRate;
    @Column(name = "IM_MONTO", precision = 22)
    private Double invoiceAmount;
    @Column(name = "TX_ACTIVO_FIJO", length = 12)
    private String invoiceFixedAsset;
    @Column(name = "TX_AVISO_PROV", length = 50)
    private String invoiceNotice;
    @Column(name = "FH_ENVIO_IMPLANT")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date invoiceSendDate;
    @Column(name = "NB_GLG", length = 23)
    private String invoiceNameGlg;
    @Column(name = "FH_REG_PAGO_GEST")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date invoiceManagerPaymentDate;
    @Column(name = "TX_OBSERVACION", length = 500)
    private String invoiceNote;
    @Column(name = "NU_FACT_PROV", length = 50)
    private String invoiceTempNumber;
    @Column(name = "IM_FACT", precision = 22)
    private Double invoiceValue;
    @Column(name = "FH_INGRESO_FACT")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date invoiceInDate;
    @Column(name = "TX_VIA_INGRESO", length = 25)
    private String invoiceEntryWay;
    @Column(name = "TX_SEM_PRES_SUF")
    private Integer txSemPresSuf;
    @Column(name = "TX_SEM_PER_SUBD")
    private Integer invoiceSubPrincipalBudget;
    @Column(name = "TX_SEM_TP_PRES")
    private Integer invoiceBudgetType;
    @Column(name = "TX_SEM_SUBD_CORR")
    private Integer invoiceAnsBudget;
    @JoinColumn(name = "ST_PEP_FACT", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status statusBudget;
    @JoinColumn(name = "ST_PAGO", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status status;
    @JoinColumn(name = "ST_FACT_HRS_PROY", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status statusHours;
    @JoinColumn(name = "CD_REQUERIMIENTO", referencedColumnName = "CD_REQUERIMIENTO", nullable = false)
    @ManyToOne(optional = false)
    private Requirement requirement;
    @JoinColumn(name = "CD_PEP_REQ", referencedColumnName = "CD_PEP_REQ", nullable = false)
    @ManyToOne(optional = false)
    private BudgetRequirement budgetRequirement;
    @JoinColumn(name = "CD_CTA_OPER", referencedColumnName = "CD_CTA_OPER")
    @ManyToOne
    private OperatingAccount operatingAccount;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoice")
    private List<Payment> payments;

    public Invoice() {
    }

    public Invoice(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Invoice(Integer invoiceId, Date invoiceCutDate, double invoiceRate) {
        this.invoiceId = invoiceId;
        this.invoiceCutDate = invoiceCutDate;
        this.invoiceRate = invoiceRate;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Date getInvoiceCutDate() {
        return invoiceCutDate;
    }

    public void setInvoiceCutDate(Date invoiceCutDate) {
        this.invoiceCutDate = invoiceCutDate;
    }

    public double getInvoiceRate() {
        return invoiceRate;
    }

    public void setInvoiceRate(double invoiceRate) {
        this.invoiceRate = invoiceRate;
    }

    public Double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(Double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public String getInvoiceFixedAsset() {
        return invoiceFixedAsset;
    }

    public void setInvoiceFixedAsset(String invoiceFixedAsset) {
        this.invoiceFixedAsset = invoiceFixedAsset;
    }

    public String getInvoiceNotice() {
        return invoiceNotice;
    }

    public void setInvoiceNotice(String invoiceNotice) {
        this.invoiceNotice = invoiceNotice;
    }

    public Date getInvoiceSendDate() {
        return invoiceSendDate;
    }

    public void setInvoiceSendDate(Date invoiceSendDate) {
        this.invoiceSendDate = invoiceSendDate;
    }

    public String getInvoiceNameGlg() {
        return invoiceNameGlg;
    }

    public void setInvoiceNameGlg(String invoiceNameGlg) {
        this.invoiceNameGlg = invoiceNameGlg;
    }

    public Date getInvoiceManagerPaymentDate() {
        return invoiceManagerPaymentDate;
    }

    public void setInvoiceManagerPaymentDate(Date invoiceManagerPaymentDate) {
        this.invoiceManagerPaymentDate = invoiceManagerPaymentDate;
    }

    public String getInvoiceNote() {
        return invoiceNote;
    }

    public void setInvoiceNote(String invoiceNote) {
        this.invoiceNote = invoiceNote;
    }

    public String getInvoiceTempNumber() {
        return invoiceTempNumber;
    }

    public void setInvoiceTempNumber(String invoiceTempNumber) {
        this.invoiceTempNumber = invoiceTempNumber;
    }

    public Double getInvoiceValue() {
        return invoiceValue;
    }

    public void setInvoiceValue(Double invoiceValue) {
        this.invoiceValue = invoiceValue;
    }

    public Date getInvoiceInDate() {
        return invoiceInDate;
    }

    public void setInvoiceInDate(Date invoiceInDate) {
        this.invoiceInDate = invoiceInDate;
    }

    public String getInvoiceEntryWay() {
        return invoiceEntryWay;
    }

    public void setInvoiceEntryWay(String invoiceEntryWay) {
        this.invoiceEntryWay = invoiceEntryWay;
    }

    public Integer getTxSemPresSuf() {
        return txSemPresSuf;
    }

    public void setTxSemPresSuf(Integer txSemPresSuf) {
        this.txSemPresSuf = txSemPresSuf;
    }

    public Integer getInvoiceSubPrincipalBudget() {
        return invoiceSubPrincipalBudget;
    }

    public void setInvoiceSubPrincipalBudget(Integer invoiceSubPrincipalBudget) {
        this.invoiceSubPrincipalBudget = invoiceSubPrincipalBudget;
    }

    public Integer getInvoiceBudgetType() {
        return invoiceBudgetType;
    }

    public void setInvoiceBudgetType(Integer invoiceBudgetType) {
        this.invoiceBudgetType = invoiceBudgetType;
    }

    public Integer getInvoiceAnsBudget() {
        return invoiceAnsBudget;
    }

    public void setInvoiceAnsBudget(Integer invoiceAnsBudget) {
        this.invoiceAnsBudget = invoiceAnsBudget;
    }

    public Status getStatusBudget() {
        return statusBudget;
    }

    public void setStatusBudget(Status statusBudget) {
        this.statusBudget = statusBudget;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatusHours() {
        return statusHours;
    }

    public void setStatusHours(Status statusHours) {
        this.statusHours = statusHours;
    }

    public Requirement getRequirement() {
        return requirement;
    }

    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }

    public BudgetRequirement getBudgetRequirement() {
        return budgetRequirement;
    }

    public void setBudgetRequirement(BudgetRequirement budgetRequirement) {
        this.budgetRequirement = budgetRequirement;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public OperatingAccount getOperatingAccount() {
        return operatingAccount;
    }

    public void setOperatingAccount(OperatingAccount operatingAccount) {
        this.operatingAccount = operatingAccount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceId != null ? invoiceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        return (this.invoiceId != null || other.invoiceId == null) && (this.invoiceId == null || this.invoiceId.equals(other.invoiceId));
    }

    @Override
    public String toString() {
        return "com.bbva.Invoice[ invoiceId=" + invoiceId + " ]";
    }

}
