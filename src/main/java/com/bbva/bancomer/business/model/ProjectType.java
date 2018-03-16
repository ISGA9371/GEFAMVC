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
@Table(name = "thge035_tipo_proy", catalog = "gestion_factoria",  uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_TIPO_PROY"})})
@NamedQueries({
        @NamedQuery(name = "ProjectType.findAll", query = "SELECT t FROM ProjectType t")})
public class ProjectType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_TIPO_PROY", nullable = false)
    private Integer cdTipoProy;
    @Basic(optional = false)
    @Column(name = "NB_TIPO_PROY", nullable = false, length = 25)
    private String nbTipoProy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTipoProy")
    private List<Requirement> requirementList;

    public ProjectType() {
    }

    public ProjectType(Integer cdTipoProy) {
        this.cdTipoProy = cdTipoProy;
    }

    public ProjectType(Integer cdTipoProy, String nbTipoProy) {
        this.cdTipoProy = cdTipoProy;
        this.nbTipoProy = nbTipoProy;
    }

    public Integer getCdTipoProy() {
        return cdTipoProy;
    }

    public void setCdTipoProy(Integer cdTipoProy) {
        this.cdTipoProy = cdTipoProy;
    }

    public String getNbTipoProy() {
        return nbTipoProy;
    }

    public void setNbTipoProy(String nbTipoProy) {
        this.nbTipoProy = nbTipoProy;
    }

    public List<Requirement> getRequirementList() {
        return requirementList;
    }

    public void setRequirementList(List<Requirement> requirementList) {
        this.requirementList = requirementList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdTipoProy != null ? cdTipoProy.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectType)) {
            return false;
        }
        ProjectType other = (ProjectType) object;
        if ((this.cdTipoProy == null && other.cdTipoProy != null) || (this.cdTipoProy != null && !this.cdTipoProy.equals(other.cdTipoProy))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.ProjectType[ cdTipoProy=" + cdTipoProy + " ]";
    }

}
