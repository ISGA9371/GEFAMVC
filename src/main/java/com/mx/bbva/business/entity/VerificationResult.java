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
@Table(name = "thge054_res_verif", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_RESULT_VERIF"})
        , @UniqueConstraint(columnNames = {"CD_RESULT_VERIF"})})
public class VerificationResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_CONS_RESUL_VER", nullable = false)
    private Integer verificationResultSerial;
    @Basic(optional = false)
    @Column(name = "CD_RESULT_VERIF", nullable = false)
    private int verificationResultId;
    @Basic(optional = false)
    @Column(name = "NB_RESULT_VERIF", nullable = false, length = 25)
    private String verificationResultName;
    @JsonIgnore
    @OneToMany(mappedBy = "verificationResult")
    private List<T955> t955List;

    public VerificationResult() {
    }

    public VerificationResult(Integer verificationResultSerial) {
        this.verificationResultSerial = verificationResultSerial;
    }

    public VerificationResult(Integer verificationResultSerial, int verificationResultId, String verificationResultName) {
        this.verificationResultSerial = verificationResultSerial;
        this.verificationResultId = verificationResultId;
        this.verificationResultName = verificationResultName;
    }

    public Integer getVerificationResultSerial() {
        return verificationResultSerial;
    }

    public void setVerificationResultSerial(Integer verificationResultSerial) {
        this.verificationResultSerial = verificationResultSerial;
    }

    public int getVerificationResultId() {
        return verificationResultId;
    }

    public void setVerificationResultId(int verificationResultId) {
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
    public int hashCode() {
        int hash = 0;
        hash += (verificationResultSerial != null ? verificationResultSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof VerificationResult)) {
            return false;
        }
        VerificationResult other = (VerificationResult) object;
        return (this.verificationResultSerial != null || other.verificationResultSerial == null) && (this.verificationResultSerial == null || this.verificationResultSerial.equals(other.verificationResultSerial));
    }

    @Override
    public String toString() {
        return "com.bbva.VerificationResult[ verificationResultSerial=" + verificationResultSerial + " ]";
    }

}
