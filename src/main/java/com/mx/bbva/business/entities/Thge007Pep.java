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
import javax.persistence.Lob;
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
@Table(name = "thge007_pep", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge007Pep.findAll", query = "SELECT t FROM Thge007Pep t")})
public class Thge007Pep implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_PEP")
    private String cdPep;
    @Basic(optional = false)
    @Column(name = "NB_DENOMINAC_PEP")
    private String nbDenominacPep;
    @Basic(optional = false)
    @Column(name = "NU_EJERCICIO")
    private int nuEjercicio;
    @Basic(optional = false)
    @Column(name = "TX_CENTRO_CTO")
    private String txCentroCto;
    @Column(name = "IM_PRESUPUESTO")
    private Double imPresupuesto;
    @Column(name = "IM_AUTORIZADO")
    private Double imAutorizado;
    @Column(name = "IM_COMPR_SOL")
    private Double imComprSol;
    @Column(name = "IM_COMPR_PEND")
    private Double imComprPend;
    @Column(name = "IM_REALIZADO")
    private Double imRealizado;
    @Column(name = "IM_DISPONIBLE")
    private Double imDisponible;
    @Column(name = "IM_COMP_PBAS")
    private Double imCompPbas;
    @Column(name = "IM_COMP_FSW")
    private Double imCompFsw;
    @Lob
    @Column(name = "TP_DESLIZADO")
    private byte[] tpDeslizado;
    @Column(name = "IM_INCURRIDO_PBAS")
    private Double imIncurridoPbas;
    @Column(name = "IM_INCURRIDO_FSW")
    private Double imIncurridoFsw;
    @JoinColumn(name = "ST_PEP", referencedColumnName = "CD_ESTADO")
    @ManyToOne(optional = false)
    private Thge005Estado stPep;
    @JoinColumn(name = "ST_DYD", referencedColumnName = "CD_ESTADO")
    @ManyToOne(optional = false)
    private Thge005Estado stDyd;
    @JoinColumn(name = "CD_USUARIO_SOLIC", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne
    private Thge011Usuario cdUsuarioSolic;
    @JoinColumn(name = "CD_USUARIO_RESP", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne
    private Thge011Usuario cdUsuarioResp;
    @JoinColumn(name = "CD_AREA", referencedColumnName = "CD_AREA")
    @ManyToOne(optional = false)
    private Thge030Area cdArea;
    @JoinColumn(name = "CD_BANCA", referencedColumnName = "CD_BANCA")
    @ManyToOne(optional = false)
    private Thge034Banca cdBanca;
    @JoinColumn(name = "CD_ENTIDAD", referencedColumnName = "CD_ENTIDAD")
    @ManyToOne(optional = false)
    private Thge037Entidad cdEntidad;
    @JoinColumn(name = "CD_NATURALEZA", referencedColumnName = "CD_NATURALEZA")
    @ManyToOne(optional = false)
    private Thge038Naturaleza cdNaturaleza;
    @OneToMany(mappedBy = "cdPep")
    private List<Thge012Traspaso> thge012TraspasoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdPep")
    private List<Thge040PepReq> thge040PepReqList;

    public Thge007Pep() {
    }

    public Thge007Pep(String cdPep) {
        this.cdPep = cdPep;
    }

    public Thge007Pep(String cdPep, String nbDenominacPep, int nuEjercicio, String txCentroCto) {
        this.cdPep = cdPep;
        this.nbDenominacPep = nbDenominacPep;
        this.nuEjercicio = nuEjercicio;
        this.txCentroCto = txCentroCto;
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

    public Double getImCompPbas() {
        return imCompPbas;
    }

    public void setImCompPbas(Double imCompPbas) {
        this.imCompPbas = imCompPbas;
    }

    public Double getImCompFsw() {
        return imCompFsw;
    }

    public void setImCompFsw(Double imCompFsw) {
        this.imCompFsw = imCompFsw;
    }

    public byte[] getTpDeslizado() {
        return tpDeslizado;
    }

    public void setTpDeslizado(byte[] tpDeslizado) {
        this.tpDeslizado = tpDeslizado;
    }

    public Double getImIncurridoPbas() {
        return imIncurridoPbas;
    }

    public void setImIncurridoPbas(Double imIncurridoPbas) {
        this.imIncurridoPbas = imIncurridoPbas;
    }

    public Double getImIncurridoFsw() {
        return imIncurridoFsw;
    }

    public void setImIncurridoFsw(Double imIncurridoFsw) {
        this.imIncurridoFsw = imIncurridoFsw;
    }

    public Thge005Estado getStPep() {
        return stPep;
    }

    public void setStPep(Thge005Estado stPep) {
        this.stPep = stPep;
    }

    public Thge005Estado getStDyd() {
        return stDyd;
    }

    public void setStDyd(Thge005Estado stDyd) {
        this.stDyd = stDyd;
    }

    public Thge011Usuario getCdUsuarioSolic() {
        return cdUsuarioSolic;
    }

    public void setCdUsuarioSolic(Thge011Usuario cdUsuarioSolic) {
        this.cdUsuarioSolic = cdUsuarioSolic;
    }

    public Thge011Usuario getCdUsuarioResp() {
        return cdUsuarioResp;
    }

    public void setCdUsuarioResp(Thge011Usuario cdUsuarioResp) {
        this.cdUsuarioResp = cdUsuarioResp;
    }

    public Thge030Area getCdArea() {
        return cdArea;
    }

    public void setCdArea(Thge030Area cdArea) {
        this.cdArea = cdArea;
    }

    public Thge034Banca getCdBanca() {
        return cdBanca;
    }

    public void setCdBanca(Thge034Banca cdBanca) {
        this.cdBanca = cdBanca;
    }

    public Thge037Entidad getCdEntidad() {
        return cdEntidad;
    }

    public void setCdEntidad(Thge037Entidad cdEntidad) {
        this.cdEntidad = cdEntidad;
    }

    public Thge038Naturaleza getCdNaturaleza() {
        return cdNaturaleza;
    }

    public void setCdNaturaleza(Thge038Naturaleza cdNaturaleza) {
        this.cdNaturaleza = cdNaturaleza;
    }

    public List<Thge012Traspaso> getThge012TraspasoList() {
        return thge012TraspasoList;
    }

    public void setThge012TraspasoList(List<Thge012Traspaso> thge012TraspasoList) {
        this.thge012TraspasoList = thge012TraspasoList;
    }

    public List<Thge040PepReq> getThge040PepReqList() {
        return thge040PepReqList;
    }

    public void setThge040PepReqList(List<Thge040PepReq> thge040PepReqList) {
        this.thge040PepReqList = thge040PepReqList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdPep != null ? cdPep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge007Pep)) {
            return false;
        }
        Thge007Pep other = (Thge007Pep) object;
        if ((this.cdPep == null && other.cdPep != null) || (this.cdPep != null && !this.cdPep.equals(other.cdPep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge007Pep[ cdPep=" + cdPep + " ]";
    }
    
}
