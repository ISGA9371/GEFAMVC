/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbva.bancomer.business.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Guevara
 */
@Entity
@Table(name = "thge011_usuario", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CD_USUARIO_CORP"})})
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "SELECT t FROM User t")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_USUARIO", nullable = false)
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "CD_USUARIO_CORP", nullable = false, length = 10)
    private String cdUsuarioCorp;
    @Basic(optional = false)
    @Column(name = "NB_USUARIO", nullable = false, length = 50)
    private String userName;
    @Basic(optional = false)
    @Column(name = "NB_APELL_PAT", nullable = false, length = 30)
    private String userFirstName;
    @Column(name = "NB_APELL_MAT", length = 30)
    private String userSecondName;
    @Column(name = "CD_CONTRASENA", length = 9)
    private String userPassword;
    @Column(name = "TX_CORREO_ELECTR", length = 70)
    private String userEmail;
    @OneToMany(mappedBy = "cdUsuarioSolic")
    private List<Budget> pepList;
    @OneToMany(mappedBy = "cdUsuarioResp")
    private List<Budget> pepList1;
    @OneToMany(mappedBy = "cdUsuRespDyd")
    private List<Transfer> transferList;
    @JoinColumn(name = "ST_ESTADO_USUARIO", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status stStatusUsuario;
    @JoinColumn(name = "CD_NIVEL", referencedColumnName = "CD_NIVEL")
    @ManyToOne
    private Level cdLevel;
    @JoinColumn(name = "CD_PERF_USU", referencedColumnName = "CD_TIPO_PERFIL", nullable = false)
    @ManyToOne(optional = false)
    private ProfileType cdProfileType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdUsuarioGestor")
    private List<Requirement> requirementList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdUsuarioResp")
    private List<Requirement> requirementList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdUsuPeticion")
    private List<Modification> modificationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdRespResol")
    private List<Modification> modificationList1;
    @OneToMany(mappedBy = "cdDuenoProd")
    private List<ProgramIncrement> programIncrementList;
    @OneToMany(mappedBy = "cdExpertoScrum")
    private List<ProgramIncrement> programIncrementList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdUsuPeticion")
    private List<Doubt> doubtList;
    @OneToMany(mappedBy = "cdUsuResp")
    private List<Doubt> doubtList1;
    @OneToMany(mappedBy = "cdUsuarioGestor")
    private List<ExternalUser> externalUserList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdUsuarioResp")
    private List<ExternalUser> externalUserList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdUsuarioResp")
    private List<T955> t955List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdUsuPeticion")
    private List<Issue> issueList;
    @OneToMany(mappedBy = "cdUsuResp")
    private List<Issue> issueList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdUsuarioResp")
    private List<Level> levelList;

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(Integer userId, String cdUsuarioCorp, String userName, String userFirstName) {
        this.userId = userId;
        this.cdUsuarioCorp = cdUsuarioCorp;
        this.userName = userName;
        this.userFirstName = userFirstName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCdUsuarioCorp() {
        return cdUsuarioCorp;
    }

    public void setCdUsuarioCorp(String cdUsuarioCorp) {
        this.cdUsuarioCorp = cdUsuarioCorp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserSecondName() {
        return userSecondName;
    }

    public void setUserSecondName(String userSecondName) {
        this.userSecondName = userSecondName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<Budget> getPepList() {
        return pepList;
    }

    public void setPepList(List<Budget> pepList) {
        this.pepList = pepList;
    }

    public List<Budget> getPepList1() {
        return pepList1;
    }

    public void setPepList1(List<Budget> pepList1) {
        this.pepList1 = pepList1;
    }

    public List<Transfer> getTransferList() {
        return transferList;
    }

    public void setTransferList(List<Transfer> transferList) {
        this.transferList = transferList;
    }

    public Status getStStatusUsuario() {
        return stStatusUsuario;
    }

    public void setStStatusUsuario(Status stStatusUsuario) {
        this.stStatusUsuario = stStatusUsuario;
    }

    public Level getCdLevel() {
        return cdLevel;
    }

    public void setCdLevel(Level cdLevel) {
        this.cdLevel = cdLevel;
    }

    public ProfileType getCdProfileType() {
        return cdProfileType;
    }

    public void setCdProfileType(ProfileType cdProfileType) {
        this.cdProfileType = cdProfileType;
    }

    public List<Requirement> getRequirementList() {
        return requirementList;
    }

    public void setRequirementList(List<Requirement> requirementList) {
        this.requirementList = requirementList;
    }

    public List<Requirement> getRequirementList1() {
        return requirementList1;
    }

    public void setRequirementList1(List<Requirement> requirementList1) {
        this.requirementList1 = requirementList1;
    }

    public List<Modification> getModificationList() {
        return modificationList;
    }

    public void setModificationList(List<Modification> modificationList) {
        this.modificationList = modificationList;
    }

    public List<Modification> getModificationList1() {
        return modificationList1;
    }

    public void setModificationList1(List<Modification> modificationList1) {
        this.modificationList1 = modificationList1;
    }

    public List<ProgramIncrement> getProgramIncrementList() {
        return programIncrementList;
    }

    public void setProgramIncrementList(List<ProgramIncrement> programIncrementList) {
        this.programIncrementList = programIncrementList;
    }

    public List<ProgramIncrement> getProgramIncrementList1() {
        return programIncrementList1;
    }

    public void setProgramIncrementList1(List<ProgramIncrement> programIncrementList1) {
        this.programIncrementList1 = programIncrementList1;
    }

    public List<Doubt> getDoubtList() {
        return doubtList;
    }

    public void setDoubtList(List<Doubt> doubtList) {
        this.doubtList = doubtList;
    }

    public List<Doubt> getDoubtList1() {
        return doubtList1;
    }

    public void setDoubtList1(List<Doubt> doubtList1) {
        this.doubtList1 = doubtList1;
    }

    public List<ExternalUser> getExternalUserList() {
        return externalUserList;
    }

    public void setExternalUserList(List<ExternalUser> externalUserList) {
        this.externalUserList = externalUserList;
    }

    public List<ExternalUser> getExternalUserList1() {
        return externalUserList1;
    }

    public void setExternalUserList1(List<ExternalUser> externalUserList1) {
        this.externalUserList1 = externalUserList1;
    }

    public List<T955> getT955List() {
        return t955List;
    }

    public void setT955List(List<T955> t955List) {
        this.t955List = t955List;
    }

    public List<Issue> getIssueList() {
        return issueList;
    }

    public void setIssueList(List<Issue> issueList) {
        this.issueList = issueList;
    }

    public List<Issue> getIssueList1() {
        return issueList1;
    }

    public void setIssueList1(List<Issue> issueList1) {
        this.issueList1 = issueList1;
    }

    public List<Level> getLevelList() {
        return levelList;
    }

    public void setLevelList(List<Level> levelList) {
        this.levelList = levelList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.User[ userId=" + userId + " ]";
    }

}
