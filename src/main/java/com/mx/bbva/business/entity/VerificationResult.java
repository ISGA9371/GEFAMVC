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
 * @author Guevara Manuel
 */
@Entity
@Table(name = "thge054_res_verif", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_RESULT_VERIF"})
        , @UniqueConstraint(columnNames = {"CD_RESULT_VERIF"})})
public class VerificationResult implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_RESULT_VERIF", nullable = false)
    private Integer verificationResultId;
    @Column(name = "NB_RESULT_VERIF", nullable = false, length = 25)
    private String verificationResultName;
    @JsonIgnore
    @OneToMany(mappedBy = "verificationResult")
    private List<T955> t955List;

    public VerificationResult() {
    }

    public VerificationResult(Integer verificationResultId) {
        this.verificationResultId = verificationResultId;
    }

    public Integer getVerificationResultId() {
        return verificationResultId;
    }

    public void setVerificationResultId(Integer verificationResultId) {
        this.verificationResultId = verificationResultId;
    }

    public String getVerificationResultName() {
        return verificationResultName;
    }

    public void setVerificationResultName(String verificationResultName) {
        this.verificationResultName = verificationResultName;
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

        VerificationResult that = (VerificationResult) o;

        return verificationResultId.equals(that.verificationResultId);
    }

    @Override
    public int hashCode() {
        return verificationResultId.hashCode();
    }

    @Override
    public String toString() {
        return "VerificationResult{" +
                "verificationResultId=" + verificationResultId +
                '}';
    }
}
