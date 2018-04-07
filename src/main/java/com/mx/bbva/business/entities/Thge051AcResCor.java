/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "thge051_ac_res_cor", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge051AcResCor.findAll", query = "SELECT t FROM Thge051AcResCor t")})
public class Thge051AcResCor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_ACEPTA_RES_COR")
    private Integer cdAceptaResCor;
    @Basic(optional = false)
    @Column(name = "NB_ACEPTA_RES_COR")
    private String nbAceptaResCor;
    @OneToMany(mappedBy = "cdAceptaResCor")
    private List<Thge048T955> thge048T955List;

    public Thge051AcResCor() {
    }

    public Thge051AcResCor(Integer cdAceptaResCor) {
        this.cdAceptaResCor = cdAceptaResCor;
    }

    public Thge051AcResCor(Integer cdAceptaResCor, String nbAceptaResCor) {
        this.cdAceptaResCor = cdAceptaResCor;
        this.nbAceptaResCor = nbAceptaResCor;
    }

    public Integer getCdAceptaResCor() {
        return cdAceptaResCor;
    }

    public void setCdAceptaResCor(Integer cdAceptaResCor) {
        this.cdAceptaResCor = cdAceptaResCor;
    }

    public String getNbAceptaResCor() {
        return nbAceptaResCor;
    }

    public void setNbAceptaResCor(String nbAceptaResCor) {
        this.nbAceptaResCor = nbAceptaResCor;
    }

    public List<Thge048T955> getThge048T955List() {
        return thge048T955List;
    }

    public void setThge048T955List(List<Thge048T955> thge048T955List) {
        this.thge048T955List = thge048T955List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdAceptaResCor != null ? cdAceptaResCor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge051AcResCor)) {
            return false;
        }
        Thge051AcResCor other = (Thge051AcResCor) object;
        if ((this.cdAceptaResCor == null && other.cdAceptaResCor != null) || (this.cdAceptaResCor != null && !this.cdAceptaResCor.equals(other.cdAceptaResCor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge051AcResCor[ cdAceptaResCor=" + cdAceptaResCor + " ]";
    }
    
}
