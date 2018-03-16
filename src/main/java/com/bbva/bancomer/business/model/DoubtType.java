/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbva.bancomer.business.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Guevara
 */
@Entity
@Table(name = "thge028_tipo_duda", catalog = "gestion_factoria",  uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_TIPO_DUDA"})})
public class DoubtType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_TIPO_DUDA", nullable = false)
    private Integer doubtTypeId;
    @Basic(optional = false)
    @Column(name = "NB_TIPO_DUDA", nullable = false, length = 50)
    private String doubtTypeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doubtType")
    private List<Doubt> doubts;

    public DoubtType() {
    }

    public DoubtType(Integer doubtTypeId) {
        this.doubtTypeId = doubtTypeId;
    }

    public DoubtType(Integer doubtTypeId, String doubtTypeName) {
        this.doubtTypeId = doubtTypeId;
        this.doubtTypeName = doubtTypeName;
    }

    public Integer getDoubtTypeId() {
        return doubtTypeId;
    }

    public void setDoubtTypeId(Integer doubtTypeId) {
        this.doubtTypeId = doubtTypeId;
    }

    public String getDoubtTypeName() {
        return doubtTypeName;
    }

    public void setDoubtTypeName(String doubtTypeName) {
        this.doubtTypeName = doubtTypeName;
    }

    public List<Doubt> getDoubts() {
        return doubts;
    }

    public void setDoubts(List<Doubt> doubts) {
        this.doubts = doubts;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doubtTypeId != null ? doubtTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DoubtType)) {
            return false;
        }
        DoubtType other = (DoubtType) object;
        return (this.doubtTypeId != null || other.doubtTypeId == null) && (this.doubtTypeId == null || this.doubtTypeId.equals(other.doubtTypeId));
    }

    @Override
    public String toString() {
        return "com.bbva.DoubtType[ doubtTypeId=" + doubtTypeId + " ]";
    }

}
