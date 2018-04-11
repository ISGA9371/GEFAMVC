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
 * @author manug
 */
@Entity
@Table(name = "thge061_metrica")
public class Metric implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_METRICA")
    private Integer metricId;
    @Column(name = "NB_METRICA")
    private String metricName;
    @Column(name = "FA_LMT_INF")
    private Float metricLowLimit;
    @Column(name = "FA_LMT_SUP")
    private Float metricHighLimit;
    @Column(name = "FA_MEDIA")
    private Float metricAverage;
    @JoinColumn(name = "CD_TP_METRICA", referencedColumnName = "CD_TP_METRICA")
    @ManyToOne(optional = false)
    private MetricType metricType;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "metric")
    private List<Evaluation> evaluationList;

    public Metric() {
    }

    public Metric(Integer metricId) {
        this.metricId = metricId;
    }

    public Metric(Integer metricId, String metricName) {
        this.metricId = metricId;
        this.metricName = metricName;
    }

    public Integer getMetricId() {
        return metricId;
    }

    public void setMetricId(Integer metricId) {
        this.metricId = metricId;
    }

    public String getMetricName() {
        return metricName;
    }

    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    public Float getMetricLowLimit() {
        return metricLowLimit;
    }

    public void setMetricLowLimit(Float metricLowLimit) {
        this.metricLowLimit = metricLowLimit;
    }

    public Float getMetricHighLimit() {
        return metricHighLimit;
    }

    public void setMetricHighLimit(Float metricHighLimit) {
        this.metricHighLimit = metricHighLimit;
    }

    public Float getMetricAverage() {
        return metricAverage;
    }

    public void setMetricAverage(Float metricAverage) {
        this.metricAverage = metricAverage;
    }

    public MetricType getMetricType() {
        return metricType;
    }

    public void setMetricType(MetricType metricType) {
        this.metricType = metricType;
    }

    public List<Evaluation> getEvaluationList() {
        return evaluationList;
    }

    public void setEvaluationList(List<Evaluation> evaluationList) {
        this.evaluationList = evaluationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (metricId != null ? metricId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Metric)) {
            return false;
        }
        Metric other = (Metric) object;
        if ((this.metricId == null && other.metricId != null) || (this.metricId != null && !this.metricId.equals(other.metricId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Metric[ metricId=" + metricId + " ]";
    }

}
