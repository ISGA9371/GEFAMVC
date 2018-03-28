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
 * @author Guevara
 */
@Entity
@Table(name = "thge007_pep", uniqueConstraints = {@UniqueConstraint(columnNames = {"CD_PEP"})})
public class Budget implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_CONSEC_PEP", nullable = false)
    private Integer budgetSerial;
    @Basic(optional = false)
    @Column(name = "CD_PEP", nullable = false, length = 15)
    private String budgetId;
    @Column(name = "NB_DENOMINAC_PEP", length = 50)
    private String budgetName;
    @Basic(optional = false)
    @Column(name = "NU_EJERCICIO", nullable = false)
    private int budgetYear;
    @Basic(optional = false)
    @Column(name = "TX_CENTRO_CTO", nullable = false, length = 10)
    private String budgetCostCenter;
    @Column(name = "IM_PRESUPUESTO", precision = 22)
    private Double budgetAmount;
    @Column(name = "IM_AUTORIZADO", precision = 22)
    private Double budgetAuthorized;
    @Column(name = "IM_COMPR_SOL", precision = 22)
    private Double budgetCommittedRequested;
    @Column(name = "IM_COMPR_PEND", precision = 22)
    private Double budgetCommittedPending;
    @Column(name = "IM_REALIZADO", precision = 22)
    private Double budgetDone;
    @Column(name = "IM_DISPONIBLE", precision = 22)
    private Double budgetAvailable;
    @Column(name = "IM_INCURRIDO_PBAS", precision = 22)
    private Double budgetIncurredTestFactory;
    @Column(name = "IM_INCURRIDO_FSW", precision = 22)
    private Double budgetIncurredSoftwareFactory;
    @Column(name = "TP_DESLIZADO")
    private byte[] budgetForNextYear;
    @JoinColumn(name = "ST_PEP", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status budgetStatus;
    @JoinColumn(name = "ST_DYD", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status statusDyd;
    @JoinColumn(name = "CD_USUARIO_SOLIC", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne
    private User userSender;
    @JoinColumn(name = "CD_USUARIO_RESP", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne
    private User userReceiver;
    @JoinColumn(name = "CD_AREA", referencedColumnName = "CD_AREA", nullable = false)
    @ManyToOne(optional = false)
    private Area area;
    @JoinColumn(name = "CD_BANCA", referencedColumnName = "CD_BANCA", nullable = false)
    @ManyToOne(optional = false)
    private Banking banking;
    @JoinColumn(name = "CD_ENTIDAD", referencedColumnName = "CD_ENTIDAD", nullable = false)
    @ManyToOne(optional = false)
    private Corporation corporation;
    @JoinColumn(name = "CD_NATURALEZA", referencedColumnName = "CD_NATURALEZA", nullable = false)
    @ManyToOne(optional = false)
    private Nature nature;
    @JsonIgnore
    @OneToMany(mappedBy = "budget")
    private List<Transfer> transfers;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "budget")
    private List<BudgetRequirement> budgetRequirements;

    public Budget() {
    }

    public Budget(Integer budgetSerial) {
        this.budgetSerial = budgetSerial;
    }

    public Budget(Integer budgetSerial, String budgetId, int budgetYear, String budgetCostCenter) {
        this.budgetSerial = budgetSerial;
        this.budgetId = budgetId;
        this.budgetYear = budgetYear;
        this.budgetCostCenter = budgetCostCenter;
    }

    public Integer getBudgetSerial() {
        return budgetSerial;
    }

    public void setBudgetSerial(Integer budgetSerial) {
        this.budgetSerial = budgetSerial;
    }

    public String getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(String budgetId) {
        this.budgetId = budgetId;
    }

    public String getBudgetName() {
        return budgetName;
    }

    public void setBudgetName(String budgetName) {
        this.budgetName = budgetName;
    }

    public int getBudgetYear() {
        return budgetYear;
    }

    public void setBudgetYear(int budgetYear) {
        this.budgetYear = budgetYear;
    }

    public String getBudgetCostCenter() {
        return budgetCostCenter;
    }

    public void setBudgetCostCenter(String budgetCostCenter) {
        this.budgetCostCenter = budgetCostCenter;
    }

    public Double getBudgetAmount() {
        return budgetAmount;
    }

    public void setBudgetAmount(Double budgetAmount) {
        this.budgetAmount = budgetAmount;
    }

    public Double getBudgetAuthorized() {
        return budgetAuthorized;
    }

    public void setBudgetAuthorized(Double budgetAuthorized) {
        this.budgetAuthorized = budgetAuthorized;
    }

    public Double getBudgetCommittedRequested() {
        return budgetCommittedRequested;
    }

    public void setBudgetCommittedRequested(Double budgetCommittedRequested) {
        this.budgetCommittedRequested = budgetCommittedRequested;
    }

    public Double getBudgetCommittedPending() {
        return budgetCommittedPending;
    }

    public void setBudgetCommittedPending(Double budgetCommittedPending) {
        this.budgetCommittedPending = budgetCommittedPending;
    }

    public Double getBudgetDone() {
        return budgetDone;
    }

    public void setBudgetDone(Double budgetDone) {
        this.budgetDone = budgetDone;
    }

    public Double getBudgetAvailable() {
        return budgetAvailable;
    }

    public void setBudgetAvailable(Double budgetAvailable) {
        this.budgetAvailable = budgetAvailable;
    }

    public Double getBudgetIncurredTestFactory() {
        return budgetIncurredTestFactory;
    }

    public void setBudgetIncurredTestFactory(Double budgetIncurredTestFactory) {
        this.budgetIncurredTestFactory = budgetIncurredTestFactory;
    }

    public Double getBudgetIncurredSoftwareFactory() {
        return budgetIncurredSoftwareFactory;
    }

    public void setBudgetIncurredSoftwareFactory(Double budgetIncurredSoftwareFactory) {
        this.budgetIncurredSoftwareFactory = budgetIncurredSoftwareFactory;
    }

    public byte[] getBudgetForNextYear() {
        return budgetForNextYear;
    }

    public void setBudgetForNextYear(byte[] budgetForNextYear) {
        this.budgetForNextYear = budgetForNextYear;
    }

    public Status getBudgetStatus() {
        return budgetStatus;
    }

    public void setBudgetStatus(Status budgetStatus) {
        this.budgetStatus = budgetStatus;
    }

    public Status getStatusDyd() {
        return statusDyd;
    }

    public void setStatusDyd(Status statusDyd) {
        this.statusDyd = statusDyd;
    }

    public User getUserSender() {
        return userSender;
    }

    public void setUserSender(User userSender) {
        this.userSender = userSender;
    }

    public User getUserReceiver() {
        return userReceiver;
    }

    public void setUserReceiver(User userReceiver) {
        this.userReceiver = userReceiver;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Banking getBanking() {
        return banking;
    }

    public void setBanking(Banking banking) {
        this.banking = banking;
    }

    public Corporation getCorporation() {
        return corporation;
    }

    public void setCorporation(Corporation corporation) {
        this.corporation = corporation;
    }

    public Nature getNature() {
        return nature;
    }

    public void setNature(Nature nature) {
        this.nature = nature;
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }

    public List<BudgetRequirement> getBudgetRequirements() {
        return budgetRequirements;
    }

    public void setBudgetRequirements(List<BudgetRequirement> budgetRequirements) {
        this.budgetRequirements = budgetRequirements;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (budgetSerial != null ? budgetSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Budget)) {
            return false;
        }
        Budget other = (Budget) object;
        return (this.budgetSerial != null || other.budgetSerial == null) && (this.budgetSerial == null || this.budgetSerial.equals(other.budgetSerial));
    }

    @Override
    public String toString() {
        return "com.bbva.Budget[ budgetSerial=" + budgetSerial + " ]";
    }

}
