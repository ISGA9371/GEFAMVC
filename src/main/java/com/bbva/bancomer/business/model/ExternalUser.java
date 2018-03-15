/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbva.bancomer.business.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Guevara
 */
@Entity
@Table(name = "thge024_ctrl_ext", catalog = "gestion_factoria", schema = "")
@NamedQueries({
        @NamedQuery(name = "ExternalUser.findAll", query = "SELECT t FROM ExternalUser t")})
public class ExternalUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_EXTERNO", nullable = false)
    private Integer cdExterno;
    @Column(name = "CD_USUARIO_CORP", length = 10)
    private String cdUsuarioCorp;
    @Basic(optional = false)
    @Column(name = "NB_REC_EXTERNO", nullable = false, length = 50)
    private String nbRecExterno;
    @Basic(optional = false)
    @Column(name = "NB_APELL_PAT", nullable = false, length = 30)
    private String nbApellPat;
    @Column(name = "NB_APELL_MAT", length = 30)
    private String nbApellMat;
    @Column(name = "TX_RFC", length = 13)
    private String txRfc;
    @Column(name = "TX_CURP", length = 18)
    private String txCurp;
    @Column(name = "TX_NSS", length = 11)
    private String txNss;
    @Column(name = "FH_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fhNacimiento;
    @Basic(optional = false)
    @Column(name = "CD_GENERO", nullable = false)
    private Character cdGenero;
    @Basic(optional = false)
    @Column(name = "TP_RECURSO", nullable = false, length = 7)
    private String tpRecurso;
    @Basic(optional = false)
    @Column(name = "CD_TIPO_CONTRATO", nullable = false)
    private int cdTipoContrato;
    @Column(name = "TX_DIR_SCRUM", length = 25)
    private String txDirScrum;
    @Column(name = "NB_PROY_EXT", length = 150)
    private String nbProyExt;
    @Column(name = "FH_INIC_PROY", length = 45)
    private String fhInicProy;
    @Column(name = "FH_FIN_PROY")
    @Temporal(TemporalType.DATE)
    private Date fhFinProy;
    @Basic(optional = false)
    @Column(name = "TP_PROY", nullable = false, length = 8)
    private String tpProy;
    @Column(name = "NB_JEFE_INMED", length = 50)
    private String nbJefeInmed;
    @Column(name = "TX_TEL_JEFE_INMED", length = 25)
    private String txTelJefeInmed;
    @Column(name = "TX_UBIC_JEF_INMED", length = 50)
    private String txUbicJefInmed;
    @Column(name = "TX_HOST", length = 2)
    private String txHost;
    @Column(name = "TX_VPN", length = 9)
    private String txVpn;
    @Column(name = "FH_VIGENCIA_TOKEN")
    @Temporal(TemporalType.DATE)
    private Date fhVigenciaToken;
    @Column(name = "NU_PISO")
    private Integer nuPiso;
    @Column(name = "TX_ESTACION", length = 6)
    private String txEstacion;
    @Column(name = "TX_CORREO_ELECTR", length = 70)
    private String txCorreoElectr;
    @Column(name = "TX_HORARIO", length = 17)
    private String txHorario;
    @Column(name = "FH_ALTA")
    @Temporal(TemporalType.DATE)
    private Date fhAlta;
    @JoinColumn(name = "CD_EMPRESA", referencedColumnName = "CD_EMPRESA", nullable = false)
    @ManyToOne(optional = false)
    private Company cdCompany;
    @JoinColumn(name = "ST_REC_EXT", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status stRecExt;
    @JoinColumn(name = "CD_USUARIO_GESTOR", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne
    private User cdUserGestor;
    @JoinColumn(name = "CD_USUARIO_RESP", referencedColumnName = "CD_USUARIO_CORP", nullable = false)
    @ManyToOne(optional = false)
    private User cdUserResp;
    @JoinColumn(name = "CD_PAIS", referencedColumnName = "CD_PAIS", nullable = false)
    @ManyToOne(optional = false)
    private Country cdCountry;
    @JoinColumn(name = "CD_PERFIL_REC", referencedColumnName = "CD_TIPO_PERFIL", nullable = false)
    @ManyToOne(optional = false)
    private ProfileType cdPerfilRec;
    @JoinColumn(name = "CD_SBCLAS_REC", referencedColumnName = "CD_SBCLAS_REC", nullable = false)
    @ManyToOne(optional = false)
    private RequirementSubClassification cdSbclasRec;
    @JoinColumn(name = "CD_SEDE", referencedColumnName = "CD_SEDE", nullable = false)
    @ManyToOne(optional = false)
    private Workplace cdWorkplace;
    @JoinColumn(name = "CD_AREA", referencedColumnName = "CD_AREA", nullable = false)
    @ManyToOne(optional = false)
    private Area cdArea;
    @JoinColumn(name = "CD_TIPO_ASIG", referencedColumnName = "CD_TIPO_ASIG", nullable = false)
    @ManyToOne(optional = false)
    private AssignationType cdAssignationType;

    public ExternalUser() {
    }

    public ExternalUser(Integer cdExterno) {
        this.cdExterno = cdExterno;
    }

    public ExternalUser(Integer cdExterno, String nbRecExterno, String nbApellPat, Character cdGenero, String tpRecurso, int cdTipoContrato, String tpProy) {
        this.cdExterno = cdExterno;
        this.nbRecExterno = nbRecExterno;
        this.nbApellPat = nbApellPat;
        this.cdGenero = cdGenero;
        this.tpRecurso = tpRecurso;
        this.cdTipoContrato = cdTipoContrato;
        this.tpProy = tpProy;
    }

    public Integer getCdExterno() {
        return cdExterno;
    }

    public void setCdExterno(Integer cdExterno) {
        this.cdExterno = cdExterno;
    }

    public String getCdUsuarioCorp() {
        return cdUsuarioCorp;
    }

    public void setCdUsuarioCorp(String cdUsuarioCorp) {
        this.cdUsuarioCorp = cdUsuarioCorp;
    }

    public String getNbRecExterno() {
        return nbRecExterno;
    }

    public void setNbRecExterno(String nbRecExterno) {
        this.nbRecExterno = nbRecExterno;
    }

    public String getNbApellPat() {
        return nbApellPat;
    }

    public void setNbApellPat(String nbApellPat) {
        this.nbApellPat = nbApellPat;
    }

    public String getNbApellMat() {
        return nbApellMat;
    }

    public void setNbApellMat(String nbApellMat) {
        this.nbApellMat = nbApellMat;
    }

    public String getTxRfc() {
        return txRfc;
    }

    public void setTxRfc(String txRfc) {
        this.txRfc = txRfc;
    }

    public String getTxCurp() {
        return txCurp;
    }

    public void setTxCurp(String txCurp) {
        this.txCurp = txCurp;
    }

    public String getTxNss() {
        return txNss;
    }

    public void setTxNss(String txNss) {
        this.txNss = txNss;
    }

    public Date getFhNacimiento() {
        return fhNacimiento;
    }

    public void setFhNacimiento(Date fhNacimiento) {
        this.fhNacimiento = fhNacimiento;
    }

    public Character getCdGenero() {
        return cdGenero;
    }

    public void setCdGenero(Character cdGenero) {
        this.cdGenero = cdGenero;
    }

    public String getTpRecurso() {
        return tpRecurso;
    }

    public void setTpRecurso(String tpRecurso) {
        this.tpRecurso = tpRecurso;
    }

    public int getCdTipoContrato() {
        return cdTipoContrato;
    }

    public void setCdTipoContrato(int cdTipoContrato) {
        this.cdTipoContrato = cdTipoContrato;
    }

    public String getTxDirScrum() {
        return txDirScrum;
    }

    public void setTxDirScrum(String txDirScrum) {
        this.txDirScrum = txDirScrum;
    }

    public String getNbProyExt() {
        return nbProyExt;
    }

    public void setNbProyExt(String nbProyExt) {
        this.nbProyExt = nbProyExt;
    }

    public String getFhInicProy() {
        return fhInicProy;
    }

    public void setFhInicProy(String fhInicProy) {
        this.fhInicProy = fhInicProy;
    }

    public Date getFhFinProy() {
        return fhFinProy;
    }

    public void setFhFinProy(Date fhFinProy) {
        this.fhFinProy = fhFinProy;
    }

    public String getTpProy() {
        return tpProy;
    }

    public void setTpProy(String tpProy) {
        this.tpProy = tpProy;
    }

    public String getNbJefeInmed() {
        return nbJefeInmed;
    }

    public void setNbJefeInmed(String nbJefeInmed) {
        this.nbJefeInmed = nbJefeInmed;
    }

    public String getTxTelJefeInmed() {
        return txTelJefeInmed;
    }

    public void setTxTelJefeInmed(String txTelJefeInmed) {
        this.txTelJefeInmed = txTelJefeInmed;
    }

    public String getTxUbicJefInmed() {
        return txUbicJefInmed;
    }

    public void setTxUbicJefInmed(String txUbicJefInmed) {
        this.txUbicJefInmed = txUbicJefInmed;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public String getTxVpn() {
        return txVpn;
    }

    public void setTxVpn(String txVpn) {
        this.txVpn = txVpn;
    }

    public Date getFhVigenciaToken() {
        return fhVigenciaToken;
    }

    public void setFhVigenciaToken(Date fhVigenciaToken) {
        this.fhVigenciaToken = fhVigenciaToken;
    }

    public Integer getNuPiso() {
        return nuPiso;
    }

    public void setNuPiso(Integer nuPiso) {
        this.nuPiso = nuPiso;
    }

    public String getTxEstacion() {
        return txEstacion;
    }

    public void setTxEstacion(String txEstacion) {
        this.txEstacion = txEstacion;
    }

    public String getTxCorreoElectr() {
        return txCorreoElectr;
    }

    public void setTxCorreoElectr(String txCorreoElectr) {
        this.txCorreoElectr = txCorreoElectr;
    }

    public String getTxHorario() {
        return txHorario;
    }

    public void setTxHorario(String txHorario) {
        this.txHorario = txHorario;
    }

    public Date getFhAlta() {
        return fhAlta;
    }

    public void setFhAlta(Date fhAlta) {
        this.fhAlta = fhAlta;
    }

    public Company getCdCompany() {
        return cdCompany;
    }

    public void setCdCompany(Company cdCompany) {
        this.cdCompany = cdCompany;
    }

    public Status getStRecExt() {
        return stRecExt;
    }

    public void setStRecExt(Status stRecExt) {
        this.stRecExt = stRecExt;
    }

    public User getCdUserGestor() {
        return cdUserGestor;
    }

    public void setCdUserGestor(User cdUserGestor) {
        this.cdUserGestor = cdUserGestor;
    }

    public User getCdUserResp() {
        return cdUserResp;
    }

    public void setCdUserResp(User cdUserResp) {
        this.cdUserResp = cdUserResp;
    }

    public Country getCdCountry() {
        return cdCountry;
    }

    public void setCdCountry(Country cdCountry) {
        this.cdCountry = cdCountry;
    }

    public ProfileType getCdPerfilRec() {
        return cdPerfilRec;
    }

    public void setCdPerfilRec(ProfileType cdPerfilRec) {
        this.cdPerfilRec = cdPerfilRec;
    }

    public RequirementSubClassification getCdSbclasRec() {
        return cdSbclasRec;
    }

    public void setCdSbclasRec(RequirementSubClassification cdSbclasRec) {
        this.cdSbclasRec = cdSbclasRec;
    }

    public Workplace getCdWorkplace() {
        return cdWorkplace;
    }

    public void setCdWorkplace(Workplace cdWorkplace) {
        this.cdWorkplace = cdWorkplace;
    }

    public Area getCdArea() {
        return cdArea;
    }

    public void setCdArea(Area cdArea) {
        this.cdArea = cdArea;
    }

    public AssignationType getCdAssignationType() {
        return cdAssignationType;
    }

    public void setCdAssignationType(AssignationType cdAssignationType) {
        this.cdAssignationType = cdAssignationType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdExterno != null ? cdExterno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExternalUser)) {
            return false;
        }
        ExternalUser other = (ExternalUser) object;
        if ((this.cdExterno == null && other.cdExterno != null) || (this.cdExterno != null && !this.cdExterno.equals(other.cdExterno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.ExternalUser[ cdExterno=" + cdExterno + " ]";
    }

}
