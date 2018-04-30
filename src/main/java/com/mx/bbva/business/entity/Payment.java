/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Guevara Manuel
 */
@Entity
@Table(name = "thge041_seg_pago", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CD_SEG_PAGO"})})
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_SEG_PAGO", nullable = false)
    private Integer paymentId;
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
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date paymentReceptionDate;
    @Column(name = "FH_AVISO_PROV")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date paymentAlertDate;
    @JoinColumn(name = "CD_FACTURA", referencedColumnName = "CD_FACTURA", nullable = false)
    @ManyToOne(optional = false)
    private Invoice invoice;

    public Payment() {
    }

    public Payment(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
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

    public Date getPaymentAlertDate() {
        return paymentAlertDate;
    }

    public void setPaymentAlertDate(Date paymentAlertDate) {
        this.paymentAlertDate = paymentAlertDate;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        return paymentId.equals(payment.paymentId);
    }

    @Override
    public int hashCode() {
        return paymentId.hashCode();
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                '}';
    }
}
