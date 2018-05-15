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
@Table(name = "thge023_solic_pep", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CD_SOLIC_PEP"})})
public class BudgetsApplicant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_SOLIC_PEP", nullable = false)
    private Integer budgetsApplicantId;
    @Column(name = "NB_SOLIC_PEP", nullable = false, length = 50)
    private String budgetsApplicantName;
    @JoinColumn(name = "ST_SOLIC_PEP", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status status;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "budgetsApplicant")
    private List<Budget> budgets;

    public BudgetsApplicant() {
    }

    public BudgetsApplicant(Integer budgetsApplicantId) {
        this.budgetsApplicantId = budgetsApplicantId;
    }

    public BudgetsApplicant(Integer budgetsApplicantId, String budgetsApplicantName) {
        this.budgetsApplicantId = budgetsApplicantId;
        this.budgetsApplicantName = budgetsApplicantName;
    }

    public BudgetsApplicant(Integer budgetsApplicantId, String budgetsApplicantName, Status status) {
        this.budgetsApplicantId = budgetsApplicantId;
        this.budgetsApplicantName = budgetsApplicantName;
        this.status = status;
    }

    public Integer getBudgetsApplicantId() {
        return budgetsApplicantId;
    }

    public void setBudgetsApplicantId(Integer budgetsApplicantId) {
        this.budgetsApplicantId = budgetsApplicantId;
    }

    public String getBudgetsApplicantName() {
        return budgetsApplicantName;
    }

    public void setBudgetsApplicantName(String budgetsApplicantName) {
        this.budgetsApplicantName = budgetsApplicantName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Budget> getBudgets() {
        return budgets;
    }

    public void setBudgets(List<Budget> budgets) {
        this.budgets = budgets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BudgetsApplicant)) return false;

        BudgetsApplicant that = (BudgetsApplicant) o;

        return getBudgetsApplicantId().equals(that.getBudgetsApplicantId());
    }

    @Override
    public int hashCode() {
        return getBudgetsApplicantId().hashCode();
    }

    @Override
    public String toString() {
        return "BudgetApplicant{budgetsApplicantId=" + budgetsApplicantId + ", budgetsApplicantName='" + budgetsApplicantName + ", status=" + status + '}';
    }
}
