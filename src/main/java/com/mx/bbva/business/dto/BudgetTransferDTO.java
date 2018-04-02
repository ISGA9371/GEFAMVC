package com.mx.bbva.business.dto;

public class BudgetTransferDTO {

    private String budgetId;
    private String budgetName;
    private int budgetYear;
    private String area;
    private String banking;
    private String userReceiver;
    private String userSender;
    private String corporation;
    private String nature;
    private String budgetCostCenter;
    private String transferDate;
    private String level;
    private String user;
    private Double transferValue;
    private String transferComment;

    public BudgetTransferDTO() {
    }

    public BudgetTransferDTO(String budgetId, String budgetName, int budgetYear, String area, String banking, String userReceiver, String userSender, String corporation, String nature, String budgetCostCenter, String transferDate, String level, String user, Double transferValue, String transferComment) {
        this.budgetId = budgetId;
        this.budgetName = budgetName;
        this.budgetYear = budgetYear;
        this.area = area;
        this.banking = banking;
        this.userReceiver = userReceiver;
        this.userSender = userSender;
        this.corporation = corporation;
        this.nature = nature;
        this.budgetCostCenter = budgetCostCenter;
        this.transferDate = transferDate;
        this.level = level;
        this.user = user;
        this.transferValue = transferValue;
        this.transferComment = transferComment;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBanking() {
        return banking;
    }

    public void setBanking(String banking) {
        this.banking = banking;
    }

    public String getUserReceiver() {
        return userReceiver;
    }

    public void setUserReceiver(String userReceiver) {
        this.userReceiver = userReceiver;
    }

    public String getUserSender() {
        return userSender;
    }

    public void setUserSender(String userSender) {
        this.userSender = userSender;
    }

    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getBudgetCostCenter() {
        return budgetCostCenter;
    }

    public void setBudgetCostCenter(String budgetCostCenter) {
        this.budgetCostCenter = budgetCostCenter;
    }

    public String getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(String transferDate) {
        this.transferDate = transferDate;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Double getTransferValue() {
        return transferValue;
    }

    public void setTransferValue(Double transferValue) {
        this.transferValue = transferValue;
    }

    public String getTransferComment() {
        return transferComment;
    }

    public void setTransferComment(String transferComment) {
        this.transferComment = transferComment;
    }
}
