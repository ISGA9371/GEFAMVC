/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Guevara Manuel
 */
@Entity
@Table(name = "thge026_modif")
public class Modification implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_MODIFICACION", nullable = false)
    private Integer modificationId;
    @Column(name = "TX_MOD_EN_VUELO", nullable = false, length = 2)
    private String modificationOnTrack;
    @Column(name = "TX_MOD_RZDA_DYD", nullable = false, length = 2)
    private String modificationDoneDyd;
    @Column(name = "NB_DESC_MODIF", length = 1000)
    private String modificationDescription;
    @Column(name = "FH_ENVIO", nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date modificationSendDate;
    @Column(name = "FH_PREV_FINAL")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date modificationPrevFinalDate;
    @Column(name = "FH_RENEGOCIADA")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date modificationRescheduleDate;
    @Column(name = "FH_CIERRE", nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date modificationEndDate;
    @Column(name = "TX_COMENT_MOD", length = 250)
    private String modificationComment;
    @Column(name = "TX_DIFICULTAD_INI")
    private Character modificationSeverity;
    @Column(name = "IM_COSTE_INIC", precision = 22)
    private Double modificationInitialCost;
    @Column(name = "TX_DIF_EMP")
    private Character txDifEmp;
    @Column(name = "IM_COSTE_EMP", precision = 22)
    private Double modificationPrice;
    @Column(name = "TX_COM_TIPIF_EMP", length = 500)
    private String modificationCommentTypo;
    @Column(name = "TX_COM_TIPIF_PROY", length = 500)
    private String modificationCommentDyd;
    @Column(name = "TX_FACT_S_N", nullable = false, length = 2)
    private String modificationInvoiced;
    @JoinColumn(name = "ST_MODIFICACION", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status modificationStatus;
    @JoinColumn(name = "ST_TIPIF", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status status;
    @JoinColumn(name = "CD_COMPONENTE", referencedColumnName = "CD_COMPONENTE", nullable = false)
    @ManyToOne(optional = false)
    private Component component;
    @JoinColumn(name = "CD_USU_PETICION", referencedColumnName = "CD_USUARIO_CORP", nullable = false)
    @ManyToOne(optional = false)
    private User userSender;
    @JoinColumn(name = "CD_RESP_RESOL", referencedColumnName = "CD_USUARIO_CORP", nullable = false)
    @ManyToOne(optional = false)
    private User userReceiver;
    @JoinColumn(name = "CD_PRIORIDAD_USU", referencedColumnName = "CD_PRIORIDAD", nullable = false)
    @ManyToOne(optional = false)
    private Priority priority;
    @JoinColumn(name = "CD_ORIGEN", referencedColumnName = "CD_ORIGEN", nullable = false)
    @ManyToOne(optional = false)
    private Origin origin;
    @JoinColumn(name = "CD_TIPOLOGIA_INI", referencedColumnName = "CD_TIPOLOGIA", nullable = false)
    @ManyToOne(optional = false)
    private Typology startTypology;
    @JoinColumn(name = "CD_TIPOLOGIA_EMP", referencedColumnName = "CD_TIPOLOGIA", nullable = false)
    @ManyToOne(optional = false)
    private Typology finalTypology;

    public Modification() {
    }

    public Modification(Integer modificationId) {
        this.modificationId = modificationId;
    }

    public Modification(Integer modificationId, String modificationOnTrack, String modificationDoneDyd, Date modificationSendDate, Date modificationEndDate, String modificationInvoiced) {
        this.modificationId = modificationId;
        this.modificationOnTrack = modificationOnTrack;
        this.modificationDoneDyd = modificationDoneDyd;
        this.modificationSendDate = modificationSendDate;
        this.modificationEndDate = modificationEndDate;
        this.modificationInvoiced = modificationInvoiced;
    }

    public Integer getModificationId() {
        return modificationId;
    }

    public void setModificationId(Integer modificationId) {
        this.modificationId = modificationId;
    }

    public String getModificationOnTrack() {
        return modificationOnTrack;
    }

    public void setModificationOnTrack(String modificationOnTrack) {
        this.modificationOnTrack = modificationOnTrack;
    }

    public String getModificationDoneDyd() {
        return modificationDoneDyd;
    }

    public void setModificationDoneDyd(String modificationDoneDyd) {
        this.modificationDoneDyd = modificationDoneDyd;
    }

    public String getModificationDescription() {
        return modificationDescription;
    }

    public void setModificationDescription(String modificationDescription) {
        this.modificationDescription = modificationDescription;
    }

    public Date getModificationSendDate() {
        return modificationSendDate;
    }

    public void setModificationSendDate(Date modificationSendDate) {
        this.modificationSendDate = modificationSendDate;
    }

    public Date getModificationPrevFinalDate() {
        return modificationPrevFinalDate;
    }

    public void setModificationPrevFinalDate(Date modificationPrevFinalDate) {
        this.modificationPrevFinalDate = modificationPrevFinalDate;
    }

    public Date getModificationRescheduleDate() {
        return modificationRescheduleDate;
    }

    public void setModificationRescheduleDate(Date modificationRescheduleDate) {
        this.modificationRescheduleDate = modificationRescheduleDate;
    }

    public Date getModificationEndDate() {
        return modificationEndDate;
    }

    public void setModificationEndDate(Date modificationEndDate) {
        this.modificationEndDate = modificationEndDate;
    }

    public String getModificationComment() {
        return modificationComment;
    }

    public void setModificationComment(String modificationComment) {
        this.modificationComment = modificationComment;
    }

    public Character getModificationSeverity() {
        return modificationSeverity;
    }

    public void setModificationSeverity(Character modificationSeverity) {
        this.modificationSeverity = modificationSeverity;
    }

    public Double getModificationInitialCost() {
        return modificationInitialCost;
    }

    public void setModificationInitialCost(Double modificationInitialCost) {
        this.modificationInitialCost = modificationInitialCost;
    }

    public Character getTxDifEmp() {
        return txDifEmp;
    }

    public void setTxDifEmp(Character txDifEmp) {
        this.txDifEmp = txDifEmp;
    }

    public Double getModificationPrice() {
        return modificationPrice;
    }

    public void setModificationPrice(Double modificationPrice) {
        this.modificationPrice = modificationPrice;
    }

    public String getModificationCommentTypo() {
        return modificationCommentTypo;
    }

    public void setModificationCommentTypo(String modificationCommentTypo) {
        this.modificationCommentTypo = modificationCommentTypo;
    }

    public String getModificationCommentDyd() {
        return modificationCommentDyd;
    }

    public void setModificationCommentDyd(String modificationCommentDyd) {
        this.modificationCommentDyd = modificationCommentDyd;
    }

    public String getModificationInvoiced() {
        return modificationInvoiced;
    }

    public void setModificationInvoiced(String modificationInvoiced) {
        this.modificationInvoiced = modificationInvoiced;
    }

    public Status getModificationStatus() {
        return modificationStatus;
    }

    public void setModificationStatus(Status modificationStatus) {
        this.modificationStatus = modificationStatus;
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

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public Typology getStartTypology() {
        return startTypology;
    }

    public void setStartTypology(Typology startTypology) {
        this.startTypology = startTypology;
    }

    public Typology getFinalTypology() {
        return finalTypology;
    }

    public void setFinalTypology(Typology finalTypology) {
        this.finalTypology = finalTypology;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modificationId != null ? modificationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Modification)) {
            return false;
        }
        Modification other = (Modification) object;
        return (this.modificationId != null || other.modificationId == null) && (this.modificationId == null || this.modificationId.equals(other.modificationId));
    }

    @Override
    public String toString() {
        return "com.bbva.Modification[ modificationId=" + modificationId + " ]";
    }

}
