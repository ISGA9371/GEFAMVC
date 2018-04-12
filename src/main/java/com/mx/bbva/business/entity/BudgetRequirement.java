/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Guevara Manuel_
 */
@Entity
@Table(name = "thge040_pep_req")
public class BudgetRequirement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_PEP_REQ", nullable = false)
    private Integer budgetRequirementId;
    @Column(name = "IM_PEP", precision = 22)
    private Double budgetRequirementValue;
    @Column(name = "HM_PEP", precision = 22)
    private Double budgetRequirementHours;
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss.S")
    @Column(name = "TM_PEP_REQ")
    @Temporal(TemporalType.TIMESTAMP)
    private Date budgetRequirementDate;
    @Column(name = "ST_FACTURADO")
    private Boolean budgetRequirementBilled;
    @JoinColumn(name = "CD_PEP", referencedColumnName = "CD_PEP", nullable = false)
    @ManyToOne(optional = false)
    private Budget budget;
    @JsonIgnore
    @JoinColumn(name = "CD_REQUERIMIENTO", referencedColumnName = "CD_REQUERIMIENTO", nullable = false)
    @ManyToOne(optional = false)
    private Requirement requirement;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "budgetRequirement")
    private List<Invoice> invoices;

    public BudgetRequirement() {
    }

    public BudgetRequirement(Integer budgetRequirementId) {
        this.budgetRequirementId = budgetRequirementId;
    }

    public Integer getBudgetRequirementId() {
        return budgetRequirementId;
    }

    public void setBudgetRequirementId(Integer budgetRequirementId) {
        this.budgetRequirementId = budgetRequirementId;
    }

    public Double getBudgetRequirementValue() {
        return budgetRequirementValue;
    }

    public void setBudgetRequirementValue(Double budgetRequirementValue) {
        this.budgetRequirementValue = budgetRequirementValue;
    }

    public Double getBudgetRequirementHours() {
        return budgetRequirementHours;
    }

    public void setBudgetRequirementHours(Double budgetRequirementHours) {
        this.budgetRequirementHours = budgetRequirementHours;
    }

    public Date getBudgetRequirementDate() {
        return budgetRequirementDate;
    }

    public void setBudgetRequirementDate(Date budgetRequirementDate) {
        this.budgetRequirementDate = budgetRequirementDate;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Boolean getBudgetRequirementBilled() {
        return budgetRequirementBilled;
    }

    public void setBudgetRequirementBilled(Boolean budgetRequirementBilled) {
        this.budgetRequirementBilled = budgetRequirementBilled;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public Requirement getRequirement() {
        return requirement;
    }

    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (budgetRequirementId != null ? budgetRequirementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BudgetRequirement)) {
            return false;
        }
        BudgetRequirement other = (BudgetRequirement) object;
        return (this.budgetRequirementId != null || other.budgetRequirementId == null) && (this.budgetRequirementId == null || this.budgetRequirementId.equals(other.budgetRequirementId));
    }

    @Override
    public String toString() {
        return "com.bbva.BudgetRequirement[ budgetRequirementId=" + budgetRequirementId + " ]";
    }

}
