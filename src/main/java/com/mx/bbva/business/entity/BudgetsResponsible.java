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
@Table(name = "thge069_resp_pep", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CD_RESP_PEP"})})
public class BudgetsResponsible implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_RESP_PEP", nullable = false)
    private Integer budgetsResponsibleId;
    @Column(name = "NB_RESP_PEP", nullable = false, length = 50)
    private String budgetsResponsibleName;
    @JoinColumn(name = "ST_RESP_PEP", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status status;

    public BudgetsResponsible() {
    }

    public BudgetsResponsible(Integer budgetsResponsibleId) {
        this.budgetsResponsibleId = budgetsResponsibleId;
    }

    public BudgetsResponsible(Integer budgetsResponsibleId, String budgetsResponsibleName) {
        this.budgetsResponsibleId = budgetsResponsibleId;
        this.budgetsResponsibleName = budgetsResponsibleName;
    }

    public BudgetsResponsible(Integer budgetsResponsibleId, String budgetsResponsibleName, Status status) {
        this.budgetsResponsibleId = budgetsResponsibleId;
        this.budgetsResponsibleName = budgetsResponsibleName;
        this.status = status;
    }

    public Integer getBudgetsResponsibleId() {
        return budgetsResponsibleId;
    }

    public void setBudgetsResponsibleId(Integer budgetsResponsibleId) {
        this.budgetsResponsibleId = budgetsResponsibleId;
    }

    public String getBudgetsResponsibleName() {
        return budgetsResponsibleName;
    }

    public void setBudgetsResponsibleName(String budgetsResponsibleName) {
        this.budgetsResponsibleName = budgetsResponsibleName;
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
        if (!(o instanceof BudgetsResponsible)) return false;

        BudgetsResponsible that = (BudgetsResponsible) o;

        return getBudgetsResponsibleId().equals(that.getBudgetsResponsibleId());
    }

    @Override
    public int hashCode() {
        return getBudgetsResponsibleId().hashCode();
    }

    @Override
    public String toString() {
        return "BudgetApplicant{budgetsResponsibleId=" + budgetsResponsibleId + ", budgetsResponsibleName='" + budgetsResponsibleName + ", status=" + status + '}';
    }
}
