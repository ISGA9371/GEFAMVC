/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbva.bancomer.business.model;

import com.google.appengine.repackaged.org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Guevara
 */
@Entity
@Table(name = "THGE046_cat_caso", catalog = "gestion_factoria", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_CATEGORIA_CASO"})})
public class TestCaseCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_CATEGORIA_CASO", nullable = false)
    private Integer testCaseCategoryId;
    @Basic(optional = false)
    @Column(name = "NB_CATEGORIA_CASO", nullable = false, length = 50)
    private String testCaseCategoryName;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "testCaseCategory")
    private List<TestCaseC204> testCaseC204List;

    public TestCaseCategory() {
    }

    public TestCaseCategory(Integer testCaseCategoryId) {
        this.testCaseCategoryId = testCaseCategoryId;
    }

    public TestCaseCategory(Integer testCaseCategoryId, String testCaseCategoryName) {
        this.testCaseCategoryId = testCaseCategoryId;
        this.testCaseCategoryName = testCaseCategoryName;
    }

    public Integer getTestCaseCategoryId() {
        return testCaseCategoryId;
    }

    public void setTestCaseCategoryId(Integer testCaseCategoryId) {
        this.testCaseCategoryId = testCaseCategoryId;
    }

    public String getTestCaseCategoryName() {
        return testCaseCategoryName;
    }

    public void setTestCaseCategoryName(String testCaseCategoryName) {
        this.testCaseCategoryName = testCaseCategoryName;
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
        hash += (testCaseCategoryId != null ? testCaseCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TestCaseCategory)) {
            return false;
        }
        TestCaseCategory other = (TestCaseCategory) object;
        return (this.testCaseCategoryId != null || other.testCaseCategoryId == null) && (this.testCaseCategoryId == null || this.testCaseCategoryId.equals(other.testCaseCategoryId));
    }

    @Override
    public String toString() {
        return "com.bbva.TestCaseCategory[ testCaseCategoryId=" + testCaseCategoryId + " ]";
    }

}
