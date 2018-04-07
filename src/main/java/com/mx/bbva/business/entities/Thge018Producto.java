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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author manug
 */
@Entity
@Table(name = "thge018_producto", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge018Producto.findAll", query = "SELECT t FROM Thge018Producto t")})
public class Thge018Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_PRODUCTO")
    private String cdProducto;
    @Basic(optional = false)
    @Column(name = "NB_PRODUCTO")
    private String nbProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdProducto")
    private List<Thge006Tipologia> thge006TipologiaList;
    @JoinColumn(name = "CD_TECNOLOGIA", referencedColumnName = "CD_TECNOLOGIA")
    @ManyToOne(optional = false)
    private Thge002Tecnologia cdTecnologia;

    public Thge018Producto() {
    }

    public Thge018Producto(String cdProducto) {
        this.cdProducto = cdProducto;
    }

    public Thge018Producto(String cdProducto, String nbProducto) {
        this.cdProducto = cdProducto;
        this.nbProducto = nbProducto;
    }

    public String getCdProducto() {
        return cdProducto;
    }

    public void setCdProducto(String cdProducto) {
        this.cdProducto = cdProducto;
    }

    public String getNbProducto() {
        return nbProducto;
    }

    public void setNbProducto(String nbProducto) {
        this.nbProducto = nbProducto;
    }

    public List<Thge006Tipologia> getThge006TipologiaList() {
        return thge006TipologiaList;
    }

    public void setThge006TipologiaList(List<Thge006Tipologia> thge006TipologiaList) {
        this.thge006TipologiaList = thge006TipologiaList;
    }

    public Thge002Tecnologia getCdTecnologia() {
        return cdTecnologia;
    }

    public void setCdTecnologia(Thge002Tecnologia cdTecnologia) {
        this.cdTecnologia = cdTecnologia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdProducto != null ? cdProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge018Producto)) {
            return false;
        }
        Thge018Producto other = (Thge018Producto) object;
        if ((this.cdProducto == null && other.cdProducto != null) || (this.cdProducto != null && !this.cdProducto.equals(other.cdProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge018Producto[ cdProducto=" + cdProducto + " ]";
    }
    
}
