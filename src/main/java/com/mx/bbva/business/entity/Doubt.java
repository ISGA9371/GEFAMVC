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
 * @author Guevara Manuel
 */
@Entity
@Table(name = "thge027_duda")
@NamedQueries({
        @NamedQuery(name = "Doubt.findAll", query = "SELECT t FROM Doubt t")})
public class Doubt implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_DUDA", nullable = false)
    private Integer doubtId;
    @Column(name = "FH_ALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date doubtUploadDate;
    @Basic(optional = false)
    @Column(name = "TX_VENTREGA", nullable = false, length = 9)
    private String doubtVersion;
    @Basic(optional = false)
    @Column(name = "NB_DESC_DUDA_HIST", nullable = false, length = 600)
    private String doubtDescription;
    @Column(name = "NB_DESC_RES_HIST", length = 600)
    private String doubtDescriptionResponse;
    @Lob
    @Column(name = "TX_DOC_DUDA")
    private byte[] doubtFile;
    @Column(name = "FH_RESOLUCION")
    @Temporal(TemporalType.DATE)
    private Date doubtDateResolution;
    @Column(name = "NU_RES_INCORR")
    private Integer doubtWrongResponse;
    @JoinColumn(name = "ST_DUDA", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status status;
    @JoinColumn(name = "CD_COMPONENTE", referencedColumnName = "CD_COMPONENTE", nullable = false)
    @ManyToOne(optional = false)
    private Component component;
    @JoinColumn(name = "CD_USU_PETICION", referencedColumnName = "CD_USUARIO_CORP", nullable = false)
    @ManyToOne(optional = false)
    private User userSender;
    @JoinColumn(name = "CD_USU_RESP", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne
    private User userReceiver;
    @JoinColumn(name = "CD_PRIORIDAD", referencedColumnName = "CD_PRIORIDAD", nullable = false)
    @ManyToOne(optional = false)
    private Priority priority;
    @JoinColumn(name = "CD_TIPO_DUDA", referencedColumnName = "CD_TIPO_DUDA", nullable = false)
    @ManyToOne(optional = false)
    private DoubtType doubtType;

    public Doubt() {
    }

    public Doubt(Integer doubtId) {
        this.doubtId = doubtId;
    }

    public Doubt(Integer doubtId, Date doubtUploadDate, String doubtVersion, String doubtDescription) {
        this.doubtId = doubtId;
        this.doubtUploadDate = doubtUploadDate;
        this.doubtVersion = doubtVersion;
        this.doubtDescription = doubtDescription;
    }

    public Integer getDoubtId() {
        return doubtId;
    }

    public void setDoubtId(Integer doubtId) {
        this.doubtId = doubtId;
    }

    public Date getDoubtUploadDate() {
        return doubtUploadDate;
    }

    public void setDoubtUploadDate(Date doubtUploadDate) {
        this.doubtUploadDate = doubtUploadDate;
    }

    public String getDoubtVersion() {
        return doubtVersion;
    }

    public void setDoubtVersion(String doubtVersion) {
        this.doubtVersion = doubtVersion;
    }

    public String getDoubtDescription() {
        return doubtDescription;
    }

    public void setDoubtDescription(String doubtDescription) {
        this.doubtDescription = doubtDescription;
    }

    public String getDoubtDescriptionResponse() {
        return doubtDescriptionResponse;
    }

    public void setDoubtDescriptionResponse(String doubtDescriptionResponse) {
        this.doubtDescriptionResponse = doubtDescriptionResponse;
    }

    public byte[] getDoubtFile() {
        return doubtFile;
    }

    public void setDoubtFile(byte[] doubtFile) {
        this.doubtFile = doubtFile;
    }

    public Date getDoubtDateResolution() {
        return doubtDateResolution;
    }

    public void setDoubtDateResolution(Date doubtDateResolution) {
        this.doubtDateResolution = doubtDateResolution;
    }

    public Integer getDoubtWrongResponse() {
        return doubtWrongResponse;
    }

    public void setDoubtWrongResponse(Integer doubtWrongResponse) {
        this.doubtWrongResponse = doubtWrongResponse;
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

    public User getUserReceiver() {
        return userReceiver;
    }

    public void setUserReceiver(User userReceiver) {
        this.userReceiver = userReceiver;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public DoubtType getDoubtType() {
        return doubtType;
    }

    public void setDoubtType(DoubtType doubtType) {
        this.doubtType = doubtType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doubtId != null ? doubtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Doubt)) {
            return false;
        }
        Doubt other = (Doubt) object;
        return (this.doubtId != null || other.doubtId == null) && (this.doubtId == null || this.doubtId.equals(other.doubtId));
    }

    @Override
    public String toString() {
        return "com.bbva.Doubt[ doubtId=" + doubtId + " ]";
    }

}
