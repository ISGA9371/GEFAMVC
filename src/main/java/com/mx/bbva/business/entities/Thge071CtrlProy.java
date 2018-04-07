/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.bbva.business.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author manug
 */
@Entity
@Table(name = "thge071_ctrl_proy", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge071CtrlProy.findAll", query = "SELECT t FROM Thge071CtrlProy t")})
public class Thge071CtrlProy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_CTRL_PROY")
    private Integer cdCtrlProy;
    @JoinColumn(name = "CD_REQUERIMIENTO", referencedColumnName = "CD_REQUERIMIENTO")
    @ManyToOne
    private Thge017Requerim cdRequerimiento;
    @JoinColumn(name = "CD_EXTERNO", referencedColumnName = "CD_EXTERNO_CORP")
    @ManyToOne
    private Thge024CtrlExt cdExterno;

    public Thge071CtrlProy() {
    }

    public Thge071CtrlProy(Integer cdCtrlProy) {
        this.cdCtrlProy = cdCtrlProy;
    }

    public Integer getCdCtrlProy() {
        return cdCtrlProy;
    }

    public void setCdCtrlProy(Integer cdCtrlProy) {
        this.cdCtrlProy = cdCtrlProy;
    }

    public Thge017Requerim getCdRequerimiento() {
        return cdRequerimiento;
    }

    public void setCdRequerimiento(Thge017Requerim cdRequerimiento) {
        this.cdRequerimiento = cdRequerimiento;
    }

    public Thge024CtrlExt getCdExterno() {
        return cdExterno;
    }

    public void setCdExterno(Thge024CtrlExt cdExterno) {
        this.cdExterno = cdExterno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdCtrlProy != null ? cdCtrlProy.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge071CtrlProy)) {
            return false;
        }
        Thge071CtrlProy other = (Thge071CtrlProy) object;
        if ((this.cdCtrlProy == null && other.cdCtrlProy != null) || (this.cdCtrlProy != null && !this.cdCtrlProy.equals(other.cdCtrlProy))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge071CtrlProy[ cdCtrlProy=" + cdCtrlProy + " ]";
    }
    
}
