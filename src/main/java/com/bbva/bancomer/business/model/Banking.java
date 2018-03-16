/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbva.bancomer.business.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Guevara
 */
@Entity
@Table(name = "thge034_banca", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_BANCA"})})
public class Banking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_BANCA", nullable = false)
    private Integer bankingId;
    @Basic(optional = false)
    @Column(name = "NB_BANCA", nullable = false, length = 50)
    private String bankingName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "banking")
    private List<Budget> budgets;

    public Banking() {
    }

    public Banking(Integer bankingId) {
        this.bankingId = bankingId;
    }

    public Banking(Integer bankingId, String bankingName) {
        this.bankingId = bankingId;
        this.bankingName = bankingName;
    }

    public Integer getBankingId() {
        return bankingId;
    }

    public void setBankingId(Integer bankingId) {
        this.bankingId = bankingId;
    }

    public String getBankingName() {
        return bankingName;
    }

    public void setBankingName(String bankingName) {
        this.bankingName = bankingName;
    }

    public List<Budget> getBudgets() {
        return budgets;
    }

    public void setBudgets(List<Budget> budgets) {
        this.budgets = budgets;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bankingId != null ? bankingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Banking)) {
            return false;
        }
        Banking other = (Banking) object;
        return (this.bankingId != null || other.bankingId == null) && (this.bankingId == null || this.bankingId.equals(other.bankingId));
    }

    @Override
    public String toString() {
        return "com.bbva.Banking[ bankingId=" + bankingId + " ]";
    }

}
