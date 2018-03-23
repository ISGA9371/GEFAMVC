/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbva.bancomer.business.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Guevara
 */
@Entity
@Table(name = "THGE032_tipo_cont",   uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_TIPO_CONTRATO"})})
public class ContractType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_TIPO_CONTRATO", nullable = false)
    private Integer contractTypeId;
    @Basic(optional = false)
    @Column(name = "NB_TIPO_CONTRATO", nullable = false, length = 25)
    private String contractTypeName;

    public ContractType() {
    }

    public ContractType(Integer contractTypeId) {
        this.contractTypeId = contractTypeId;
    }

    public ContractType(Integer contractTypeId, String contractTypeName) {
        this.contractTypeId = contractTypeId;
        this.contractTypeName = contractTypeName;
    }

    public Integer getContractTypeId() {
        return contractTypeId;
    }

    public void setContractTypeId(Integer contractTypeId) {
        this.contractTypeId = contractTypeId;
    }

    public String getContractTypeName() {
        return contractTypeName;
    }

    public void setContractTypeName(String contractTypeName) {
        this.contractTypeName = contractTypeName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contractTypeId != null ? contractTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ContractType)) {
            return false;
        }
        ContractType other = (ContractType) object;
        return (this.contractTypeId != null || other.contractTypeId == null) && (this.contractTypeId == null || this.contractTypeId.equals(other.contractTypeId));
    }

    @Override
    public String toString() {
        return "com.bbva.ContractType[ contractTypeId=" + contractTypeId + " ]";
    }

}
