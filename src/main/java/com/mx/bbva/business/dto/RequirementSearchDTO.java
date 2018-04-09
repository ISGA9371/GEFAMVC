package com.mx.bbva.business.dto;

public class RequirementSearchDTO {
    private String requirementName;
    private Integer principalId;
    private Integer subPrincipalId;
    private String userInternalId;
    private Integer areaId;
    private Integer projectTypeId;
    private Integer technologyId;
    private Integer companyId;
    private Integer serviceTypeId;
    private String requirementStartDate;
    private String requirementEndDate;
    private String budgetId;
    private String userManagerId;
    private Integer applicationId;
    private Integer channelId;
    private Integer programIncrementId;

    public RequirementSearchDTO() {
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public Integer getPrincipalId() {
        return principalId;
    }

    public void setPrincipalId(Integer principalId) {
        this.principalId = principalId;
    }

    public Integer getSubPrincipalId() {
        return subPrincipalId;
    }

    public void setSubPrincipalId(Integer subPrincipalId) {
        this.subPrincipalId = subPrincipalId;
    }

    public String getUserInternalId() {
        return userInternalId;
    }

    public void setUserInternalId(String userInternalId) {
        this.userInternalId = userInternalId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getProjectTypeId() {
        return projectTypeId;
    }

    public void setProjectTypeId(Integer projectTypeId) {
        this.projectTypeId = projectTypeId;
    }

    public Integer getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(Integer technologyId) {
        this.technologyId = technologyId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Integer serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getRequirementStartDate() {
        return requirementStartDate;
    }

    public void setRequirementStartDate(String requirementStartDate) {
        this.requirementStartDate = requirementStartDate;
    }

    public String getRequirementEndDate() {
        return requirementEndDate;
    }

    public void setRequirementEndDate(String requirementEndDate) {
        this.requirementEndDate = requirementEndDate;
    }

    public String getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(String budgetId) {
        this.budgetId = budgetId;
    }

    public String getUserManagerId() {
        return userManagerId;
    }

    public void setUserManagerId(String userManagerId) {
        this.userManagerId = userManagerId;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public Integer getProgramIncrementId() {
        return programIncrementId;
    }

    public void setProgramIncrementId(Integer programIncrementId) {
        this.programIncrementId = programIncrementId;
    }

    @Override
    public String toString() {
        return "RequirementSearchDTO{" + "requirementName='" + requirementName + '\'' + ", principalId=" + principalId +
                ", subPrincipalId=" + subPrincipalId + ", userInternalId='" + userInternalId + '\'' + ", areaId=" + areaId +
                ", projectTypeId=" + projectTypeId + ", technologyId=" + technologyId + ", companyId=" + companyId +
                ", serviceTypeId=" + serviceTypeId + ", requirementStartDate='" + requirementStartDate + '\'' +
                ", requirementEndDate='" + requirementEndDate + '\'' + ", userManagerId='" + userManagerId + '\''
                + ", applicationId=" + applicationId + ", channelId=" + channelId + ", programIncrementId='"
                + programIncrementId + '\'' + '}';
    }
}
