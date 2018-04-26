package com.mx.bbva.business.dto;

public class ComponentClosureDTO {
    private Integer componentId;
    private String componentTypoComment;
    private Integer statusTypologyId;
    private boolean componentForBill;
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

    public boolean isComponentForBill() {
        return componentForBill;
    }

    public void setComponentForBill(boolean componentForBill) {
        this.componentForBill = componentForBill;
    }

    public Integer getFinalTypologyId() {
        return finalTypologyId;
    }

    public void setFinalTypologyId(Integer finalTypologyId) {
        this.finalTypologyId = finalTypologyId;
    }
}
