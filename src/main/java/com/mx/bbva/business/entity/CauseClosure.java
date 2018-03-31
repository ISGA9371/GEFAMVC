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
 * @author Guevara
 */
@Entity
@Table(name = "thge053_causa_cier", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CD_CAUSA_CIERRE"})
        , @UniqueConstraint(columnNames = {"NB_CAUSA_CIERRE"})})
public class CauseClosure implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_CONS_CAUSA_C", nullable = false)
    private Integer causeClosureSerial;
    @Basic(optional = false)
    @Column(name = "CD_CAUSA_CIERRE", nullable = false)
    private int causeClosureId;
    @Basic(optional = false)
    @Column(name = "NB_CAUSA_CIERRE", nullable = false, length = 25)
    private String causeClosureName;
    @JsonIgnore
    @OneToMany(mappedBy = "causeClosure")
    private List<T955> t955List;

    public CauseClosure() {
    }

    public CauseClosure(Integer causeClosureSerial) {
        this.causeClosureSerial = causeClosureSerial;
    }

    public CauseClosure(Integer causeClosureSerial, int causeClosureId, String causeClosureName) {
        this.causeClosureSerial = causeClosureSerial;
        this.causeClosureId = causeClosureId;
        this.causeClosureName = causeClosureName;
    }

    public Integer getCauseClosureSerial() {
        return causeClosureSerial;
    }

    public void setCauseClosureSerial(Integer causeClosureSerial) {
        this.causeClosureSerial = causeClosureSerial;
    }

    public int getCauseClosureId() {
        return causeClosureId;
    }

    public void setCauseClosureId(int causeClosureId) {
        this.causeClosureId = causeClosureId;
    }

    public String getCauseClosureName() {
        return causeClosureName;
    }

    public void setCauseClosureName(String causeClosureName) {
        this.causeClosureName = causeClosureName;
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
        hash += (causeClosureSerial != null ? causeClosureSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CauseClosure)) {
            return false;
        }
        CauseClosure other = (CauseClosure) object;
        return (this.causeClosureSerial != null || other.causeClosureSerial == null) && (this.causeClosureSerial == null || this.causeClosureSerial.equals(other.causeClosureSerial));
    }

    @Override
    public String toString() {
        return "com.bbva.CauseClosure[ causeClosureSerial=" + causeClosureSerial + " ]";
    }

}
