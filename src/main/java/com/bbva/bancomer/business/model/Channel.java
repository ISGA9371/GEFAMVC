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
@Table(name = "thge056_canal", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CD_CANAL"})
        , @UniqueConstraint(columnNames = {"NB_CANAL"})})
@NamedQueries({
        @NamedQuery(name = "Channel.findAll", query = "SELECT t FROM Channel t")})
public class Channel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_CONS_CANAL", nullable = false)
    private Integer cdConsCanal;
    @Basic(optional = false)
    @Column(name = "CD_CANAL", nullable = false)
    private int cdCanal;
    @Basic(optional = false)
    @Column(name = "NB_CANAL", nullable = false, length = 50)
    private String nbCanal;
    @OneToMany(mappedBy = "cdCanal")
    private List<Requirement> requirementList;

    public Channel() {
    }

    public Channel(Integer cdConsCanal) {
        this.cdConsCanal = cdConsCanal;
    }

    public Channel(Integer cdConsCanal, int cdCanal, String nbCanal) {
        this.cdConsCanal = cdConsCanal;
        this.cdCanal = cdCanal;
        this.nbCanal = nbCanal;
    }

    public Integer getCdConsCanal() {
        return cdConsCanal;
    }

    public void setCdConsCanal(Integer cdConsCanal) {
        this.cdConsCanal = cdConsCanal;
    }

    public int getCdCanal() {
        return cdCanal;
    }

    public void setCdCanal(int cdCanal) {
        this.cdCanal = cdCanal;
    }

    public String getNbCanal() {
        return nbCanal;
    }

    public void setNbCanal(String nbCanal) {
        this.nbCanal = nbCanal;
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
        hash += (cdConsCanal != null ? cdConsCanal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Channel)) {
            return false;
        }
        Channel other = (Channel) object;
        if ((this.cdConsCanal == null && other.cdConsCanal != null) || (this.cdConsCanal != null && !this.cdConsCanal.equals(other.cdConsCanal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Channel[ cdConsCanal=" + cdConsCanal + " ]";
    }

}
