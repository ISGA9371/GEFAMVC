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
@Table(name = "thge014_pais", catalog = "gestion_factoria", schema = "")
@NamedQueries({
        @NamedQuery(name = "Country.findAll", query = "SELECT t FROM Country t")})
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_PAIS", nullable = false)
    private Integer cdPais;
    @Basic(optional = false)
    @Column(name = "NB_PAIS", nullable = false, length = 50)
    private String nbPais;
    @Basic(optional = false)
    @Column(name = "NB_NACIONALIDAD", nullable = false, length = 50)
    private String nbNacionalidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdPais")
    private List<ExternalUser> externalUserList;

    public Country() {
    }

    public Country(Integer cdPais) {
        this.cdPais = cdPais;
    }

    public Country(Integer cdPais, String nbPais, String nbNacionalidad) {
        this.cdPais = cdPais;
        this.nbPais = nbPais;
        this.nbNacionalidad = nbNacionalidad;
    }

    public Integer getCdPais() {
        return cdPais;
    }

    public void setCdPais(Integer cdPais) {
        this.cdPais = cdPais;
    }

    public String getNbPais() {
        return nbPais;
    }

    public void setNbPais(String nbPais) {
        this.nbPais = nbPais;
    }

    public String getNbNacionalidad() {
        return nbNacionalidad;
    }

    public void setNbNacionalidad(String nbNacionalidad) {
        this.nbNacionalidad = nbNacionalidad;
    }

    public List<ExternalUser> getExternalUserList() {
        return externalUserList;
    }

    public void setExternalUserList(List<ExternalUser> externalUserList) {
        this.externalUserList = externalUserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdPais != null ? cdPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Country)) {
            return false;
        }
        Country other = (Country) object;
        if ((this.cdPais == null && other.cdPais != null) || (this.cdPais != null && !this.cdPais.equals(other.cdPais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Country[ cdPais=" + cdPais + " ]";
    }

}
