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
@Table(name = "thge042_t926", catalog = "gestion_factoria", schema = "")
@NamedQueries({
        @NamedQuery(name = "T926.findAll", query = "SELECT t FROM T926 t")})
public class T926 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_T926", nullable = false)
    private Integer cdT926;
    @Basic(optional = false)
    @Column(name = "CD_FUNCION", nullable = false, length = 5)
    private String cdFuncion;
    @Basic(optional = false)
    @Column(name = "NB_FUNCION", nullable = false, length = 100)
    private String nbFuncion;
    @Column(name = "NU_DEFECTO_ESTIM")
    private Integer nuDefectoEstim;
    @Column(name = "NU_CASO_ESTIM")
    private Integer nuCasoEstim;
    @Column(name = "NU_DEFECTO_REAL")
    private Integer nuDefectoReal;
    @JoinColumn(name = "CD_REQUERIMIENTO", referencedColumnName = "CD_REQUERIMIENTO", nullable = false)
    @ManyToOne(optional = false)
    private Requirement cdRequerimiento;
    @JoinColumn(name = "CD_CRITICIDAD", referencedColumnName = "CD_CRITICIDAD")
    @ManyToOne
    private Critical cdCritical;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdT926")
    private List<T955> t955List;
    @OneToMany(mappedBy = "cdT926")
    private List<TestCaseC204> testCaseC204List;

    public T926() {
    }

    public T926(Integer cdT926) {
        this.cdT926 = cdT926;
    }

    public T926(Integer cdT926, String cdFuncion, String nbFuncion) {
        this.cdT926 = cdT926;
        this.cdFuncion = cdFuncion;
        this.nbFuncion = nbFuncion;
    }

    public Integer getCdT926() {
        return cdT926;
    }

    public void setCdT926(Integer cdT926) {
        this.cdT926 = cdT926;
    }

    public String getCdFuncion() {
        return cdFuncion;
    }

    public void setCdFuncion(String cdFuncion) {
        this.cdFuncion = cdFuncion;
    }

    public String getNbFuncion() {
        return nbFuncion;
    }

    public void setNbFuncion(String nbFuncion) {
        this.nbFuncion = nbFuncion;
    }

    public Integer getNuDefectoEstim() {
        return nuDefectoEstim;
    }

    public void setNuDefectoEstim(Integer nuDefectoEstim) {
        this.nuDefectoEstim = nuDefectoEstim;
    }

    public Integer getNuCasoEstim() {
        return nuCasoEstim;
    }

    public void setNuCasoEstim(Integer nuCasoEstim) {
        this.nuCasoEstim = nuCasoEstim;
    }

    public Integer getNuDefectoReal() {
        return nuDefectoReal;
    }

    public void setNuDefectoReal(Integer nuDefectoReal) {
        this.nuDefectoReal = nuDefectoReal;
    }

    public Requirement getCdRequerimiento() {
        return cdRequerimiento;
    }

    public void setCdRequerimiento(Requirement cdRequerimiento) {
        this.cdRequerimiento = cdRequerimiento;
    }

    public Critical getCdCritical() {
        return cdCritical;
    }

    public void setCdCritical(Critical cdCritical) {
        this.cdCritical = cdCritical;
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
        hash += (cdT926 != null ? cdT926.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T926)) {
            return false;
        }
        T926 other = (T926) object;
        if ((this.cdT926 == null && other.cdT926 != null) || (this.cdT926 != null && !this.cdT926.equals(other.cdT926))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.T926[ cdT926=" + cdT926 + " ]";
    }

}
