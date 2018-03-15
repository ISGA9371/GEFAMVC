/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbva.bancomer.business.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Guevara
 */
@Entity
public class ServiceType_ {

    @Id
    Integer serviceTypeId;

    public ServiceType_() {
    }

    public ServiceType_(Integer serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public Integer getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Integer serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }
}
