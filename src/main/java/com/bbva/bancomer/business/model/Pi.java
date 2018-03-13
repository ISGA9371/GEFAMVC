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
@Table(name = "thge022_pi", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CD_SCRUM"})})
@NamedQueries({
        @NamedQuery(name = "Pi.findAll", query = "SELECT t FROM Pi t")})
public class Pi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_CONS_PI", nullable = false)
    private Integer cdConsPi;
    @Basic(optional = false)
    @Column(name = "CD_SCRUM", nullable = false)
    private int cdScrum;
    @Basic(optional = false)
    @Column(name = "NB_SCRUM", nullable = false, length = 100)
    private String nbScrum;
    @OneToMany(mappedBy = "cdScrum")
    private List<Requerim> requerimList;
    @JoinColumn(name = "CD_DUENO_PROD", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne
    private Usuario cdDuenoProd;
    @JoinColumn(name = "CD_EXPERTO_SCRUM", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne
    private Usuario cdExpertoScrum;
    @JoinColumn(name = "CD_TIPO_PI", referencedColumnName = "CD_TIPO_PI", nullable = false)
    @ManyToOne(optional = false)
    private TipoPi cdTipoPi;
    @JoinColumn(name = "CD_PROGRAMA", referencedColumnName = "CD_PROGRAMA", nullable = false)
    @ManyToOne(optional = false)
    private Programa cdPrograma;

    public Pi() {
    }

    public Pi(Integer cdConsPi) {
        this.cdConsPi = cdConsPi;
    }

    public Pi(Integer cdConsPi, int cdScrum, String nbScrum) {
        this.cdConsPi = cdConsPi;
        this.cdScrum = cdScrum;
        this.nbScrum = nbScrum;
    }

    public Integer getCdConsPi() {
        return cdConsPi;
    }

    public void setCdConsPi(Integer cdConsPi) {
        this.cdConsPi = cdConsPi;
    }

    public int getCdScrum() {
        return cdScrum;
    }

    public void setCdScrum(int cdScrum) {
        this.cdScrum = cdScrum;
    }

    public String getNbScrum() {
        return nbScrum;
    }

    public void setNbScrum(String nbScrum) {
        this.nbScrum = nbScrum;
    }

    public List<Requerim> getRequerimList() {
        return requerimList;
    }

    public void setRequerimList(List<Requerim> requerimList) {
        this.requerimList = requerimList;
    }

    public Usuario getCdDuenoProd() {
        return cdDuenoProd;
    }

    public void setCdDuenoProd(Usuario cdDuenoProd) {
        this.cdDuenoProd = cdDuenoProd;
    }

    public Usuario getCdExpertoScrum() {
        return cdExpertoScrum;
    }

    public void setCdExpertoScrum(Usuario cdExpertoScrum) {
        this.cdExpertoScrum = cdExpertoScrum;
    }

    public TipoPi getCdTipoPi() {
        return cdTipoPi;
    }

    public void setCdTipoPi(TipoPi cdTipoPi) {
        this.cdTipoPi = cdTipoPi;
    }

    public Programa getCdPrograma() {
        return cdPrograma;
    }

    public void setCdPrograma(Programa cdPrograma) {
        this.cdPrograma = cdPrograma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdConsPi != null ? cdConsPi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pi)) {
            return false;
        }
        Pi other = (Pi) object;
        if ((this.cdConsPi == null && other.cdConsPi != null) || (this.cdConsPi != null && !this.cdConsPi.equals(other.cdConsPi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Pi[ cdConsPi=" + cdConsPi + " ]";
    }

}
