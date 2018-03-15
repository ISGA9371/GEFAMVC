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
@Table(name = "thge041_seg_pago", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CD_SEG_PAGO"})})
@NamedQueries({
        @NamedQuery(name = "Payment.findAll", query = "SELECT t FROM Payment t")})
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_CONS_SEG_PAGO", nullable = false)
    private Integer cdConsSegPago;
    @Basic(optional = false)
    @Column(name = "CD_SEG_PAGO", nullable = false)
    private int cdSegPago;
    @Column(name = "NU_POS_SOL_PEDIDO")
    private Integer nuPosSolPedido;
    @Column(name = "NU_PEDIDO", length = 10)
    private String nuPedido;
    @Column(name = "NU_POSICION_PED")
    private Integer nuPosicionPed;
    @Column(name = "NU_HOJA_ENTRADA", length = 10)
    private String nuHojaEntrada;
    @Column(name = "NU_RECEPCION", length = 10)
    private String nuRecepcion;
    @Column(name = "FH_RECEPCION")
    @Temporal(TemporalType.DATE)
    private Date fhRecepcion;
    @OneToMany(mappedBy = "cdSegPago")
    private List<Invoice> invoiceList;

    public Payment() {
    }

    public Payment(Integer cdConsSegPago) {
        this.cdConsSegPago = cdConsSegPago;
    }

    public Payment(Integer cdConsSegPago, int cdSegPago) {
        this.cdConsSegPago = cdConsSegPago;
        this.cdSegPago = cdSegPago;
    }

    public Integer getCdConsSegPago() {
        return cdConsSegPago;
    }

    public void setCdConsSegPago(Integer cdConsSegPago) {
        this.cdConsSegPago = cdConsSegPago;
    }

    public int getCdSegPago() {
        return cdSegPago;
    }

    public void setCdSegPago(int cdSegPago) {
        this.cdSegPago = cdSegPago;
    }

    public Integer getNuPosSolPedido() {
        return nuPosSolPedido;
    }

    public void setNuPosSolPedido(Integer nuPosSolPedido) {
        this.nuPosSolPedido = nuPosSolPedido;
    }

    public String getNuPedido() {
        return nuPedido;
    }

    public void setNuPedido(String nuPedido) {
        this.nuPedido = nuPedido;
    }

    public Integer getNuPosicionPed() {
        return nuPosicionPed;
    }

    public void setNuPosicionPed(Integer nuPosicionPed) {
        this.nuPosicionPed = nuPosicionPed;
    }

    public String getNuHojaEntrada() {
        return nuHojaEntrada;
    }

    public void setNuHojaEntrada(String nuHojaEntrada) {
        this.nuHojaEntrada = nuHojaEntrada;
    }

    public String getNuRecepcion() {
        return nuRecepcion;
    }

    public void setNuRecepcion(String nuRecepcion) {
        this.nuRecepcion = nuRecepcion;
    }

    public Date getFhRecepcion() {
        return fhRecepcion;
    }

    public void setFhRecepcion(Date fhRecepcion) {
        this.fhRecepcion = fhRecepcion;
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdConsSegPago != null ? cdConsSegPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.cdConsSegPago == null && other.cdConsSegPago != null) || (this.cdConsSegPago != null && !this.cdConsSegPago.equals(other.cdConsSegPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Payment[ cdConsSegPago=" + cdConsSegPago + " ]";
    }

}
