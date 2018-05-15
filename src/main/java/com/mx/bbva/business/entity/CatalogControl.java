/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author manug
 */
@Entity
@Table(name = "thge100_ctrl_cat", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"TX_CTRL_CAT_TABLA"}),
        @UniqueConstraint(columnNames = {"NB_CTRL_CAT"}),
        @UniqueConstraint(columnNames = {"CD_CTRL_CAT"})})
public class CatalogControl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_CTRL_CAT", nullable = false)
    private Integer catalogControlId;
    @Column(name = "NB_CTRL_CAT", length = 150)
    private String catalogControlName;
    @Column(name = "TX_CTRL_CAT_TABLA", length = 100)
    private String catalogControlTable;
    @JoinColumn(name = "ST_CTRL_CAT", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status status;

    public CatalogControl() {
    }

    public CatalogControl(Integer catalogControlId) {
        this.catalogControlId = catalogControlId;
    }

    public Integer getCatalogControlId() {
        return catalogControlId;
    }

    public void setCatalogControlId(Integer catalogControlId) {
        this.catalogControlId = catalogControlId;
    }

    public String getCatalogControlName() {
        return catalogControlName;
    }

    public void setCatalogControlName(String catalogControlName) {
        this.catalogControlName = catalogControlName;
    }

    public String getCatalogControlTable() {
        return catalogControlTable;
    }

    public void setCatalogControlTable(String catalogControlTable) {
        this.catalogControlTable = catalogControlTable;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catalogControlId != null ? catalogControlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CatalogControl)) {
            return false;
        }
        CatalogControl other = (CatalogControl) object;
        return (this.catalogControlId != null || other.catalogControlId == null) && (this.catalogControlId == null || this.catalogControlId.equals(other.catalogControlId));
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.CatalogControl[ catalogControlId=" + catalogControlId + " ]";
    }

}
