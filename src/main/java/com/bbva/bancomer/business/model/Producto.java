/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbva.bancomer.business.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Guevara
 */
@Entity
@Table(name = "thge018_producto", catalog = "gestion_factoria", schema = "")
@NamedQueries({
        @NamedQuery(name = "Producto.findAll", query = "SELECT t FROM Producto t")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_PRODUCTO", nullable = false, length = 3)
    private String cdProducto;
    @Basic(optional = false)
    @Column(name = "NB_PRODUCTO", nullable = false, length = 50)
    private String nbProducto;
    @JoinColumn(name = "CD_TECNOLOGIA", referencedColumnName = "CD_TECNOLOGIA", nullable = false)
    @ManyToOne(optional = false)
    private Tecnologia cdTecnologia;

    public Producto() {
    }

    public Producto(String cdProducto) {
        this.cdProducto = cdProducto;
    }

    public Producto(String cdProducto, String nbProducto) {
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

    public Tecnologia getCdTecnologia() {
        return cdTecnologia;
    }

    public void setCdTecnologia(Tecnologia cdTecnologia) {
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
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.cdProducto == null && other.cdProducto != null) || (this.cdProducto != null && !this.cdProducto.equals(other.cdProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Producto[ cdProducto=" + cdProducto + " ]";
    }

}
