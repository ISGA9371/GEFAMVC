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
@Table(name = "thge011_usuario", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CD_USUARIO_CORP"})})
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "SELECT t FROM User t")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_USUARIO", nullable = false)
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "CD_USUARIO_CORP", nullable = false, length = 10)
    private String cdUsuarioCorp;
    @Basic(optional = false)
    @Column(name = "NB_USUARIO", nullable = false, length = 50)
    private String userName;
    @Basic(optional = false)
    @Column(name = "NB_APELL_PAT", nullable = false, length = 30)
    private String userFirstName;
    @Column(name = "NB_APELL_MAT", length = 30)
    private String userSecondName;
    @Column(name = "CD_CONTRASENA", length = 9)
    private String userPassword;
    @Column(name = "TX_CORREO_ELECTR", length = 70)
    private String userEmail;
    @OneToMany(mappedBy = "cdUsuarioSolic")
    private List<Pep> pepList;
    @OneToMany(mappedBy = "cdUsuarioResp")
    private List<Pep> pepList1;
    @OneToMany(mappedBy = "cdUsuRespDyd")
    private List<Traspaso> traspasoList;
    @JoinColumn(name = "ST_ESTADO_USUARIO", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Estado stEstadoUsuario;
    @JoinColumn(name = "CD_NIVEL", referencedColumnName = "CD_NIVEL")
    @ManyToOne
    private Nivel cdNivel;
    @JoinColumn(name = "CD_PERF_USU", referencedColumnName = "CD_TIPO_PERFIL", nullable = false)
    @ManyToOne(optional = false)
    private PerfUsu cdPerfUsu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdUsuarioGestor")
    private List<Requerim> requerimList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdUsuarioResp")
    private List<Requerim> requerimList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdUsuPeticion")
    private List<Modif> modifList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdRespResol")
    private List<Modif> modifList1;
    @OneToMany(mappedBy = "cdDuenoProd")
    private List<Pi> piList;
    @OneToMany(mappedBy = "cdExpertoScrum")
    private List<Pi> piList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdUsuPeticion")
    private List<Duda> dudaList;
    @OneToMany(mappedBy = "cdUsuResp")
    private List<Duda> dudaList1;
    @OneToMany(mappedBy = "cdUsuarioGestor")
    private List<CtrlExt> ctrlExtList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdUsuarioResp")
    private List<CtrlExt> ctrlExtList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdUsuarioResp")
    private List<T955> t955List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdUsuPeticion")
    private List<Incidencia> incidenciaList;
    @OneToMany(mappedBy = "cdUsuResp")
    private List<Incidencia> incidenciaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdUsuarioResp")
    private List<Nivel> nivelList;

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(Integer userId, String cdUsuarioCorp, String userName, String userFirstName) {
        this.userId = userId;
        this.cdUsuarioCorp = cdUsuarioCorp;
        this.userName = userName;
        this.userFirstName = userFirstName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCdUsuarioCorp() {
        return cdUsuarioCorp;
    }

    public void setCdUsuarioCorp(String cdUsuarioCorp) {
        this.cdUsuarioCorp = cdUsuarioCorp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserSecondName() {
        return userSecondName;
    }

    public void setUserSecondName(String userSecondName) {
        this.userSecondName = userSecondName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<Pep> getPepList() {
        return pepList;
    }

    public void setPepList(List<Pep> pepList) {
        this.pepList = pepList;
    }

    public List<Pep> getPepList1() {
        return pepList1;
    }

    public void setPepList1(List<Pep> pepList1) {
        this.pepList1 = pepList1;
    }

    public List<Traspaso> getTraspasoList() {
        return traspasoList;
    }

    public void setTraspasoList(List<Traspaso> traspasoList) {
        this.traspasoList = traspasoList;
    }

    public Estado getStEstadoUsuario() {
        return stEstadoUsuario;
    }

    public void setStEstadoUsuario(Estado stEstadoUsuario) {
        this.stEstadoUsuario = stEstadoUsuario;
    }

    public Nivel getCdNivel() {
        return cdNivel;
    }

    public void setCdNivel(Nivel cdNivel) {
        this.cdNivel = cdNivel;
    }

    public PerfUsu getCdPerfUsu() {
        return cdPerfUsu;
    }

    public void setCdPerfUsu(PerfUsu cdPerfUsu) {
        this.cdPerfUsu = cdPerfUsu;
    }

    public List<Requerim> getRequerimList() {
        return requerimList;
    }

    public void setRequerimList(List<Requerim> requerimList) {
        this.requerimList = requerimList;
    }

    public List<Requerim> getRequerimList1() {
        return requerimList1;
    }

    public void setRequerimList1(List<Requerim> requerimList1) {
        this.requerimList1 = requerimList1;
    }

    public List<Modif> getModifList() {
        return modifList;
    }

    public void setModifList(List<Modif> modifList) {
        this.modifList = modifList;
    }

    public List<Modif> getModifList1() {
        return modifList1;
    }

    public void setModifList1(List<Modif> modifList1) {
        this.modifList1 = modifList1;
    }

    public List<Pi> getPiList() {
        return piList;
    }

    public void setPiList(List<Pi> piList) {
        this.piList = piList;
    }

    public List<Pi> getPiList1() {
        return piList1;
    }

    public void setPiList1(List<Pi> piList1) {
        this.piList1 = piList1;
    }

    public List<Duda> getDudaList() {
        return dudaList;
    }

    public void setDudaList(List<Duda> dudaList) {
        this.dudaList = dudaList;
    }

    public List<Duda> getDudaList1() {
        return dudaList1;
    }

    public void setDudaList1(List<Duda> dudaList1) {
        this.dudaList1 = dudaList1;
    }

    public List<CtrlExt> getCtrlExtList() {
        return ctrlExtList;
    }

    public void setCtrlExtList(List<CtrlExt> ctrlExtList) {
        this.ctrlExtList = ctrlExtList;
    }

    public List<CtrlExt> getCtrlExtList1() {
        return ctrlExtList1;
    }

    public void setCtrlExtList1(List<CtrlExt> ctrlExtList1) {
        this.ctrlExtList1 = ctrlExtList1;
    }

    public List<T955> getT955List() {
        return t955List;
    }

    public void setT955List(List<T955> t955List) {
        this.t955List = t955List;
    }

    public List<Incidencia> getIncidenciaList() {
        return incidenciaList;
    }

    public void setIncidenciaList(List<Incidencia> incidenciaList) {
        this.incidenciaList = incidenciaList;
    }

    public List<Incidencia> getIncidenciaList1() {
        return incidenciaList1;
    }

    public void setIncidenciaList1(List<Incidencia> incidenciaList1) {
        this.incidenciaList1 = incidenciaList1;
    }

    public List<Nivel> getNivelList() {
        return nivelList;
    }

    public void setNivelList(List<Nivel> nivelList) {
        this.nivelList = nivelList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.User[ userId=" + userId + " ]";
    }

}
