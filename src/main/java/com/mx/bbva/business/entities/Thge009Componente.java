/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author manug
 */
@Entity
@Table(name = "thge009_componente", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge009Componente.findAll", query = "SELECT t FROM Thge009Componente t")})
public class Thge009Componente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_COMPONENTE")
    private Integer cdComponente;
    @Basic(optional = false)
    @Column(name = "NB_COMPONENTE")
    private String nbComponente;
    @Basic(optional = false)
    @Column(name = "TX_VENTREGA")
    private String txVentrega;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "IM_COSTE_EMP")
    private Double imCosteEmp;
    @Column(name = "IM_COSTE_INIC")
    private Double imCosteInic;
    @Column(name = "TX_COM_TIPIF_EMP")
    private String txComTipifEmp;
    @Basic(optional = false)
    @Column(name = "FH_NEG_EMP_CGF_SW")
    @Temporal(TemporalType.DATE)
    private Date fhNegEmpCgfSw;
    @Basic(optional = false)
    @Column(name = "FH_PRV_EMP_CGF_SW")
    @Temporal(TemporalType.DATE)
    private Date fhPrvEmpCgfSw;
    @Basic(optional = false)
    @Column(name = "FH_R_CGF_EMP_DIS")
    @Temporal(TemporalType.DATE)
    private Date fhRCgfEmpDis;
    @Column(name = "FH_R_EMP_CGF_SW")
    @Temporal(TemporalType.DATE)
    private Date fhREmpCgfSw;
    @Column(name = "NU_FACTURABLE")
    private Integer nuFacturable;
    @Basic(optional = false)
    @Column(name = "TM_ALTA_COMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tmAltaComp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdComponente")
    private List<Thge026Modif> thge026ModifList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdComponente")
    private List<Thge027Duda> thge027DudaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdComponente")
    private List<Thge029Incidencia> thge029IncidenciaList;
    @JoinColumn(name = "ST_TIPIFICACION", referencedColumnName = "CD_ESTADO")
    @ManyToOne(optional = false)
    private Thge005Estado stTipificacion;
    @JoinColumn(name = "ST_COMPONENTE", referencedColumnName = "CD_ESTADO")
    @ManyToOne(optional = false)
    private Thge005Estado stComponente;
    @JoinColumn(name = "CD_TIPOLOGIA", referencedColumnName = "CD_TIPOLOGIA")
    @ManyToOne(optional = false)
    private Thge006Tipologia cdTipologia;
    @JoinColumn(name = "CD_TIPOLOGIA_EMP", referencedColumnName = "CD_TIPOLOGIA")
    @ManyToOne(optional = false)
    private Thge006Tipologia cdTipologiaEmp;
    @JoinColumn(name = "CD_REQUERIMIENTO", referencedColumnName = "CD_REQUERIMIENTO")
    @ManyToOne(optional = false)
    private Thge017Requerim cdRequerimiento;

    public Thge009Componente() {
    }

    public Thge009Componente(Integer cdComponente) {
        this.cdComponente = cdComponente;
    }

    public Thge009Componente(Integer cdComponente, String nbComponente, String txVentrega, Date fhNegEmpCgfSw, Date fhPrvEmpCgfSw, Date fhRCgfEmpDis, Date tmAltaComp) {
        this.cdComponente = cdComponente;
        this.nbComponente = nbComponente;
        this.txVentrega = txVentrega;
        this.fhNegEmpCgfSw = fhNegEmpCgfSw;
        this.fhPrvEmpCgfSw = fhPrvEmpCgfSw;
        this.fhRCgfEmpDis = fhRCgfEmpDis;
        this.tmAltaComp = tmAltaComp;
    }

    public Integer getCdComponente() {
        return cdComponente;
    }

    public void setCdComponente(Integer cdComponente) {
        this.cdComponente = cdComponente;
    }

    public String getNbComponente() {
        return nbComponente;
    }

    public void setNbComponente(String nbComponente) {
        this.nbComponente = nbComponente;
    }

    public String getTxVentrega() {
        return txVentrega;
    }

    public void setTxVentrega(String txVentrega) {
        this.txVentrega = txVentrega;
    }

    public Double getImCosteEmp() {
        return imCosteEmp;
    }

    public void setImCosteEmp(Double imCosteEmp) {
        this.imCosteEmp = imCosteEmp;
    }

    public Double getImCosteInic() {
        return imCosteInic;
    }

    public void setImCosteInic(Double imCosteInic) {
        this.imCosteInic = imCosteInic;
    }

    public String getTxComTipifEmp() {
        return txComTipifEmp;
    }

    public void setTxComTipifEmp(String txComTipifEmp) {
        this.txComTipifEmp = txComTipifEmp;
    }

    public Date getFhNegEmpCgfSw() {
        return fhNegEmpCgfSw;
    }

    public void setFhNegEmpCgfSw(Date fhNegEmpCgfSw) {
        this.fhNegEmpCgfSw = fhNegEmpCgfSw;
    }

    public Date getFhPrvEmpCgfSw() {
        return fhPrvEmpCgfSw;
    }

    public void setFhPrvEmpCgfSw(Date fhPrvEmpCgfSw) {
        this.fhPrvEmpCgfSw = fhPrvEmpCgfSw;
    }

    public Date getFhRCgfEmpDis() {
        return fhRCgfEmpDis;
    }

    public void setFhRCgfEmpDis(Date fhRCgfEmpDis) {
        this.fhRCgfEmpDis = fhRCgfEmpDis;
    }

    public Date getFhREmpCgfSw() {
        return fhREmpCgfSw;
    }

    public void setFhREmpCgfSw(Date fhREmpCgfSw) {
        this.fhREmpCgfSw = fhREmpCgfSw;
    }

    public Integer getNuFacturable() {
        return nuFacturable;
    }

    public void setNuFacturable(Integer nuFacturable) {
        this.nuFacturable = nuFacturable;
    }

    public Date getTmAltaComp() {
        return tmAltaComp;
    }

    public void setTmAltaComp(Date tmAltaComp) {
        this.tmAltaComp = tmAltaComp;
    }

    public List<Thge026Modif> getThge026ModifList() {
        return thge026ModifList;
    }

    public void setThge026ModifList(List<Thge026Modif> thge026ModifList) {
        this.thge026ModifList = thge026ModifList;
    }

    public List<Thge027Duda> getThge027DudaList() {
        return thge027DudaList;
    }

    public void setThge027DudaList(List<Thge027Duda> thge027DudaList) {
        this.thge027DudaList = thge027DudaList;
    }

    public List<Thge029Incidencia> getThge029IncidenciaList() {
        return thge029IncidenciaList;
    }

    public void setThge029IncidenciaList(List<Thge029Incidencia> thge029IncidenciaList) {
        this.thge029IncidenciaList = thge029IncidenciaList;
    }

    public Thge005Estado getStTipificacion() {
        return stTipificacion;
    }

    public void setStTipificacion(Thge005Estado stTipificacion) {
        this.stTipificacion = stTipificacion;
    }

    public Thge005Estado getStComponente() {
        return stComponente;
    }

    public void setStComponente(Thge005Estado stComponente) {
        this.stComponente = stComponente;
    }

    public Thge006Tipologia getCdTipologia() {
        return cdTipologia;
    }

    public void setCdTipologia(Thge006Tipologia cdTipologia) {
        this.cdTipologia = cdTipologia;
    }

    public Thge006Tipologia getCdTipologiaEmp() {
        return cdTipologiaEmp;
    }

    public void setCdTipologiaEmp(Thge006Tipologia cdTipologiaEmp) {
        this.cdTipologiaEmp = cdTipologiaEmp;
    }

    public Thge017Requerim getCdRequerimiento() {
        return cdRequerimiento;
    }

    public void setCdRequerimiento(Thge017Requerim cdRequerimiento) {
        this.cdRequerimiento = cdRequerimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdComponente != null ? cdComponente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge009Componente)) {
            return false;
        }
        Thge009Componente other = (Thge009Componente) object;
        if ((this.cdComponente == null && other.cdComponente != null) || (this.cdComponente != null && !this.cdComponente.equals(other.cdComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge009Componente[ cdComponente=" + cdComponente + " ]";
    }
    
}
