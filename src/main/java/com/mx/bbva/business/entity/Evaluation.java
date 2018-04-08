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
@Table(name = "thge059_h_c_mando")
public class Evaluation implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EvaluationPK evaluationPK;
    @Basic(optional = false)
    @Column(name = "HM_MIL")
    private double evaluationBilledHours;
    @Basic(optional = false)
    @Column(name = "TO_PUNT_ACT")
    private float evaluationPoints;
    @Column(name = "TO_PUNT_METRICA")
    private Float evaluationMetricPoints;
    @JoinColumn(name = "CD_TECNOLOGIA", referencedColumnName = "CD_TECNOLOGIA")
    @ManyToOne(optional = false)
    private Technology technology;
    @JoinColumn(name = "CD_EMPRESA", referencedColumnName = "CD_EMPRESA")
    @ManyToOne(optional = false)
    private Company company;
    @JoinColumn(name = "CD_METRICA", referencedColumnName = "CD_METRICA")
    @ManyToOne(optional = false)
    private Metric metric;

    public Evaluation() {
    }

    public Evaluation(EvaluationPK evaluationPK) {
        this.evaluationPK = evaluationPK;
    }

    public Evaluation(EvaluationPK evaluationPK, double evaluationBilledHours, float evaluationPoints) {
        this.evaluationPK = evaluationPK;
        this.evaluationBilledHours = evaluationBilledHours;
        this.evaluationPoints = evaluationPoints;
    }

    public Evaluation(Date evaluationStartDate, Date evaluationFinalDate) {
        this.evaluationPK = new EvaluationPK(evaluationStartDate, evaluationFinalDate);
    }

    public EvaluationPK getEvaluationPK() {
        return evaluationPK;
    }

    public void setEvaluationPK(EvaluationPK evaluationPK) {
        this.evaluationPK = evaluationPK;
    }

    public double getEvaluationBilledHours() {
        return evaluationBilledHours;
    }

    public void setEvaluationBilledHours(double evaluationBilledHours) {
        this.evaluationBilledHours = evaluationBilledHours;
    }

    public float getEvaluationPoints() {
        return evaluationPoints;
    }

    public void setEvaluationPoints(float evaluationPoints) {
        this.evaluationPoints = evaluationPoints;
    }

    public Float getEvaluationMetricPoints() {
        return evaluationMetricPoints;
    }

    public void setEvaluationMetricPoints(Float evaluationMetricPoints) {
        this.evaluationMetricPoints = evaluationMetricPoints;
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

    public Metric getMetric() {
        return metric;
    }

    public void setMetric(Metric metric) {
        this.metric = metric;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaluationPK != null ? evaluationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluation)) {
            return false;
        }
        Evaluation other = (Evaluation) object;
        if ((this.evaluationPK == null && other.evaluationPK != null) || (this.evaluationPK != null && !this.evaluationPK.equals(other.evaluationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Evaluation[ evaluationPK=" + evaluationPK + " ]";
    }

}
