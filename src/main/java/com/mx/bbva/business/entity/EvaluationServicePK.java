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
 *
 * @author manug
 */
@Embeddable
public class EvaluationServicePK implements Serializable {

    @Column(name = "FH_INICIO")
    @Temporal(TemporalType.DATE)
    private Date EvaluationServiceStartDate;
    @Column(name = "FH_FIN")
    @Temporal(TemporalType.DATE)
    private Date EvaluationServiceFinalDate;

    public EvaluationServicePK() {
    }

    public EvaluationServicePK(Date EvaluationServiceStartDate, Date EvaluationServiceFinalDate) {
        this.EvaluationServiceStartDate = EvaluationServiceStartDate;
        this.EvaluationServiceFinalDate = EvaluationServiceFinalDate;
    }

    public Date getEvaluationServiceStartDate() {
        return EvaluationServiceStartDate;
    }

    public void setEvaluationServiceStartDate(Date evaluationServiceStartDate) {
        this.EvaluationServiceStartDate = evaluationServiceStartDate;
    }

    public Date getEvaluationServiceFinalDate() {
        return EvaluationServiceFinalDate;
    }

    public void setEvaluationServiceFinalDate(Date evaluationServiceFinalDate) {
        this.EvaluationServiceFinalDate = evaluationServiceFinalDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (EvaluationServiceStartDate != null ? EvaluationServiceStartDate.hashCode() : 0);
        hash += (EvaluationServiceFinalDate != null ? EvaluationServiceFinalDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluationServicePK)) {
            return false;
        }
        EvaluationServicePK other = (EvaluationServicePK) object;
        if ((this.EvaluationServiceStartDate == null && other.EvaluationServiceStartDate != null) || (this.EvaluationServiceStartDate != null && !this.EvaluationServiceStartDate.equals(other.EvaluationServiceStartDate))) {
            return false;
        }
        if ((this.EvaluationServiceFinalDate == null && other.EvaluationServiceFinalDate != null) || (this.EvaluationServiceFinalDate != null && !this.EvaluationServiceFinalDate.equals(other.EvaluationServiceFinalDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.EvaluationServicePK[ EvaluationServiceStartDate=" + EvaluationServiceStartDate + ", EvaluationServiceFinalDate=" + EvaluationServiceFinalDate + " ]";
    }
    
}
