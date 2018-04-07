/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author manug
 */
@Entity
@Table(name = "thge012_traspaso", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge012Traspaso.findAll", query = "SELECT t FROM Thge012Traspaso t")})
public class Thge012Traspaso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_TRASPASO")
    private Integer cdTraspaso;
    @Basic(optional = false)
    @Column(name = "FH_TRASPASO")
    @Temporal(TemporalType.DATE)
    private Date fhTraspaso;
    @Column(name = "FH_RETIRO")
    @Temporal(TemporalType.DATE)
    private Date fhRetiro;
    @Basic(optional = false)
    @Column(name = "IM_TRASPASO")
    private double imTraspaso;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "IM_RETIRO")
    private Double imRetiro;
    @Column(name = "TX_COMENTARIO")
    private String txComentario;
    @JoinColumn(name = "CD_PEP", referencedColumnName = "CD_PEP")
    @ManyToOne
    private Thge007Pep cdPep;
    @JoinColumn(name = "CD_NIVEL_SUBDIR", referencedColumnName = "CD_NIVEL")
    @ManyToOne
    private Thge010Nivel cdNivelSubdir;
    @JoinColumn(name = "CD_USU_RESP_DYD", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne
    private Thge011Usuario cdUsuRespDyd;

    public Thge012Traspaso() {
    }

    public Thge012Traspaso(Integer cdTraspaso) {
        this.cdTraspaso = cdTraspaso;
    }

    public Thge012Traspaso(Integer cdTraspaso, Date fhTraspaso, double imTraspaso) {
        this.cdTraspaso = cdTraspaso;
        this.fhTraspaso = fhTraspaso;
        this.imTraspaso = imTraspaso;
    }

    public Integer getCdTraspaso() {
        return cdTraspaso;
    }

    public void setCdTraspaso(Integer cdTraspaso) {
        this.cdTraspaso = cdTraspaso;
    }

    public Date getFhTraspaso() {
        return fhTraspaso;
    }

    public void setFhTraspaso(Date fhTraspaso) {
        this.fhTraspaso = fhTraspaso;
    }

    public Date getFhRetiro() {
        return fhRetiro;
    }

    public void setFhRetiro(Date fhRetiro) {
        this.fhRetiro = fhRetiro;
    }

    public double getImTraspaso() {
        return imTraspaso;
    }

    public void setImTraspaso(double imTraspaso) {
        this.imTraspaso = imTraspaso;
    }

    public Double getImRetiro() {
        return imRetiro;
    }

    public void setImRetiro(Double imRetiro) {
        this.imRetiro = imRetiro;
    }

    public String getTxComentario() {
        return txComentario;
    }

    public void setTxComentario(String txComentario) {
        this.txComentario = txComentario;
    }

    public Thge007Pep getCdPep() {
        return cdPep;
    }

    public void setCdPep(Thge007Pep cdPep) {
        this.cdPep = cdPep;
    }

    public Thge010Nivel getCdNivelSubdir() {
        return cdNivelSubdir;
    }

    public void setCdNivelSubdir(Thge010Nivel cdNivelSubdir) {
        this.cdNivelSubdir = cdNivelSubdir;
    }

    public Thge011Usuario getCdUsuRespDyd() {
        return cdUsuRespDyd;
    }

    public void setCdUsuRespDyd(Thge011Usuario cdUsuRespDyd) {
        this.cdUsuRespDyd = cdUsuRespDyd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdTraspaso != null ? cdTraspaso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge012Traspaso)) {
            return false;
        }
        Thge012Traspaso other = (Thge012Traspaso) object;
        if ((this.cdTraspaso == null && other.cdTraspaso != null) || (this.cdTraspaso != null && !this.cdTraspaso.equals(other.cdTraspaso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge012Traspaso[ cdTraspaso=" + cdTraspaso + " ]";
    }
    
}
