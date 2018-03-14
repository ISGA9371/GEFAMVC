/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbva.bancomer.business.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Guevara
 */
@Entity
@Table(name = "thge046_cat_caso", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_CATEGORIA_CASO"})})
@NamedQueries({
        @NamedQuery(name = "TestCaseCategory.findAll", query = "SELECT t FROM TestCaseCategory t")})
public class TestCaseCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_CATEGORIA_CASO", nullable = false)
    private Integer cdCategoriaCaso;
    @Basic(optional = false)
    @Column(name = "NB_CATEGORIA_CASO", nullable = false, length = 50)
    private String nbCategoriaCaso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdCategoriaCaso")
    private List<TestCaseC204> testCaseC204List;

    public TestCaseCategory() {
    }

    public TestCaseCategory(Integer cdCategoriaCaso) {
        this.cdCategoriaCaso = cdCategoriaCaso;
    }

    public TestCaseCategory(Integer cdCategoriaCaso, String nbCategoriaCaso) {
        this.cdCategoriaCaso = cdCategoriaCaso;
        this.nbCategoriaCaso = nbCategoriaCaso;
    }

    public Integer getCdCategoriaCaso() {
        return cdCategoriaCaso;
    }

    public void setCdCategoriaCaso(Integer cdCategoriaCaso) {
        this.cdCategoriaCaso = cdCategoriaCaso;
    }

    public String getNbCategoriaCaso() {
        return nbCategoriaCaso;
    }

    public void setNbCategoriaCaso(String nbCategoriaCaso) {
        this.nbCategoriaCaso = nbCategoriaCaso;
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
        hash += (cdCategoriaCaso != null ? cdCategoriaCaso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestCaseCategory)) {
            return false;
        }
        TestCaseCategory other = (TestCaseCategory) object;
        if ((this.cdCategoriaCaso == null && other.cdCategoriaCaso != null) || (this.cdCategoriaCaso != null && !this.cdCategoriaCaso.equals(other.cdCategoriaCaso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.TestCaseCategory[ cdCategoriaCaso=" + cdCategoriaCaso + " ]";
    }

}
