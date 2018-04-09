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
@Table(name = "thge060_tp_metrica")
public class MetricType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_TP_METRICA")
    private Integer metricTypeId;
    @Basic(optional = false)
    @Column(name = "NB_TP_METRICA")
    private String metricTypeName;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "metricType")
    private List<Metric> metrics;

    public MetricType() {
    }

    public MetricType(Integer metricTypeId) {
        this.metricTypeId = metricTypeId;
    }

    public MetricType(Integer metricTypeId, String metricTypeName) {
        this.metricTypeId = metricTypeId;
        this.metricTypeName = metricTypeName;
    }

    public Integer getMetricTypeId() {
        return metricTypeId;
    }

    public void setMetricTypeId(Integer metricTypeId) {
        this.metricTypeId = metricTypeId;
    }

    public String getMetricTypeName() {
        return metricTypeName;
    }

    public void setMetricTypeName(String metricTypeName) {
        this.metricTypeName = metricTypeName;
    }

    public List<Metric> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<Metric> metrics) {
        this.metrics = metrics;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (metricTypeId != null ? metricTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetricType)) {
            return false;
        }
        MetricType other = (MetricType) object;
        if ((this.metricTypeId == null && other.metricTypeId != null) || (this.metricTypeId != null && !this.metricTypeId.equals(other.metricTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.MetricType[ metricTypeId=" + metricTypeId + " ]";
    }

}
