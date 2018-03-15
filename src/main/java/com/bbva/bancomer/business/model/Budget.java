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
        @NamedQuery(name = "Budget.findAll", query = "SELECT t FROM Budget t")})
public class Budget implements Serializable {

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
    private Status stPep;
    @JoinColumn(name = "ST_DYD", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status stDyd;
    @JoinColumn(name = "CD_USUARIO_SOLIC", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne
    private User cdUserSolic;
    @JoinColumn(name = "CD_USUARIO_RESP", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne
    private User cdUserResp;
    @JoinColumn(name = "CD_AREA", referencedColumnName = "CD_AREA", nullable = false)
    @ManyToOne(optional = false)
    private Area cdArea;
    @JoinColumn(name = "CD_BANCA", referencedColumnName = "CD_BANCA", nullable = false)
    @ManyToOne(optional = false)
    private Banking cdBanking;
    @JoinColumn(name = "CD_ENTIDAD", referencedColumnName = "CD_ENTIDAD", nullable = false)
    @ManyToOne(optional = false)
    private Corporation cdCorporation;
    @JoinColumn(name = "CD_NATURALEZA", referencedColumnName = "CD_NATURALEZA", nullable = false)
    @ManyToOne(optional = false)
    private Nature cdNature;
    @OneToMany(mappedBy = "cdPep")
    private List<Transfer> transferList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdPep")
    private List<BudgetRequirement> budgetRequirementList;

    public Budget() {
    }

    public Budget(Integer cdConsecPep) {
        this.cdConsecPep = cdConsecPep;
    }

    public Budget(Integer cdConsecPep, String cdPep, int nuEjercicio, String txCentroCto) {
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

    public Status getStPep() {
        return stPep;
    }

    public void setStPep(Status stPep) {
        this.stPep = stPep;
    }

    public Status getStDyd() {
        return stDyd;
    }

    public void setStDyd(Status stDyd) {
        this.stDyd = stDyd;
    }

    public User getCdUserSolic() {
        return cdUserSolic;
    }

    public void setCdUserSolic(User cdUserSolic) {
        this.cdUserSolic = cdUserSolic;
    }

    public User getCdUserResp() {
        return cdUserResp;
    }

    public void setCdUserResp(User cdUserResp) {
        this.cdUserResp = cdUserResp;
    }

    public Area getCdArea() {
        return cdArea;
    }

    public void setCdArea(Area cdArea) {
        this.cdArea = cdArea;
    }

    public Banking getCdBanking() {
        return cdBanking;
    }

    public void setCdBanking(Banking cdBanking) {
        this.cdBanking = cdBanking;
    }

    public Corporation getCdCorporation() {
        return cdCorporation;
    }

    public void setCdCorporation(Corporation cdCorporation) {
        this.cdCorporation = cdCorporation;
    }

    public Nature getCdNature() {
        return cdNature;
    }

    public void setCdNature(Nature cdNature) {
        this.cdNature = cdNature;
    }

    public List<Transfer> getTransferList() {
        return transferList;
    }

    public void setTransferList(List<Transfer> transferList) {
        this.transferList = transferList;
    }

    public List<BudgetRequirement> getBudgetRequirementList() {
        return budgetRequirementList;
    }

    public void setBudgetRequirementList(List<BudgetRequirement> budgetRequirementList) {
        this.budgetRequirementList = budgetRequirementList;
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
        if (!(object instanceof Budget)) {
            return false;
        }
        Budget other = (Budget) object;
        if ((this.cdConsecPep == null && other.cdConsecPep != null) || (this.cdConsecPep != null && !this.cdConsecPep.equals(other.cdConsecPep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Budget[ cdConsecPep=" + cdConsecPep + " ]";
    }

}
