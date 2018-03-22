/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbva.bancomer.business.model;

import com.google.appengine.repackaged.org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Guevara
 */
@Entity
@Table(name = "THGE041_seg_pago", catalog = "gestion_factoria", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CD_SEG_PAGO"})})
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_CONS_SEG_PAGO", nullable = false)
    private Integer paymentSerial;
    @Basic(optional = false)
    @Column(name = "CD_SEG_PAGO", nullable = false)
    private int paymentId;
    @Column(name = "NU_POS_SOL_PEDIDO")
    private Integer paymentPosition;
    @Column(name = "NU_PEDIDO", length = 10)
    private String paymentOrder;
    @Column(name = "NU_POSICION_PED")
    private Integer paymentOrderPosition;
    @Column(name = "NU_HOJA_ENTRADA", length = 10)
    private String paymentInPaper;
    @Column(name = "NU_RECEPCION", length = 10)
    private String paymentReception;
    @Column(name = "FH_RECEPCION")
    @Temporal(TemporalType.DATE)
    private Date paymentReceptionDate;
    @JsonIgnore
    @OneToMany(mappedBy = "payment")
    private List<Invoice> invoices;

    public Payment() {
    }

    public Payment(Integer paymentSerial) {
        this.paymentSerial = paymentSerial;
    }

    public Payment(Integer paymentSerial, int paymentId) {
        this.paymentSerial = paymentSerial;
        this.paymentId = paymentId;
    }

    public Integer getPaymentSerial() {
        return paymentSerial;
    }

    public void setPaymentSerial(Integer paymentSerial) {
        this.paymentSerial = paymentSerial;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getPaymentPosition() {
        return paymentPosition;
    }

    public void setPaymentPosition(Integer paymentPosition) {
        this.paymentPosition = paymentPosition;
    }

    public String getPaymentOrder() {
        return paymentOrder;
    }

    public void setPaymentOrder(String paymentOrder) {
        this.paymentOrder = paymentOrder;
    }

    public Integer getPaymentOrderPosition() {
        return paymentOrderPosition;
    }

    public void setPaymentOrderPosition(Integer paymentOrderPosition) {
        this.paymentOrderPosition = paymentOrderPosition;
    }

    public String getPaymentInPaper() {
        return paymentInPaper;
    }

    public void setPaymentInPaper(String paymentInPaper) {
        this.paymentInPaper = paymentInPaper;
    }

    public String getPaymentReception() {
        return paymentReception;
    }

    public void setPaymentReception(String paymentReception) {
        this.paymentReception = paymentReception;
    }

    public Date getPaymentReceptionDate() {
        return paymentReceptionDate;
    }

    public void setPaymentReceptionDate(Date paymentReceptionDate) {
        this.paymentReceptionDate = paymentReceptionDate;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentSerial != null ? paymentSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        return (this.paymentSerial != null || other.paymentSerial == null) && (this.paymentSerial == null || this.paymentSerial.equals(other.paymentSerial));
    }

    @Override
    public String toString() {
        return "com.bbva.Payment[ paymentSerial=" + paymentSerial + " ]";
    }

}
