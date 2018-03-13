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
@Table(name = "thge040_pep_req", catalog = "gestion_factoria", schema = "")
@NamedQueries({
        @NamedQuery(name = "PepReq.findAll", query = "SELECT t FROM PepReq t")})
public class PepReq implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_PEP_REQ", nullable = false)
    private Integer cdPepReq;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "IM_PEP", precision = 22)
    private Double imPep;
    @Column(name = "CT_HORAS_PEP", precision = 22)
    private Double ctHorasPep;
    @Column(name = "TM_PEP_REQ")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tmPepReq;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdPepReq")
    private List<Factura> facturaList;
    @JoinColumn(name = "CD_PEP", referencedColumnName = "CD_PEP", nullable = false)
    @ManyToOne(optional = false)
    private Pep cdPep;
    @JoinColumn(name = "CD_REQUERIMIENTO", referencedColumnName = "CD_REQUERIMIENTO", nullable = false)
    @ManyToOne(optional = false)
    private Requerim cdRequerimiento;

    public PepReq() {
    }

    public PepReq(Integer cdPepReq) {
        this.cdPepReq = cdPepReq;
    }

    public Integer getCdPepReq() {
        return cdPepReq;
    }

    public void setCdPepReq(Integer cdPepReq) {
        this.cdPepReq = cdPepReq;
    }

    public Double getImPep() {
        return imPep;
    }

    public void setImPep(Double imPep) {
        this.imPep = imPep;
    }

    public Double getCtHorasPep() {
        return ctHorasPep;
    }

    public void setCtHorasPep(Double ctHorasPep) {
        this.ctHorasPep = ctHorasPep;
    }

    public Date getTmPepReq() {
        return tmPepReq;
    }

    public void setTmPepReq(Date tmPepReq) {
        this.tmPepReq = tmPepReq;
    }

    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    public Pep getCdPep() {
        return cdPep;
    }

    public void setCdPep(Pep cdPep) {
        this.cdPep = cdPep;
    }

    public Requerim getCdRequerimiento() {
        return cdRequerimiento;
    }

    public void setCdRequerimiento(Requerim cdRequerimiento) {
        this.cdRequerimiento = cdRequerimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdPepReq != null ? cdPepReq.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PepReq)) {
            return false;
        }
        PepReq other = (PepReq) object;
        if ((this.cdPepReq == null && other.cdPepReq != null) || (this.cdPepReq != null && !this.cdPepReq.equals(other.cdPepReq))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.PepReq[ cdPepReq=" + cdPepReq + " ]";
    }

}
