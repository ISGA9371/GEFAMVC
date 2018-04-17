/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author manug
 */
@Entity
@Table(name = "thge063_seg_req")
public class RequirementTracking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_SEG_REQ")
    private Integer requirementTrackingId;
    @Column(name = "TM_SEG_REQ")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date requirementTrackingDate;
    @Column(name = "NB_DEPENDENCIA")
    private String requirementTrackingDependency;
    @Column(name = "NB_OBSERVACION")
    private String requirementTrackingComment;
    @JoinColumn(name = "ST_SEG_REQ", referencedColumnName = "CD_ESTADO")
    @ManyToOne(optional = false)
    private Status status;
    @JoinColumn(name = "CD_REQUERIMIENTO", referencedColumnName = "CD_REQUERIMIENTO")
    @ManyToOne(optional = false)
    private Requirement requirement;

    public RequirementTracking() {
    }

    public RequirementTracking(Integer requirementTrackingId) {
        this.requirementTrackingId = requirementTrackingId;
    }

    public RequirementTracking(Integer requirementTrackingId, Date requirementTrackingDate) {
        this.requirementTrackingId = requirementTrackingId;
        this.requirementTrackingDate = requirementTrackingDate;
    }

    public Integer getRequirementTrackingId() {
        return requirementTrackingId;
    }

    public void setRequirementTrackingId(Integer requirementTrackingId) {
        this.requirementTrackingId = requirementTrackingId;
    }

    public Date getRequirementTrackingDate() {
        return requirementTrackingDate;
    }

    public void setRequirementTrackingDate(Date requirementTrackingDate) {
        this.requirementTrackingDate = requirementTrackingDate;
    }

    public String getRequirementTrackingDependency() {
        return requirementTrackingDependency;
    }

    public void setRequirementTrackingDependency(String requirementTrackingDependency) {
        this.requirementTrackingDependency = requirementTrackingDependency;
    }

    public String getRequirementTrackingComment() {
        return requirementTrackingComment;
    }

    public void setRequirementTrackingComment(String requirementTrackingComment) {
        this.requirementTrackingComment = requirementTrackingComment;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
        hash += (requirementTrackingId != null ? requirementTrackingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof RequirementTracking)) {
            return false;
        }
        RequirementTracking other = (RequirementTracking) object;
        if ((this.requirementTrackingId == null && other.requirementTrackingId != null) || (this.requirementTrackingId != null && !this.requirementTrackingId.equals(other.requirementTrackingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.RequirementTracking[ requirementTrackingId=" + requirementTrackingId + " ]";
    }

}
