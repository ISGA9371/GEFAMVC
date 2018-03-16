/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbva.bancomer.business.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Guevara
 */
@Entity
@Table(name = "thge058_ctrl_acc", catalog = "gestion_factoria", schema = "")
public class Access implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_ACCESO", nullable = false)
    private Integer accessId;
    @Basic(optional = false)
    @Column(name = "CD_EXTERNO", nullable = false)
    private int externalUserId;
    @Basic(optional = false)
    @Column(name = "FH_VIGENCIA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date effectiveDate;
    @JoinColumn(name = "ST_ACCESO", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status status;
    @JoinColumn(name = "CD_SEDE", referencedColumnName = "CD_SEDE", nullable = false)
    @ManyToOne(optional = false)
    private Workplace workplace;

    public Access() {
    }

    public Access(Integer accessId) {
        this.accessId = accessId;
    }

    public Access(Integer accessId, int externalUserId, Date effectiveDate) {
        this.accessId = accessId;
        this.externalUserId = externalUserId;
        this.effectiveDate = effectiveDate;
    }

    public Integer getAccessId() {
        return accessId;
    }

    public void setAccessId(Integer accessId) {
        this.accessId = accessId;
    }

    public int getExternalUserId() {
        return externalUserId;
    }

    public void setExternalUserId(int externalUserId) {
        this.externalUserId = externalUserId;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Workplace getWorkplace() {
        return workplace;
    }

    public void setWorkplace(Workplace workplace) {
        this.workplace = workplace;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accessId != null ? accessId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Access)) {
            return false;
        }
        Access other = (Access) object;
        return (this.accessId != null || other.accessId == null) && (this.accessId == null || this.accessId.equals(other.accessId));
    }

    @Override
    public String toString() {
        return "com.bbva.Access[ accessId=" + accessId + " ]";
    }

}
