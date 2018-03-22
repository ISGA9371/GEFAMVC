/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbva.bancomer.business.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Guevara
 */
@Entity
@Table(name = "thge017_requerim", catalog = "gestion_factoria", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_REQUERIMIENTO"})})
public class Requirement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_REQUERIMIENTO", nullable = false)
    private Integer requirementId;
    @Basic(optional = false)
    @Column(name = "NB_REQUERIMIENTO", nullable = false, length = 100)
    private String requirementName;
    @Column(name = "NU_HORA_REQ", precision = 22)
    private Double requirementHour;
    @Column(name = "NU_HRS_TOT")
    private Integer requirementTotalHours;
    @Column(name = "NU_HRS_FACT")
    private Integer requirementBilledHours;
    @Column(name = "NU_HRS_SIN_FACT")
    private Integer requirementNoBilledHours;
    @Column(name = "ST_FACTURADO")
    private Short requirementBilled;
    @Column(name = "TM_ALTA_REQ")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requirementDateUpload;
    @Column(name = "NU_FACTURABLE")
    private Short requirementCanBilled;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requirement")
    private List<Invoice> invoices;
    @JoinColumn(name = "CD_USUARIO_GESTOR", referencedColumnName = "CD_USUARIO_CORP", nullable = false)
    @ManyToOne(optional = false)
    private User userManager;
    @JoinColumn(name = "CD_TECNOLOGIA", referencedColumnName = "CD_TECNOLOGIA", nullable = false)
    @ManyToOne(optional = false)
    private Technology_ technology;
    @JoinColumn(name = "CD_EMPRESA", referencedColumnName = "CD_EMPRESA", nullable = false)
    @ManyToOne(optional = false)
    private Company company;
    @JoinColumn(name = "ST_REQUERIMIENTO", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status status;
    @JoinColumn(name = "CD_NIVEL", referencedColumnName = "CD_NIVEL", nullable = false)
    @ManyToOne(optional = false)
    private Level level;
    @JoinColumn(name = "CD_USUARIO_RESP", referencedColumnName = "CD_USUARIO_CORP", nullable = false)
    @ManyToOne(optional = false)
    private User user;
    @JoinColumn(name = "CD_APLICACION", referencedColumnName = "CD_APLICACION")
    @ManyToOne
    private Application application;
    @JoinColumn(name = "CD_SCRUM", referencedColumnName = "CD_SCRUM")
    @ManyToOne
    private ProgramIncrement programIncrementScrum;
    @JoinColumn(name = "CD_AREA", referencedColumnName = "CD_AREA", nullable = false)
    @ManyToOne(optional = false)
    private Area_ area;
    @JoinColumn(name = "CD_TIPO_PROY", referencedColumnName = "CD_TIPO_PROY", nullable = false)
    @ManyToOne(optional = false)
    private ProjectType projectType;
    @JoinColumn(name = "CD_CANAL", referencedColumnName = "CD_CANAL")
    @ManyToOne
    private Channel channel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requirement")
    private List<BudgetRequirement> budgetRequirements;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requirement")
    private List<T926> t926List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requirement")
    private List<T955> t955List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requirement")
    private List<Component_> components;

    public Requirement() {
    }

    public Requirement(Integer requirementId) {
        this.requirementId = requirementId;
    }

    public Requirement(Integer requirementId, String requirementName) {
        this.requirementId = requirementId;
        this.requirementName = requirementName;
    }

    public Integer getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(Integer requirementId) {
        this.requirementId = requirementId;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public Double getRequirementHour() {
        return requirementHour;
    }

    public void setRequirementHour(Double requirementHour) {
        this.requirementHour = requirementHour;
    }

    public Integer getRequirementTotalHours() {
        return requirementTotalHours;
    }

    public void setRequirementTotalHours(Integer requirementTotalHours) {
        this.requirementTotalHours = requirementTotalHours;
    }

    public Integer getRequirementBilledHours() {
        return requirementBilledHours;
    }

    public void setRequirementBilledHours(Integer requirementBilledHours) {
        this.requirementBilledHours = requirementBilledHours;
    }

    public Integer getRequirementNoBilledHours() {
        return requirementNoBilledHours;
    }

    public void setRequirementNoBilledHours(Integer requirementNoBilledHours) {
        this.requirementNoBilledHours = requirementNoBilledHours;
    }

    public Short getRequirementBilled() {
        return requirementBilled;
    }

    public void setRequirementBilled(Short requirementBilled) {
        this.requirementBilled = requirementBilled;
    }

    public Date getRequirementDateUpload() {
        return requirementDateUpload;
    }

    public void setRequirementDateUpload(Date requirementDateUpload) {
        this.requirementDateUpload = requirementDateUpload;
    }

    public Short getRequirementCanBilled() {
        return requirementCanBilled;
    }

    public void setRequirementCanBilled(Short requirementCanBilled) {
        this.requirementCanBilled = requirementCanBilled;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public User getUserManager() {
        return userManager;
    }

    public void setUserManager(User userManager) {
        this.userManager = userManager;
    }

    public Technology_ getTechnology() {
        return technology;
    }

    public void setTechnology(Technology_ technology) {
        this.technology = technology;
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

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public ProgramIncrement getProgramIncrementScrum() {
        return programIncrementScrum;
    }

    public void setProgramIncrementScrum(ProgramIncrement programIncrementScrum) {
        this.programIncrementScrum = programIncrementScrum;
    }

    public Area_ getArea() {
        return area;
    }

    public void setArea(Area_ area) {
        this.area = area;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public List<BudgetRequirement> getBudgetRequirements() {
        return budgetRequirements;
    }

    public void setBudgetRequirements(List<BudgetRequirement> budgetRequirements) {
        this.budgetRequirements = budgetRequirements;
    }

    public List<T926> getT926List() {
        return t926List;
    }

    public void setT926List(List<T926> t926List) {
        this.t926List = t926List;
    }

    public List<T955> getT955List() {
        return t955List;
    }

    public void setT955List(List<T955> t955List) {
        this.t955List = t955List;
    }

    public List<Component_> getComponents() {
        return components;
    }

    public void setComponents(List<Component_> components) {
        this.components = components;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requirementId != null ? requirementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Requirement)) {
            return false;
        }
        Requirement other = (Requirement) object;
        return (this.requirementId != null || other.requirementId == null) && (this.requirementId == null || this.requirementId.equals(other.requirementId));
    }

    @Override
    public String toString() {
        return "com.bbva.Requirement[ requirementId=" + requirementId + " ]";
    }

}
