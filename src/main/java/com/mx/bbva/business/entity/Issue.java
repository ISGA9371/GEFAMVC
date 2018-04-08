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
@Table(name = "thge029_incidencia")
public class Issue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_INCIDENCIA", nullable = false)
    private Integer issueId;
    @Basic(optional = false)
    @Column(name = "FH_ALTA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date issueUploadDate;
    @Basic(optional = false)
    @Column(name = "NB_DESC_INC_HIST", nullable = false, length = 600)
    private String issueInitialDescription;
    @Column(name = "NB_DESC_RESOL_INC", length = 600)
    private String issueInitialFixDescription;
    @Lob
    @Column(name = "TX_DOC_INCIDENCIA")
    private byte[] issueDoc;
    @Column(name = "TX_INC_RLTA_DYD")
    private String issueFixByDyD; // TODO
    @Column(name = "FH_RESOLUCION")
    @Temporal(TemporalType.DATE)
    private Date issueFixDate;
    @Column(name = "NU_RES_INCORR")
    private Integer issueWrongSolution;
    @JoinColumn(name = "ST_INCIDENCIA", referencedColumnName = "CD_ESTADO")
    @ManyToOne
    private Status status;
    @JoinColumn(name = "CD_COMPONENTE", referencedColumnName = "CD_COMPONENTE", nullable = false)
    @ManyToOne(optional = false)
    private Component component;
    @JoinColumn(name = "CD_USU_PETICION", referencedColumnName = "CD_USUARIO_CORP", nullable = false)
    @ManyToOne(optional = false)
    private User userSender;
    @JoinColumn(name = "CD_PRIORIDAD", referencedColumnName = "CD_PRIORIDAD", nullable = false)
    @ManyToOne(optional = false)
    private Priority priority;
    @JoinColumn(name = "CD_ORIGEN", referencedColumnName = "CD_ORIGEN")
    @ManyToOne
    private Origin origin;

    public Issue() {
    }

    public Issue(Integer issueId) {
        this.issueId = issueId;
    }

    public Issue(Integer issueId, Date issueUploadDate, String issueInitialDescription) {
        this.issueId = issueId;
        this.issueUploadDate = issueUploadDate;
        this.issueInitialDescription = issueInitialDescription;
    }

    public Integer getIssueId() {
        return issueId;
    }

    public void setIssueId(Integer issueId) {
        this.issueId = issueId;
    }

    public Date getIssueUploadDate() {
        return issueUploadDate;
    }

    public void setIssueUploadDate(Date issueUploadDate) {
        this.issueUploadDate = issueUploadDate;
    }

    public String getIssueInitialDescription() {
        return issueInitialDescription;
    }

    public void setIssueInitialDescription(String issueInitialDescription) {
        this.issueInitialDescription = issueInitialDescription;
    }

    public String getIssueInitialFixDescription() {
        return issueInitialFixDescription;
    }

    public void setIssueInitialFixDescription(String issueInitialFixDescription) {
        this.issueInitialFixDescription = issueInitialFixDescription;
    }

    public byte[] getIssueDoc() {
        return issueDoc;
    }

    public void setIssueDoc(byte[] issueDoc) {
        this.issueDoc = issueDoc;
    }

    public Date getIssueFixDate() {
        return issueFixDate;
    }

    public void setIssueFixDate(Date issueFixDate) {
        this.issueFixDate = issueFixDate;
    }

    public Integer getIssueWrongSolution() {
        return issueWrongSolution;
    }

    public void setIssueWrongSolution(Integer issueWrongSolution) {
        this.issueWrongSolution = issueWrongSolution;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public User getUserSender() {
        return userSender;
    }

    public void setUserSender(User userSender) {
        this.userSender = userSender;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getIssueFixByDyD() {
        return issueFixByDyD;
    }

    public void setIssueFixByDyD(String issueFixByDyD) {
        this.issueFixByDyD = issueFixByDyD;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (issueId != null ? issueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Issue)) {
            return false;
        }
        Issue other = (Issue) object;
        return (this.issueId != null || other.issueId == null) && (this.issueId == null || this.issueId.equals(other.issueId));
    }

    @Override
    public String toString() {
        return "com.bbva.Issue[ issueId=" + issueId + " ]";
    }

}
