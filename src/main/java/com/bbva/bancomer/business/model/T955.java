/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbva.bancomer.business.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Guevara
 */
@Entity
@Table(name = "THGE048_t955")
public class T955 implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected T955PK t955PK;
    @Basic(optional = false)
    @Column(name = "TX_NIVEL_PBA", nullable = false, length = 50)
    private String t955LevelPba;
    @Basic(optional = false)
    @Column(name = "FH_IDENTIFICACION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date t955IdentificationDate;
    @Column(name = "TX_MODULO_PAQ", length = 50)
    private String t955ModuloPackage;
    @Column(name = "TX_EVIDENCIA_PBA")
    private byte[] t955EvidencePba;
    @Column(name = "NB_DESC_HALLAZGO", length = 500)
    private String t955Description;
    @Column(name = "TX_RESUL_ESPERADO", length = 500)
    private String t955ExpectedResult;
    @Column(name = "TX_COM_AREA_RESOL", length = 500)
    private String t955AreaResponsible;
    @Column(name = "FH_ATENC_PREV")
    @Temporal(TemporalType.DATE)
    private Date t955AttentionDate;
    @Column(name = "NU_PERIODO_CORREC")
    private Integer t955Fixes;
    @Column(name = "TX_COMENT_F_PBA", length = 500)
    private String t955CommentsPba;
    @Column(name = "FH_SOLIC_VERIF")
    @Temporal(TemporalType.DATE)
    private Date t955VerificationDate;
    @Column(name = "FH_REAL_CIERRE")
    @Temporal(TemporalType.DATE)
    private Date t955RealDate;
    @JoinColumn(name = "CD_ENTORNO", referencedColumnName = "CD_ENTORNO", nullable = false)
    @ManyToOne(optional = false)
    private Environment environment;
    @JoinColumn(name = "CD_EDO_DEFECTO", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status status;
    @JoinColumn(name = "CD_USUARIO_RESP", referencedColumnName = "CD_USUARIO_CORP", nullable = false)
    @ManyToOne(optional = false)
    private User user;
    @JoinColumn(name = "CD_REQUERIMIENTO", referencedColumnName = "CD_REQUERIMIENTO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Requirement requirement;
    @JoinColumn(name = "CD_T926", referencedColumnName = "CD_T926", nullable = false)
    @ManyToOne(optional = false)
    private T926 t926;
    @JoinColumn(name = "CD_C204", referencedColumnName = "CD_C204", nullable = false)
    @ManyToOne(optional = false)
    private TestCaseC204 testCaseC204;
    @JoinColumn(name = "CD_SEVERIDAD", referencedColumnName = "CD_SEVERIDAD", nullable = false)
    @ManyToOne(optional = false)
    private Severity severity;
    @JoinColumn(name = "CD_ACEPTA_RES_COR", referencedColumnName = "CD_ACEPTA_RES_COR")
    @ManyToOne
    private ResponsibleArea responsibleArea;
    @JoinColumn(name = "CD_CAUSA_RECHAZO", referencedColumnName = "CD_CAUSA_RECHAZO")
    @ManyToOne
    private CauseRejection causeRejection;
    @JoinColumn(name = "CD_CAUSA_CIERRE", referencedColumnName = "CD_CONS_CAUSA_C")
    @ManyToOne
    private CauseClosure causeClosure;
    @JoinColumn(name = "CD_RESULT_VERIF", referencedColumnName = "CD_CONS_RESUL_VER")
    @ManyToOne
    private VerificationResult verificationResult;

    public T955() {
    }

    public T955(T955PK t955PK) {
        this.t955PK = t955PK;
    }

    public T955(T955PK t955PK, String t955LevelPba, Date T955IdentificationDate) {
        this.t955PK = t955PK;
        this.t955LevelPba = t955LevelPba;
        this.t955IdentificationDate = T955IdentificationDate;
    }

    public T955(int cdDefecto, int cdRequerimiento) {
        this.t955PK = new T955PK(cdDefecto, cdRequerimiento);
    }

    public T955PK getT955PK() {
        return t955PK;
    }

    public void setT955PK(T955PK t955PK) {
        this.t955PK = t955PK;
    }

    public String getT955LevelPba() {
        return t955LevelPba;
    }

    public void setT955LevelPba(String t955LevelPba) {
        this.t955LevelPba = t955LevelPba;
    }

    public Date getT955IdentificationDate() {
        return t955IdentificationDate;
    }

    public void setT955IdentificationDate(Date t955IdentificationDate) {
        this.t955IdentificationDate = t955IdentificationDate;
    }

    public String getT955ModuloPackage() {
        return t955ModuloPackage;
    }

    public void setT955ModuloPackage(String t955ModuloPackage) {
        this.t955ModuloPackage = t955ModuloPackage;
    }

    public byte[] getT955EvidencePba() {
        return t955EvidencePba;
    }

    public void setT955EvidencePba(byte[] t955EvidencePba) {
        this.t955EvidencePba = t955EvidencePba;
    }

    public String getT955Description() {
        return t955Description;
    }

    public void setT955Description(String t955Description) {
        this.t955Description = t955Description;
    }

    public String getT955ExpectedResult() {
        return t955ExpectedResult;
    }

    public void setT955ExpectedResult(String t955ExpectedResult) {
        this.t955ExpectedResult = t955ExpectedResult;
    }

    public String getT955AreaResponsible() {
        return t955AreaResponsible;
    }

    public void setT955AreaResponsible(String t955AreaResponsible) {
        this.t955AreaResponsible = t955AreaResponsible;
    }

    public Date getT955AttentionDate() {
        return t955AttentionDate;
    }

    public void setT955AttentionDate(Date t955AttentionDate) {
        this.t955AttentionDate = t955AttentionDate;
    }

    public Integer getT955Fixes() {
        return t955Fixes;
    }

    public void setT955Fixes(Integer t955Fixes) {
        this.t955Fixes = t955Fixes;
    }

    public String getT955CommentsPba() {
        return t955CommentsPba;
    }

    public void setT955CommentsPba(String t955CommentsPba) {
        this.t955CommentsPba = t955CommentsPba;
    }

    public Date getT955VerificationDate() {
        return t955VerificationDate;
    }

    public void setT955VerificationDate(Date t955VerificationDate) {
        this.t955VerificationDate = t955VerificationDate;
    }

    public Date getT955RealDate() {
        return t955RealDate;
    }

    public void setT955RealDate(Date t955RealDate) {
        this.t955RealDate = t955RealDate;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Requirement getRequirement() {
        return requirement;
    }

    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }

    public T926 getT926() {
        return t926;
    }

    public void setT926(T926 t926) {
        this.t926 = t926;
    }

    public TestCaseC204 getTestCaseC204() {
        return testCaseC204;
    }

    public void setTestCaseC204(TestCaseC204 testCaseC204) {
        this.testCaseC204 = testCaseC204;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public ResponsibleArea getResponsibleArea() {
        return responsibleArea;
    }

    public void setResponsibleArea(ResponsibleArea responsibleArea) {
        this.responsibleArea = responsibleArea;
    }

    public CauseRejection getCauseRejection() {
        return causeRejection;
    }

    public void setCauseRejection(CauseRejection causeRejection) {
        this.causeRejection = causeRejection;
    }

    public CauseClosure getCauseClosure() {
        return causeClosure;
    }

    public void setCauseClosure(CauseClosure causeClosure) {
        this.causeClosure = causeClosure;
    }

    public VerificationResult getVerificationResult() {
        return verificationResult;
    }

    public void setVerificationResult(VerificationResult verificationResult) {
        this.verificationResult = verificationResult;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (t955PK != null ? t955PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof T955)) {
            return false;
        }
        T955 other = (T955) object;
        return (this.t955PK != null || other.t955PK == null) && (this.t955PK == null || this.t955PK.equals(other.t955PK));
    }

    @Override
    public String toString() {
        return "com.bbva.T955[ t955PK=" + t955PK + " ]";
    }

}
