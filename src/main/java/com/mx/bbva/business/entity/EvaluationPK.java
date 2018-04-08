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
public class EvaluationPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "FH_INICIO")
    @Temporal(TemporalType.DATE)
    private Date evaluationStartDate;
    @Basic(optional = false)
    @Column(name = "FH_FIN")
    @Temporal(TemporalType.DATE)
    private Date evaluationFinalDate;

    public EvaluationPK() {
    }

    public EvaluationPK(Date evaluationStartDate, Date evaluationFinalDate) {
        this.evaluationStartDate = evaluationStartDate;
        this.evaluationFinalDate = evaluationFinalDate;
    }

    public Date getEvaluationStartDate() {
        return evaluationStartDate;
    }

    public void setEvaluationStartDate(Date evaluationStartDate) {
        this.evaluationStartDate = evaluationStartDate;
    }

    public Date getEvaluationFinalDate() {
        return evaluationFinalDate;
    }

    public void setEvaluationFinalDate(Date evaluationFinalDate) {
        this.evaluationFinalDate = evaluationFinalDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaluationStartDate != null ? evaluationStartDate.hashCode() : 0);
        hash += (evaluationFinalDate != null ? evaluationFinalDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluationPK)) {
            return false;
        }
        EvaluationPK other = (EvaluationPK) object;
        if ((this.evaluationStartDate == null && other.evaluationStartDate != null) || (this.evaluationStartDate != null && !this.evaluationStartDate.equals(other.evaluationStartDate))) {
            return false;
        }
        if ((this.evaluationFinalDate == null && other.evaluationFinalDate != null) || (this.evaluationFinalDate != null && !this.evaluationFinalDate.equals(other.evaluationFinalDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.EvaluationPK[ evaluationStartDate=" + evaluationStartDate + ", evaluationFinalDate=" + evaluationFinalDate + " ]";
    }
    
}
