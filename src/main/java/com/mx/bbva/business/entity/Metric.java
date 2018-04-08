/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entity;

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
    @Basic(optional = false)
    @Column(name = "CD_METRICA")
    private Integer cdMetrica;
    @Basic(optional = false)
    @Column(name = "NB_METRICA")
    private String nbMetrica;
    @Column(name = "FA_LMT_INF")
    private Float faLmtInf;
    @Column(name = "FA_LMT_SUP")
    private Float faLmtSup;
    @Column(name = "FA_MEDIA")
    private Float faMedia;
    @JoinColumn(name = "CD_TP_METRICA", referencedColumnName = "CD_TP_METRICA")
    @ManyToOne(optional = false)
    private MetricType metricType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "metric")
    private List<Evaluation> evaluationList;

    public Metric() {
    }

    public Metric(Integer cdMetrica) {
        this.cdMetrica = cdMetrica;
    }

    public Metric(Integer cdMetrica, String nbMetrica) {
        this.cdMetrica = cdMetrica;
        this.nbMetrica = nbMetrica;
    }

    public Integer getCdMetrica() {
        return cdMetrica;
    }

    public void setCdMetrica(Integer cdMetrica) {
        this.cdMetrica = cdMetrica;
    }

    public String getNbMetrica() {
        return nbMetrica;
    }

    public void setNbMetrica(String nbMetrica) {
        this.nbMetrica = nbMetrica;
    }

    public Float getFaLmtInf() {
        return faLmtInf;
    }

    public void setFaLmtInf(Float faLmtInf) {
        this.faLmtInf = faLmtInf;
    }

    public Float getFaLmtSup() {
        return faLmtSup;
    }

    public void setFaLmtSup(Float faLmtSup) {
        this.faLmtSup = faLmtSup;
    }

    public Float getFaMedia() {
        return faMedia;
    }

    public void setFaMedia(Float faMedia) {
        this.faMedia = faMedia;
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
        hash += (cdMetrica != null ? cdMetrica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Metric)) {
            return false;
        }
        Metric other = (Metric) object;
        if ((this.cdMetrica == null && other.cdMetrica != null) || (this.cdMetrica != null && !this.cdMetrica.equals(other.cdMetrica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Metric[ cdMetrica=" + cdMetrica + " ]";
    }

}
