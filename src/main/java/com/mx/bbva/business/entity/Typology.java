/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
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
    @Basic(optional = false)
    @Column(name = "CD_TIPOLOGIA", nullable = false)
    private Integer typologyId;
    @Basic(optional = false)
    @Column(name = "TP_COMPONENTE", nullable = false)
    private boolean typologyNewComponent;
    @Column(name = "NU_DIFICULTAD")
    private Character typologySeverity;
    @Column(name = "NU_HM_DIFICULTAD", precision = 12)
    private Float typologySeverityHours;
    @Basic(optional = false)
    @Column(name = "NU_ANO", nullable = false)
    private int typologyYear;
    @JoinColumn(name = "CD_PRODUCTO", referencedColumnName = "CD_PRODUCTO", nullable = false)
    @ManyToOne
    private Product product;
    @JoinColumn(name = "ST_ESTADO", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status status;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typology")
    private List<Component> components;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typologyEmp")
    private List<Component> componentList;

    public Typology() {
    }

    public Typology(Integer typologyId) {
        this.typologyId = typologyId;
    }

    public Typology(Integer typologyId, int typologyYear) {
        this.typologyId = typologyId;
        this.typologyYear = typologyYear;
    }

    public Integer getTypologyId() {
        return typologyId;
    }

    public void setTypologyId(Integer typologyId) {
        this.typologyId = typologyId;
    }

    public boolean isTypologyNewComponent() {
        return typologyNewComponent;
    }

    public void setTypologyNewComponent(boolean typologyNewComponent) {
        this.typologyNewComponent = typologyNewComponent;
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

    public int getTypologyYear() {
        return typologyYear;
    }

    public void setTypologyYear(int typologyYear) {
        this.typologyYear = typologyYear;
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
