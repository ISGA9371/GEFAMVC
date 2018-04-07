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
@Table(name = "thge011_usuario", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge011Usuario.findAll", query = "SELECT t FROM Thge011Usuario t")})
public class Thge011Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_USUARIO_CORP")
    private String cdUsuarioCorp;
    @OneToMany(mappedBy = "cdUsuarioSolic")
    private List<Thge007Pep> thge007PepList;
    @OneToMany(mappedBy = "cdUsuarioResp")
    private List<Thge007Pep> thge007PepList1;
    @OneToMany(mappedBy = "cdUsuRespDyd")
    private List<Thge012Traspaso> thge012TraspasoList;
    @JoinColumn(name = "ST_USUARIO", referencedColumnName = "CD_ESTADO")
    @ManyToOne
    private Thge005Estado stUsuario;
    @JoinColumn(name = "CD_PERF_USU", referencedColumnName = "CD_TIPO_PERFIL")
    @ManyToOne
    private Thge016PerfUsu cdPerfUsu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdUsuarioResp")
    private List<Thge017Requerim> thge017RequerimList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdUsuarioGestor")
    private List<Thge017Requerim> thge017RequerimList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdUsuPeticion")
    private List<Thge026Modif> thge026ModifList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdRespResol")
    private List<Thge026Modif> thge026ModifList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdUsuPeticion")
    private List<Thge027Duda> thge027DudaList;
    @OneToMany(mappedBy = "cdUsuResp")
    private List<Thge027Duda> thge027DudaList1;
    @OneToMany(mappedBy = "cdUsuarioGestor")
    private List<Thge024CtrlExt> thge024CtrlExtList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdUsuarioResp")
    private List<Thge024CtrlExt> thge024CtrlExtList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdUsuarioResp")
    private List<Thge048T955> thge048T955List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdUsuPeticion")
    private List<Thge029Incidencia> thge029IncidenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdUsuarioResp")
    private List<Thge010Nivel> thge010NivelList;

    public Thge011Usuario() {
    }

    public Thge011Usuario(String cdUsuarioCorp) {
        this.cdUsuarioCorp = cdUsuarioCorp;
    }

    public String getCdUsuarioCorp() {
        return cdUsuarioCorp;
    }

    public void setCdUsuarioCorp(String cdUsuarioCorp) {
        this.cdUsuarioCorp = cdUsuarioCorp;
    }

    public List<Thge007Pep> getThge007PepList() {
        return thge007PepList;
    }

    public void setThge007PepList(List<Thge007Pep> thge007PepList) {
        this.thge007PepList = thge007PepList;
    }

    public List<Thge007Pep> getThge007PepList1() {
        return thge007PepList1;
    }

    public void setThge007PepList1(List<Thge007Pep> thge007PepList1) {
        this.thge007PepList1 = thge007PepList1;
    }

    public List<Thge012Traspaso> getThge012TraspasoList() {
        return thge012TraspasoList;
    }

    public void setThge012TraspasoList(List<Thge012Traspaso> thge012TraspasoList) {
        this.thge012TraspasoList = thge012TraspasoList;
    }

    public Thge005Estado getStUsuario() {
        return stUsuario;
    }

    public void setStUsuario(Thge005Estado stUsuario) {
        this.stUsuario = stUsuario;
    }

    public Thge016PerfUsu getCdPerfUsu() {
        return cdPerfUsu;
    }

    public void setCdPerfUsu(Thge016PerfUsu cdPerfUsu) {
        this.cdPerfUsu = cdPerfUsu;
    }

    public List<Thge017Requerim> getThge017RequerimList() {
        return thge017RequerimList;
    }

    public void setThge017RequerimList(List<Thge017Requerim> thge017RequerimList) {
        this.thge017RequerimList = thge017RequerimList;
    }

    public List<Thge017Requerim> getThge017RequerimList1() {
        return thge017RequerimList1;
    }

    public void setThge017RequerimList1(List<Thge017Requerim> thge017RequerimList1) {
        this.thge017RequerimList1 = thge017RequerimList1;
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

    public List<Thge027Duda> getThge027DudaList() {
        return thge027DudaList;
    }

    public void setThge027DudaList(List<Thge027Duda> thge027DudaList) {
        this.thge027DudaList = thge027DudaList;
    }

    public List<Thge027Duda> getThge027DudaList1() {
        return thge027DudaList1;
    }

    public void setThge027DudaList1(List<Thge027Duda> thge027DudaList1) {
        this.thge027DudaList1 = thge027DudaList1;
    }

    public List<Thge024CtrlExt> getThge024CtrlExtList() {
        return thge024CtrlExtList;
    }

    public void setThge024CtrlExtList(List<Thge024CtrlExt> thge024CtrlExtList) {
        this.thge024CtrlExtList = thge024CtrlExtList;
    }

    public List<Thge024CtrlExt> getThge024CtrlExtList1() {
        return thge024CtrlExtList1;
    }

    public void setThge024CtrlExtList1(List<Thge024CtrlExt> thge024CtrlExtList1) {
        this.thge024CtrlExtList1 = thge024CtrlExtList1;
    }

    public List<Thge048T955> getThge048T955List() {
        return thge048T955List;
    }

    public void setThge048T955List(List<Thge048T955> thge048T955List) {
        this.thge048T955List = thge048T955List;
    }

    public List<Thge029Incidencia> getThge029IncidenciaList() {
        return thge029IncidenciaList;
    }

    public void setThge029IncidenciaList(List<Thge029Incidencia> thge029IncidenciaList) {
        this.thge029IncidenciaList = thge029IncidenciaList;
    }

    public List<Thge010Nivel> getThge010NivelList() {
        return thge010NivelList;
    }

    public void setThge010NivelList(List<Thge010Nivel> thge010NivelList) {
        this.thge010NivelList = thge010NivelList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdUsuarioCorp != null ? cdUsuarioCorp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge011Usuario)) {
            return false;
        }
        Thge011Usuario other = (Thge011Usuario) object;
        if ((this.cdUsuarioCorp == null && other.cdUsuarioCorp != null) || (this.cdUsuarioCorp != null && !this.cdUsuarioCorp.equals(other.cdUsuarioCorp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge011Usuario[ cdUsuarioCorp=" + cdUsuarioCorp + " ]";
    }
    
}
