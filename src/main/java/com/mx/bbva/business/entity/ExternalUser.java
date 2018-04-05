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
@Table(name = "thge024_ctrl_ext")
public class ExternalUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_EXTERNO_CORP", length = 10)
    private String externalUserCorpId;
    @Basic(optional = false)
    @Column(name = "NB_REC_EXTERNO", nullable = false, length = 50)
    private String externalUserName;
    @Basic(optional = false)
    @Column(name = "NB_APELL_PAT", nullable = false, length = 30)
    private String externalUserLastName;
    @Column(name = "NB_APELL_MAT", length = 30)
    private String externalUserSecondLastName;
    @Column(name = "TX_RFC", length = 13)
    private String externalUserRfc;
    @Column(name = "TX_CURP", length = 18)
    private String externalUserCurp;
    @Column(name = "TX_NSS", length = 11)
    private String externalUserNss;
    @Column(name = "FH_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date externalUserBirthDate;
    @Basic(optional = false)
    @Column(name = "CD_GENERO", nullable = false)
    private Character externalUserGender;
    @Basic(optional = false)
    @Column(name = "TP_IDENTIF", nullable = false)
    private int externalIdType;
    @Column(name = "TX_IDENTIFICACION", length = 10)
    private String externalId;
    @Column(name = "TX_DIR_SCRUM", length = 25)
    private String externalUserScrumDirector;
    @Column(name = "NB_PROY_EXT", length = 150)
    private String externalUserProjectName;
    @Column(name = "FH_INIC_PROY", length = 45)
    private String externalUserProjectStartDate;
    @Column(name = "FH_FIN_PROY")
    @Temporal(TemporalType.DATE)
    private Date externalUserProjectFinalDate;
    @Column(name = "TX_HOST", length = 2)
    private String externalUserHost;
    @Column(name = "TX_VPN", length = 9)
    private String externalUserVpn;
    @Column(name = "FH_VIGENCIA_TOKEN")
    @Temporal(TemporalType.DATE)
    private Date externalUserTokenExpirationDate;
    @Column(name = "NU_PISO")
    private Integer externalUserFloor;
    @Column(name = "TX_ESTACION", length = 6)
    private String externalUserStation;
    @Column(name = "TX_CORREO_ELECTR", length = 70)
    private String externalUserEmail;
    @Column(name = "TX_HORARIO", length = 17)
    private String externalUserSchedule;
    @Column(name = "FH_ALTA")
    @Temporal(TemporalType.DATE)
    private Date externalUserUploadDate;
    @Column(name = "FH_BAJA")
    @Temporal(TemporalType.DATE)
    private Date externalUserEndDate;
    @Basic(optional = false)
    @Column(name = "CD_PROYECTO_AG", nullable = false)
    private int externalGrouperProject;
    @Basic(optional = false)
    @Column(name = "CD_ESQUEMA_PAGO", nullable = false)
    private int externalPaymentScheme;
    @Basic(optional = false)
    @Column(name = "CD_TP_PROYECTO", nullable = false)
    private int externalUserProjectType;
    @JoinColumn(name = "CD_USUARIO_GESTOR", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne
    private User manager;
    @JoinColumn(name = "CD_PAIS", referencedColumnName = "CD_PAIS", nullable = false)
    @ManyToOne(optional = false)
    private Country country;
    @JoinColumn(name = "ST_REC_EXT", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status status;
    @JoinColumn(name = "CD_PERFIL_REC", referencedColumnName = "CD_TIPO_PERFIL", nullable = false)
    @ManyToOne(optional = false)
    private ProfileType profileType;
    @JoinColumn(name = "CD_SBCLAS_REC", referencedColumnName = "CD_SBCLAS_REC", nullable = false)
    @ManyToOne(optional = false)
    private ResourceSubClassification resourceSubClassification;
    @JoinColumn(name = "CD_EMPRESA", referencedColumnName = "CD_EMPRESA", nullable = false)
    @ManyToOne(optional = false)
    private Company company;
    @JoinColumn(name = "CD_AREA", referencedColumnName = "CD_AREA", nullable = false)
    @ManyToOne(optional = false)
    private Area area;
    @JoinColumn(name = "CD_USUARIO_RESP", referencedColumnName = "CD_USUARIO_CORP", nullable = false)
    @ManyToOne(optional = false)
    private User responsible;
    @JoinColumn(name = "CD_SEDE", referencedColumnName = "CD_SEDE", nullable = false)
    @ManyToOne(optional = false)
    private Workplace workplace;
    @JoinColumn(name = "CD_TIPO_ASIG", referencedColumnName = "CD_TIPO_ASIG", nullable = false)
    @ManyToOne(optional = false)
    private AssignationType assignationType;


    public ExternalUser() {
    }

    public ExternalUser(String externalUserCorpId) {
        this.externalUserCorpId = externalUserCorpId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getExternalUserCorpId() {
        return externalUserCorpId;
    }

    public void setExternalUserCorpId(String externalUserCorpId) {
        this.externalUserCorpId = externalUserCorpId;
    }

    public String getExternalUserName() {
        return externalUserName;
    }

    public void setExternalUserName(String externalUserName) {
        this.externalUserName = externalUserName;
    }

    public String getExternalUserLastName() {
        return externalUserLastName;
    }

    public void setExternalUserLastName(String externalUserLastName) {
        this.externalUserLastName = externalUserLastName;
    }

    public String getExternalUserSecondLastName() {
        return externalUserSecondLastName;
    }

    public void setExternalUserSecondLastName(String externalUserSecondLastName) {
        this.externalUserSecondLastName = externalUserSecondLastName;
    }

    public String getExternalUserRfc() {
        return externalUserRfc;
    }

    public void setExternalUserRfc(String externalUserRfc) {
        this.externalUserRfc = externalUserRfc;
    }

    public String getExternalUserCurp() {
        return externalUserCurp;
    }

    public void setExternalUserCurp(String externalUserCurp) {
        this.externalUserCurp = externalUserCurp;
    }

    public String getExternalUserNss() {
        return externalUserNss;
    }

    public void setExternalUserNss(String externalUserNss) {
        this.externalUserNss = externalUserNss;
    }

    public Date getExternalUserBirthDate() {
        return externalUserBirthDate;
    }

    public void setExternalUserBirthDate(Date externalUserBirthDate) {
        this.externalUserBirthDate = externalUserBirthDate;
    }

    public Character getExternalUserGender() {
        return externalUserGender;
    }

    public void setExternalUserGender(Character externalUserGender) {
        this.externalUserGender = externalUserGender;
    }

    public int getExternalIdType() {
        return externalIdType;
    }

    public void setExternalIdType(int externalIdType) {
        this.externalIdType = externalIdType;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getExternalUserScrumDirector() {
        return externalUserScrumDirector;
    }

    public void setExternalUserScrumDirector(String externalUserScrumDirector) {
        this.externalUserScrumDirector = externalUserScrumDirector;
    }

    public String getExternalUserProjectName() {
        return externalUserProjectName;
    }

    public void setExternalUserProjectName(String externalUserProjectName) {
        this.externalUserProjectName = externalUserProjectName;
    }

    public String getExternalUserProjectStartDate() {
        return externalUserProjectStartDate;
    }

    public void setExternalUserProjectStartDate(String externalUserProjectStartDate) {
        this.externalUserProjectStartDate = externalUserProjectStartDate;
    }

    public Date getExternalUserProjectFinalDate() {
        return externalUserProjectFinalDate;
    }

    public void setExternalUserProjectFinalDate(Date externalUserProjectFinalDate) {
        this.externalUserProjectFinalDate = externalUserProjectFinalDate;
    }

    public String getExternalUserHost() {
        return externalUserHost;
    }

    public void setExternalUserHost(String externalUserHost) {
        this.externalUserHost = externalUserHost;
    }

    public String getExternalUserVpn() {
        return externalUserVpn;
    }

    public void setExternalUserVpn(String externalUserVpn) {
        this.externalUserVpn = externalUserVpn;
    }

    public Date getExternalUserTokenExpirationDate() {
        return externalUserTokenExpirationDate;
    }

    public void setExternalUserTokenExpirationDate(Date externalUserTokenExpirationDate) {
        this.externalUserTokenExpirationDate = externalUserTokenExpirationDate;
    }

    public Integer getExternalUserFloor() {
        return externalUserFloor;
    }

    public void setExternalUserFloor(Integer externalUserFloor) {
        this.externalUserFloor = externalUserFloor;
    }

    public String getExternalUserStation() {
        return externalUserStation;
    }

    public void setExternalUserStation(String externalUserStation) {
        this.externalUserStation = externalUserStation;
    }

    public String getExternalUserEmail() {
        return externalUserEmail;
    }

    public void setExternalUserEmail(String externalUserEmail) {
        this.externalUserEmail = externalUserEmail;
    }

    public String getExternalUserSchedule() {
        return externalUserSchedule;
    }

    public void setExternalUserSchedule(String externalUserSchedule) {
        this.externalUserSchedule = externalUserSchedule;
    }

    public Date getExternalUserUploadDate() {
        return externalUserUploadDate;
    }

    public void setExternalUserUploadDate(Date externalUserUploadDate) {
        this.externalUserUploadDate = externalUserUploadDate;
    }

    public Date getExternalUserEndDate() {
        return externalUserEndDate;
    }

    public void setExternalUserEndDate(Date externalUserEndDate) {
        this.externalUserEndDate = externalUserEndDate;
    }

    public int getExternalGrouperProject() {
        return externalGrouperProject;
    }

    public void setExternalGrouperProject(int externalGrouperProject) {
        this.externalGrouperProject = externalGrouperProject;
    }

    public int getExternalPaymentScheme() {
        return externalPaymentScheme;
    }

    public void setExternalPaymentScheme(int externalPaymentScheme) {
        this.externalPaymentScheme = externalPaymentScheme;
    }

    public int getExternalUserProjectType() {
        return externalUserProjectType;
    }

    public void setExternalUserProjectType(int externalUserProjectType) {
        this.externalUserProjectType = externalUserProjectType;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ProfileType getProfileType() {
        return profileType;
    }

    public void setProfileType(ProfileType profileType) {
        this.profileType = profileType;
    }

    public ResourceSubClassification getResourceSubClassification() {
        return resourceSubClassification;
    }

    public void setResourceSubClassification(ResourceSubClassification resourceSubClassification) {
        this.resourceSubClassification = resourceSubClassification;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public User getResponsible() {
        return responsible;
    }

    public void setResponsible(User responsible) {
        this.responsible = responsible;
    }

    public Workplace getWorkplace() {
        return workplace;
    }

    public void setWorkplace(Workplace workplace) {
        this.workplace = workplace;
    }

    public AssignationType getAssignationType() {
        return assignationType;
    }

    public void setAssignationType(AssignationType assignationType) {
        this.assignationType = assignationType;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (externalUserCorpId != null ? externalUserCorpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ExternalUser)) {
            return false;
        }
        ExternalUser other = (ExternalUser) object;
        return (this.externalUserCorpId != null || other.externalUserCorpId == null) && (this.externalUserCorpId == null || this.externalUserCorpId.equals(other.externalUserCorpId));
    }

    @Override
    public String toString() {
        return "com.bbva.ExternalUser[ externalUserCorpId=" + externalUserCorpId + " ]";
    }

}
