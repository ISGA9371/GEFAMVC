/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Guevara
 */
@Entity
@Table(name = "thge018_producto")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_PRODUCTO", nullable = false, length = 3)
    private String productId;
    @Basic(optional = false)
    @Column(name = "NB_PRODUCTO", nullable = false, length = 50)
    private String productName;
    @JoinColumn(name = "CD_TECNOLOGIA", referencedColumnName = "CD_TECNOLOGIA", nullable = false)
    @ManyToOne(optional = false)
    private Technology technology;

    public Product() {
    }

    public Product(String productId) {
        this.productId = productId;
    }

    public Product(String productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Technology getTechnology() {
        return technology;
    }

    public void setTechnology(Technology technology) {
        this.technology = technology;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        return (this.productId != null || other.productId == null) && (this.productId == null || this.productId.equals(other.productId));
    }

    @Override
    public String toString() {
        return "com.bbva.Product[ productId=" + productId + " ]";
    }

}
