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
@Table(name = "thge049_entorno", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_ENTORNO"})})
@NamedQueries({
        @NamedQuery(name = "Environment.findAll", query = "SELECT t FROM Environment t")})
public class Environment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_ENTORNO", nullable = false)
    private Integer cdEntorno;
    @Basic(optional = false)
    @Column(name = "NB_ENTORNO", nullable = false, length = 25)
    private String nbEntorno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdEntorno")
    private List<T955> t955List;

    public Environment() {
    }

    public Environment(Integer cdEntorno) {
        this.cdEntorno = cdEntorno;
    }

    public Environment(Integer cdEntorno, String nbEntorno) {
        this.cdEntorno = cdEntorno;
        this.nbEntorno = nbEntorno;
    }

    public Integer getCdEntorno() {
        return cdEntorno;
    }

    public void setCdEntorno(Integer cdEntorno) {
        this.cdEntorno = cdEntorno;
    }

    public String getNbEntorno() {
        return nbEntorno;
    }

    public void setNbEntorno(String nbEntorno) {
        this.nbEntorno = nbEntorno;
    }

    public List<T955> getT955List() {
        return t955List;
    }

    public void setT955List(List<T955> t955List) {
        this.t955List = t955List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdEntorno != null ? cdEntorno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Environment)) {
            return false;
        }
        Environment other = (Environment) object;
        if ((this.cdEntorno == null && other.cdEntorno != null) || (this.cdEntorno != null && !this.cdEntorno.equals(other.cdEntorno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Environment[ cdEntorno=" + cdEntorno + " ]";
    }

}
