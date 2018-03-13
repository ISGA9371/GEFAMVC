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
@Table(name = "thge007_pep", catalog = "gestion_factoria", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CD_PEP"})})
@NamedQueries({
        @NamedQuery(name = "Pep.findAll", query = "SELECT t FROM Pep t")})
public class Pep implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_CONSEC_PEP", nullable = false)
    private Integer cdConsecPep;
    @Basic(optional = false)
    @Column(name = "CD_PEP", nullable = false, length = 15)
    private String cdPep;
    @Column(name = "NB_DENOMINAC_PEP", length = 50)
    private String nbDenominacPep;
    @Basic(optional = false)
    @Column(name = "NU_EJERCICIO", nullable = false)
    private int nuEjercicio;
    @Basic(optional = false)
    @Column(name = "TX_CENTRO_CTO", nullable = false, length = 10)
    private String txCentroCto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "IM_PRESUPUESTO", precision = 22)
    private Double imPresupuesto;
    @Column(name = "IM_AUTORIZADO", precision = 22)
    private Double imAutorizado;
    @Column(name = "IM_COMPR_SOL", precision = 22)
    private Double imComprSol;
    @Column(name = "IM_COMPR_PEND", precision = 22)
    private Double imComprPend;
    @Column(name = "IM_REALIZADO", precision = 22)
    private Double imRealizado;
    @Column(name = "IM_DISPONIBLE", precision = 22)
    private Double imDisponible;
    @Column(name = "IM_INCURRIDO_PBAS", precision = 22)
    private Double imIncurridoPbas;
    @Column(name = "IM_IMCURRIDO_FSW", precision = 22)
    private Double imImcurridoFsw;
    @Lob
    @Column(name = "TP_DESLIZADO")
    private byte[] tpDeslizado;
    @JoinColumn(name = "ST_PEP", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Estado stPep;
    @JoinColumn(name = "ST_DYD", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Estado stDyd;
    @JoinColumn(name = "CD_USUARIO_SOLIC", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne
    private Usuario cdUsuarioSolic;
    @JoinColumn(name = "CD_USUARIO_RESP", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne
    private Usuario cdUsuarioResp;
    @JoinColumn(name = "CD_AREA", referencedColumnName = "CD_AREA", nullable = false)
    @ManyToOne(optional = false)
    private Area cdArea;
    @JoinColumn(name = "CD_BANCA", referencedColumnName = "CD_BANCA", nullable = false)
    @ManyToOne(optional = false)
    private Banca cdBanca;
    @JoinColumn(name = "CD_ENTIDAD", referencedColumnName = "CD_ENTIDAD", nullable = false)
    @ManyToOne(optional = false)
    private Entidad cdEntidad;
    @JoinColumn(name = "CD_NATURALEZA", referencedColumnName = "CD_NATURALEZA", nullable = false)
    @ManyToOne(optional = false)
    private Naturaleza cdNaturaleza;
    @OneToMany(mappedBy = "cdPep")
    private List<Traspaso> traspasoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdPep")
    private List<PepReq> pepReqList;

    public Pep() {
    }

    public Pep(Integer cdConsecPep) {
        this.cdConsecPep = cdConsecPep;
    }

    public Pep(Integer cdConsecPep, String cdPep, int nuEjercicio, String txCentroCto) {
        this.cdConsecPep = cdConsecPep;
        this.cdPep = cdPep;
        this.nuEjercicio = nuEjercicio;
        this.txCentroCto = txCentroCto;
    }

    public Integer getCdConsecPep() {
        return cdConsecPep;
    }

    public void setCdConsecPep(Integer cdConsecPep) {
        this.cdConsecPep = cdConsecPep;
    }

    public String getCdPep() {
        return cdPep;
    }

    public void setCdPep(String cdPep) {
        this.cdPep = cdPep;
    }

    public String getNbDenominacPep() {
        return nbDenominacPep;
    }

    public void setNbDenominacPep(String nbDenominacPep) {
        this.nbDenominacPep = nbDenominacPep;
    }

    public int getNuEjercicio() {
        return nuEjercicio;
    }

    public void setNuEjercicio(int nuEjercicio) {
        this.nuEjercicio = nuEjercicio;
    }

    public String getTxCentroCto() {
        return txCentroCto;
    }

    public void setTxCentroCto(String txCentroCto) {
        this.txCentroCto = txCentroCto;
    }

    public Double getImPresupuesto() {
        return imPresupuesto;
    }

    public void setImPresupuesto(Double imPresupuesto) {
        this.imPresupuesto = imPresupuesto;
    }

    public Double getImAutorizado() {
        return imAutorizado;
    }

    public void setImAutorizado(Double imAutorizado) {
        this.imAutorizado = imAutorizado;
    }

    public Double getImComprSol() {
        return imComprSol;
    }

    public void setImComprSol(Double imComprSol) {
        this.imComprSol = imComprSol;
    }

    public Double getImComprPend() {
        return imComprPend;
    }

    public void setImComprPend(Double imComprPend) {
        this.imComprPend = imComprPend;
    }

    public Double getImRealizado() {
        return imRealizado;
    }

    public void setImRealizado(Double imRealizado) {
        this.imRealizado = imRealizado;
    }

    public Double getImDisponible() {
        return imDisponible;
    }

    public void setImDisponible(Double imDisponible) {
        this.imDisponible = imDisponible;
    }

    public Double getImIncurridoPbas() {
        return imIncurridoPbas;
    }

    public void setImIncurridoPbas(Double imIncurridoPbas) {
        this.imIncurridoPbas = imIncurridoPbas;
    }

    public Double getImImcurridoFsw() {
        return imImcurridoFsw;
    }

    public void setImImcurridoFsw(Double imImcurridoFsw) {
        this.imImcurridoFsw = imImcurridoFsw;
    }

    public byte[] getTpDeslizado() {
        return tpDeslizado;
    }

    public void setTpDeslizado(byte[] tpDeslizado) {
        this.tpDeslizado = tpDeslizado;
    }

    public Estado getStPep() {
        return stPep;
    }

    public void setStPep(Estado stPep) {
        this.stPep = stPep;
    }

    public Estado getStDyd() {
        return stDyd;
    }

    public void setStDyd(Estado stDyd) {
        this.stDyd = stDyd;
    }

    public Usuario getCdUsuarioSolic() {
        return cdUsuarioSolic;
    }

    public void setCdUsuarioSolic(Usuario cdUsuarioSolic) {
        this.cdUsuarioSolic = cdUsuarioSolic;
    }

    public Usuario getCdUsuarioResp() {
        return cdUsuarioResp;
    }

    public void setCdUsuarioResp(Usuario cdUsuarioResp) {
        this.cdUsuarioResp = cdUsuarioResp;
    }

    public Area getCdArea() {
        return cdArea;
    }

    public void setCdArea(Area cdArea) {
        this.cdArea = cdArea;
    }

    public Banca getCdBanca() {
        return cdBanca;
    }

    public void setCdBanca(Banca cdBanca) {
        this.cdBanca = cdBanca;
    }

    public Entidad getCdEntidad() {
        return cdEntidad;
    }

    public void setCdEntidad(Entidad cdEntidad) {
        this.cdEntidad = cdEntidad;
    }

    public Naturaleza getCdNaturaleza() {
        return cdNaturaleza;
    }

    public void setCdNaturaleza(Naturaleza cdNaturaleza) {
        this.cdNaturaleza = cdNaturaleza;
    }

    public List<Traspaso> getTraspasoList() {
        return traspasoList;
    }

    public void setTraspasoList(List<Traspaso> traspasoList) {
        this.traspasoList = traspasoList;
    }

    public List<PepReq> getPepReqList() {
        return pepReqList;
    }

    public void setPepReqList(List<PepReq> pepReqList) {
        this.pepReqList = pepReqList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdConsecPep != null ? cdConsecPep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pep)) {
            return false;
        }
        Pep other = (Pep) object;
        if ((this.cdConsecPep == null && other.cdConsecPep != null) || (this.cdConsecPep != null && !this.cdConsecPep.equals(other.cdConsecPep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Pep[ cdConsecPep=" + cdConsecPep + " ]";
    }

}
