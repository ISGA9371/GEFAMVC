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
 * @author Guevara Manuel
 */
@Entity
@Table(name = "thge051_ac_res_cor", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CD_ACEPTA_RES_COR"})
        , @UniqueConstraint(columnNames = {"NB_ACEPTA_RES_COR"})})
public class ResponsibleArea implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "CD_ACEPTA_RES_COR", nullable = false)
    private Integer responsibleAreaId;

    @Column(name = "NB_ACEPTA_RES_COR", nullable = false, length = 25)
    private String responsibleAreaName;
    @JsonIgnore
    @OneToMany(mappedBy = "responsibleArea")
    private List<T955> t955List;

    public ResponsibleArea() {
    }

    public ResponsibleArea(Integer responsibleAreaId) {
        this.responsibleAreaId = responsibleAreaId;
    }

    public Integer getResponsibleAreaId() {
        return responsibleAreaId;
    }

    public void setResponsibleAreaId(Integer responsibleAreaId) {
        this.responsibleAreaId = responsibleAreaId;
    }

    public String getResponsibleAreaName() {
        return responsibleAreaName;
    }

    public void setResponsibleAreaName(String responsibleAreaName) {
        this.responsibleAreaName = responsibleAreaName;
    }

    public List<T955> getT955List() {
        return t955List;
    }

    public void setT955List(List<T955> t955List) {
        this.t955List = t955List;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResponsibleArea that = (ResponsibleArea) o;

        return responsibleAreaId.equals(that.responsibleAreaId);
    }

    @Override
    public int hashCode() {
        return responsibleAreaId.hashCode();
    }

    @Override
    public String toString() {
        return "ResponsibleArea{" +
                "responsibleAreaId=" + responsibleAreaId +
                '}';
    }
}
