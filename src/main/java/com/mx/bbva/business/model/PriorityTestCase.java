/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.model;

import com.google.appengine.repackaged.org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Guevara
 */
@Entity
@Table(name = "thge045_prioridad_cp",  uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_PRIORIDAD_CP"})})
public class PriorityTestCase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_PRIORIDAD_CP", nullable = false)
    private Integer priorityTestCaseId;
    @Basic(optional = false)
    @Column(name = "NB_PRIORIDAD_CP", nullable = false, length = 25)
    private String priorityTestCaseName;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "priorityTestCase")
    private List<TestCaseC204> testCaseC204List;

    public PriorityTestCase() {
    }

    public PriorityTestCase(Integer priorityTestCaseId) {
        this.priorityTestCaseId = priorityTestCaseId;
    }

    public PriorityTestCase(Integer priorityTestCaseId, String priorityTestCaseName) {
        this.priorityTestCaseId = priorityTestCaseId;
        this.priorityTestCaseName = priorityTestCaseName;
    }

    public Integer getPriorityTestCaseId() {
        return priorityTestCaseId;
    }

    public void setPriorityTestCaseId(Integer priorityTestCaseId) {
        this.priorityTestCaseId = priorityTestCaseId;
    }

    public String getPriorityTestCaseName() {
        return priorityTestCaseName;
    }

    public void setPriorityTestCaseName(String priorityTestCaseName) {
        this.priorityTestCaseName = priorityTestCaseName;
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
        hash += (priorityTestCaseId != null ? priorityTestCaseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PriorityTestCase)) {
            return false;
        }
        PriorityTestCase other = (PriorityTestCase) object;
        return (this.priorityTestCaseId != null || other.priorityTestCaseId == null) && (this.priorityTestCaseId == null || this.priorityTestCaseId.equals(other.priorityTestCaseId));
    }

    @Override
    public String toString() {
        return "com.bbva.PriorityTestCase[ priorityTestCaseId=" + priorityTestCaseId + " ]";
    }

}
