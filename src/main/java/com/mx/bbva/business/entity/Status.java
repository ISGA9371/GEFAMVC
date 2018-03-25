/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entity;

import com.google.appengine.repackaged.org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Guevara
 */
@Entity
@Table(name = "thge005_estado")
public class Status implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_ESTADO", nullable = false)
    private Integer statusId;
    @Basic(optional = false)
    @Column(name = "NB_ESTADO", nullable = false, length = 50)
    private String statusName;
    @JoinColumn(name = "CD_TIPO_EDO", referencedColumnName = "CD_TIPO_EDO", nullable = false)
    @ManyToOne(optional = false)
    private StatusType statusType;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private List<Company> companies;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "budgetStatus")
    private List<Budget> budgets;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusDyd")
    private List<Budget> budgetsDyd;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private List<Fare> fares;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private List<User> users;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusBudget")
    private List<Invoice> budgetInvoices;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private List<Invoice> invoices;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusHours")
    private List<Invoice> hourInvoices;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private List<Requirement> requirements;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modificationStatus")
    private List<Modification> modificationList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private List<Modification> modificationList1;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private List<Contract> contracts;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private List<com.mx.bbva.business.entity.Access> accessList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private List<Doubt> doubts;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private List<Typology> typologies;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private List<ExternalUser> externalUsers;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private List<T955> t955List;
    @JsonIgnore
    @OneToMany(mappedBy = "status")
    private List<Issue> issues;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusTypology")
    private List<Component> componentList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private List<Component> componentList1;

    public Status() {
    }

    public Status(Integer statusId) {
        this.statusId = statusId;
    }

    public Status(Integer statusId, String statusName) {
        this.statusId = statusId;
        this.statusName = statusName;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public List<Budget> getBudgets() {
        return budgets;
    }

    public void setBudgets(List<Budget> budgets) {
        this.budgets = budgets;
    }

    public List<Budget> getBudgetsDyd() {
        return budgetsDyd;
    }

    public void setBudgetsDyd(List<Budget> budgetsDyd) {
        this.budgetsDyd = budgetsDyd;
    }

    public List<Fare> getFares() {
        return fares;
    }

    public void setFares(List<Fare> fares) {
        this.fares = fares;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Invoice> getBudgetInvoices() {
        return budgetInvoices;
    }

    public void setBudgetInvoices(List<Invoice> budgetInvoices) {
        this.budgetInvoices = budgetInvoices;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public List<Invoice> getHourInvoices() {
        return hourInvoices;
    }

    public void setHourInvoices(List<Invoice> hourInvoices) {
        this.hourInvoices = hourInvoices;
    }

    public List<Requirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Requirement> requirements) {
        this.requirements = requirements;
    }

    public List<Modification> getModificationList() {
        return modificationList;
    }

    public void setModificationList(List<Modification> modificationList) {
        this.modificationList = modificationList;
    }

    public List<Modification> getModificationList1() {
        return modificationList1;
    }

    public void setModificationList1(List<Modification> modificationList1) {
        this.modificationList1 = modificationList1;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public List<com.mx.bbva.business.entity.Access> getAccessList() {
        return accessList;
    }

    public void setAccessList(List<com.mx.bbva.business.entity.Access> accessList) {
        this.accessList = accessList;
    }

    public List<Doubt> getDoubts() {
        return doubts;
    }

    public void setDoubts(List<Doubt> doubts) {
        this.doubts = doubts;
    }

    public List<Typology> getTypologies() {
        return typologies;
    }

    public void setTypologies(List<Typology> typologies) {
        this.typologies = typologies;
    }

    public List<ExternalUser> getExternalUsers() {
        return externalUsers;
    }

    public void setExternalUsers(List<ExternalUser> externalUsers) {
        this.externalUsers = externalUsers;
    }

    public List<T955> getT955List() {
        return t955List;
    }

    public void setT955List(List<T955> t955List) {
        this.t955List = t955List;
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    public List<Component> getComponentList() {
        return componentList;
    }

    public void setComponentList(List<Component> componentList) {
        this.componentList = componentList;
    }

    public List<Component> getComponentList1() {
        return componentList1;
    }

    public void setComponentList1(List<Component> componentList1) {
        this.componentList1 = componentList1;
    }

    public StatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statusId != null ? statusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Status)) {
            return false;
        }
        Status other = (Status) object;
        if ((this.statusId == null && other.statusId != null) || (this.statusId != null && !this.statusId.equals(other.statusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Status[ statusId=" + statusId + " ]";
    }

}
