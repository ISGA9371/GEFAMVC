/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbva.bancomer.business.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Guevara
 */
@Entity
@Table(name = "thge009_componente", catalog = "gestion_factoria", schema = "")
@NamedQueries({
        @NamedQuery(name = "Component.findAll", query = "SELECT t FROM Component t")})
public class Component implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_COMPONENTE", nullable = false)
    private Integer cdComponente;
    @Basic(optional = false)
    @Column(name = "NB_COMPONENTE", nullable = false, length = 45)
    private String nbComponente;
    @Basic(optional = false)
    @Column(name = "TX_VENTREGA", nullable = false, length = 9)
    private String txVentrega;
    @Basic(optional = false)
    @Column(name = "TP_NVO_MOD", nullable = false, length = 10)
    private String tpNvoMod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "IM_COSTE_EMP", precision = 22)
    private Double imCosteEmp;
    @Column(name = "IM_COSTE_INIC", precision = 22)
    private Double imCosteInic;
    @Column(name = "TX_COM_TIPIF_EMP", length = 600)
    private String txComTipifEmp;
    @Basic(optional = false)
    @Column(name = "FH_NEG_EMP_CGF_SW", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fhNegEmpCgfSw;
    @Basic(optional = false)
    @Column(name = "FH_PRV_EMP_CGF_SW", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fhPrvEmpCgfSw;
    @Basic(optional = false)
    @Column(name = "FH_R_CGF_EMP_DIS", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fhRCgfEmpDis;
    @Column(name = "FH_R_EMP_CGF_SW")
    @Temporal(TemporalType.DATE)
    private Date fhREmpCgfSw;
    @Column(name = "TM_ALTA_COMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tmAltaComp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdComponente")
    private List<Modification> modificationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdComponente")
    private List<Doubt> doubtList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdComponente")
    private List<Issue> issueList;
    @JoinColumn(name = "ST_TIPIFICACION", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status stTipificacion;
    @JoinColumn(name = "ST_COMPONENTE", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status stComponente;
    @JoinColumn(name = "CD_TIPOLOGIA", referencedColumnName = "CD_TIPOLOGIA", nullable = false)
    @ManyToOne(optional = false)
    private Typology cdTypology;
    @JoinColumn(name = "CD_TIPOLOGIA_EMP", referencedColumnName = "CD_TIPOLOGIA", nullable = false)
    @ManyToOne(optional = false)
    private Typology cdTypologyEmp;
    @JoinColumn(name = "CD_REQUERIMIENTO", referencedColumnName = "CD_REQUERIMIENTO", nullable = false)
    @ManyToOne(optional = false)
    private Requirement cdRequerimiento;

    public Component() {
    }

    public Component(Integer cdComponente) {
        this.cdComponente = cdComponente;
    }

    public Component(Integer cdComponente, String nbComponente, String txVentrega, String tpNvoMod, Date fhNegEmpCgfSw, Date fhPrvEmpCgfSw, Date fhRCgfEmpDis) {
        this.cdComponente = cdComponente;
        this.nbComponente = nbComponente;
        this.txVentrega = txVentrega;
        this.tpNvoMod = tpNvoMod;
        this.fhNegEmpCgfSw = fhNegEmpCgfSw;
        this.fhPrvEmpCgfSw = fhPrvEmpCgfSw;
        this.fhRCgfEmpDis = fhRCgfEmpDis;
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

    public String getTpNvoMod() {
        return tpNvoMod;
    }

    public void setTpNvoMod(String tpNvoMod) {
        this.tpNvoMod = tpNvoMod;
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

    public Date getTmAltaComp() {
        return tmAltaComp;
    }

    public void setTmAltaComp(Date tmAltaComp) {
        this.tmAltaComp = tmAltaComp;
    }

    public List<Modification> getModificationList() {
        return modificationList;
    }

    public void setModificationList(List<Modification> modificationList) {
        this.modificationList = modificationList;
    }

    public List<Doubt> getDoubtList() {
        return doubtList;
    }

    public void setDoubtList(List<Doubt> doubtList) {
        this.doubtList = doubtList;
    }

    public List<Issue> getIssueList() {
        return issueList;
    }

    public void setIssueList(List<Issue> issueList) {
        this.issueList = issueList;
    }

    public Status getStTipificacion() {
        return stTipificacion;
    }

    public void setStTipificacion(Status stTipificacion) {
        this.stTipificacion = stTipificacion;
    }

    public Status getStComponente() {
        return stComponente;
    }

    public void setStComponente(Status stComponente) {
        this.stComponente = stComponente;
    }

    public Typology getCdTypology() {
        return cdTypology;
    }

    public void setCdTypology(Typology cdTypology) {
        this.cdTypology = cdTypology;
    }

    public Typology getCdTypologyEmp() {
        return cdTypologyEmp;
    }

    public void setCdTypologyEmp(Typology cdTypologyEmp) {
        this.cdTypologyEmp = cdTypologyEmp;
    }

    public Requirement getCdRequerimiento() {
        return cdRequerimiento;
    }

    public void setCdRequerimiento(Requirement cdRequerimiento) {
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
        if (!(object instanceof Component)) {
            return false;
        }
        Component other = (Component) object;
        if ((this.cdComponente == null && other.cdComponente != null) || (this.cdComponente != null && !this.cdComponente.equals(other.cdComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Component[ cdComponente=" + cdComponente + " ]";
    }

}
