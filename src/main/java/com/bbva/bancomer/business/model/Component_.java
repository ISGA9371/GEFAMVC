/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbva.bancomer.business.model;

import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Guevara
 */
@Entity
@Table(name = "thge009_componente", catalog = "gestion_factoria", schema = "")
public class Component_ implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_COMPONENTE", nullable = false)
    private Integer componentId;
    @Basic(optional = false)
    @Column(name = "NB_COMPONENTE", nullable = false, length = 45)
    private String componentName;
    @Basic(optional = false)
    @Column(name = "TX_VENTREGA", nullable = false, length = 9)
    private String componentVersion;
    @Basic(optional = false)
    @Column(name = "TP_NVO_MOD", nullable = false, length = 10)
    private String componentNewMod;
    @Column(name = "IM_COSTE_EMP", precision = 22)
    private Double componentFinalCost;
    @Column(name = "IM_COSTE_INIC", precision = 22)
    private Double componentStartCost;
    @Column(name = "TX_COM_TIPIF_EMP", length = 600)
    private String componentType;
    @Basic(optional = false)
    @Column(name = "FH_NEG_EMP_CGF_SW", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date componentPossibleDeliverDate;
    @Basic(optional = false)
    @Column(name = "FH_PRV_EMP_CGF_SW", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date componentPreviewDeliverDate;
    @Basic(optional = false)
    @Column(name = "FH_R_CGF_EMP_DIS", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date componentDesignRealDeliverDate;
    @Column(name = "FH_R_EMP_CGF_SW")
    @Temporal(TemporalType.DATE)
    private Date componentRealDeliverDate;
    @Column(name = "TM_ALTA_COMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date componentUploadDate;
    @Ignore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "component")
    private List<Modification> modifications;
    @Ignore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "component")
    private List<Doubt_> doubts;
    @Ignore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "component")
    private List<Issue> issues;
    @Ignore
    @JoinColumn(name = "ST_TIPIFICACION", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status statusTypology;
    @Ignore
    @JoinColumn(name = "ST_COMPONENTE", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status status;
    @Ignore
    @JoinColumn(name = "CD_TIPOLOGIA", referencedColumnName = "CD_TIPOLOGIA", nullable = false)
    @ManyToOne(optional = false)
    private Typology typology;
    @Ignore
    @JoinColumn(name = "CD_TIPOLOGIA_EMP", referencedColumnName = "CD_TIPOLOGIA", nullable = false)
    @ManyToOne(optional = false)
    private Typology typologyEmp;
    @Ignore
    @JoinColumn(name = "CD_REQUERIMIENTO", referencedColumnName = "CD_REQUERIMIENTO", nullable = false)
    @ManyToOne(optional = false)
    private Requirement requirement;

    public Component_() {
    }

    public Component_(Integer componentId) {
        this.componentId = componentId;
    }

    public Component_(Integer componentId, String componentName, String componentVersion, String componentType) {
        this.componentId = componentId;
        this.componentName = componentName;
        this.componentVersion = componentVersion;
        this.componentType = componentType;
    }

    public Component_(Integer componentId, String componentName, String componentVersion, String componentNewMod, Date componentPossibleDeliverDate, Date componentPreviewDeliverDate, Date componentDesignRealDeliverDate) {
        this.componentId = componentId;
        this.componentName = componentName;
        this.componentVersion = componentVersion;
        this.componentNewMod = componentNewMod;
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

    public String getComponentNewMod() {
        return componentNewMod;
    }

    public void setComponentNewMod(String componentNewMod) {
        this.componentNewMod = componentNewMod;
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

    public String getComponentType() {
        return componentType;
    }

    public void setComponentType(String componentType) {
        this.componentType = componentType;
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

    public List<Doubt_> getDoubts() {
        return doubts;
    }

    public void setDoubts(List<Doubt_> doubts) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (componentId != null ? componentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Component_)) {
            return false;
        }
        Component_ other = (Component_) object;
        return (this.componentId != null || other.componentId == null) && (this.componentId == null || this.componentId.equals(other.componentId));
    }

    @Override
    public String toString() {
        return "com.bbva.Component_[ componentId=" + componentId + " ]";
    }

}