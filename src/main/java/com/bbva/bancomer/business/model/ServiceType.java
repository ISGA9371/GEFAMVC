/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbva.bancomer.business.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Guevara
 */
@Entity
@Table(name = "THGE001_tipo_serv", catalog = "gestion_factoria", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_TIPO_SERVICIO"})})
public class ServiceType implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ServiceTypePK serviceTypePK;
    @Basic(optional = false)
    @Column(name = "NB_TIPO_SERVICIO", nullable = false, length = 50)
    private String serviceTypeName;
    @Basic(optional = false)
    @Column(name = "CD_AREA", nullable = false)
    private int areaId;
    @JoinColumn(name = "CD_TIPO_SERVICIO", referencedColumnName = "CD_AREA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Area area;

    public ServiceType() {
    }

    public ServiceType(ServiceTypePK serviceTypePK) {
        this.serviceTypePK = serviceTypePK;
    }

    public ServiceType(ServiceTypePK serviceTypePK, String serviceTypeName, int areaId) {
        this.serviceTypePK = serviceTypePK;
        this.serviceTypeName = serviceTypeName;
        this.areaId = areaId;
    }

    public ServiceType(int cdTipoServicio, int thge030AreaCdArea) {
        this.serviceTypePK = new ServiceTypePK(cdTipoServicio, thge030AreaCdArea);
    }

    public ServiceTypePK getServiceTypePK() {
        return serviceTypePK;
    }

    public void setServiceTypePK(ServiceTypePK serviceTypePK) {
        this.serviceTypePK = serviceTypePK;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceTypePK != null ? serviceTypePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ServiceType)) {
            return false;
        }
        ServiceType other = (ServiceType) object;
        return (this.serviceTypePK != null || other.serviceTypePK == null) && (this.serviceTypePK == null || this.serviceTypePK.equals(other.serviceTypePK));
    }

    @Override
    public String toString() {
        return "ServiceType{" + "serviceTypePK=" + serviceTypePK +  '}';
    }
}
