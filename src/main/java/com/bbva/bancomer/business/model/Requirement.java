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
    private Integer cdRequerimiento;
    @Basic(optional = false)
    @Column(name = "NB_REQUERIMIENTO", nullable = false, length = 100)
    private String nbRequerimiento;
    @Column(name = "NU_HORA_REQ", precision = 22)
    private Double nuHoraReq;
    @Column(name = "NU_HRS_TOT")
    private Integer nuHrsTot;
    @Column(name = "NU_HRS_FACT")
    private Integer nuHrsFact;
    @Column(name = "NU_HRS_SIN_FACT")
    private Integer nuHrsSinFact;
    @Column(name = "ST_FACTURADO")
    private Short stFacturado;
    @Column(name = "TM_ALTA_REQ")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tmAltaReq;
    @Column(name = "NU_FACTURABLE")
    private Short nuFacturable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdRequerimiento")
    private List<Invoice> invoiceList;
    @JoinColumn(name = "CD_USUARIO_GESTOR", referencedColumnName = "CD_USUARIO_CORP", nullable = false)
    @ManyToOne(optional = false)
    private User cdUserGestor;
    @JoinColumn(name = "CD_TECNOLOGIA", referencedColumnName = "CD_TECNOLOGIA", nullable = false)
    @ManyToOne(optional = false)
    private Technology cdTechnology;
    @JoinColumn(name = "CD_EMPRESA", referencedColumnName = "CD_EMPRESA", nullable = false)
    @ManyToOne(optional = false)
    private Company cdCompany;
    @JoinColumn(name = "ST_REQUERIMIENTO", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status stRequerimiento;
    @JoinColumn(name = "CD_NIVEL", referencedColumnName = "CD_NIVEL", nullable = false)
    @ManyToOne(optional = false)
    private Level cdLevel;
    @JoinColumn(name = "CD_USUARIO_RESP", referencedColumnName = "CD_USUARIO_CORP", nullable = false)
    @ManyToOne(optional = false)
    private User cdUserResp;
    @JoinColumn(name = "CD_APLICACION", referencedColumnName = "CD_APLICACION")
    @ManyToOne
    private Application cdApplication;
    @JoinColumn(name = "CD_SCRUM", referencedColumnName = "CD_SCRUM")
    @ManyToOne
    private ProgramIncrement cdScrum;
    @JoinColumn(name = "CD_AREA", referencedColumnName = "CD_AREA", nullable = false)
    @ManyToOne(optional = false)
    private Area cdArea;
    @JoinColumn(name = "CD_TIPO_PROY", referencedColumnName = "CD_TIPO_PROY", nullable = false)
    @ManyToOne(optional = false)
    private ProjectType cdProjectType;
    @JoinColumn(name = "CD_CANAL", referencedColumnName = "CD_CANAL")
    @ManyToOne
    private Channel cdChannel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdRequerimiento")
    private List<BudgetRequirement> budgetRequirementList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdRequerimiento")
    private List<T926> t926List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requirement")
    private List<T955> t955List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdRequerimiento")
    private List<Component> componentList;

    public Requirement() {
    }

    public Requirement(Integer cdRequerimiento) {
        this.cdRequerimiento = cdRequerimiento;
    }

    public Requirement(Integer cdRequerimiento, String nbRequerimiento) {
        this.cdRequerimiento = cdRequerimiento;
        this.nbRequerimiento = nbRequerimiento;
    }

    public Integer getCdRequerimiento() {
        return cdRequerimiento;
    }

    public void setCdRequerimiento(Integer cdRequerimiento) {
        this.cdRequerimiento = cdRequerimiento;
    }

    public String getNbRequerimiento() {
        return nbRequerimiento;
    }

    public void setNbRequerimiento(String nbRequerimiento) {
        this.nbRequerimiento = nbRequerimiento;
    }

    public Double getNuHoraReq() {
        return nuHoraReq;
    }

    public void setNuHoraReq(Double nuHoraReq) {
        this.nuHoraReq = nuHoraReq;
    }

    public Integer getNuHrsTot() {
        return nuHrsTot;
    }

    public void setNuHrsTot(Integer nuHrsTot) {
        this.nuHrsTot = nuHrsTot;
    }

    public Integer getNuHrsFact() {
        return nuHrsFact;
    }

    public void setNuHrsFact(Integer nuHrsFact) {
        this.nuHrsFact = nuHrsFact;
    }

    public Integer getNuHrsSinFact() {
        return nuHrsSinFact;
    }

    public void setNuHrsSinFact(Integer nuHrsSinFact) {
        this.nuHrsSinFact = nuHrsSinFact;
    }

    public Short getStFacturado() {
        return stFacturado;
    }

    public void setStFacturado(Short stFacturado) {
        this.stFacturado = stFacturado;
    }

    public Date getTmAltaReq() {
        return tmAltaReq;
    }

    public void setTmAltaReq(Date tmAltaReq) {
        this.tmAltaReq = tmAltaReq;
    }

    public Short getNuFacturable() {
        return nuFacturable;
    }

    public void setNuFacturable(Short nuFacturable) {
        this.nuFacturable = nuFacturable;
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public User getCdUserGestor() {
        return cdUserGestor;
    }

    public void setCdUserGestor(User cdUserGestor) {
        this.cdUserGestor = cdUserGestor;
    }

    public Technology getCdTechnology() {
        return cdTechnology;
    }

    public void setCdTechnology(Technology cdTechnology) {
        this.cdTechnology = cdTechnology;
    }

    public Company getCdCompany() {
        return cdCompany;
    }

    public void setCdCompany(Company cdCompany) {
        this.cdCompany = cdCompany;
    }

    public Status getStRequerimiento() {
        return stRequerimiento;
    }

    public void setStRequerimiento(Status stRequerimiento) {
        this.stRequerimiento = stRequerimiento;
    }

    public Level getCdLevel() {
        return cdLevel;
    }

    public void setCdLevel(Level cdLevel) {
        this.cdLevel = cdLevel;
    }

    public User getCdUserResp() {
        return cdUserResp;
    }

    public void setCdUserResp(User cdUserResp) {
        this.cdUserResp = cdUserResp;
    }

    public Application getCdApplication() {
        return cdApplication;
    }

    public void setCdApplication(Application cdApplication) {
        this.cdApplication = cdApplication;
    }

    public ProgramIncrement getCdScrum() {
        return cdScrum;
    }

    public void setCdScrum(ProgramIncrement cdScrum) {
        this.cdScrum = cdScrum;
    }

    public Area getCdArea() {
        return cdArea;
    }

    public void setCdArea(Area cdArea) {
        this.cdArea = cdArea;
    }

    public ProjectType getCdProjectType() {
        return cdProjectType;
    }

    public void setCdProjectType(ProjectType cdProjectType) {
        this.cdProjectType = cdProjectType;
    }

    public Channel getCdChannel() {
        return cdChannel;
    }

    public void setCdChannel(Channel cdChannel) {
        this.cdChannel = cdChannel;
    }

    public List<BudgetRequirement> getBudgetRequirementList() {
        return budgetRequirementList;
    }

    public void setBudgetRequirementList(List<BudgetRequirement> budgetRequirementList) {
        this.budgetRequirementList = budgetRequirementList;
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

    public List<Component> getComponentList() {
        return componentList;
    }

    public void setComponentList(List<Component> componentList) {
        this.componentList = componentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdRequerimiento != null ? cdRequerimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Requirement)) {
            return false;
        }
        Requirement other = (Requirement) object;
        return (this.cdRequerimiento != null || other.cdRequerimiento == null) && (this.cdRequerimiento == null || this.cdRequerimiento.equals(other.cdRequerimiento));
    }

    @Override
    public String toString() {
        return "com.bbva.Requirement[ cdRequerimiento=" + cdRequerimiento + " ]";
    }

}
