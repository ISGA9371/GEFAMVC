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
@Table(name = "thge045_prioridad_cp", catalog = "gestion_factoria",  uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_PRIORIDAD_CP"})})
@NamedQueries({
        @NamedQuery(name = "PriorityTestCase.findAll", query = "SELECT t FROM PriorityTestCase t")})
public class PriorityTestCase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_PRIORIDAD_CP", nullable = false)
    private Integer cdPrioridadCp;
    @Basic(optional = false)
    @Column(name = "NB_PRIORIDAD_CP", nullable = false, length = 25)
    private String nbPrioridadCp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdPrioridadCp")
    private List<TestCaseC204> testCaseC204List;

    public PriorityTestCase() {
    }

    public PriorityTestCase(Integer cdPrioridadCp) {
        this.cdPrioridadCp = cdPrioridadCp;
    }

    public PriorityTestCase(Integer cdPrioridadCp, String nbPrioridadCp) {
        this.cdPrioridadCp = cdPrioridadCp;
        this.nbPrioridadCp = nbPrioridadCp;
    }

    public Integer getCdPrioridadCp() {
        return cdPrioridadCp;
    }

    public void setCdPrioridadCp(Integer cdPrioridadCp) {
        this.cdPrioridadCp = cdPrioridadCp;
    }

    public String getNbPrioridadCp() {
        return nbPrioridadCp;
    }

    public void setNbPrioridadCp(String nbPrioridadCp) {
        this.nbPrioridadCp = nbPrioridadCp;
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
        hash += (cdPrioridadCp != null ? cdPrioridadCp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PriorityTestCase)) {
            return false;
        }
        PriorityTestCase other = (PriorityTestCase) object;
        if ((this.cdPrioridadCp == null && other.cdPrioridadCp != null) || (this.cdPrioridadCp != null && !this.cdPrioridadCp.equals(other.cdPrioridadCp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.PriorityTestCase[ cdPrioridadCp=" + cdPrioridadCp + " ]";
    }

}
