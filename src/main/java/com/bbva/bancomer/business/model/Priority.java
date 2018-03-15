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
@Table(name = "thge015_prioridad", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_PRIORIDAD"})})
@NamedQueries({
        @NamedQuery(name = "Priority.findAll", query = "SELECT t FROM Priority t")})
public class Priority implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_PRIORIDAD", nullable = false)
    private Integer cdPrioridad;
    @Basic(optional = false)
    @Column(name = "NB_PRIORIDAD", nullable = false, length = 25)
    private String nbPrioridad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdPriorityUsu")
    private List<Modification> modificationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdPriority")
    private List<Doubt> doubtList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdPriority")
    private List<Issue> issueList;

    public Priority() {
    }

    public Priority(Integer cdPrioridad) {
        this.cdPrioridad = cdPrioridad;
    }

    public Priority(Integer cdPrioridad, String nbPrioridad) {
        this.cdPrioridad = cdPrioridad;
        this.nbPrioridad = nbPrioridad;
    }

    public Integer getCdPrioridad() {
        return cdPrioridad;
    }

    public void setCdPrioridad(Integer cdPrioridad) {
        this.cdPrioridad = cdPrioridad;
    }

    public String getNbPrioridad() {
        return nbPrioridad;
    }

    public void setNbPrioridad(String nbPrioridad) {
        this.nbPrioridad = nbPrioridad;
    }

    public List<Modification> getModificationList() {
        return modificationList;
    }

    public void setModificationList(List<Modification> modificationList) {
        this.modificationList = modificationList;
    }

    public List<Doubt> getDoubtList() {
        return doubtList;
    }

    public void setDoubtList(List<Doubt> doubtList) {
        this.doubtList = doubtList;
    }

    public List<Issue> getIssueList() {
        return issueList;
    }

    public void setIssueList(List<Issue> issueList) {
        this.issueList = issueList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdPrioridad != null ? cdPrioridad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Priority)) {
            return false;
        }
        Priority other = (Priority) object;
        if ((this.cdPrioridad == null && other.cdPrioridad != null) || (this.cdPrioridad != null && !this.cdPrioridad.equals(other.cdPrioridad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Priority[ cdPrioridad=" + cdPrioridad + " ]";
    }

}
