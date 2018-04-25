package com.mx.bbva.business.dto;

public class ComponentClosureDTO {
    private Integer componentId;
    private String componentTypoComment;
    private Integer statusTypologyId;
    private String componentForBill;
    private Integer finalTypologyId;

    public ComponentClosureDTO() {
    }

    public Integer getComponentId() {
        return componentId;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
    }

    public String getComponentTypoComment() {
        return componentTypoComment;
    }

    public void setComponentTypoComment(String componentTypoComment) {
        this.componentTypoComment = componentTypoComment;
    }

    public Integer getStatusTypologyId() {
        return statusTypologyId;
    }

    public void setStatusTypologyId(Integer statusTypologyId) {
        this.statusTypologyId = statusTypologyId;
    }

    public String getComponentForBill() {
        return componentForBill;
    }

    public void setComponentForBill(String componentForBill) {
        this.componentForBill = componentForBill;
    }

    public Integer getFinalTypologyId() {
        return finalTypologyId;
    }

    public void setFinalTypologyId(Integer finalTypologyId) {
        this.finalTypologyId = finalTypologyId;
    }
}
