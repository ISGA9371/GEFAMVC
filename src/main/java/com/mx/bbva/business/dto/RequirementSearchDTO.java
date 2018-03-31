package com.mx.bbva.business.dto;

public class RequirementSearchDTO {
    private String name;
    private Integer directionId;
    private Integer subDirectionId;
    private String responsible;
    private Integer attAreaId;
    private Integer proyTypeId;
    private Integer techId;
    private Integer companyId;
    private Integer serviceTypeId;
    private String initialPropDate;
    private String finalPropDate;
    private String pep;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDirectionId() {
        return directionId;
    }

    public void setDirectionId(Integer directionId) {
        this.directionId = directionId;
    }

    public Integer getSubDirectionId() {
        return subDirectionId;
    }

    public void setSubDirectionId(Integer subDirectionId) {
        this.subDirectionId = subDirectionId;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public Integer getAttAreaId() {
        return attAreaId;
    }

    public void setAttAreaId(Integer attAreaId) {
        this.attAreaId = attAreaId;
    }

    public Integer getProyTypeId() {
        return proyTypeId;
    }

    public void setProyTypeId(Integer proyTypeId) {
        this.proyTypeId = proyTypeId;
    }

    public Integer getTechId() {
        return techId;
    }

    public void setTechId(Integer techId) {
        this.techId = techId;
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

    public String getInitialPropDate() {
        return initialPropDate;
    }

    public void setInitialPropDate(String initialPropDate) {
        this.initialPropDate = initialPropDate;
    }

    public String getFinalPropDate() {
        return finalPropDate;
    }

    public void setFinalPropDate(String finalPropDate) {
        this.finalPropDate = finalPropDate;
    }

    public String getPep() {
        return pep;
    }

    public void setPep(String pep) {
        this.pep = pep;
    }

    @Override
    public String toString() {
        return "RequirementSearchTO{" +
                "name='" + name + '\'' +
                ", directionId=" + directionId +
                ", subDirectionId=" + subDirectionId +
                ", responsible='" + responsible + '\'' +
                ", attAreaId=" + attAreaId +
                ", proyTypeId=" + proyTypeId +
                ", techId=" + techId +
                ", companyId=" + companyId +
                ", serviceTypeId=" + serviceTypeId +
                ", initialPropDate='" + initialPropDate + '\'' +
                ", finalPropDate='" + finalPropDate + '\'' +
                ", pep='" + pep + '\'' +
                '}';
    }
}
