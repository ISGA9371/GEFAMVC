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
@Table(name = "thge042_t926", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge042T926.findAll", query = "SELECT t FROM Thge042T926 t")})
public class Thge042T926 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_T926")
    private Integer cdT926;
    @Basic(optional = false)
    @Column(name = "CD_FUNCION")
    private String cdFuncion;
    @Basic(optional = false)
    @Column(name = "NB_FUNCION")
    private String nbFuncion;
    @Column(name = "NU_DEFECTO_ESTIM")
    private Integer nuDefectoEstim;
    @Column(name = "NU_CASO_ESTIM")
    private Integer nuCasoEstim;
    @Column(name = "NU_DEFECTO_REAL")
    private Integer nuDefectoReal;
    @JoinColumn(name = "CD_REQUERIMIENTO", referencedColumnName = "CD_REQUERIMIENTO")
    @ManyToOne(optional = false)
    private Thge017Requerim cdRequerimiento;
    @JoinColumn(name = "CD_CRITICIDAD", referencedColumnName = "CD_CRITICIDAD")
    @ManyToOne
    private Thge043Criticidad cdCriticidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdT926")
    private List<Thge048T955> thge048T955List;
    @OneToMany(mappedBy = "cdT926")
    private List<Thge044C204> thge044C204List;

    public Thge042T926() {
    }

    public Thge042T926(Integer cdT926) {
        this.cdT926 = cdT926;
    }

    public Thge042T926(Integer cdT926, String cdFuncion, String nbFuncion) {
        this.cdT926 = cdT926;
        this.cdFuncion = cdFuncion;
        this.nbFuncion = nbFuncion;
    }

    public Integer getCdT926() {
        return cdT926;
    }

    public void setCdT926(Integer cdT926) {
        this.cdT926 = cdT926;
    }

    public String getCdFuncion() {
        return cdFuncion;
    }

    public void setCdFuncion(String cdFuncion) {
        this.cdFuncion = cdFuncion;
    }

    public String getNbFuncion() {
        return nbFuncion;
    }

    public void setNbFuncion(String nbFuncion) {
        this.nbFuncion = nbFuncion;
    }

    public Integer getNuDefectoEstim() {
        return nuDefectoEstim;
    }

    public void setNuDefectoEstim(Integer nuDefectoEstim) {
        this.nuDefectoEstim = nuDefectoEstim;
    }

    public Integer getNuCasoEstim() {
        return nuCasoEstim;
    }

    public void setNuCasoEstim(Integer nuCasoEstim) {
        this.nuCasoEstim = nuCasoEstim;
    }

    public Integer getNuDefectoReal() {
        return nuDefectoReal;
    }

    public void setNuDefectoReal(Integer nuDefectoReal) {
        this.nuDefectoReal = nuDefectoReal;
    }

    public Thge017Requerim getCdRequerimiento() {
        return cdRequerimiento;
    }

    public void setCdRequerimiento(Thge017Requerim cdRequerimiento) {
        this.cdRequerimiento = cdRequerimiento;
    }

    public Thge043Criticidad getCdCriticidad() {
        return cdCriticidad;
    }

    public void setCdCriticidad(Thge043Criticidad cdCriticidad) {
        this.cdCriticidad = cdCriticidad;
    }

    public List<Thge048T955> getThge048T955List() {
        return thge048T955List;
    }

    public void setThge048T955List(List<Thge048T955> thge048T955List) {
        this.thge048T955List = thge048T955List;
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
        hash += (cdT926 != null ? cdT926.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge042T926)) {
            return false;
        }
        Thge042T926 other = (Thge042T926) object;
        if ((this.cdT926 == null && other.cdT926 != null) || (this.cdT926 != null && !this.cdT926.equals(other.cdT926))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge042T926[ cdT926=" + cdT926 + " ]";
    }
    
}
