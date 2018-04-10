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
 * @author  Guevara Manuel
 */
@Entity
@Table(name = "thge052_causa_rech", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CD_CAUSA_RECHAZO"})
        , @UniqueConstraint(columnNames = {"NB_CAUSA_RECHAZO"})})
public class CauseRejection implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_CAUSA_RECHAZO", nullable = false)
    private Integer causeRejectionId;
    @Column(name = "NB_CAUSA_RECHAZO", nullable = false, length = 50)
    private String causeRejectionName;
    @JsonIgnore
    @OneToMany(mappedBy = "causeRejection")
    private List<T955> t955List;

    public CauseRejection() {
    }

    public CauseRejection(Integer causeRejectionId) {
        this.causeRejectionId = causeRejectionId;
    }

    public Integer getCauseRejectionId() {
        return causeRejectionId;
    }

    public void setCauseRejectionId(Integer causeRejectionId) {
        this.causeRejectionId = causeRejectionId;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CauseRejection that = (CauseRejection) o;

        return causeRejectionId.equals(that.causeRejectionId);
    }

    @Override
    public int hashCode() {
        return causeRejectionId.hashCode();
    }

    @Override
    public String toString() {
        return "CauseRejection{" +
                "causeRejectionId=" + causeRejectionId +
                '}';
    }
}
