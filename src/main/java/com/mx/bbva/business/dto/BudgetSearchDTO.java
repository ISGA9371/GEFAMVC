package com.mx.bbva.business.dto;

public class BudgetSearchDTO {

    private String budgetId;
    private String budgetName;
    private Integer budgetYear;
    private Integer areaId;
    private Integer bankingId;
    private String userInternalId;
    private Integer corporationId;
    private Integer natureId;
    private String budgetCostCenter;

    public BudgetSearchDTO() {
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

    public Integer getBudgetYear() {
        return budgetYear;
    }

    public void setBudgetYear(Integer budgetYear) {
        this.budgetYear = budgetYear;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getBankingId() {
        return bankingId;
    }

    public void setBankingId(Integer bankingId) {
        this.bankingId = bankingId;
    }

    public String getUserInternalId() {
        return userInternalId;
    }

    public void setUserInternalId(String userInternalId) {
        this.userInternalId = userInternalId;
    }

    public Integer getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(Integer corporationId) {
        this.corporationId = corporationId;
    }

    public Integer getNatureId() {
        return natureId;
    }

    public void setNatureId(Integer natureId) {
        this.natureId = natureId;
    }

    public String getBudgetCostCenter() {
        return budgetCostCenter;
    }

    public void setBudgetCostCenter(String budgetCostCenter) {
        this.budgetCostCenter = budgetCostCenter;
    }
}
