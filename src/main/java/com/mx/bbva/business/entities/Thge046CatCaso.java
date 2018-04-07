/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author manug
 */
@Entity
@Table(name = "thge046_cat_caso", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge046CatCaso.findAll", query = "SELECT t FROM Thge046CatCaso t")})
public class Thge046CatCaso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_CATEGORIA_CASO")
    private Integer cdCategoriaCaso;
    @Basic(optional = false)
    @Column(name = "NB_CATEGORIA_CASO")
    private String nbCategoriaCaso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdCategoriaCaso")
    private List<Thge044C204> thge044C204List;

    public Thge046CatCaso() {
    }

    public Thge046CatCaso(Integer cdCategoriaCaso) {
        this.cdCategoriaCaso = cdCategoriaCaso;
    }

    public Thge046CatCaso(Integer cdCategoriaCaso, String nbCategoriaCaso) {
        this.cdCategoriaCaso = cdCategoriaCaso;
        this.nbCategoriaCaso = nbCategoriaCaso;
    }

    public Integer getCdCategoriaCaso() {
        return cdCategoriaCaso;
    }

    public void setCdCategoriaCaso(Integer cdCategoriaCaso) {
        this.cdCategoriaCaso = cdCategoriaCaso;
    }

    public String getNbCategoriaCaso() {
        return nbCategoriaCaso;
    }

    public void setNbCategoriaCaso(String nbCategoriaCaso) {
        this.nbCategoriaCaso = nbCategoriaCaso;
    }

    public List<Thge044C204> getThge044C204List() {
        return thge044C204List;
    }

    public void setThge044C204List(List<Thge044C204> thge044C204List) {
        this.thge044C204List = thge044C204List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdCategoriaCaso != null ? cdCategoriaCaso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge046CatCaso)) {
            return false;
        }
        Thge046CatCaso other = (Thge046CatCaso) object;
        if ((this.cdCategoriaCaso == null && other.cdCategoriaCaso != null) || (this.cdCategoriaCaso != null && !this.cdCategoriaCaso.equals(other.cdCategoriaCaso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge046CatCaso[ cdCategoriaCaso=" + cdCategoriaCaso + " ]";
    }
    
}
