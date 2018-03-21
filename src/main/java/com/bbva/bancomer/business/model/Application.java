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
@Table(name = "thge057_aplicacion", catalog = "gestion_factoria",  uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CD_APLICACION"})
        , @UniqueConstraint(columnNames = {"NB_APLICACION"})})
public class Application implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_CONS_APLIC", nullable = false)
    private Integer applicationSerial;
    @Basic(optional = false)
    @Column(name = "CD_APLICACION", nullable = false)
    private int applicationId;
    @Basic(optional = false)
    @Column(name = "NB_APLICACION", nullable = false, length = 50)
    private String applicationName;
    @JoinColumn(name = "CD_TECNOLOGIA", referencedColumnName = "CD_TECNOLOGIA", nullable = false)
    @ManyToOne(optional = false)
    private Technology_ technology;
    @OneToMany(mappedBy = "application")
    private List<Requirement> requirements;

    public Application() {
    }

    public Application(Integer applicationSerial) {
        this.applicationSerial = applicationSerial;
    }

    public Application(Integer applicationSerial, int applicationId, String applicationName) {
        this.applicationSerial = applicationSerial;
        this.applicationId = applicationId;
        this.applicationName = applicationName;
    }

    public Integer getApplicationSerial() {
        return applicationSerial;
    }

    public void setApplicationSerial(Integer applicationSerial) {
        this.applicationSerial = applicationSerial;
    }

    public int getApplicationId() {
        return applicationId;
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

    public Technology_ getTechnology() {
        return technology;
    }

    public void setTechnology(Technology_ technology) {
        this.technology = technology;
    }

    public List<Requirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Requirement> requirements) {
        this.requirements = requirements;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (applicationSerial != null ? applicationSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Application)) {
            return false;
        }
        Application other = (Application) object;
        return (this.applicationSerial != null || other.applicationSerial == null) && (this.applicationSerial == null || this.applicationSerial.equals(other.applicationSerial));
    }

    @Override
    public String toString() {
        return "com.bbva.Application[ applicationSerial=" + applicationSerial + " ]";
    }

}
