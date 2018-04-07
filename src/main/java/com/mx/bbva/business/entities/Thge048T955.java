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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "thge048_t955", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge048T955.findAll", query = "SELECT t FROM Thge048T955 t")})
public class Thge048T955 implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Thge048T955PK thge048T955PK;
    @Basic(optional = false)
    @Column(name = "TX_NIVEL_PBA")
    private String txNivelPba;
    @Basic(optional = false)
    @Column(name = "FH_IDENTIFICACION")
    @Temporal(TemporalType.DATE)
    private Date fhIdentificacion;
    @Column(name = "TX_MODULO_PAQ")
    private String txModuloPaq;
    @Lob
    @Column(name = "TX_EVIDENCIA_PBA")
    private byte[] txEvidenciaPba;
    @Column(name = "NB_DESC_HALLAZGO")
    private String nbDescHallazgo;
    @Column(name = "TX_RESUL_ESPERADO")
    private String txResulEsperado;
    @Column(name = "TX_COM_AREA_RESOL")
    private String txComAreaResol;
    @Column(name = "FH_ATENC_PREV")
    @Temporal(TemporalType.DATE)
    private Date fhAtencPrev;
    @Column(name = "NU_PERIODO_CORREC")
    private Integer nuPeriodoCorrec;
    @Column(name = "TX_COMENT_F_PBA")
    private String txComentFPba;
    @Column(name = "FH_SOLIC_VERIF")
    @Temporal(TemporalType.DATE)
    private Date fhSolicVerif;
    @Column(name = "FH_REAL_CIERRE")
    @Temporal(TemporalType.DATE)
    private Date fhRealCierre;
    @Column(name = "CD_CAUSA_CIERRE")
    private Integer cdCausaCierre;
    @Column(name = "CD_RESULT_VERIF")
    private Integer cdResultVerif;
    @JoinColumn(name = "CD_EDO_DEFECTO", referencedColumnName = "CD_ESTADO")
    @ManyToOne(optional = false)
    private Thge005Estado cdEdoDefecto;
    @JoinColumn(name = "CD_USUARIO_RESP", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne(optional = false)
    private Thge011Usuario cdUsuarioResp;
    @JoinColumn(name = "CD_REQUERIMIENTO", referencedColumnName = "CD_REQUERIMIENTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Thge017Requerim thge017Requerim;
    @JoinColumn(name = "CD_T926", referencedColumnName = "CD_T926")
    @ManyToOne(optional = false)
    private Thge042T926 cdT926;
    @JoinColumn(name = "CD_C204", referencedColumnName = "CD_C204")
    @ManyToOne(optional = false)
    private Thge044C204 cdC204;
    @JoinColumn(name = "CD_ENTORNO", referencedColumnName = "CD_ENTORNO")
    @ManyToOne(optional = false)
    private Thge049Entorno cdEntorno;
    @JoinColumn(name = "CD_SEVERIDAD", referencedColumnName = "CD_SEVERIDAD")
    @ManyToOne(optional = false)
    private Thge050Severidad cdSeveridad;
    @JoinColumn(name = "CD_ACEPTA_RES_COR", referencedColumnName = "CD_ACEPTA_RES_COR")
    @ManyToOne
    private Thge051AcResCor cdAceptaResCor;
    @JoinColumn(name = "CD_CAUSA_RECHAZO", referencedColumnName = "CD_CAUSA_RECHAZO")
    @ManyToOne
    private Thge052CausaRech cdCausaRechazo;

    public Thge048T955() {
    }

    public Thge048T955(Thge048T955PK thge048T955PK) {
        this.thge048T955PK = thge048T955PK;
    }

    public Thge048T955(Thge048T955PK thge048T955PK, String txNivelPba, Date fhIdentificacion) {
        this.thge048T955PK = thge048T955PK;
        this.txNivelPba = txNivelPba;
        this.fhIdentificacion = fhIdentificacion;
    }

    public Thge048T955(int cdDefecto, int cdRequerimiento) {
        this.thge048T955PK = new Thge048T955PK(cdDefecto, cdRequerimiento);
    }

    public Thge048T955PK getThge048T955PK() {
        return thge048T955PK;
    }

    public void setThge048T955PK(Thge048T955PK thge048T955PK) {
        this.thge048T955PK = thge048T955PK;
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

    public Integer getCdCausaCierre() {
        return cdCausaCierre;
    }

    public void setCdCausaCierre(Integer cdCausaCierre) {
        this.cdCausaCierre = cdCausaCierre;
    }

    public Integer getCdResultVerif() {
        return cdResultVerif;
    }

    public void setCdResultVerif(Integer cdResultVerif) {
        this.cdResultVerif = cdResultVerif;
    }

    public Thge005Estado getCdEdoDefecto() {
        return cdEdoDefecto;
    }

    public void setCdEdoDefecto(Thge005Estado cdEdoDefecto) {
        this.cdEdoDefecto = cdEdoDefecto;
    }

    public Thge011Usuario getCdUsuarioResp() {
        return cdUsuarioResp;
    }

    public void setCdUsuarioResp(Thge011Usuario cdUsuarioResp) {
        this.cdUsuarioResp = cdUsuarioResp;
    }

    public Thge017Requerim getThge017Requerim() {
        return thge017Requerim;
    }

    public void setThge017Requerim(Thge017Requerim thge017Requerim) {
        this.thge017Requerim = thge017Requerim;
    }

    public Thge042T926 getCdT926() {
        return cdT926;
    }

    public void setCdT926(Thge042T926 cdT926) {
        this.cdT926 = cdT926;
    }

    public Thge044C204 getCdC204() {
        return cdC204;
    }

    public void setCdC204(Thge044C204 cdC204) {
        this.cdC204 = cdC204;
    }

    public Thge049Entorno getCdEntorno() {
        return cdEntorno;
    }

    public void setCdEntorno(Thge049Entorno cdEntorno) {
        this.cdEntorno = cdEntorno;
    }

    public Thge050Severidad getCdSeveridad() {
        return cdSeveridad;
    }

    public void setCdSeveridad(Thge050Severidad cdSeveridad) {
        this.cdSeveridad = cdSeveridad;
    }

    public Thge051AcResCor getCdAceptaResCor() {
        return cdAceptaResCor;
    }

    public void setCdAceptaResCor(Thge051AcResCor cdAceptaResCor) {
        this.cdAceptaResCor = cdAceptaResCor;
    }

    public Thge052CausaRech getCdCausaRechazo() {
        return cdCausaRechazo;
    }

    public void setCdCausaRechazo(Thge052CausaRech cdCausaRechazo) {
        this.cdCausaRechazo = cdCausaRechazo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (thge048T955PK != null ? thge048T955PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge048T955)) {
            return false;
        }
        Thge048T955 other = (Thge048T955) object;
        if ((this.thge048T955PK == null && other.thge048T955PK != null) || (this.thge048T955PK != null && !this.thge048T955PK.equals(other.thge048T955PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge048T955[ thge048T955PK=" + thge048T955PK + " ]";
    }
    
}
