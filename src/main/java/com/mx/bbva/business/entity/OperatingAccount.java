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
 * @author Guevara Manuel
 */
@Entity
@Table(name = "thge055_cta_oper", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NU_CTA_OPERATIVA"})
        , @UniqueConstraint(columnNames = {"CD_CTA_OPER"})})
public class OperatingAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_CTA_OPER", nullable = false)
    private Integer operatingAccountId;
    @Column(name = "NU_CTA_OPERATIVA", nullable = false, length = 8)
    private String operatingAccountValue;
    @JsonIgnore
    @OneToMany(mappedBy = "operatingAccount")
    private List<Invoice> invoices;

    public OperatingAccount() {
    }

    public OperatingAccount(Integer operatingAccountId) {
        this.operatingAccountId = operatingAccountId;
    }

    public Integer getOperatingAccountId() {
        return operatingAccountId;
    }

    public void setOperatingAccountId(Integer operatingAccountId) {
        this.operatingAccountId = operatingAccountId;
    }

    public String getOperatingAccountValue() {
        return operatingAccountValue;
    }

    public void setOperatingAccountValue(String operatingAccountValue) {
        this.operatingAccountValue = operatingAccountValue;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OperatingAccount that = (OperatingAccount) o;

        return operatingAccountId.equals(that.operatingAccountId);
    }

    @Override
    public int hashCode() {
        return operatingAccountId.hashCode();
    }

    @Override
    public String toString() {
        return "OperatingAccount{" +
                "operatingAccountId=" + operatingAccountId +
                '}';
    }
}
