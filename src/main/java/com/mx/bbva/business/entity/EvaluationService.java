/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author manug
 */
@Entity
@Table(name = "thge062_eval_serv")
public class EvaluationService implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EvaluationServicePK evaluationServicePK;
    @Column(name = "TO_CALIF")
    private String evaluationServiceScore;
    @JoinColumn(name = "CD_TECNOLOGIA", referencedColumnName = "CD_TECNOLOGIA")
    @ManyToOne(optional = false)
    private Technology technology;
    @JoinColumn(name = "CD_EMPRESA", referencedColumnName = "CD_EMPRESA")
    @ManyToOne(optional = false)
    private Company company;

    public EvaluationService() {
    }

    public EvaluationService(EvaluationServicePK evaluationServicePK) {
        this.evaluationServicePK = evaluationServicePK;
    }

    public EvaluationService(EvaluationServicePK evaluationServicePK, String evaluationServiceScore) {
        this.evaluationServicePK = evaluationServicePK;
        this.evaluationServiceScore = evaluationServiceScore;
    }

    public EvaluationService(Date fhInicio, Date fhFin) {
        this.evaluationServicePK = new EvaluationServicePK(fhInicio, fhFin);
    }

    public EvaluationServicePK getEvaluationServicePK() {
        return evaluationServicePK;
    }

    public void setEvaluationServicePK(EvaluationServicePK evaluationServicePK) {
        this.evaluationServicePK = evaluationServicePK;
    }

    public String getEvaluationServiceScore() {
        return evaluationServiceScore;
    }

    public void setEvaluationServiceScore(String evaluationServiceScore) {
        this.evaluationServiceScore = evaluationServiceScore;
    }

    public Technology getTechnology() {
        return technology;
    }

    public void setTechnology(Technology technology) {
        this.technology = technology;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaluationServicePK != null ? evaluationServicePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluationService)) {
            return false;
        }
        EvaluationService other = (EvaluationService) object;
        if ((this.evaluationServicePK == null && other.evaluationServicePK != null) || (this.evaluationServicePK != null && !this.evaluationServicePK.equals(other.evaluationServicePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.EvaluationService[ evaluationServicePK=" + evaluationServicePK + " ]";
    }

}
