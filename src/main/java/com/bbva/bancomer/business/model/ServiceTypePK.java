/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbva.bancomer.business.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Guevara
 */
@Embeddable
public class ServiceTypePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "CD_TIPO_SERVICIO", nullable = false)
    private int serviceTypeId;
    @Basic(optional = false)
    @Column(name = "THGE030_AREA_CD_AREA", nullable = false)
    private int areaId;

    public ServiceTypePK() {
    }

    public ServiceTypePK(int serviceTypeId, int areaId) {
        this.serviceTypeId = serviceTypeId;
        this.areaId = areaId;
    }

    public int getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(int serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) serviceTypeId;
        hash += (int) areaId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ServiceTypePK)) {
            return false;
        }
        ServiceTypePK other = (ServiceTypePK) object;
        if (this.serviceTypeId != other.serviceTypeId) {
            return false;
        }
        return this.areaId == other.areaId;
    }

    @Override
    public String toString() {
        return "ServiceTypePK{" + "serviceTypeId=" + serviceTypeId + ", areaId=" + areaId + '}';
    }
}
