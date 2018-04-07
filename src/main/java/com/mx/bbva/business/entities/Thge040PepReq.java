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
@Table(name = "thge040_pep_req", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge040PepReq.findAll", query = "SELECT t FROM Thge040PepReq t")})
public class Thge040PepReq implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_PEP_REQ")
    private Integer cdPepReq;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "IM_PEP")
    private Double imPep;
    @Column(name = "HM_PEP")
    private Double hmPep;
    @Column(name = "TM_PEP_REQ")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tmPepReq;
    @Column(name = "ST_FACTURADO")
    private Boolean stFacturado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdPepReq")
    private List<Thge039Factura> thge039FacturaList;
    @JoinColumn(name = "CD_PEP", referencedColumnName = "CD_PEP")
    @ManyToOne(optional = false)
    private Thge007Pep cdPep;
    @JoinColumn(name = "CD_REQUERIMIENTO", referencedColumnName = "CD_REQUERIMIENTO")
    @ManyToOne(optional = false)
    private Thge017Requerim cdRequerimiento;

    public Thge040PepReq() {
    }

    public Thge040PepReq(Integer cdPepReq) {
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

    public Double getHmPep() {
        return hmPep;
    }

    public void setHmPep(Double hmPep) {
        this.hmPep = hmPep;
    }

    public Date getTmPepReq() {
        return tmPepReq;
    }

    public void setTmPepReq(Date tmPepReq) {
        this.tmPepReq = tmPepReq;
    }

    public Boolean getStFacturado() {
        return stFacturado;
    }

    public void setStFacturado(Boolean stFacturado) {
        this.stFacturado = stFacturado;
    }

    public List<Thge039Factura> getThge039FacturaList() {
        return thge039FacturaList;
    }

    public void setThge039FacturaList(List<Thge039Factura> thge039FacturaList) {
        this.thge039FacturaList = thge039FacturaList;
    }

    public Thge007Pep getCdPep() {
        return cdPep;
    }

    public void setCdPep(Thge007Pep cdPep) {
        this.cdPep = cdPep;
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
        hash += (cdPepReq != null ? cdPepReq.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge040PepReq)) {
            return false;
        }
        Thge040PepReq other = (Thge040PepReq) object;
        if ((this.cdPepReq == null && other.cdPepReq != null) || (this.cdPepReq != null && !this.cdPepReq.equals(other.cdPepReq))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge040PepReq[ cdPepReq=" + cdPepReq + " ]";
    }
    
}
