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
@Table(name = "thge047_result_obt", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_RESUL_ONTENIDO"})})
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_RESUL_OBTENIDO", nullable = false)
    private Integer resultId;
    @Column(name = "NB_RESUL_ONTENIDO", nullable = false, length = 25)
    private String resultName;
    @JsonIgnore
    @OneToMany(mappedBy = "result")
    private List<TestCaseC204> testCaseC204List;

    public Result() {
    }

    public Result(Integer resultId) {
        this.resultId = resultId;
    }

    public Result(Integer resultId, String resultName) {
        this.resultId = resultId;
        this.resultName = resultName;
    }

    public Integer getResultId() {
        return resultId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    public String getResultName() {
        return resultName;
    }

    public void setResultName(String resultName) {
        this.resultName = resultName;
    }

    public List<TestCaseC204> getTestCaseC204List() {
        return testCaseC204List;
    }

    public void setTestCaseC204List(List<TestCaseC204> testCaseC204List) {
        this.testCaseC204List = testCaseC204List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resultId != null ? resultId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Result)) {
            return false;
        }
        Result other = (Result) object;
        return (this.resultId != null || other.resultId == null) && (this.resultId == null || this.resultId.equals(other.resultId));
    }

    @Override
    public String toString() {
        return "com.bbva.Result[ resultId=" + resultId + " ]";
    }

}
