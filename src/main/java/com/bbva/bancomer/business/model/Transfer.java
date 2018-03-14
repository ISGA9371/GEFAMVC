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
@Table(name = "thge012_traspaso", catalog = "gestion_factoria", schema = "")
@NamedQueries({
        @NamedQuery(name = "Transfer.findAll", query = "SELECT t FROM Transfer t")})
public class Transfer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_TRASPASO", nullable = false)
    private Integer cdTraspaso;
    @Basic(optional = false)
    @Column(name = "FH_TRASPASO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fhTraspaso;
    @Column(name = "FH_RETIRO")
    @Temporal(TemporalType.DATE)
    private Date fhRetiro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "IM_TRASPASO", precision = 22)
    private Double imTraspaso;
    @Column(name = "IM_RETIRO", precision = 22)
    private Double imRetiro;
    @Column(name = "TX_COMENTARIO", length = 200)
    private String txComentario;
    @JoinColumn(name = "CD_PEP", referencedColumnName = "CD_PEP")
    @ManyToOne
    private Budget cdPep;
    @JoinColumn(name = "CD_NIVEL_SUBDIR", referencedColumnName = "CD_NIVEL")
    @ManyToOne
    private Level cdLevelSubdir;
    @JoinColumn(name = "CD_USU_RESP_DYD", referencedColumnName = "CD_USUARIO_CORP")
    @ManyToOne
    private User cdUsuRespDyd;

    public Transfer() {
    }

    public Transfer(Integer cdTraspaso) {
        this.cdTraspaso = cdTraspaso;
    }

    public Transfer(Integer cdTraspaso, Date fhTraspaso) {
        this.cdTraspaso = cdTraspaso;
        this.fhTraspaso = fhTraspaso;
    }

    public Integer getCdTraspaso() {
        return cdTraspaso;
    }

    public void setCdTraspaso(Integer cdTraspaso) {
        this.cdTraspaso = cdTraspaso;
    }

    public Date getFhTraspaso() {
        return fhTraspaso;
    }

    public void setFhTraspaso(Date fhTraspaso) {
        this.fhTraspaso = fhTraspaso;
    }

    public Date getFhRetiro() {
        return fhRetiro;
    }

    public void setFhRetiro(Date fhRetiro) {
        this.fhRetiro = fhRetiro;
    }

    public Double getImTraspaso() {
        return imTraspaso;
    }

    public void setImTraspaso(Double imTraspaso) {
        this.imTraspaso = imTraspaso;
    }

    public Double getImRetiro() {
        return imRetiro;
    }

    public void setImRetiro(Double imRetiro) {
        this.imRetiro = imRetiro;
    }

    public String getTxComentario() {
        return txComentario;
    }

    public void setTxComentario(String txComentario) {
        this.txComentario = txComentario;
    }

    public Budget getCdPep() {
        return cdPep;
    }

    public void setCdPep(Budget cdPep) {
        this.cdPep = cdPep;
    }

    public Level getCdLevelSubdir() {
        return cdLevelSubdir;
    }

    public void setCdLevelSubdir(Level cdLevelSubdir) {
        this.cdLevelSubdir = cdLevelSubdir;
    }

    public User getCdUsuRespDyd() {
        return cdUsuRespDyd;
    }

    public void setCdUsuRespDyd(User cdUsuRespDyd) {
        this.cdUsuRespDyd = cdUsuRespDyd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdTraspaso != null ? cdTraspaso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transfer)) {
            return false;
        }
        Transfer other = (Transfer) object;
        if ((this.cdTraspaso == null && other.cdTraspaso != null) || (this.cdTraspaso != null && !this.cdTraspaso.equals(other.cdTraspaso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.Transfer[ cdTraspaso=" + cdTraspaso + " ]";
    }

}
