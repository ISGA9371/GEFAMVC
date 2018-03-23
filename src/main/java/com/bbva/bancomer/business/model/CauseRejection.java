/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbva.bancomer.business.model;

import com.google.appengine.repackaged.org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Guevara
 */
@Entity
@Table(name = "THGE052_causa_rech",   uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CD_CAUSA_RECHAZO"})
        , @UniqueConstraint(columnNames = {"NB_CAUSA_RECHAZO"})})
public class CauseRejection implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_CONS_CAUSA_R", nullable = false)
    private Integer causeRejectionSerial;
    @Basic(optional = false)
    @Column(name = "CD_CAUSA_RECHAZO", nullable = false)
    private int causeRejectionId;
    @Basic(optional = false)
    @Column(name = "NB_CAUSA_RECHAZO", nullable = false, length = 50)
    private String causeRejectionName;
    @JsonIgnore
    @OneToMany(mappedBy = "causeRejection")
    private List<T955> t955List;

    public CauseRejection() {
    }

    public CauseRejection(Integer causeRejectionSerial) {
        this.causeRejectionSerial = causeRejectionSerial;
    }

    public CauseRejection(Integer causeRejectionSerial, int causeRejectionId, String causeRejectionName) {
        this.causeRejectionSerial = causeRejectionSerial;
        this.causeRejectionId = causeRejectionId;
        this.causeRejectionName = causeRejectionName;
    }

    public Integer getCauseRejectionSerial() {
        return causeRejectionSerial;
    }

    public void setCauseRejectionSerial(Integer causeRejectionSerial) {
        this.causeRejectionSerial = causeRejectionSerial;
    }

    public int getCauseRejectionId() {
        return causeRejectionId;
    }

    public void setCauseRejectionId(int causeRejectionId) {
        this.causeRejectionId = causeRejectionId;
    }

    public String getCauseRejectionName() {
        return causeRejectionName;
    }

    public void setCauseRejectionName(String causeRejectionName) {
        this.causeRejectionName = causeRejectionName;
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
        hash += (causeRejectionSerial != null ? causeRejectionSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CauseRejection)) {
            return false;
        }
        CauseRejection other = (CauseRejection) object;
        return (this.causeRejectionSerial != null || other.causeRejectionSerial == null) && (this.causeRejectionSerial == null || this.causeRejectionSerial.equals(other.causeRejectionSerial));
    }

    @Override
    public String toString() {
        return "com.bbva.CauseRejection[ causeRejectionSerial=" + causeRejectionSerial + " ]";
    }

}
