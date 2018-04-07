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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author manug
 */
@Entity
@Table(name = "thge016_perf_usu", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge016PerfUsu.findAll", query = "SELECT t FROM Thge016PerfUsu t")})
public class Thge016PerfUsu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_TIPO_PERFIL")
    private Integer cdTipoPerfil;
    @Basic(optional = false)
    @Column(name = "NB_PERFIL")
    private String nbPerfil;
    @OneToMany(mappedBy = "cdPerfUsu")
    private List<Thge011Usuario> thge011UsuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdPerfilRec")
    private List<Thge024CtrlExt> thge024CtrlExtList;

    public Thge016PerfUsu() {
    }

    public Thge016PerfUsu(Integer cdTipoPerfil) {
        this.cdTipoPerfil = cdTipoPerfil;
    }

    public Thge016PerfUsu(Integer cdTipoPerfil, String nbPerfil) {
        this.cdTipoPerfil = cdTipoPerfil;
        this.nbPerfil = nbPerfil;
    }

    public Integer getCdTipoPerfil() {
        return cdTipoPerfil;
    }

    public void setCdTipoPerfil(Integer cdTipoPerfil) {
        this.cdTipoPerfil = cdTipoPerfil;
    }

    public String getNbPerfil() {
        return nbPerfil;
    }

    public void setNbPerfil(String nbPerfil) {
        this.nbPerfil = nbPerfil;
    }

    public List<Thge011Usuario> getThge011UsuarioList() {
        return thge011UsuarioList;
    }

    public void setThge011UsuarioList(List<Thge011Usuario> thge011UsuarioList) {
        this.thge011UsuarioList = thge011UsuarioList;
    }

    public List<Thge024CtrlExt> getThge024CtrlExtList() {
        return thge024CtrlExtList;
    }

    public void setThge024CtrlExtList(List<Thge024CtrlExt> thge024CtrlExtList) {
        this.thge024CtrlExtList = thge024CtrlExtList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdTipoPerfil != null ? cdTipoPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge016PerfUsu)) {
            return false;
        }
        Thge016PerfUsu other = (Thge016PerfUsu) object;
        if ((this.cdTipoPerfil == null && other.cdTipoPerfil != null) || (this.cdTipoPerfil != null && !this.cdTipoPerfil.equals(other.cdTipoPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge016PerfUsu[ cdTipoPerfil=" + cdTipoPerfil + " ]";
    }
    
}
