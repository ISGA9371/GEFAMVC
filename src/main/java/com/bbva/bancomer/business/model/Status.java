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
@Table(name = "thge005_estado", catalog = "gestion_factoria", schema = "")
@NamedQueries({
        @NamedQuery(name = "Status.findAll", query = "SELECT t FROM Status t")})
public class Status implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_ESTADO", nullable = false)
    private Integer cdEstado;
    @Basic(optional = false)
    @Column(name = "NB_ESTADO", nullable = false, length = 50)
    private String nbEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stEmpresa")
    private List<Company> companyList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stPep")
    private List<Budget> pepList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stDyd")
    private List<Budget> pepList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stTarifa")
    private List<Fare> fareList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stStatusUsuario")
    private List<User> userList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stPepFact")
    private List<Invoice> invoiceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stPago")
    private List<Invoice> invoiceList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stFactHrsProy")
    private List<Invoice> invoiceList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stRequerimiento")
    private List<Requirement> requirementList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stModificacion")
    private List<Modification> modificationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stTipif")
    private List<Modification> modificationList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stContrato")
    private List<Contract> contractList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stAcceso")
    private List<Access> accessList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stDuda")
    private List<Doubt> doubtList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stStatus")
    private List<Typology> typologyList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stRecExt")
    private List<ExternalUser> externalUserList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdEdoDefecto")
    private List<T955> t955List;
    @OneToMany(mappedBy = "stIncidencia")
    private List<Issue> issueList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stTipificacion")
    private List<Component> componentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stComponente")
    private List<Component> componentList1;
    @JoinColumn(name = "CD_TIPO_EDO", referencedColumnName = "CD_TIPO_EDO", nullable = false)
    @ManyToOne(optional = false)
    private StatusType cdStatusType;

    public Status() {
    }

    public Status(Integer cdEstado) {
        this.cdEstado = cdEstado;
    }

    public Status(Integer cdEstado, String nbEstado) {
        this.cdEstado = cdEstado;
        this.nbEstado = nbEstado;
    }

    public Integer getCdEstado() {
        return cdEstado;
    }

    public void setCdEstado(Integer cdEstado) {
        this.cdEstado = cdEstado;
    }

    public String getNbEstado() {
        return nbEstado;
    }

    public void setNbEstado(String nbEstado) {
        this.nbEstado = nbEstado;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
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

    public List<Fare> getFareList() {
        return fareList;
    }

    public void setFareList(List<Fare> fareList) {
        this.fareList = fareList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public List<Invoice> getInvoiceList1() {
        return invoiceList1;
    }

    public void setInvoiceList1(List<Invoice> invoiceList1) {
        this.invoiceList1 = invoiceList1;
    }

    public List<Invoice> getInvoiceList2() {
        return invoiceList2;
    }

    public void setInvoiceList2(List<Invoice> invoiceList2) {
        this.invoiceList2 = invoiceList2;
    }

    public List<Requirement> getRequirementList() {
        return requirementList;
    }

    public void setRequirementList(List<Requirement> requirementList) {
        this.requirementList = requirementList;
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

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public List<Access> getAccessList() {
        return accessList;
    }

    public void setAccessList(List<Access> accessList) {
        this.accessList = accessList;
    }

    public List<Doubt> getDoubtList() {
        return doubtList;
    }

    public void setDoubtList(List<Doubt> doubtList) {
        this.doubtList = doubtList;
    }

    public List<Typology> getTypologyList() {
        return typologyList;
    }

    public void setTypologyList(List<Typology> typologyList) {
        this.typologyList = typologyList;
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

    public List<Issue> getIssueList() {
        return issueList;
    }

    public void setIssueList(List<Issue> issueList) {
        this.issueList = issueList;
    }

    public List<Component> getComponentList() {
        return componentList;
    }

    public void setComponentList(List<Component> componentList) {
        this.componentList = componentList;
    }

    public List<Component> getComponentList1() {
        return componentList1;
    }

    public void setComponentList1(List<Component> componentList1) {
        this.componentList1 = componentList1;
    }

    public StatusType getCdStatusType() {
        return cdStatusType;
    }

    public void setCdStatusType(StatusType cdStatusType) {
        this.cdStatusType = cdStatusType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdEstado != null ? cdEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Status)) {
            return false;
        }
        Status other = (Status) object;
        if ((this.cdEstado == null && other.cdEstado != null) || (this.cdEstado != null && !this.cdEstado.equals(other.cdEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Status[ cdEstado=" + cdEstado + " ]";
    }

}
