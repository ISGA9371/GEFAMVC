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
    @Column(name = "CD_CAUSA_CIERRE", nullable = false)
    private Integer causeClosureId;
    @Basic(optional = false)
    @Column(name = "NB_CAUSA_CIERRE", nullable = false, length = 25)
    private String causeClosureName;
    @JsonIgnore
    @OneToMany(mappedBy = "causeClosure")
    private List<T955> t955List;

    public CauseClosure() {
    }

    public CauseClosure(Integer causeClosureId) {
        this.causeClosureId = causeClosureId;
    }

    public Integer getCauseClosureId() {
        return causeClosureId;
    }

    public void setCauseClosureId(Integer causeClosureId) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CauseClosure that = (CauseClosure) o;

        return causeClosureId.equals(that.causeClosureId);
    }

    @Override
    public int hashCode() {
        return causeClosureId.hashCode();
    }

    @Override
    public String toString() {
        return "CauseClosure{" +
                "causeClosureId=" + causeClosureId +
                '}';
    }
}
