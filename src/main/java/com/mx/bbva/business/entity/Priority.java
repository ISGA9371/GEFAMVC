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
 * @author Guevara
 */
@Entity
@Table(name = "thge015_prioridad", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_PRIORIDAD"})})
public class Priority implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_PRIORIDAD", nullable = false)
    private Integer priorityId;
    @Basic(optional = false)
    @Column(name = "NB_PRIORIDAD", nullable = false, length = 25)
    private String priorityName;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "priority")
    private List<Modification> modifications;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "priority")
    private List<Doubt> doubts;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "priority")
    private List<Issue> issues;

    public Priority() {
    }

    public Priority(Integer priorityId) {
        this.priorityId = priorityId;
    }

    public Priority(Integer priorityId, String priorityName) {
        this.priorityId = priorityId;
        this.priorityName = priorityName;
    }

    public Integer getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(Integer priorityId) {
        this.priorityId = priorityId;
    }

    public String getPriorityName() {
        return priorityName;
    }

    public void setPriorityName(String priorityName) {
        this.priorityName = priorityName;
    }

    public List<Modification> getModifications() {
        return modifications;
    }

    public void setModifications(List<Modification> modifications) {
        this.modifications = modifications;
    }

    public List<Doubt> getDoubts() {
        return doubts;
    }

    public void setDoubts(List<Doubt> doubts) {
        this.doubts = doubts;
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (priorityId != null ? priorityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Priority)) {
            return false;
        }
        Priority other = (Priority) object;
        return (this.priorityId != null || other.priorityId == null) && (this.priorityId == null || this.priorityId.equals(other.priorityId));
    }

    @Override
    public String toString() {
        return "com.bbva.Priority[ priorityId=" + priorityId + " ]";
    }

}
