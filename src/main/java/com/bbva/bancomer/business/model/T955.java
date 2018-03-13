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
@Table(name = "thge048_t955", catalog = "gestion_factoria", schema = "")
@NamedQueries({
        @NamedQuery(name = "T955.findAll", query = "SELECT t FROM T955 t")})
public class T955 implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected T955PK t955PK;
    @Basic(optional = false)
    @Column(name = "TX_NIVEL_PBA", nullable = false, length = 50)
    private String txNivelPba;
    @Basic(optional = false)
    @Column(name = "FH_IDENTIFICACION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fhIdentificacion;
    @Column(name = "TX_MODULO_PAQ", length = 50)
    private String txModuloPaq;
    @Lob
    @Column(name = "TX_EVIDENCIA_PBA")
    private byte[] txEvidenciaPba;
    @Column(name = "NB_DESC_HALLAZGO", length = 500)
    private String nbDescHallazgo;
    @Column(name = "TX_RESUL_ESPERADO", length = 500)
    private String txResulEsperado;
    @Column(name = "TX_COM_AREA_RESOL", length = 500)
    private String txComAreaResol;
    @Column(name = "FH_ATENC_PREV")
    @Temporal(TemporalType.DATE)
    private Date fhAtencPrev;
    @Column(name = "NU_PERIODO_CORREC")
    private Integer nuPeriodoCorrec;
    @Column(name = "TX_COMENT_F_PBA", length = 500)
    private String txComentFPba;
    @Column(name = "FH_SOLIC_VERIF")
    @Temporal(TemporalType.DATE)
    private Date fhSolicVerif;
    @Column(name = "FH_REAL_CIERRE")
    @Temporal(TemporalType.DATE)
    private Date fhRealCierre;
    @JoinColumn(name = "CD_ENTORNO", referencedColumnName = "CD_ENTORNO", nullable = false)
    @ManyToOne(optional = false)
    private Entorno cdEntorno;
    @JoinColumn(name = "CD_EDO_DEFECTO", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Estado cdEdoDefecto;
    @JoinColumn(name = "CD_USUARIO_RESP", referencedColumnName = "CD_USUARIO_CORP", nullable = false)
    @ManyToOne(optional = false)
    private User cdUserResp;
    @JoinColumn(name = "CD_REQUERIMIENTO", referencedColumnName = "CD_REQUERIMIENTO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Requerim requerim;
    @JoinColumn(name = "CD_T926", referencedColumnName = "CD_T926", nullable = false)
    @ManyToOne(optional = false)
    private T926 cdT926;
    @JoinColumn(name = "CD_C204", referencedColumnName = "CD_C204", nullable = false)
    @ManyToOne(optional = false)
    private C204 cdC204;
    @JoinColumn(name = "CD_SEVERIDAD", referencedColumnName = "CD_SEVERIDAD", nullable = false)
    @ManyToOne(optional = false)
    private Severidad cdSeveridad;
    @JoinColumn(name = "CD_ACEPTA_RES_COR", referencedColumnName = "CD_ACEPTA_RES_COR")
    @ManyToOne
    private AcResCor cdAceptaResCor;
    @JoinColumn(name = "CD_CAUSA_RECHAZO", referencedColumnName = "CD_CAUSA_RECHAZO")
    @ManyToOne
    private CausaRech cdCausaRechazo;
    @JoinColumn(name = "CD_CAUSA_CIERRE", referencedColumnName = "CD_CONS_CAUSA_C")
    @ManyToOne
    private CausaCier cdCausaCierre;
    @JoinColumn(name = "CD_RESULT_VERIF", referencedColumnName = "CD_CONS_RESUL_VER")
    @ManyToOne
    private ResVerif cdResultVerif;

    public T955() {
    }

    public T955(T955PK t955PK) {
        this.t955PK = t955PK;
    }

    public T955(T955PK t955PK, String txNivelPba, Date fhIdentificacion) {
        this.t955PK = t955PK;
        this.txNivelPba = txNivelPba;
        this.fhIdentificacion = fhIdentificacion;
    }

    public T955(int cdDefecto, int cdRequerimiento) {
        this.t955PK = new T955PK(cdDefecto, cdRequerimiento);
    }

    public T955PK getT955PK() {
        return t955PK;
    }

    public void setT955PK(T955PK t955PK) {
        this.t955PK = t955PK;
    }

    public String getTxNivelPba() {
        return txNivelPba;
    }

    public void setTxNivelPba(String txNivelPba) {
        this.txNivelPba = txNivelPba;
    }

    public Date getFhIdentificacion() {
        return fhIdentificacion;
    }

    public void setFhIdentificacion(Date fhIdentificacion) {
        this.fhIdentificacion = fhIdentificacion;
    }

    public String getTxModuloPaq() {
        return txModuloPaq;
    }

    public void setTxModuloPaq(String txModuloPaq) {
        this.txModuloPaq = txModuloPaq;
    }

    public byte[] getTxEvidenciaPba() {
        return txEvidenciaPba;
    }

    public void setTxEvidenciaPba(byte[] txEvidenciaPba) {
        this.txEvidenciaPba = txEvidenciaPba;
    }

    public String getNbDescHallazgo() {
        return nbDescHallazgo;
    }

    public void setNbDescHallazgo(String nbDescHallazgo) {
        this.nbDescHallazgo = nbDescHallazgo;
    }

    public String getTxResulEsperado() {
        return txResulEsperado;
    }

    public void setTxResulEsperado(String txResulEsperado) {
        this.txResulEsperado = txResulEsperado;
    }

    public String getTxComAreaResol() {
        return txComAreaResol;
    }

    public void setTxComAreaResol(String txComAreaResol) {
        this.txComAreaResol = txComAreaResol;
    }

    public Date getFhAtencPrev() {
        return fhAtencPrev;
    }

    public void setFhAtencPrev(Date fhAtencPrev) {
        this.fhAtencPrev = fhAtencPrev;
    }

    public Integer getNuPeriodoCorrec() {
        return nuPeriodoCorrec;
    }

    public void setNuPeriodoCorrec(Integer nuPeriodoCorrec) {
        this.nuPeriodoCorrec = nuPeriodoCorrec;
    }

    public String getTxComentFPba() {
        return txComentFPba;
    }

    public void setTxComentFPba(String txComentFPba) {
        this.txComentFPba = txComentFPba;
    }

    public Date getFhSolicVerif() {
        return fhSolicVerif;
    }

    public void setFhSolicVerif(Date fhSolicVerif) {
        this.fhSolicVerif = fhSolicVerif;
    }

    public Date getFhRealCierre() {
        return fhRealCierre;
    }

    public void setFhRealCierre(Date fhRealCierre) {
        this.fhRealCierre = fhRealCierre;
    }

    public Entorno getCdEntorno() {
        return cdEntorno;
    }

    public void setCdEntorno(Entorno cdEntorno) {
        this.cdEntorno = cdEntorno;
    }

    public Estado getCdEdoDefecto() {
        return cdEdoDefecto;
    }

    public void setCdEdoDefecto(Estado cdEdoDefecto) {
        this.cdEdoDefecto = cdEdoDefecto;
    }

    public User getCdUserResp() {
        return cdUserResp;
    }

    public void setCdUserResp(User cdUserResp) {
        this.cdUserResp = cdUserResp;
    }

    public Requerim getRequerim() {
        return requerim;
    }

    public void setRequerim(Requerim requerim) {
        this.requerim = requerim;
    }

    public T926 getCdT926() {
        return cdT926;
    }

    public void setCdT926(T926 cdT926) {
        this.cdT926 = cdT926;
    }

    public C204 getCdC204() {
        return cdC204;
    }

    public void setCdC204(C204 cdC204) {
        this.cdC204 = cdC204;
    }

    public Severidad getCdSeveridad() {
        return cdSeveridad;
    }

    public void setCdSeveridad(Severidad cdSeveridad) {
        this.cdSeveridad = cdSeveridad;
    }

    public AcResCor getCdAceptaResCor() {
        return cdAceptaResCor;
    }

    public void setCdAceptaResCor(AcResCor cdAceptaResCor) {
        this.cdAceptaResCor = cdAceptaResCor;
    }

    public CausaRech getCdCausaRechazo() {
        return cdCausaRechazo;
    }

    public void setCdCausaRechazo(CausaRech cdCausaRechazo) {
        this.cdCausaRechazo = cdCausaRechazo;
    }

    public CausaCier getCdCausaCierre() {
        return cdCausaCierre;
    }

    public void setCdCausaCierre(CausaCier cdCausaCierre) {
        this.cdCausaCierre = cdCausaCierre;
    }

    public ResVerif getCdResultVerif() {
        return cdResultVerif;
    }

    public void setCdResultVerif(ResVerif cdResultVerif) {
        this.cdResultVerif = cdResultVerif;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (t955PK != null ? t955PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T955)) {
            return false;
        }
        T955 other = (T955) object;
        if ((this.t955PK == null && other.t955PK != null) || (this.t955PK != null && !this.t955PK.equals(other.t955PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.T955[ t955PK=" + t955PK + " ]";
    }

}
