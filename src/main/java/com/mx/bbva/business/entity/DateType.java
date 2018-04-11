/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author manug
 */
@Entity
@Table(name = "thge070_tp_fh")
public class DateType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_TP_FH")
    private Integer dateTypeId;
    @Column(name = "TP_FH")
    private String dateTypeName;
    @JsonIgnore
    @OneToMany(mappedBy = "dateType")
    private List<ComponentDatesLog> componentDatesLogList;

    public DateType() {
    }

    public DateType(Integer dateTypeId) {
        this.dateTypeId = dateTypeId;
    }

    public DateType(Integer dateTypeId, String dateTypeName) {
        this.dateTypeId = dateTypeId;
        this.dateTypeName = dateTypeName;
    }

    public Integer getDateTypeId() {
        return dateTypeId;
    }

    public void setDateTypeId(Integer dateTypeId) {
        this.dateTypeId = dateTypeId;
    }

    public String getDateTypeName() {
        return dateTypeName;
    }

    public void setDateTypeName(String dateTypeName) {
        this.dateTypeName = dateTypeName;
    }

    public List<ComponentDatesLog> getComponentDatesLogList() {
        return componentDatesLogList;
    }

    public void setComponentDatesLogList(List<ComponentDatesLog> componentDatesLogList) {
        this.componentDatesLogList = componentDatesLogList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dateTypeId != null ? dateTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DateType)) {
            return false;
        }
        DateType other = (DateType) object;
        if ((this.dateTypeId == null && other.dateTypeId != null) || (this.dateTypeId != null && !this.dateTypeId.equals(other.dateTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.DateType[ dateTypeId=" + dateTypeId + " ]";
    }

}
