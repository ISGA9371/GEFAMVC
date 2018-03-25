/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entity;

import com.google.appengine.repackaged.org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Guevara
 */
@Entity
@Table(name = "thge042_t926")
public class T926 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_T926", nullable = false)
    private Integer t926Id;
    @Basic(optional = false)
    @Column(name = "CD_FUNCION", nullable = false, length = 5)
    private String t926FunctionId;
    @Basic(optional = false)
    @Column(name = "NB_FUNCION", nullable = false, length = 100)
    private String t926FunctionName;
    @Column(name = "NU_DEFECTO_ESTIM")
    private Integer t926Issues;
    @Column(name = "NU_CASO_ESTIM")
    private Integer t926Cases;
    @Column(name = "NU_DEFECTO_REAL")
    private Integer t926RealIssues;
    @JoinColumn(name = "CD_REQUERIMIENTO", referencedColumnName = "CD_REQUERIMIENTO", nullable = false)
    @ManyToOne(optional = false)
    private Requirement requirement;
    @JoinColumn(name = "CD_CRITICIDAD", referencedColumnName = "CD_CRITICIDAD")
    @ManyToOne
    private Critical critical;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "t926")
    private List<T955> t955List;
    @JsonIgnore
    @OneToMany(mappedBy = "t926")
    private List<TestCaseC204> testCaseC204List;

    public T926() {
    }

    public T926(Integer t926Id) {
        this.t926Id = t926Id;
    }

    public T926(Integer t926Id, String t926FunctionId, String t926FunctionName) {
        this.t926Id = t926Id;
        this.t926FunctionId = t926FunctionId;
        this.t926FunctionName = t926FunctionName;
    }

    public Integer getT926Id() {
        return t926Id;
    }

    public void setT926Id(Integer t926Id) {
        this.t926Id = t926Id;
    }

    public String getT926FunctionId() {
        return t926FunctionId;
    }

    public void setT926FunctionId(String t926FunctionId) {
        this.t926FunctionId = t926FunctionId;
    }

    public String getT926FunctionName() {
        return t926FunctionName;
    }

    public void setT926FunctionName(String t926FunctionName) {
        this.t926FunctionName = t926FunctionName;
    }

    public Integer getT926Issues() {
        return t926Issues;
    }

    public void setT926Issues(Integer t926Issues) {
        this.t926Issues = t926Issues;
    }

    public Integer getT926Cases() {
        return t926Cases;
    }

    public void setT926Cases(Integer t926Cases) {
        this.t926Cases = t926Cases;
    }

    public Integer getT926RealIssues() {
        return t926RealIssues;
    }

    public void setT926RealIssues(Integer t926RealIssues) {
        this.t926RealIssues = t926RealIssues;
    }

    public Requirement getRequirement() {
        return requirement;
    }

    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }

    public Critical getCritical() {
        return critical;
    }

    public void setCritical(Critical critical) {
        this.critical = critical;
    }

    public List<T955> getT955List() {
        return t955List;
    }

    public void setT955List(List<T955> t955List) {
        this.t955List = t955List;
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
        hash += (t926Id != null ? t926Id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof T926)) {
            return false;
        }
        T926 other = (T926) object;
        return (this.t926Id != null || other.t926Id == null) && (this.t926Id == null || this.t926Id.equals(other.t926Id));
    }

    @Override
    public String toString() {
        return "com.bbva.T926[ t926Id=" + t926Id + " ]";
    }

}
