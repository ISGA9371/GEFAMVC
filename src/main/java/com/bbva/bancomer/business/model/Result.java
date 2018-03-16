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
@Table(name = "thge047_result_obt", catalog = "gestion_factoria",  uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_RESUL_ONTENIDO"})})
@NamedQueries({
        @NamedQuery(name = "Result.findAll", query = "SELECT t FROM Result t")})
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_RESUL_OBTENIDO", nullable = false)
    private Integer cdResulObtenido;
    @Basic(optional = false)
    @Column(name = "NB_RESUL_ONTENIDO", nullable = false, length = 25)
    private String nbResulOntenido;
    @OneToMany(mappedBy = "cdResulObtenido")
    private List<TestCaseC204> testCaseC204List;

    public Result() {
    }

    public Result(Integer cdResulObtenido) {
        this.cdResulObtenido = cdResulObtenido;
    }

    public Result(Integer cdResulObtenido, String nbResulOntenido) {
        this.cdResulObtenido = cdResulObtenido;
        this.nbResulOntenido = nbResulOntenido;
    }

    public Integer getCdResulObtenido() {
        return cdResulObtenido;
    }

    public void setCdResulObtenido(Integer cdResulObtenido) {
        this.cdResulObtenido = cdResulObtenido;
    }

    public String getNbResulOntenido() {
        return nbResulOntenido;
    }

    public void setNbResulOntenido(String nbResulOntenido) {
        this.nbResulOntenido = nbResulOntenido;
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
        hash += (cdResulObtenido != null ? cdResulObtenido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Result)) {
            return false;
        }
        Result other = (Result) object;
        if ((this.cdResulObtenido == null && other.cdResulObtenido != null) || (this.cdResulObtenido != null && !this.cdResulObtenido.equals(other.cdResulObtenido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Result[ cdResulObtenido=" + cdResulObtenido + " ]";
    }

}
