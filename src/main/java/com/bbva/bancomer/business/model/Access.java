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
@Table(name = "thge058_ctrl_acc", catalog = "gestion_factoria", schema = "")
@NamedQueries({
        @NamedQuery(name = "Access.findAll", query = "SELECT t FROM Access t")})
public class Access implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_ACCESO", nullable = false)
    private Integer cdAcceso;
    @Basic(optional = false)
    @Column(name = "CD_EXTERNO", nullable = false)
    private int cdExterno;
    @Basic(optional = false)
    @Column(name = "FH_VIGENCIA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fhVigencia;
    @JoinColumn(name = "ST_ACCESO", referencedColumnName = "CD_ESTADO", nullable = false)
    @ManyToOne(optional = false)
    private Status stAcceso;
    @JoinColumn(name = "CD_SEDE", referencedColumnName = "CD_SEDE", nullable = false)
    @ManyToOne(optional = false)
    private Workplace cdWorkplace;

    public Access() {
    }

    public Access(Integer cdAcceso) {
        this.cdAcceso = cdAcceso;
    }

    public Access(Integer cdAcceso, int cdExterno, Date fhVigencia) {
        this.cdAcceso = cdAcceso;
        this.cdExterno = cdExterno;
        this.fhVigencia = fhVigencia;
    }

    public Integer getCdAcceso() {
        return cdAcceso;
    }

    public void setCdAcceso(Integer cdAcceso) {
        this.cdAcceso = cdAcceso;
    }

    public int getCdExterno() {
        return cdExterno;
    }

    public void setCdExterno(int cdExterno) {
        this.cdExterno = cdExterno;
    }

    public Date getFhVigencia() {
        return fhVigencia;
    }

    public void setFhVigencia(Date fhVigencia) {
        this.fhVigencia = fhVigencia;
    }

    public Status getStAcceso() {
        return stAcceso;
    }

    public void setStAcceso(Status stAcceso) {
        this.stAcceso = stAcceso;
    }

    public Workplace getCdWorkplace() {
        return cdWorkplace;
    }

    public void setCdWorkplace(Workplace cdWorkplace) {
        this.cdWorkplace = cdWorkplace;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdAcceso != null ? cdAcceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Access)) {
            return false;
        }
        Access other = (Access) object;
        if ((this.cdAcceso == null && other.cdAcceso != null) || (this.cdAcceso != null && !this.cdAcceso.equals(other.cdAcceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Access[ cdAcceso=" + cdAcceso + " ]";
    }

}
