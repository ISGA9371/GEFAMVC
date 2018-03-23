/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbva.bancomer.business.model;

import com.google.appengine.repackaged.org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Guevara
 */
@Entity
@Table(name = "THGE055_cta_oper",  uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NU_CTA_OPERATIVA"})
        , @UniqueConstraint(columnNames = {"CD_CTA_OPER"})})
public class OperatingAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_CONS_CTA_OPER", nullable = false)
    private Integer operatingAccountSerial;
    @Basic(optional = false)
    @Column(name = "CD_CTA_OPER", nullable = false)
    private int operatingAccountId;
    @Basic(optional = false)
    @Column(name = "NU_CTA_OPERATIVA", nullable = false, length = 8)
    private String operatingAccountValue;
    @JsonIgnore
    @OneToMany(mappedBy = "operatingAccount")
    private List<Invoice> invoices;

    public OperatingAccount() {
    }

    public OperatingAccount(Integer operatingAccountSerial) {
        this.operatingAccountSerial = operatingAccountSerial;
    }

    public OperatingAccount(Integer operatingAccountSerial, int operatingAccountId, String operatingAccountValue) {
        this.operatingAccountSerial = operatingAccountSerial;
        this.operatingAccountId = operatingAccountId;
        this.operatingAccountValue = operatingAccountValue;
    }

    public Integer getOperatingAccountSerial() {
        return operatingAccountSerial;
    }

    public void setOperatingAccountSerial(Integer operatingAccountSerial) {
        this.operatingAccountSerial = operatingAccountSerial;
    }

    public int getOperatingAccountId() {
        return operatingAccountId;
    }

    public void setOperatingAccountId(int operatingAccountId) {
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
    public int hashCode() {
        int hash = 0;
        hash += (operatingAccountSerial != null ? operatingAccountSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof OperatingAccount)) {
            return false;
        }
        OperatingAccount other = (OperatingAccount) object;
        return (this.operatingAccountSerial != null || other.operatingAccountSerial == null) && (this.operatingAccountSerial == null || this.operatingAccountSerial.equals(other.operatingAccountSerial));
    }

    @Override
    public String toString() {
        return "com.bbva.OperatingAccount[ operatingAccountSerial=" + operatingAccountSerial + " ]";
    }

}
