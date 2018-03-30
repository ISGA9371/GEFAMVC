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
@Table(name = "thge014_pais")
public class Country implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_PAIS", nullable = false)
    private Integer countryId;
    @Basic(optional = false)
    @Column(name = "NB_PAIS", nullable = false, length = 50)
    private String countryName;
    @Basic(optional = false)
    @Column(name = "NB_NACIONALIDAD", nullable = false, length = 50)
    private String countryNacionality;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    private List<ExternalUser> externalUsers;

    public Country() {
    }

    public Country(Integer countryId) {
        this.countryId = countryId;
    }

    public Country(Integer countryId, String countryName, String countryNacionality) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.countryNacionality = countryNacionality;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryNacionality() {
        return countryNacionality;
    }

    public void setCountryNacionality(String countryNacionality) {
        this.countryNacionality = countryNacionality;
    }

    public List<ExternalUser> getExternalUsers() {
        return externalUsers;
    }

    public void setExternalUsers(List<ExternalUser> externalUsers) {
        this.externalUsers = externalUsers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryId != null ? countryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Country)) {
            return false;
        }
        Country other = (Country) object;
        return (this.countryId != null || other.countryId == null) && (this.countryId == null || this.countryId.equals(other.countryId));
    }

    @Override
    public String toString() {
        return "com.bbva.Country[ countryId=" + countryId + " ]";
    }

}
