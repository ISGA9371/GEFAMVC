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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_USUARIO_CORP", length = 10)
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
    @Column(name = "TP_RECURSO", nullable = false, length = 7)
    private String externalUserType;
    @Basic(optional = false)
    @Column(name = "CD_TIPO_CONTRATO", nullable = false)
    private int externalUserContractType;
    @Column(name = "TX_DIR_SCRUM", length = 25)
    private String externalUserScrumDirector;
    @Column(name = "NB_PROY_EXT", length = 150)
    private String externalUserProjectName;
    @Column(name = "FH_INIC_PROY", length = 45)
    private String externalUserProjectStartDate;
    @Column(name = "FH_FIN_PROY")
    @Temporal(TemporalType.DATE)
    private Date externalUserProjectFinalDate;
    @Basic(optional = false)
    @Column(name = "TP_PROY", nullable = false, length = 8)
    private String externalUserProjectType;
    @Column(name = "NB_JEFE_INMED", length = 50)
    private String externalUserBossName;
    @Column(name = "TX_TEL_JEFE_INMED", length = 25)
    private String externalUserBossPhone;
    @Column(name = "TX_UBIC_JEF_INMED", length = 50)
    private String externalUserBossLocation;
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
    @JoinColumn(name = "CD_EMPRESA", referencedColumnName = "CD_EMPRESA", nullable = false)
    @ManyToOne(optional = false)
    private Company company;
    @JoinColumn(name = "ST_REC_EXT", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status status;
    @JoinColumn(name = "CD_USUARIO_GESTOR", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne
    private User manager;
    @JoinColumn(name = "CD_USUARIO_RESP", referencedColumnName = "CD_USUARIO_CORP", nullable = false)
    @ManyToOne(optional = false)
    private User responsible;
    @JoinColumn(name = "CD_PAIS", referencedColumnName = "CD_PAIS", nullable = false)
    @ManyToOne(optional = false)
    private Country country;
    @JoinColumn(name = "CD_PERFIL_REC", referencedColumnName = "CD_TIPO_PERFIL", nullable = false)
    @ManyToOne(optional = false)
    private ProfileType profileType;
    @JoinColumn(name = "CD_SBCLAS_REC", referencedColumnName = "CD_SBCLAS_REC", nullable = false)
    @ManyToOne(optional = false)
    private ResourceSubClassification resourceSubClassification;
    @JoinColumn(name = "CD_SEDE", referencedColumnName = "CD_SEDE", nullable = false)
    @ManyToOne(optional = false)
    private Workplace workplace;
    @JoinColumn(name = "CD_AREA", referencedColumnName = "CD_AREA", nullable = false)
    @ManyToOne(optional = false)
    private Area area;
    @JoinColumn(name = "CD_TIPO_ASIG", referencedColumnName = "CD_TIPO_ASIG", nullable = false)
    @ManyToOne(optional = false)
    private AssignationType assignationType;

    public ExternalUser() {
    }

    public ExternalUser(String externalUserCorpId) {
        this.externalUserCorpId = externalUserCorpId;
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

    public String getExternalUserType() {
        return externalUserType;
    }

    public void setExternalUserType(String externalUserType) {
        this.externalUserType = externalUserType;
    }

    public int getExternalUserContractType() {
        return externalUserContractType;
    }

    public void setExternalUserContractType(int externalUserContractType) {
        this.externalUserContractType = externalUserContractType;
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

    public String getExternalUserProjectType() {
        return externalUserProjectType;
    }

    public void setExternalUserProjectType(String externalUserProjectType) {
        this.externalUserProjectType = externalUserProjectType;
    }

    public String getExternalUserBossName() {
        return externalUserBossName;
    }

    public void setExternalUserBossName(String externalUserBossName) {
        this.externalUserBossName = externalUserBossName;
    }

    public String getExternalUserBossPhone() {
        return externalUserBossPhone;
    }

    public void setExternalUserBossPhone(String externalUserBossPhone) {
        this.externalUserBossPhone = externalUserBossPhone;
    }

    public String getExternalUserBossLocation() {
        return externalUserBossLocation;
    }

    public void setExternalUserBossLocation(String externalUserBossLocation) {
        this.externalUserBossLocation = externalUserBossLocation;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public User getResponsible() {
        return responsible;
    }

    public void setResponsible(User responsible) {
        this.responsible = responsible;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
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

    public Workplace getWorkplace() {
        return workplace;
    }

    public void setWorkplace(Workplace workplace) {
        this.workplace = workplace;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public AssignationType getAssignationType() {
        return assignationType;
    }

    public void setAssignationType(AssignationType assignationType) {
        this.assignationType = assignationType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExternalUser that = (ExternalUser) o;

        return externalUserCorpId.equals(that.externalUserCorpId);
    }

    @Override
    public int hashCode() {
        return externalUserCorpId.hashCode();
    }

    @Override
    public String toString() {
        return "ExternalUser{" +
                "externalUserCorpId='" + externalUserCorpId + '\'' +
                '}';
    }
}
