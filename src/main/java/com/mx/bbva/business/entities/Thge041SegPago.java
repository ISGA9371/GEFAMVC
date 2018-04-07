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
@Table(name = "thge041_seg_pago", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge041SegPago.findAll", query = "SELECT t FROM Thge041SegPago t")})
public class Thge041SegPago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_SEG_PAGO")
    private String cdSegPago;
    @Column(name = "NU_POS_SOL_PEDIDO")
    private Integer nuPosSolPedido;
    @Column(name = "NU_PEDIDO")
    private String nuPedido;
    @Column(name = "NU_POSICION_PED")
    private Integer nuPosicionPed;
    @Column(name = "NU_HOJA_ENTRADA")
    private String nuHojaEntrada;
    @Basic(optional = false)
    @Column(name = "NU_RECEPCION")
    private String nuRecepcion;
    @Column(name = "FH_RECEPCION")
    @Temporal(TemporalType.DATE)
    private Date fhRecepcion;
    @OneToMany(mappedBy = "cdSegPago")
    private List<Thge039Factura> thge039FacturaList;

    public Thge041SegPago() {
    }

    public Thge041SegPago(String cdSegPago) {
        this.cdSegPago = cdSegPago;
    }

    public Thge041SegPago(String cdSegPago, String nuRecepcion) {
        this.cdSegPago = cdSegPago;
        this.nuRecepcion = nuRecepcion;
    }

    public String getCdSegPago() {
        return cdSegPago;
    }

    public void setCdSegPago(String cdSegPago) {
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

    public List<Thge039Factura> getThge039FacturaList() {
        return thge039FacturaList;
    }

    public void setThge039FacturaList(List<Thge039Factura> thge039FacturaList) {
        this.thge039FacturaList = thge039FacturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdSegPago != null ? cdSegPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge041SegPago)) {
            return false;
        }
        Thge041SegPago other = (Thge041SegPago) object;
        if ((this.cdSegPago == null && other.cdSegPago != null) || (this.cdSegPago != null && !this.cdSegPago.equals(other.cdSegPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge041SegPago[ cdSegPago=" + cdSegPago + " ]";
    }
    
}
