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
@Table(name = "thge044_c204")
public class TestCaseC204 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_C204", nullable = false)
    private Integer testCaseC204Id;
    @Column(name = "CD_CASO_PRUEBA", nullable = false, length = 12)
    private String testCaseId;
    @Column(name = "TX_COND_DTO_ENTR", length = 200)
    private String testCaseC204Condition;
    @Column(name = "NB_DESC_CASO", length = 1000)
    private String testCaseC204Description;
    @Column(name = "NB_RESULT_ESP")
    private byte[] testCaseC204ExpectedResult;
    @Lob
    @Column(name = "TX_EVIDENCIA_PBA")
    private byte[] testCaseC204EvidencePba;
    @JoinColumn(name = "CD_T926", referencedColumnName = "CD_T926")
    @ManyToOne
    private T926 t926;
    @JoinColumn(name = "CD_PRIORIDAD_CP", referencedColumnName = "CD_PRIORIDAD_CP", nullable = false)
    @ManyToOne(optional = false)
    private PriorityTestCase priorityTestCase;
    @JoinColumn(name = "CD_CATEGORIA_CASO", referencedColumnName = "CD_CATEGORIA_CASO", nullable = false)
    @ManyToOne(optional = false)
    private TestCaseCategory testCaseCategory;
    @JoinColumn(name = "CD_RESUL_OBTENIDO", referencedColumnName = "CD_RESUL_OBTENIDO")
    @ManyToOne
    private Result result;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "testCaseC204")
    private List<T955> t955List;

    public TestCaseC204() {
    }

    public TestCaseC204(Integer testCaseC204Id) {
        this.testCaseC204Id = testCaseC204Id;
    }

    public TestCaseC204(Integer testCaseC204Id, String testCaseId) {
        this.testCaseC204Id = testCaseC204Id;
        this.testCaseId = testCaseId;
    }

    public Integer getTestCaseC204Id() {
        return testCaseC204Id;
    }

    public void setTestCaseC204Id(Integer testCaseC204Id) {
        this.testCaseC204Id = testCaseC204Id;
    }

    public String getTestCaseId() {
        return testCaseId;
    }

    public void setTestCaseId(String testCaseId) {
        this.testCaseId = testCaseId;
    }

    public String getTestCaseC204Condition() {
        return testCaseC204Condition;
    }

    public void setTestCaseC204Condition(String testCaseC204Condition) {
        this.testCaseC204Condition = testCaseC204Condition;
    }

    public String getTestCaseC204Description() {
        return testCaseC204Description;
    }

    public void setTestCaseC204Description(String testCaseC204Description) {
        this.testCaseC204Description = testCaseC204Description;
    }

    public byte[] getTestCaseC204ExpectedResult() {
        return testCaseC204ExpectedResult;
    }

    public void setTestCaseC204ExpectedResult(byte[] testCaseC204ExpectedResult) {
        this.testCaseC204ExpectedResult = testCaseC204ExpectedResult;
    }

    public byte[] getTestCaseC204EvidencePba() {
        return testCaseC204EvidencePba;
    }

    public void setTestCaseC204EvidencePba(byte[] testCaseC204EvidencePba) {
        this.testCaseC204EvidencePba = testCaseC204EvidencePba;
    }

    public List<T955> getT955List() {
        return t955List;
    }

    public void setT955List(List<T955> t955List) {
        this.t955List = t955List;
    }

    public T926 getT926() {
        return t926;
    }

    public void setT926(T926 t926) {
        this.t926 = t926;
    }

    public PriorityTestCase getPriorityTestCase() {
        return priorityTestCase;
    }

    public void setPriorityTestCase(PriorityTestCase priorityTestCase) {
        this.priorityTestCase = priorityTestCase;
    }

    public TestCaseCategory getTestCaseCategory() {
        return testCaseCategory;
    }

    public void setTestCaseCategory(TestCaseCategory testCaseCategory) {
        this.testCaseCategory = testCaseCategory;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (testCaseC204Id != null ? testCaseC204Id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TestCaseC204)) {
            return false;
        }
        TestCaseC204 other = (TestCaseC204) object;
        return (this.testCaseC204Id != null || other.testCaseC204Id == null) && (this.testCaseC204Id == null || this.testCaseC204Id.equals(other.testCaseC204Id));
    }

    @Override
    public String toString() {
        return "com.bbva.TestCaseC204[ testCaseC204Id=" + testCaseC204Id + " ]";
    }

}
