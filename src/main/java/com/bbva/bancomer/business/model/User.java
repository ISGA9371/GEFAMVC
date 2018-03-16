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
@Table(name = "thge011_usuario", catalog = "gestion_factoria", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CD_USUARIO_CORP"})})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_USUARIO", nullable = false)
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "CD_USUARIO_CORP", nullable = false, length = 10)
    private String userCorp;
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
    @OneToMany(mappedBy = "userSender")
    private List<Budget> budgets;
    @OneToMany(mappedBy = "userReceiver")
    private List<Budget> budgetList;
    @OneToMany(mappedBy = "user")
    private List<Transfer> transfers;
    @JoinColumn(name = "ST_ESTADO_USUARIO", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status status;
    @JoinColumn(name = "CD_NIVEL", referencedColumnName = "CD_NIVEL")
    @ManyToOne
    private Level level;
    @JoinColumn(name = "CD_PERF_USU", referencedColumnName = "CD_TIPO_PERFIL", nullable = false)
    @ManyToOne(optional = false)
    private ProfileType profileType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userManager")
    private List<Requirement> requirements;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Requirement> requirementList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userSender")
    private List<Modification> modifications;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userReceiver")
    private List<Modification> modificationList;
    @OneToMany(mappedBy = "userOwner")
    private List<ProgramIncrement> programIncrements;
    @OneToMany(mappedBy = "userScrumMaster")
    private List<ProgramIncrement> programIncrementList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userSender")
    private List<Doubt> doubts;
    @OneToMany(mappedBy = "userReceiver")
    private List<Doubt> doubtList;
    @OneToMany(mappedBy = "manager")
    private List<ExternalUser> externalUsers;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "responsible")
    private List<ExternalUser> externalUserList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<T955> t955List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userSender")
    private List<Issue> issues;
    @OneToMany(mappedBy = "userReceiver")
    private List<Issue> issueList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Level> levels;

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(Integer userId, String userCorp, String userName, String userFirstName) {
        this.userId = userId;
        this.userCorp = userCorp;
        this.userName = userName;
        this.userFirstName = userFirstName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserCorp() {
        return userCorp;
    }

    public void setUserCorp(String userCorp) {
        this.userCorp = userCorp;
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

    public List<Budget> getBudgets() {
        return budgets;
    }

    public void setBudgets(List<Budget> budgets) {
        this.budgets = budgets;
    }

    public List<Budget> getBudgetList() {
        return budgetList;
    }

    public void setBudgetList(List<Budget> budgetList) {
        this.budgetList = budgetList;
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public ProfileType getProfileType() {
        return profileType;
    }

    public void setProfileType(ProfileType profileType) {
        this.profileType = profileType;
    }

    public List<Requirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Requirement> requirements) {
        this.requirements = requirements;
    }

    public List<Requirement> getRequirementList() {
        return requirementList;
    }

    public void setRequirementList(List<Requirement> requirementList) {
        this.requirementList = requirementList;
    }

    public List<Modification> getModifications() {
        return modifications;
    }

    public void setModifications(List<Modification> modifications) {
        this.modifications = modifications;
    }

    public List<Modification> getModificationList() {
        return modificationList;
    }

    public void setModificationList(List<Modification> modificationList) {
        this.modificationList = modificationList;
    }

    public List<ProgramIncrement> getProgramIncrements() {
        return programIncrements;
    }

    public void setProgramIncrements(List<ProgramIncrement> programIncrements) {
        this.programIncrements = programIncrements;
    }

    public List<ProgramIncrement> getProgramIncrementList() {
        return programIncrementList;
    }

    public void setProgramIncrementList(List<ProgramIncrement> programIncrementList) {
        this.programIncrementList = programIncrementList;
    }

    public List<Doubt> getDoubts() {
        return doubts;
    }

    public void setDoubts(List<Doubt> doubts) {
        this.doubts = doubts;
    }

    public List<Doubt> getDoubtList() {
        return doubtList;
    }

    public void setDoubtList(List<Doubt> doubtList) {
        this.doubtList = doubtList;
    }

    public List<ExternalUser> getExternalUsers() {
        return externalUsers;
    }

    public void setExternalUsers(List<ExternalUser> externalUsers) {
        this.externalUsers = externalUsers;
    }

    public List<ExternalUser> getExternalUserList() {
        return externalUserList;
    }

    public void setExternalUserList(List<ExternalUser> externalUserList) {
        this.externalUserList = externalUserList;
    }

    public List<T955> getT955List() {
        return t955List;
    }

    public void setT955List(List<T955> t955List) {
        this.t955List = t955List;
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    public List<Issue> getIssueList() {
        return issueList;
    }

    public void setIssueList(List<Issue> issueList) {
        this.issueList = issueList;
    }

    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        return (this.userId != null || other.userId == null) && (this.userId == null || this.userId.equals(other.userId));
    }

    @Override
    public String toString() {
        return "com.bbva.User[ userId=" + userId + " ]";
    }

}
