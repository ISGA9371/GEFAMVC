package com.mx.bbva.business.dto;

import java.util.Date;

public class ComponentSearchDTO {

    private String componentName;
    private String requirementName;
    private String componentVersion;
    private Integer principalId;
    private Integer subPrincipalId;
    private Integer companyId;
    private Integer technologyId;
    private Boolean typologyNewComponent;
    private Integer statusId;
    private Date componentDesignRealDeliverDate;
    private Date componentPreviewDeliverDate;
    private Integer startProductId;
    private Date componentPossibleDeliverDate;
    private Date componentRealDeliverDate;
    private Integer finalProductId;
    private Integer typologyStartSeverity;
    private Long typologyStartSeverityHours;
    private Integer statusTypologyId;
    private Integer typologyFinalSeverity;
    private Long typologyFinalSeverityHours;

    public ComponentSearchDTO() {
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public String getComponentVersion() {
        return componentVersion;
    }

    public void setComponentVersion(String componentVersion) {
        this.componentVersion = componentVersion;
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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(Integer technologyId) {
        this.technologyId = technologyId;
    }

    public Boolean getTypologyNewComponent() {
        return typologyNewComponent;
    }

    public void setTypologyNewComponent(Boolean typologyNewComponent) {
        this.typologyNewComponent = typologyNewComponent;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Date getComponentDesignRealDeliverDate() {
        return componentDesignRealDeliverDate;
    }

    public void setComponentDesignRealDeliverDate(Date componentDesignRealDeliverDate) {
        this.componentDesignRealDeliverDate = componentDesignRealDeliverDate;
    }

    public Date getComponentPreviewDeliverDate() {
        return componentPreviewDeliverDate;
    }

    public void setComponentPreviewDeliverDate(Date componentPreviewDeliverDate) {
        this.componentPreviewDeliverDate = componentPreviewDeliverDate;
    }

    public Integer getStartProductId() {
        return startProductId;
    }

    public void setStartProductId(Integer startProductId) {
        this.startProductId = startProductId;
    }

    public Date getComponentPossibleDeliverDate() {
        return componentPossibleDeliverDate;
    }

    public void setComponentPossibleDeliverDate(Date componentPossibleDeliverDate) {
        this.componentPossibleDeliverDate = componentPossibleDeliverDate;
    }

    public Date getComponentRealDeliverDate() {
        return componentRealDeliverDate;
    }

    public void setComponentRealDeliverDate(Date componentRealDeliverDate) {
        this.componentRealDeliverDate = componentRealDeliverDate;
    }

    public Integer getFinalProductId() {
        return finalProductId;
    }

    public void setFinalProductId(Integer finalProductId) {
        this.finalProductId = finalProductId;
    }

    public Integer getTypologyStartSeverity() {
        return typologyStartSeverity;
    }

    public void setTypologyStartSeverity(Integer typologyStartSeverity) {
        this.typologyStartSeverity = typologyStartSeverity;
    }

    public Long getTypologyStartSeverityHours() {
        return typologyStartSeverityHours;
    }

    public void setTypologyStartSeverityHours(Long typologyStartSeverityHours) {
        this.typologyStartSeverityHours = typologyStartSeverityHours;
    }

    public Integer getStatusTypologyId() {
        return statusTypologyId;
    }

    public void setStatusTypologyId(Integer statusTypologyId) {
        this.statusTypologyId = statusTypologyId;
    }

    public Integer getTypologyFinalSeverity() {
        return typologyFinalSeverity;
    }

    public void setTypologyFinalSeverity(Integer typologyFinalSeverity) {
        this.typologyFinalSeverity = typologyFinalSeverity;
    }

    public Long getTypologyFinalSeverityHours() {
        return typologyFinalSeverityHours;
    }

    public void setTypologyFinalSeverityHours(Long typologyFinalSeverityHours) {
        this.typologyFinalSeverityHours = typologyFinalSeverityHours;
    }
}
