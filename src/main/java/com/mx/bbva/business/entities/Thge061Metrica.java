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
@Table(name = "thge061_metrica", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge061Metrica.findAll", query = "SELECT t FROM Thge061Metrica t")})
public class Thge061Metrica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_METRICA")
    private Integer cdMetrica;
    @Basic(optional = false)
    @Column(name = "NB_METRICA")
    private String nbMetrica;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FA_LMT_INF")
    private Float faLmtInf;
    @Column(name = "FA_LMT_SUP")
    private Float faLmtSup;
    @Column(name = "FA_MEDIA")
    private Float faMedia;
    @JoinColumn(name = "CD_TP_METRICA", referencedColumnName = "CD_TP_METRICA")
    @ManyToOne(optional = false)
    private Thge060TpMetrica cdTpMetrica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdMetrica")
    private List<Thge059HCMando> thge059HCMandoList;

    public Thge061Metrica() {
    }

    public Thge061Metrica(Integer cdMetrica) {
        this.cdMetrica = cdMetrica;
    }

    public Thge061Metrica(Integer cdMetrica, String nbMetrica) {
        this.cdMetrica = cdMetrica;
        this.nbMetrica = nbMetrica;
    }

    public Integer getCdMetrica() {
        return cdMetrica;
    }

    public void setCdMetrica(Integer cdMetrica) {
        this.cdMetrica = cdMetrica;
    }

    public String getNbMetrica() {
        return nbMetrica;
    }

    public void setNbMetrica(String nbMetrica) {
        this.nbMetrica = nbMetrica;
    }

    public Float getFaLmtInf() {
        return faLmtInf;
    }

    public void setFaLmtInf(Float faLmtInf) {
        this.faLmtInf = faLmtInf;
    }

    public Float getFaLmtSup() {
        return faLmtSup;
    }

    public void setFaLmtSup(Float faLmtSup) {
        this.faLmtSup = faLmtSup;
    }

    public Float getFaMedia() {
        return faMedia;
    }

    public void setFaMedia(Float faMedia) {
        this.faMedia = faMedia;
    }

    public Thge060TpMetrica getCdTpMetrica() {
        return cdTpMetrica;
    }

    public void setCdTpMetrica(Thge060TpMetrica cdTpMetrica) {
        this.cdTpMetrica = cdTpMetrica;
    }

    public List<Thge059HCMando> getThge059HCMandoList() {
        return thge059HCMandoList;
    }

    public void setThge059HCMandoList(List<Thge059HCMando> thge059HCMandoList) {
        this.thge059HCMandoList = thge059HCMandoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdMetrica != null ? cdMetrica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge061Metrica)) {
            return false;
        }
        Thge061Metrica other = (Thge061Metrica) object;
        if ((this.cdMetrica == null && other.cdMetrica != null) || (this.cdMetrica != null && !this.cdMetrica.equals(other.cdMetrica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge061Metrica[ cdMetrica=" + cdMetrica + " ]";
    }
    
}
