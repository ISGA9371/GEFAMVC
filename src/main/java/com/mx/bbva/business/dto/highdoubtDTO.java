package com.mx.bbva.business.dto;

import java.util.Date;

public class highdoubtDTO {

    public String componentName;
    public String componentVersion;
    public Date componentUploadDate;
    public String technologyName;
    public String typologyProductId;
    public String levelName;
    public String userInternalId;
    public String requirementName;

    public highdoubtDTO(){

    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getComponentVersion() {
        return componentVersion;
    }

    public void setComponentVersion(String componentVersion) {
        this.componentVersion = componentVersion;
    }

    public Date getComponentUploadDate() {
        return componentUploadDate;
    }

    public void setComponentUploadDate(Date componentUploadDate) {
        this.componentUploadDate = componentUploadDate;
    }

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }

    public String getTypologyProductId() {
        return typologyProductId;
    }

    public void setTypologyProductId(String typologyProductId) {
        this.typologyProductId = typologyProductId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getUserInternalId() {
        return userInternalId;
    }

    public void setUserInternalId(String userInternalId) {
        this.userInternalId = userInternalId;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }
}
