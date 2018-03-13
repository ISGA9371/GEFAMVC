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
@Table(name = "thge006_tipologia", catalog = "gestion_factoria", schema = "")
@NamedQueries({
        @NamedQuery(name = "Tipologia.findAll", query = "SELECT t FROM Tipologia t")})
public class Tipologia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)

    @Column(name = "CD_TIPOLOGIA", nullable = false)
    private Integer cdTipologia;
    @Basic(optional = false)
    @Column(name = "CD_PRODUCTO", nullable = false, length = 3)
    private String cdProducto;
    @Basic(optional = false)
    @Column(name = "TP_COMPONENTE", nullable = false, length = 10)
    private String tpComponente;
    @Column(name = "NU_DIFICULTAD")
    private Character nuDificultad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NU_HRS_DIFICULTAD", precision = 12)
    private Float nuHrsDificultad;
    @Basic(optional = false)
    @Column(name = "NU_ANO", nullable = false)
    private int nuAno;
    @JoinColumn(name = "ST_ESTADO", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Estado stEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTipologia")
    private List<Componente> componenteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTipologiaEmp")
    private List<Componente> componenteList1;

    public Tipologia() {
    }

    public Tipologia(Integer cdTipologia) {
        this.cdTipologia = cdTipologia;
    }

    public Tipologia(Integer cdTipologia, String cdProducto, String tpComponente, int nuAno) {
        this.cdTipologia = cdTipologia;
        this.cdProducto = cdProducto;
        this.tpComponente = tpComponente;
        this.nuAno = nuAno;
    }

    public Integer getCdTipologia() {
        return cdTipologia;
    }

    public void setCdTipologia(Integer cdTipologia) {
        this.cdTipologia = cdTipologia;
    }

    public String getCdProducto() {
        return cdProducto;
    }

    public void setCdProducto(String cdProducto) {
        this.cdProducto = cdProducto;
    }

    public String getTpComponente() {
        return tpComponente;
    }

    public void setTpComponente(String tpComponente) {
        this.tpComponente = tpComponente;
    }

    public Character getNuDificultad() {
        return nuDificultad;
    }

    public void setNuDificultad(Character nuDificultad) {
        this.nuDificultad = nuDificultad;
    }

    public Float getNuHrsDificultad() {
        return nuHrsDificultad;
    }

    public void setNuHrsDificultad(Float nuHrsDificultad) {
        this.nuHrsDificultad = nuHrsDificultad;
    }

    public int getNuAno() {
        return nuAno;
    }

    public void setNuAno(int nuAno) {
        this.nuAno = nuAno;
    }

    public Estado getStEstado() {
        return stEstado;
    }

    public void setStEstado(Estado stEstado) {
        this.stEstado = stEstado;
    }

    public List<Componente> getComponenteList() {
        return componenteList;
    }

    public void setComponenteList(List<Componente> componenteList) {
        this.componenteList = componenteList;
    }

    public List<Componente> getComponenteList1() {
        return componenteList1;
    }

    public void setComponenteList1(List<Componente> componenteList1) {
        this.componenteList1 = componenteList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdTipologia != null ? cdTipologia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipologia)) {
            return false;
        }
        Tipologia other = (Tipologia) object;
        if ((this.cdTipologia == null && other.cdTipologia != null) || (this.cdTipologia != null && !this.cdTipologia.equals(other.cdTipologia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Tipologia[ cdTipologia=" + cdTipologia + " ]";
    }

}
