/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Guevara
 */
@Embeddable
public class T955PK implements Serializable {

    @Column(name = "CD_DEFECTO", nullable = false)
    private int t955Id;
    @Column(name = "CD_REQUERIMIENTO", nullable = false)
    private int requirementId;

    public T955PK() {
    }

    public T955PK(int t955Id, int requirementId) {
        this.t955Id = t955Id;
        this.requirementId = requirementId;
    }

    public int getT955Id() {
        return t955Id;
    }

    public void setT955Id(int t955Id) {
        this.t955Id = t955Id;
    }

    public int getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(int requirementId) {
        this.requirementId = requirementId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) t955Id;
        hash += (int) requirementId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof T955PK)) {
            return false;
        }
        T955PK other = (T955PK) object;
        if (this.t955Id != other.t955Id) {
            return false;
        }
        return this.requirementId == other.requirementId;
    }

    @Override
    public String toString() {
        return "com.bbva.T955PK[ t955Id=" + t955Id + ", requirementId=" + requirementId + " ]";
    }

}
