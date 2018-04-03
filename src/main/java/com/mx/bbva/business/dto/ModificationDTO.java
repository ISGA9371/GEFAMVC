package com.mx.bbva.business.dto;

public class ModificationDTO {


    private String componentName;
    private String levelName;
    private String componentVersion;
    private String requirementName;
    private String technology;
    private Integer typology;
    private String status;
    private Integer modificationSendDate;
    private String modificationDescription;
    private String priority;
    private Integer userSender;
    private String origin;
    private String componentPossibleDeliverDate;
    private String componentDesignRealDeliverDate;
    private String modV;
    private String modRz;

    public ModificationDTO() {
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getComponentVersion() {
        return componentVersion;
    }

    public void setComponentVersion(String componentVersion) {
        this.componentVersion = componentVersion;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public Integer getTypology() {
        return typology;
    }

    public void setTypology(Integer typology) {
        this.typology = typology;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getModificationSendDate() {
        return modificationSendDate;
    }

    public void setModificationSendDate(Integer modificationSendDate) {
        this.modificationSendDate = modificationSendDate;
    }

    public String getModificationDescription() {
        return modificationDescription;
    }

    public void setModificationDescription(String modificationDescription) {
        this.modificationDescription = modificationDescription;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Integer getUserSender() {
        return userSender;
    }

    public void setUserSender(Integer userSender) {
        this.userSender = userSender;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getComponentPossibleDeliverDate() {
        return componentPossibleDeliverDate;
    }

    public void setComponentPossibleDeliverDate(String componentPossibleDeliverDate) {
        this.componentPossibleDeliverDate = componentPossibleDeliverDate;
    }

    public String getComponentDesignRealDeliverDate() {
        return componentDesignRealDeliverDate;
    }

    public void setComponentDesignRealDeliverDate(String componentDesignRealDeliverDate) {
        this.componentDesignRealDeliverDate = componentDesignRealDeliverDate;
    }

    public String getModV() {
        return modV;
    }

    public void setModV(String modV) {
        this.modV = modV;
    }

    public String getModRz() {
        return modRz;
    }

    public void setModRz(String modRz) {
        this.modRz = modRz;
    }

    public ModificationDTO(String componentName, String levelName, String componentVersion, String requirementName, String technology, Integer typology, String status, Integer modificationSendDate, String modificationDescription, String priority, Integer userSender, String origin, String componentPossibleDeliverDate, String componentDesignRealDeliverDate, String modV, String modRz) {
        this.componentName = componentName;
        this.levelName = levelName;
        this.componentVersion = componentVersion;
        this.requirementName = requirementName;
        this.technology = technology;
        this.typology = typology;
        this.status = status;
        this.modificationSendDate = modificationSendDate;
        this.modificationDescription = modificationDescription;
        this.priority = priority;
        this.userSender = userSender;
        this.origin = origin;
        this.componentPossibleDeliverDate = componentPossibleDeliverDate;
        this.componentDesignRealDeliverDate = componentDesignRealDeliverDate;
        this.modV = modV;
        this.modRz = modRz;
    }
}
