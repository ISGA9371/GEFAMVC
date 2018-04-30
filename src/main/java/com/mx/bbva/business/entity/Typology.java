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
 * @author Guevara M
 */
@Entity
@Table(name = "thge006_tipologia")
public class Typology implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_TIPOLOGIA", nullable = false)
    private Integer typologyId;
    @Column(name = "TP_COMPONENTE", nullable = false)
    private Boolean typologyComponentModified;
    @Column(name = "NU_DIFICULTAD")
    private Character typologySeverity;
    @Column(name = "NU_HM_DIFICULTAD", precision = 12)
    private Float typologySeverityHours;
    @Column(name = "FH_INIC_VIGENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date typologyStartDate;
    @Column(name = "FH_FIN_VIGENCIA")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date typologyFinalDate;
    @JoinColumn(name = "CD_PRODUCTO", referencedColumnName = "CD_PRODUCTO", nullable = false)
    @ManyToOne
    private Product product;
    @JoinColumn(name = "ST_ESTADO", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status status;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "startTypology")
    private List<Component> components;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "finalTypology")
    private List<Component> componentList;
    @JsonIgnore
    @OneToMany(mappedBy = "startTypology")
    private List<Modification> startModifications;
    @JsonIgnore
    @OneToMany(mappedBy = "finalTypology")
    private List<Modification> finalModifications;

    public Typology() {
    }

    public Typology(Integer typologyId) {
        this.typologyId = typologyId;
    }

    public Integer getTypologyId() {
        return typologyId;
    }

    public void setTypologyId(Integer typologyId) {
        this.typologyId = typologyId;
    }

    public Boolean getTypologyComponentModified() {
        return typologyComponentModified;
    }

    public void setTypologyComponentModified(Boolean typologyComponentModified) {
        this.typologyComponentModified = typologyComponentModified;
    }

    public Character getTypologySeverity() {
        return typologySeverity;
    }

    public void setTypologySeverity(Character typologySeverity) {
        this.typologySeverity = typologySeverity;
    }

    public Float getTypologySeverityHours() {
        return typologySeverityHours;
    }

    public void setTypologySeverityHours(Float typologySeverityHours) {
        this.typologySeverityHours = typologySeverityHours;
    }

    public Date getTypologyStartDate() {
        return typologyStartDate;
    }

    public void setTypologyStartDate(Date typologyStartDate) {
        this.typologyStartDate = typologyStartDate;
    }

    public Date getTypologyFinalDate() {
        return typologyFinalDate;
    }

    public void setTypologyFinalDate(Date typologyFinalDate) {
        this.typologyFinalDate = typologyFinalDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public List<Component> getComponentList() {
        return componentList;
    }

    public void setComponentList(List<Component> componentList) {
        this.componentList = componentList;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Modification> getStartModifications() {
        return startModifications;
    }

    public void setStartModifications(List<Modification> startModifications) {
        this.startModifications = startModifications;
    }

    public List<Modification> getFinalModifications() {
        return finalModifications;
    }

    public void setFinalModifications(List<Modification> finalModifications) {
        this.finalModifications = finalModifications;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typologyId != null ? typologyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Typology)) {
            return false;
        }
        Typology other = (Typology) object;
        return (this.typologyId != null || other.typologyId == null) && (this.typologyId == null || this.typologyId.equals(other.typologyId));
    }

    @Override
    public String toString() {
        return "com.bbva.Typology[ typologyId=" + typologyId + " ]";
    }

}
