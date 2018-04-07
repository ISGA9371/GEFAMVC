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
@Table(name = "thge010_nivel", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge010Nivel.findAll", query = "SELECT t FROM Thge010Nivel t")})
public class Thge010Nivel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_NIVEL")
    private Integer cdNivel;
    @Basic(optional = false)
    @Column(name = "NB_NIVEL")
    private String nbNivel;
    @OneToMany(mappedBy = "cdNivelSubdir")
    private List<Thge012Traspaso> thge012TraspasoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdNivel")
    private List<Thge017Requerim> thge017RequerimList;
    @JoinColumn(name = "CD_TIPO_NIVEL", referencedColumnName = "CD_TIPO_NIVEL")
    @ManyToOne(optional = false)
    private Thge004TipoNivel cdTipoNivel;
    @OneToMany(mappedBy = "cdNivelSuperior")
    private List<Thge010Nivel> thge010NivelList;
    @JoinColumn(name = "CD_NIVEL_SUPERIOR", referencedColumnName = "CD_NIVEL")
    @ManyToOne
    private Thge010Nivel cdNivelSuperior;
    @JoinColumn(name = "CD_USUARIO_RESP", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne(optional = false)
    private Thge011Usuario cdUsuarioResp;

    public Thge010Nivel() {
    }

    public Thge010Nivel(Integer cdNivel) {
        this.cdNivel = cdNivel;
    }

    public Thge010Nivel(Integer cdNivel, String nbNivel) {
        this.cdNivel = cdNivel;
        this.nbNivel = nbNivel;
    }

    public Integer getCdNivel() {
        return cdNivel;
    }

    public void setCdNivel(Integer cdNivel) {
        this.cdNivel = cdNivel;
    }

    public String getNbNivel() {
        return nbNivel;
    }

    public void setNbNivel(String nbNivel) {
        this.nbNivel = nbNivel;
    }

    public List<Thge012Traspaso> getThge012TraspasoList() {
        return thge012TraspasoList;
    }

    public void setThge012TraspasoList(List<Thge012Traspaso> thge012TraspasoList) {
        this.thge012TraspasoList = thge012TraspasoList;
    }

    public List<Thge017Requerim> getThge017RequerimList() {
        return thge017RequerimList;
    }

    public void setThge017RequerimList(List<Thge017Requerim> thge017RequerimList) {
        this.thge017RequerimList = thge017RequerimList;
    }

    public Thge004TipoNivel getCdTipoNivel() {
        return cdTipoNivel;
    }

    public void setCdTipoNivel(Thge004TipoNivel cdTipoNivel) {
        this.cdTipoNivel = cdTipoNivel;
    }

    public List<Thge010Nivel> getThge010NivelList() {
        return thge010NivelList;
    }

    public void setThge010NivelList(List<Thge010Nivel> thge010NivelList) {
        this.thge010NivelList = thge010NivelList;
    }

    public Thge010Nivel getCdNivelSuperior() {
        return cdNivelSuperior;
    }

    public void setCdNivelSuperior(Thge010Nivel cdNivelSuperior) {
        this.cdNivelSuperior = cdNivelSuperior;
    }

    public Thge011Usuario getCdUsuarioResp() {
        return cdUsuarioResp;
    }

    public void setCdUsuarioResp(Thge011Usuario cdUsuarioResp) {
        this.cdUsuarioResp = cdUsuarioResp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdNivel != null ? cdNivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge010Nivel)) {
            return false;
        }
        Thge010Nivel other = (Thge010Nivel) object;
        if ((this.cdNivel == null && other.cdNivel != null) || (this.cdNivel != null && !this.cdNivel.equals(other.cdNivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge010Nivel[ cdNivel=" + cdNivel + " ]";
    }
    
}
