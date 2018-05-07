package com.mx.bbva.business.dto;


import java.util.List;

public class ComponentUpdateDatesDTO {
    private Integer componentId;
    private List<Integer> componentIds;
    private String componentDesignRealDeliverDate;
    private String componentPossibleDeliverDate;
    private String componentPreviewDeliverDate;
    private String componentRealDeliverDate;

    public ComponentUpdateDatesDTO() {
    }

    public Integer getComponentId() {
        return componentId;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
    }

    public List<Integer> getComponentIds() {
        return componentIds;
    }

    public void setComponentIds(List<Integer> componentIds) {
        this.componentIds = componentIds;
    }

    public String getComponentDesignRealDeliverDate() {
        return componentDesignRealDeliverDate;
    }

    public void setComponentDesignRealDeliverDate(String componentDesignRealDeliverDate) {
        this.componentDesignRealDeliverDate = componentDesignRealDeliverDate;
    }

    public String getComponentPossibleDeliverDate() {
        return componentPossibleDeliverDate;
    }

    public void setComponentPossibleDeliverDate(String componentPossibleDeliverDate) {
        this.componentPossibleDeliverDate = componentPossibleDeliverDate;
    }

    public String getComponentPreviewDeliverDate() {
        return componentPreviewDeliverDate;
    }

    public void setComponentPreviewDeliverDate(String componentPreviewDeliverDate) {
        this.componentPreviewDeliverDate = componentPreviewDeliverDate;
    }

    public String getComponentRealDeliverDate() {
        return componentRealDeliverDate;
    }

    public void setComponentRealDeliverDate(String componentRealDeliverDate) {
        this.componentRealDeliverDate = componentRealDeliverDate;
    }
}
