/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Guevara Manuel
 */
@Entity
@Table(name = "thge023_solic_pep", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CD_SOLIC_PEP"})})
public class BudgetApplicant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_SOLIC_PEP", nullable = false)
    private Integer budgetApplicantId;
    @Column(name = "NB_SOLIC_PEP", nullable = false, length = 50)
    private String budgetApplicantName;
    @Column(name = "ST_SOLIC_PEP", nullable = false)
    private Status status;

    public BudgetApplicant() {
    }

    public BudgetApplicant(Integer budgetApplicantId) {
        this.budgetApplicantId = budgetApplicantId;
    }

    public BudgetApplicant(Integer budgetApplicantId, String budgetApplicantName) {
        this.budgetApplicantId = budgetApplicantId;
        this.budgetApplicantName = budgetApplicantName;
    }

    public BudgetApplicant(Integer budgetApplicantId, String budgetApplicantName, Status status) {
        this.budgetApplicantId = budgetApplicantId;
        this.budgetApplicantName = budgetApplicantName;
        this.status = status;
    }

    public Integer getBudgetApplicantId() {
        return budgetApplicantId;
    }

    public void setBudgetApplicantId(Integer budgetApplicantId) {
        this.budgetApplicantId = budgetApplicantId;
    }

    public String getBudgetApplicantName() {
        return budgetApplicantName;
    }

    public void setBudgetApplicantName(String budgetApplicantName) {
        this.budgetApplicantName = budgetApplicantName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BudgetApplicant)) return false;

        BudgetApplicant that = (BudgetApplicant) o;

        return getBudgetApplicantId().equals(that.getBudgetApplicantId());
    }

    @Override
    public int hashCode() {
        return getBudgetApplicantId().hashCode();
    }

    @Override
    public String toString() {
        return "BudgetApplicant{budgetApplicantId=" + budgetApplicantId + ", budgetApplicantName='" + budgetApplicantName + ", status=" + status + '}';
    }
}
