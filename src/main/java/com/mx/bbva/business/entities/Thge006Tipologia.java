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
@Table(name = "thge006_tipologia", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge006Tipologia.findAll", query = "SELECT t FROM Thge006Tipologia t")})
public class Thge006Tipologia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_TIPOLOGIA")
    private Integer cdTipologia;
    @Basic(optional = false)
    @Column(name = "TP_COMPONENTE")
    private boolean tpComponente;
    @Basic(optional = false)
    @Column(name = "NU_DIFICULTAD")
    private Character nuDificultad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NU_HM_DIFICULTAD")
    private Float nuHmDificultad;
    @Basic(optional = false)
    @Column(name = "NU_ANO")
    private int nuAno;
    @OneToMany(mappedBy = "cdTipologiaEmp")
    private List<Thge026Modif> thge026ModifList;
    @OneToMany(mappedBy = "cdTipologiaIni")
    private List<Thge026Modif> thge026ModifList1;
    @JoinColumn(name = "CD_PRODUCTO", referencedColumnName = "CD_PRODUCTO")
    @ManyToOne(optional = false)
    private Thge018Producto cdProducto;
    @JoinColumn(name = "ST_ESTADO", referencedColumnName = "CD_ESTADO")
    @ManyToOne(optional = false)
    private Thge005Estado stEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTipologia")
    private List<Thge009Componente> thge009ComponenteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdTipologiaEmp")
    private List<Thge009Componente> thge009ComponenteList1;

    public Thge006Tipologia() {
    }

    public Thge006Tipologia(Integer cdTipologia) {
        this.cdTipologia = cdTipologia;
    }

    public Thge006Tipologia(Integer cdTipologia, boolean tpComponente, Character nuDificultad, int nuAno) {
        this.cdTipologia = cdTipologia;
        this.tpComponente = tpComponente;
        this.nuDificultad = nuDificultad;
        this.nuAno = nuAno;
    }

    public Integer getCdTipologia() {
        return cdTipologia;
    }

    public void setCdTipologia(Integer cdTipologia) {
        this.cdTipologia = cdTipologia;
    }

    public boolean getTpComponente() {
        return tpComponente;
    }

    public void setTpComponente(boolean tpComponente) {
        this.tpComponente = tpComponente;
    }

    public Character getNuDificultad() {
        return nuDificultad;
    }

    public void setNuDificultad(Character nuDificultad) {
        this.nuDificultad = nuDificultad;
    }

    public Float getNuHmDificultad() {
        return nuHmDificultad;
    }

    public void setNuHmDificultad(Float nuHmDificultad) {
        this.nuHmDificultad = nuHmDificultad;
    }

    public int getNuAno() {
        return nuAno;
    }

    public void setNuAno(int nuAno) {
        this.nuAno = nuAno;
    }

    public List<Thge026Modif> getThge026ModifList() {
        return thge026ModifList;
    }

    public void setThge026ModifList(List<Thge026Modif> thge026ModifList) {
        this.thge026ModifList = thge026ModifList;
    }

    public List<Thge026Modif> getThge026ModifList1() {
        return thge026ModifList1;
    }

    public void setThge026ModifList1(List<Thge026Modif> thge026ModifList1) {
        this.thge026ModifList1 = thge026ModifList1;
    }

    public Thge018Producto getCdProducto() {
        return cdProducto;
    }

    public void setCdProducto(Thge018Producto cdProducto) {
        this.cdProducto = cdProducto;
    }

    public Thge005Estado getStEstado() {
        return stEstado;
    }

    public void setStEstado(Thge005Estado stEstado) {
        this.stEstado = stEstado;
    }

    public List<Thge009Componente> getThge009ComponenteList() {
        return thge009ComponenteList;
    }

    public void setThge009ComponenteList(List<Thge009Componente> thge009ComponenteList) {
        this.thge009ComponenteList = thge009ComponenteList;
    }

    public List<Thge009Componente> getThge009ComponenteList1() {
        return thge009ComponenteList1;
    }

    public void setThge009ComponenteList1(List<Thge009Componente> thge009ComponenteList1) {
        this.thge009ComponenteList1 = thge009ComponenteList1;
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
        if (!(object instanceof Thge006Tipologia)) {
            return false;
        }
        Thge006Tipologia other = (Thge006Tipologia) object;
        if ((this.cdTipologia == null && other.cdTipologia != null) || (this.cdTipologia != null && !this.cdTipologia.equals(other.cdTipologia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge006Tipologia[ cdTipologia=" + cdTipologia + " ]";
    }
    
}
