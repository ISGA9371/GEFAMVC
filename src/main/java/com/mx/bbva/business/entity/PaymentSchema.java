/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author manug
 */
@Entity
@Table(name = "thge067_esq_pago")
public class PaymentSchema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_ESQUEMA_PAGO")
    private Integer paymentSchemaId;
    @Column(name = "NB_ESQ_PAGO")
    private String paymentSchemaName;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentSchema")
    private List<ExternalUser> externalUsers;

    public PaymentSchema() {
    }

    public PaymentSchema(Integer paymentSchemaId) {
        this.paymentSchemaId = paymentSchemaId;
    }

    public PaymentSchema(Integer paymentSchemaId, String paymentSchemaName) {
        this.paymentSchemaId = paymentSchemaId;
        this.paymentSchemaName = paymentSchemaName;
    }

    public Integer getPaymentSchemaId() {
        return paymentSchemaId;
    }

    public void setPaymentSchemaId(Integer paymentSchemaId) {
        this.paymentSchemaId = paymentSchemaId;
    }

    public String getPaymentSchemaName() {
        return paymentSchemaName;
    }

    public void setPaymentSchemaName(String paymentSchemaName) {
        this.paymentSchemaName = paymentSchemaName;
    }

    public List<ExternalUser> getExternalUsers() {
        return externalUsers;
    }

    public void setExternalUsers(List<ExternalUser> externalUsers) {
        this.externalUsers = externalUsers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentSchemaId != null ? paymentSchemaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentSchema)) {
            return false;
        }
        PaymentSchema other = (PaymentSchema) object;
        if ((this.paymentSchemaId == null && other.paymentSchemaId != null) || (this.paymentSchemaId != null && !this.paymentSchemaId.equals(other.paymentSchemaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.PaymentSchema[ paymentSchemaId=" + paymentSchemaId + " ]";
    }

}
