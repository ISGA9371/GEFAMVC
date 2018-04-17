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
@Table(name = "thge068_log_fh_com")
public class ComponentDatesLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_CAMBIO")
    private Integer componentDatesLogId;
    @Column(name = "TM_FH_MODIFICADA")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date componentDateModified;
    @Column(name = "FH_ANTERIOR")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date componentDateBefore;
    @Column(name = "FH_ACTUAL")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date componentDateCurrent;
    @JoinColumn(name = "CD_COMPONENTE", referencedColumnName = "CD_COMPONENTE")
    @ManyToOne
    private Component component;
    @JoinColumn(name = "CD_TP_FH", referencedColumnName = "CD_TP_FH")
    @ManyToOne
    private DateType dateType;

    public ComponentDatesLog() {
    }

    public ComponentDatesLog(Integer componentDatesLogId) {
        this.componentDatesLogId = componentDatesLogId;
    }

    public ComponentDatesLog(Integer componentDatesLogId, Date componentDateBefore, Date componentDateCurrent) {
        this.componentDatesLogId = componentDatesLogId;
        this.componentDateBefore = componentDateBefore;
        this.componentDateCurrent = componentDateCurrent;
    }

    public Integer getComponentDatesLogId() {
        return componentDatesLogId;
    }

    public void setComponentDatesLogId(Integer componentDatesLogId) {
        this.componentDatesLogId = componentDatesLogId;
    }

    public Date getComponentDateModified() {
        return componentDateModified;
    }

    public void setComponentDateModified(Date componentDateModified) {
        this.componentDateModified = componentDateModified;
    }

    public Date getComponentDateBefore() {
        return componentDateBefore;
    }

    public void setComponentDateBefore(Date componentDateBefore) {
        this.componentDateBefore = componentDateBefore;
    }

    public Date getComponentDateCurrent() {
        return componentDateCurrent;
    }

    public void setComponentDateCurrent(Date componentDateCurrent) {
        this.componentDateCurrent = componentDateCurrent;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public DateType getDateType() {
        return dateType;
    }

    public void setDateType(DateType dateType) {
        this.dateType = dateType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (componentDatesLogId != null ? componentDatesLogId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ComponentDatesLog)) {
            return false;
        }
        ComponentDatesLog other = (ComponentDatesLog) object;
        if ((this.componentDatesLogId == null && other.componentDatesLogId != null) || (this.componentDatesLogId != null && !this.componentDatesLogId.equals(other.componentDatesLogId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.ComponentDatesLog[ componentDatesLogId=" + componentDatesLogId + " ]";
    }

}
