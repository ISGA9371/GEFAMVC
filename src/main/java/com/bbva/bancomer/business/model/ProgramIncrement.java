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
@Table(name = "thge022_pi", catalog = "gestion_factoria",  uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CD_SCRUM"})})
@NamedQueries({
        @NamedQuery(name = "ProgramIncrement.findAll", query = "SELECT t FROM ProgramIncrement t")})
public class ProgramIncrement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_CONS_PI", nullable = false)
    private Integer cdConsPi;
    @Basic(optional = false)
    @Column(name = "CD_SCRUM", nullable = false)
    private int cdScrum;
    @Basic(optional = false)
    @Column(name = "NB_SCRUM", nullable = false, length = 100)
    private String nbScrum;
    @OneToMany(mappedBy = "cdScrum")
    private List<Requirement> requirementList;
    @JoinColumn(name = "CD_DUENO_PROD", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne
    private User cdDuenoProd;
    @JoinColumn(name = "CD_EXPERTO_SCRUM", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne
    private User cdExpertoScrum;
    @JoinColumn(name = "CD_TIPO_PI", referencedColumnName = "CD_TIPO_PI", nullable = false)
    @ManyToOne(optional = false)
    private ProgramIncrementType cdProgramIncrementType;
    @JoinColumn(name = "CD_PROGRAMA", referencedColumnName = "CD_PROGRAMA", nullable = false)
    @ManyToOne(optional = false)
    private Program cdProgram;

    public ProgramIncrement() {
    }

    public ProgramIncrement(Integer cdConsPi) {
        this.cdConsPi = cdConsPi;
    }

    public ProgramIncrement(Integer cdConsPi, int cdScrum, String nbScrum) {
        this.cdConsPi = cdConsPi;
        this.cdScrum = cdScrum;
        this.nbScrum = nbScrum;
    }

    public Integer getCdConsPi() {
        return cdConsPi;
    }

    public void setCdConsPi(Integer cdConsPi) {
        this.cdConsPi = cdConsPi;
    }

    public int getCdScrum() {
        return cdScrum;
    }

    public void setCdScrum(int cdScrum) {
        this.cdScrum = cdScrum;
    }

    public String getNbScrum() {
        return nbScrum;
    }

    public void setNbScrum(String nbScrum) {
        this.nbScrum = nbScrum;
    }

    public List<Requirement> getRequirementList() {
        return requirementList;
    }

    public void setRequirementList(List<Requirement> requirementList) {
        this.requirementList = requirementList;
    }

    public User getCdDuenoProd() {
        return cdDuenoProd;
    }

    public void setCdDuenoProd(User cdDuenoProd) {
        this.cdDuenoProd = cdDuenoProd;
    }

    public User getCdExpertoScrum() {
        return cdExpertoScrum;
    }

    public void setCdExpertoScrum(User cdExpertoScrum) {
        this.cdExpertoScrum = cdExpertoScrum;
    }

    public ProgramIncrementType getCdProgramIncrementType() {
        return cdProgramIncrementType;
    }

    public void setCdProgramIncrementType(ProgramIncrementType cdProgramIncrementType) {
        this.cdProgramIncrementType = cdProgramIncrementType;
    }

    public Program getCdProgram() {
        return cdProgram;
    }

    public void setCdProgram(Program cdProgram) {
        this.cdProgram = cdProgram;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdConsPi != null ? cdConsPi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramIncrement)) {
            return false;
        }
        ProgramIncrement other = (ProgramIncrement) object;
        if ((this.cdConsPi == null && other.cdConsPi != null) || (this.cdConsPi != null && !this.cdConsPi.equals(other.cdConsPi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.ProgramIncrement[ cdConsPi=" + cdConsPi + " ]";
    }

}
