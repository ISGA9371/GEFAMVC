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
@Table(name = "thge001_tipo_serv", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_TIPO_SERVICIO"})})
public class ServiceType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "CD_TIPO_SERVICIO", nullable = false)
    private Integer serviceTypeId;

    @Column(name = "NB_TIPO_SERVICIO", nullable = false, length = 50)
    private String serviceTypeName;
    @JoinColumn(name = "CD_AREA", referencedColumnName = "CD_AREA", nullable = false)
    @ManyToOne(optional = false)
    private Area area;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceType")
    private List<Requirement> requirements;

    public ServiceType() {
    }

    public ServiceType(Integer serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public Integer getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Integer serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public List<Requirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Requirement> requirements) {
        this.requirements = requirements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceType)) return false;

        ServiceType that = (ServiceType) o;

        return getServiceTypeId() != null ? getServiceTypeId().equals(that.getServiceTypeId()) : that.getServiceTypeId() == null;
    }

    @Override
    public int hashCode() {
        return getServiceTypeId() != null ? getServiceTypeId().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ServiceType{" + "serviceTypeId=" + serviceTypeId + '}';
    }
}
