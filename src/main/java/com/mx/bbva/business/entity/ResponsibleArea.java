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
 * @author Guevara
 */
@Entity
@Table(name = "thge051_ac_res_cor", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CD_ACEPTA_RES_COR"})
        , @UniqueConstraint(columnNames = {"NB_ACEPTA_RES_COR"})})
public class ResponsibleArea implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_CONS_ACEPTA", nullable = false)
    private Integer responsibleAreaSerial;
    @Basic(optional = false)
    @Column(name = "CD_ACEPTA_RES_COR", nullable = false)
    private int responsibleAreaId;
    @Basic(optional = false)
    @Column(name = "NB_ACEPTA_RES_COR", nullable = false, length = 25)
    private String responsibleAreaName;
    @JsonIgnore
    @OneToMany(mappedBy = "responsibleArea")
    private List<T955> t955List;

    public ResponsibleArea() {
    }

    public ResponsibleArea(Integer responsibleAreaSerial) {
        this.responsibleAreaSerial = responsibleAreaSerial;
    }

    public ResponsibleArea(Integer responsibleAreaSerial, int responsibleAreaId, String responsibleAreaName) {
        this.responsibleAreaSerial = responsibleAreaSerial;
        this.responsibleAreaId = responsibleAreaId;
        this.responsibleAreaName = responsibleAreaName;
    }

    public Integer getResponsibleAreaSerial() {
        return responsibleAreaSerial;
    }

    public void setResponsibleAreaSerial(Integer responsibleAreaSerial) {
        this.responsibleAreaSerial = responsibleAreaSerial;
    }

    public int getResponsibleAreaId() {
        return responsibleAreaId;
    }

    public void setResponsibleAreaId(int responsibleAreaId) {
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
    public int hashCode() {
        int hash = 0;
        hash += (responsibleAreaSerial != null ? responsibleAreaSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ResponsibleArea)) {
            return false;
        }
        ResponsibleArea other = (ResponsibleArea) object;
        return (this.responsibleAreaSerial != null || other.responsibleAreaSerial == null) && (this.responsibleAreaSerial == null || this.responsibleAreaSerial.equals(other.responsibleAreaSerial));
    }

    @Override
    public String toString() {
        return "com.bbva.ResponsibleArea[ responsibleAreaSerial=" + responsibleAreaSerial + " ]";
    }

}
