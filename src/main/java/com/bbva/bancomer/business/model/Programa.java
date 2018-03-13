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
@Table(name = "thge023_programa", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_PROGRAMA"})})
@NamedQueries({
        @NamedQuery(name = "Programa.findAll", query = "SELECT t FROM Programa t")})
public class Programa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_PROGRAMA", nullable = false)
    private Integer cdPrograma;
    @Basic(optional = false)
    @Column(name = "NB_PROGRAMA", nullable = false, length = 50)
    private String nbPrograma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdPrograma")
    private List<Pi> piList;

    public Programa() {
    }

    public Programa(Integer cdPrograma) {
        this.cdPrograma = cdPrograma;
    }

    public Programa(Integer cdPrograma, String nbPrograma) {
        this.cdPrograma = cdPrograma;
        this.nbPrograma = nbPrograma;
    }

    public Integer getCdPrograma() {
        return cdPrograma;
    }

    public void setCdPrograma(Integer cdPrograma) {
        this.cdPrograma = cdPrograma;
    }

    public String getNbPrograma() {
        return nbPrograma;
    }

    public void setNbPrograma(String nbPrograma) {
        this.nbPrograma = nbPrograma;
    }

    public List<Pi> getPiList() {
        return piList;
    }

    public void setPiList(List<Pi> piList) {
        this.piList = piList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdPrograma != null ? cdPrograma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programa)) {
            return false;
        }
        Programa other = (Programa) object;
        if ((this.cdPrograma == null && other.cdPrograma != null) || (this.cdPrograma != null && !this.cdPrograma.equals(other.cdPrograma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Programa[ cdPrograma=" + cdPrograma + " ]";
    }

}
