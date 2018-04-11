/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Guevara Manuel
 */
@Entity
@Table(name = "thge009_componente")
public class Component implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_COMPONENTE", nullable = false)
    private Integer componentId;
    @Column(name = "NB_COMPONENTE", nullable = false, length = 45)
    private String componentName;
    @Column(name = "TX_VENTREGA", nullable = false, length = 9)
    private String componentVersion;
    @Column(name = "IM_COSTE_EMP", precision = 22)
    private Double componentFinalCost;
    @Column(name = "IM_COSTE_INIC", precision = 22)
    private Double componentStartCost;
    @Column(name = "TX_COM_TIPIF_EMP", length = 600)
    private String componentTypoComment;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "FH_NEG_EMP_CGF_SW", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date componentPossibleDeliverDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "FH_PRV_EMP_CGF_SW", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date componentPreviewDeliverDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "FH_R_CGF_EMP_DIS", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date componentDesignRealDeliverDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "FH_R_EMP_CGF_SW")
    @Temporal(TemporalType.DATE)
    private Date componentRealDeliverDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss.S")
    @Column(name = "TM_ALTA_COMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date componentUploadDate;
    @Column(name = "NU_FACTURABLE")
    private Boolean componentForBill;
    @JoinColumn(name = "ST_TIPIFICACION", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status statusTypology;
    @JoinColumn(name = "ST_COMPONENTE", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status status;
    @JsonIgnore
    @JoinColumn(name = "CD_TIPOLOGIA", referencedColumnName = "CD_TIPOLOGIA", nullable = false)
    @ManyToOne(optional = false)
    private Typology typology;
    @JsonIgnore
    @JoinColumn(name = "CD_TIPOLOGIA_EMP", referencedColumnName = "CD_TIPOLOGIA", nullable = false)
    @ManyToOne(optional = false)
    private Typology typologyEmp;
    @JoinColumn(name = "CD_REQUERIMIENTO", referencedColumnName = "CD_REQUERIMIENTO", nullable = false)
    @ManyToOne(optional = false)
    private Requirement requirement;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "component")
    private List<Modification> modifications;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "component")
    private List<Doubt> doubts;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "component")
    private List<Issue> issues;

    public Component() {
    }

    public Component(Integer componentId) {
        this.componentId = componentId;
    }

    public Component(Integer componentId, String componentName, String componentVersion, String componentTypoComment) {
        this.componentId = componentId;
        this.componentName = componentName;
        this.componentVersion = componentVersion;
        this.componentTypoComment = componentTypoComment;
    }

    public Component(Integer componentId, String componentName, String componentVersion, Date componentPossibleDeliverDate, Date componentPreviewDeliverDate, Date componentDesignRealDeliverDate) {
        this.componentId = componentId;
        this.componentName = componentName;
        this.componentVersion = componentVersion;
        this.componentPossibleDeliverDate = componentPossibleDeliverDate;
        this.componentPreviewDeliverDate = componentPreviewDeliverDate;
        this.componentDesignRealDeliverDate = componentDesignRealDeliverDate;
    }

    public Integer getComponentId() {
        return componentId;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
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

    public Double getComponentFinalCost() {
        return componentFinalCost;
    }

    public void setComponentFinalCost(Double componentFinalCost) {
        this.componentFinalCost = componentFinalCost;
    }

    public Double getComponentStartCost() {
        return componentStartCost;
    }

    public void setComponentStartCost(Double componentStartCost) {
        this.componentStartCost = componentStartCost;
    }

    public String getComponentTypoComment() {
        return componentTypoComment;
    }

    public void setComponentTypoComment(String componentTypoComment) {
        this.componentTypoComment = componentTypoComment;
    }

    public Date getComponentPossibleDeliverDate() {
        return componentPossibleDeliverDate;
    }

    public void setComponentPossibleDeliverDate(Date componentPossibleDeliverDate) {
        this.componentPossibleDeliverDate = componentPossibleDeliverDate;
    }

    public Date getComponentPreviewDeliverDate() {
        return componentPreviewDeliverDate;
    }

    public void setComponentPreviewDeliverDate(Date componentPreviewDeliverDate) {
        this.componentPreviewDeliverDate = componentPreviewDeliverDate;
    }

    public Date getComponentDesignRealDeliverDate() {
        return componentDesignRealDeliverDate;
    }

    public void setComponentDesignRealDeliverDate(Date componentDesignRealDeliverDate) {
        this.componentDesignRealDeliverDate = componentDesignRealDeliverDate;
    }

    public Date getComponentRealDeliverDate() {
        return componentRealDeliverDate;
    }

    public void setComponentRealDeliverDate(Date componentRealDeliverDate) {
        this.componentRealDeliverDate = componentRealDeliverDate;
    }

    public Date getComponentUploadDate() {
        return componentUploadDate;
    }

    public void setComponentUploadDate(Date componentUploadDate) {
        this.componentUploadDate = componentUploadDate;
    }

    public List<Modification> getModifications() {
        return modifications;
    }

    public void setModifications(List<Modification> modifications) {
        this.modifications = modifications;
    }

    public List<Doubt> getDoubts() {
        return doubts;
    }

    public void setDoubts(List<Doubt> doubts) {
        this.doubts = doubts;
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    public Status getStatusTypology() {
        return statusTypology;
    }

    public void setStatusTypology(Status statusTypology) {
        this.statusTypology = statusTypology;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Typology getTypology() {
        return typology;
    }

    public void setTypology(Typology typology) {
        this.typology = typology;
    }

    public Typology getTypologyEmp() {
        return typologyEmp;
    }

    public void setTypologyEmp(Typology typologyEmp) {
        this.typologyEmp = typologyEmp;
    }

    public Requirement getRequirement() {
        return requirement;
    }

    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }

    public Boolean getComponentForBill() {
        return componentForBill;
    }

    public void setComponentForBill(Boolean componentForBill) {
        this.componentForBill = componentForBill;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (componentId != null ? componentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Component)) {
            return false;
        }
        Component other = (Component) object;
        return (this.componentId != null || other.componentId == null) && (this.componentId == null || this.componentId.equals(other.componentId));
    }

    @Override
    public String toString() {
        return "com.bbva.Component[ componentId=" + componentId + " ]";
    }

}
