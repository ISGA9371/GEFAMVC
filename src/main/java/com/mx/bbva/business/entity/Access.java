/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Guevara Manuel
 */
@Entity
@Table(name = "thge058_ctrl_acc")
public class Access implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_ACCESO", nullable = false)
    private Integer accessId;
    @Basic(optional = false)
    @Column(name = "FH_VIG_ACC_LOG", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date accessLogicalExpDate;
    @Basic(optional = false)
    @Column(name = "FH_VIG_ACC_FIS", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date accessPhysicalExpDate;
    @JoinColumn(name = "CD_EXTERNO", referencedColumnName = "CD_EXTERNO_CORP", nullable = false)
    @ManyToOne(optional = false)
    private ExternalUser externalUser;
    @JoinColumn(name = "ST_ACCESO_LOG", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status statusLogical;
    @JoinColumn(name = "ST_ACCESO_FIS", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status statusPhysical;
    @JoinColumn(name = "CD_SEDE", referencedColumnName = "CD_SEDE", nullable = false)
    @ManyToOne(optional = false)
    private Workplace workplace;

    public Access() {
    }

    public Access(Integer accessId) {
        this.accessId = accessId;
    }

    public Integer getAccessId() {
        return accessId;
    }

    public void setAccessId(Integer accessId) {
        this.accessId = accessId;
    }

    public Date getAccessLogicalExpDate() {
        return accessLogicalExpDate;
    }

    public void setAccessLogicalExpDate(Date accessLogicalExpDate) {
        this.accessLogicalExpDate = accessLogicalExpDate;
    }

    public Date getAccessPhysicalExpDate() {
        return accessPhysicalExpDate;
    }

    public void setAccessPhysicalExpDate(Date accessPhysicalExpDate) {
        this.accessPhysicalExpDate = accessPhysicalExpDate;
    }

    public ExternalUser getExternalUser() {
        return externalUser;
    }

    public void setExternalUser(ExternalUser externalUser) {
        this.externalUser = externalUser;
    }

    public Status getStatusLogical() {
        return statusLogical;
    }

    public void setStatusLogical(Status statusLogical) {
        this.statusLogical = statusLogical;
    }

    public Status getStatusPhysical() {
        return statusPhysical;
    }

    public void setStatusPhysical(Status statusPhysical) {
        this.statusPhysical = statusPhysical;
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
