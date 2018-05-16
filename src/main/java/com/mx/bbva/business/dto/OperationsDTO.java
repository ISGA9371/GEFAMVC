package com.mx.bbva.business.dto;

import java.util.Date;

public class OperationsDTO {

    private Integer requirementId;
    private Integer companyId;
    private Date uploadDate;
    private Integer areaId;
    private Integer levelId;
    private Integer methodologyId;
    private String componentSelected;

    public OperationsDTO() {
    }

    public Integer getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(Integer requirementId) {
        this.requirementId = requirementId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public Integer getMethodologyId() {
        return methodologyId;
    }

    public void setMethodologyId(Integer methodologyId) {
        this.methodologyId = methodologyId;
    }

    public String getComponentSelected() {
        return componentSelected;
    }

    public void setComponentSelected(String componentSelected) {
        this.componentSelected = componentSelected;
    }

}
