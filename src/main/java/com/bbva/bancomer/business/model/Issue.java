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
@Table(name = "thge029_incidencia", catalog = "gestion_factoria", schema = "")
@NamedQueries({
        @NamedQuery(name = "Issue.findAll", query = "SELECT t FROM Issue t")})
public class Issue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_INCIDENCIA", nullable = false)
    private Integer cdIncidencia;
    @Basic(optional = false)
    @Column(name = "FH_ALTA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fhAlta;
    @Basic(optional = false)
    @Column(name = "NB_DESC_INC_HIST", nullable = false, length = 600)
    private String nbDescIncHist;
    @Column(name = "NB_DESC_RESOL_INC", length = 600)
    private String nbDescResolInc;
    @Lob
    @Column(name = "TX_DOC_INCIDENCIA")
    private byte[] txDocIncidencia;
    @Column(name = "FH_RESOLUCION")
    @Temporal(TemporalType.DATE)
    private Date fhResolucion;
    @Column(name = "NU_RES_INCORR")
    private Integer nuResIncorr;
    @JoinColumn(name = "ST_INCIDENCIA", referencedColumnName = "CD_ESTADO")
    @ManyToOne
    private Status stIncidencia;
    @JoinColumn(name = "CD_COMPONENTE", referencedColumnName = "CD_COMPONENTE", nullable = false)
    @ManyToOne(optional = false)
    private Component cdComponent;
    @JoinColumn(name = "CD_USU_PETICION", referencedColumnName = "CD_USUARIO_CORP", nullable = false)
    @ManyToOne(optional = false)
    private User cdUsuPeticion;
    @JoinColumn(name = "CD_USU_RESP", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne
    private User cdUsuResp;
    @JoinColumn(name = "CD_PRIORIDAD", referencedColumnName = "CD_PRIORIDAD", nullable = false)
    @ManyToOne(optional = false)
    private Priority cdPriority;

    public Issue() {
    }

    public Issue(Integer cdIncidencia) {
        this.cdIncidencia = cdIncidencia;
    }

    public Issue(Integer cdIncidencia, Date fhAlta, String nbDescIncHist) {
        this.cdIncidencia = cdIncidencia;
        this.fhAlta = fhAlta;
        this.nbDescIncHist = nbDescIncHist;
    }

    public Integer getCdIncidencia() {
        return cdIncidencia;
    }

    public void setCdIncidencia(Integer cdIncidencia) {
        this.cdIncidencia = cdIncidencia;
    }

    public Date getFhAlta() {
        return fhAlta;
    }

    public void setFhAlta(Date fhAlta) {
        this.fhAlta = fhAlta;
    }

    public String getNbDescIncHist() {
        return nbDescIncHist;
    }

    public void setNbDescIncHist(String nbDescIncHist) {
        this.nbDescIncHist = nbDescIncHist;
    }

    public String getNbDescResolInc() {
        return nbDescResolInc;
    }

    public void setNbDescResolInc(String nbDescResolInc) {
        this.nbDescResolInc = nbDescResolInc;
    }

    public byte[] getTxDocIncidencia() {
        return txDocIncidencia;
    }

    public void setTxDocIncidencia(byte[] txDocIncidencia) {
        this.txDocIncidencia = txDocIncidencia;
    }

    public Date getFhResolucion() {
        return fhResolucion;
    }

    public void setFhResolucion(Date fhResolucion) {
        this.fhResolucion = fhResolucion;
    }

    public Integer getNuResIncorr() {
        return nuResIncorr;
    }

    public void setNuResIncorr(Integer nuResIncorr) {
        this.nuResIncorr = nuResIncorr;
    }

    public Status getStIncidencia() {
        return stIncidencia;
    }

    public void setStIncidencia(Status stIncidencia) {
        this.stIncidencia = stIncidencia;
    }

    public Component getCdComponent() {
        return cdComponent;
    }

    public void setCdComponent(Component cdComponent) {
        this.cdComponent = cdComponent;
    }

    public User getCdUsuPeticion() {
        return cdUsuPeticion;
    }

    public void setCdUsuPeticion(User cdUsuPeticion) {
        this.cdUsuPeticion = cdUsuPeticion;
    }

    public User getCdUsuResp() {
        return cdUsuResp;
    }

    public void setCdUsuResp(User cdUsuResp) {
        this.cdUsuResp = cdUsuResp;
    }

    public Priority getCdPriority() {
        return cdPriority;
    }

    public void setCdPriority(Priority cdPriority) {
        this.cdPriority = cdPriority;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdIncidencia != null ? cdIncidencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Issue)) {
            return false;
        }
        Issue other = (Issue) object;
        if ((this.cdIncidencia == null && other.cdIncidencia != null) || (this.cdIncidencia != null && !this.cdIncidencia.equals(other.cdIncidencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Issue[ cdIncidencia=" + cdIncidencia + " ]";
    }

}
