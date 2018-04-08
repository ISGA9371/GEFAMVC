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
import java.util.Objects;

/**
 * @author Guevara Manuel_
 */
@Entity
@Table(name = "thge057_aplicacion", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CD_APLICACION"})
        , @UniqueConstraint(columnNames = {"NB_APLICACION"})})
public class Application implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_APLICACION", nullable = false)
    private Integer applicationId;
    @Basic(optional = false)
    @Column(name = "NB_APLICACION", nullable = false, length = 50)
    private String applicationName;
    @JoinColumn(name = "CD_TECNOLOGIA", referencedColumnName = "CD_TECNOLOGIA", nullable = false)
    @ManyToOne(optional = false)
    private Technology technology;
    @JsonIgnore
    @OneToMany(mappedBy = "application")
    private List<Requirement> requirements;

    public Application() {
    }

    public Application(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public Technology getTechnology() {
        return technology;
    }

    public void setTechnology(Technology technology) {
        this.technology = technology;
    }

    public List<Requirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Requirement> requirements) {
        this.requirements = requirements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return Objects.equals(applicationId, that.applicationId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(applicationId);
    }

    @Override
    public String toString() {
        return "Application{" +
                "applicationId=" + applicationId +
                '}';
    }
}
