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
@Table(name = "thge016_perf_usu", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NB_PERFIL"})})
@NamedQueries({
        @NamedQuery(name = "PerfUsu.findAll", query = "SELECT t FROM PerfUsu t")})
public class PerfUsu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_TIPO_PERFIL", nullable = false)
    private Integer cdTipoPerfil;
    @Basic(optional = false)
    @Column(name = "NB_PERFIL", nullable = false, length = 25)
    private String nbPerfil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdPerfUsu")
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdPerfilRec")
    private List<CtrlExt> ctrlExtList;

    public PerfUsu() {
    }

    public PerfUsu(Integer cdTipoPerfil) {
        this.cdTipoPerfil = cdTipoPerfil;
    }

    public PerfUsu(Integer cdTipoPerfil, String nbPerfil) {
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

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public List<CtrlExt> getCtrlExtList() {
        return ctrlExtList;
    }

    public void setCtrlExtList(List<CtrlExt> ctrlExtList) {
        this.ctrlExtList = ctrlExtList;
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
        if (!(object instanceof PerfUsu)) {
            return false;
        }
        PerfUsu other = (PerfUsu) object;
        if ((this.cdTipoPerfil == null && other.cdTipoPerfil != null) || (this.cdTipoPerfil != null && !this.cdTipoPerfil.equals(other.cdTipoPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.PerfUsu[ cdTipoPerfil=" + cdTipoPerfil + " ]";
    }

}
