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
 * @author Guevara
 */
@Entity
@Table(name = "thge012_traspaso")
public class Transfer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_TRASPASO", nullable = false)
    private Integer transferId;
    @Basic(optional = false)
    @Column(name = "FH_TRASPASO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date transferDate;
    @Column(name = "FH_RETIRO")
    @Temporal(TemporalType.DATE)
    private Date transferWithdrawalDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "IM_TRASPASO", precision = 22)
    private Double transferValue;
    @Column(name = "IM_RETIRO", precision = 22)
    private Double transferWithdrawalValue;
    @Column(name = "TX_COMENTARIO", length = 200)
    private String transferComment;
    @JoinColumn(name = "CD_PEP", referencedColumnName = "CD_PEP")
    @ManyToOne
    private Budget budget;
    @JoinColumn(name = "CD_NIVEL_SUBDIR", referencedColumnName = "CD_NIVEL")
    @ManyToOne
    private Level level;
    @JoinColumn(name = "CD_USU_RESP_DYD", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne
    private User user;

    public Transfer() {
    }

    public Transfer(Integer transferId) {
        this.transferId = transferId;
    }

    public Transfer(Integer transferId, Date transferDate) {
        this.transferId = transferId;
        this.transferDate = transferDate;
    }

    public Integer getTransferId() {
        return transferId;
    }

    public void setTransferId(Integer transferId) {
        this.transferId = transferId;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    public Date getTransferWithdrawalDate() {
        return transferWithdrawalDate;
    }

    public void setTransferWithdrawalDate(Date transferWithdrawalDate) {
        this.transferWithdrawalDate = transferWithdrawalDate;
    }

    public Double getTransferValue() {
        return transferValue;
    }

    public void setTransferValue(Double transferValue) {
        this.transferValue = transferValue;
    }

    public Double getTransferWithdrawalValue() {
        return transferWithdrawalValue;
    }

    public void setTransferWithdrawalValue(Double transferWithdrawalValue) {
        this.transferWithdrawalValue = transferWithdrawalValue;
    }

    public String getTransferComment() {
        return transferComment;
    }

    public void setTransferComment(String transferComment) {
        this.transferComment = transferComment;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transferId != null ? transferId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Transfer)) {
            return false;
        }
        Transfer other = (Transfer) object;
        return (this.transferId != null || other.transferId == null) && (this.transferId == null || this.transferId.equals(other.transferId));
    }

    @Override
    public String toString() {
        return "com.bbva.Transfer[ transferId=" + transferId + " ]";
    }

}
