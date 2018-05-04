/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Guevara
 */
@Entity
@Table(name = "thge017_requerim", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_REQUERIMIENTO"})})
public class Requirement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_REQUERIMIENTO", nullable = false)
    private Integer requirementId;
    @Column(name = "NB_REQUERIMIENTO", nullable = false, length = 100)
    private String requirementName;
    @Column(name = "NU_HORA_REQ", precision = 22)
    private Double requirementHour;
    @Column(name = "NU_HRS_TOT")
    private Double requirementTotalHours;
    @Column(name = "NU_HRS_FACT")
    private Double requirementBilledHours;
    @Column(name = "NU_HRS_SIN_FACT")
    private Double requirementNoBilledHours;
    @Column(name = "ST_FACTURADO")
    private Boolean requirementBilled;
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss.S")
    @Column(name = "TM_ALTA_REQ")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requirementDateUpload;
    @Column(name = "NU_FACTURABLE")
    private Boolean requirementCanBilled;
    @Column(name = "FH_INICIO_REQ")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date requirementStartDate;
    @Column(name = "FH_FIN_REQ")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date requirementEndDate;
    @JoinColumn(name = "CD_USUARIO_GESTOR", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne
    private User userManager;
    @JoinColumn(name = "CD_TECNOLOGIA", referencedColumnName = "CD_TECNOLOGIA", nullable = false)
    @ManyToOne(optional = false)
    private Technology technology;
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
    @JoinColumn(name = "CD_SDA", referencedColumnName = "CD_SDA")
    @ManyToOne
    private Project project;
    @JoinColumn(name = "CD_AREA", referencedColumnName = "CD_AREA", nullable = false)
    @ManyToOne(optional = false)
    private Area area;
    @JoinColumn(name = "CD_TIPO_SERVICIO", referencedColumnName = "CD_TIPO_SERVICIO")
    @ManyToOne
    private ServiceType serviceType;
    @JoinColumn(name = "CD_CANAL", referencedColumnName = "CD_CANAL")
    @ManyToOne
    private Channel channel;
    @JoinColumn(name = "CD_PI", referencedColumnName = "CD_PI")
    @ManyToOne
    private ProgramIncrement programIncrement;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requirement")
    private List<Invoice> invoices;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "requirement")
    private List<BudgetRequirement> budgetRequirementsList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requirement")
    private List<T926> t926List;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requirement")
    private List<T955> t955List;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requirement")
    private List<Component> components;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requirement")
    private List<RequirementTracking> requirementTrackings;
    @JsonIgnore
    @OneToMany(mappedBy = "requirement")
    private List<ProjectControl> projectControls;
    @Transient
    private List<BudgetRequirement> budgetRequirements;
    @Transient
    private Double fareValue;

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

    public Double getRequirementTotalHours() {
        return requirementTotalHours;
    }

    public void setRequirementTotalHours(Double requirementTotalHours) {
        this.requirementTotalHours = requirementTotalHours;
    }

    public Double getRequirementBilledHours() {
        return requirementBilledHours;
    }

    public void setRequirementBilledHours(Double requirementBilledHours) {
        this.requirementBilledHours = requirementBilledHours;
    }

    public Double getRequirementNoBilledHours() {
        return requirementNoBilledHours;
    }

    public void setRequirementNoBilledHours(Double requirementNoBilledHours) {
        this.requirementNoBilledHours = requirementNoBilledHours;
    }

    public Boolean getRequirementBilled() {
        return requirementBilled;
    }

    public void setRequirementBilled(Boolean requirementBilled) {
        this.requirementBilled = requirementBilled;
    }

    public Date getRequirementDateUpload() {
        return requirementDateUpload;
    }

    public void setRequirementDateUpload(Date requirementDateUpload) {
        this.requirementDateUpload = requirementDateUpload;
    }

    public Boolean getRequirementCanBilled() {
        return requirementCanBilled;
    }

    public void setRequirementCanBilled(Boolean requirementCanBilled) {
        this.requirementCanBilled = requirementCanBilled;
    }

    public Date getRequirementStartDate() {
        return requirementStartDate;
    }

    public void setRequirementStartDate(Date requirementStartDate) {
        this.requirementStartDate = requirementStartDate;
    }

    public Date getRequirementEndDate() {
        return requirementEndDate;
    }

    public void setRequirementEndDate(Date requirementEndDate) {
        this.requirementEndDate = requirementEndDate;
    }

    public User getUserManager() {
        return userManager;
    }

    public void setUserManager(User userManager) {
        this.userManager = userManager;
    }

    public Technology getTechnology() {
        return technology;
    }

    public void setTechnology(Technology technology) {
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public ProgramIncrement getProgramIncrement() {
        return programIncrement;
    }

    public void setProgramIncrement(ProgramIncrement programIncrement) {
        this.programIncrement = programIncrement;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public List<BudgetRequirement> getBudgetRequirementsList() {
        return budgetRequirementsList;
    }

    public void setBudgetRequirementsList(List<BudgetRequirement> budgetRequirementsList) {
        this.budgetRequirementsList = budgetRequirementsList;
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

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public List<RequirementTracking> getRequirementTrackings() {
        return requirementTrackings;
    }

    public void setRequirementTrackings(List<RequirementTracking> requirementTrackings) {
        this.requirementTrackings = requirementTrackings;
    }

    public List<ProjectControl> getProjectControls() {
        return projectControls;
    }

    public void setProjectControls(List<ProjectControl> projectControls) {
        this.projectControls = projectControls;
    }

    public Double getFareValue() {
        return fareValue;
    }

    public void setFareValue(Double fareValue) {
        this.fareValue = fareValue;
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
