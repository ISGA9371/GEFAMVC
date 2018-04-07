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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "thge044_c204", catalog = "gestion_factoria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Thge044C204.findAll", query = "SELECT t FROM Thge044C204 t")})
public class Thge044C204 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_C204")
    private Integer cdC204;
    @Basic(optional = false)
    @Column(name = "CD_CASO_PRUEBA")
    private String cdCasoPrueba;
    @Column(name = "TX_COND_DTO_ENTR")
    private String txCondDtoEntr;
    @Column(name = "NB_DESC_CASO")
    private String nbDescCaso;
    @Lob
    @Column(name = "NB_RESULT_ESP")
    private byte[] nbResultEsp;
    @Lob
    @Column(name = "TX_EVIDENCIA_PBA")
    private byte[] txEvidenciaPba;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdC204")
    private List<Thge048T955> thge048T955List;
    @JoinColumn(name = "CD_T926", referencedColumnName = "CD_T926")
    @ManyToOne
    private Thge042T926 cdT926;
    @JoinColumn(name = "CD_PRIORIDAD_CP", referencedColumnName = "CD_PRIORIDAD_CP")
    @ManyToOne(optional = false)
    private Thge045PrioridadCp cdPrioridadCp;
    @JoinColumn(name = "CD_CATEGORIA_CASO", referencedColumnName = "CD_CATEGORIA_CASO")
    @ManyToOne(optional = false)
    private Thge046CatCaso cdCategoriaCaso;
    @JoinColumn(name = "CD_RESUL_OBTENIDO", referencedColumnName = "CD_RESUL_OBTENIDO")
    @ManyToOne
    private Thge047ResultObt cdResulObtenido;

    public Thge044C204() {
    }

    public Thge044C204(Integer cdC204) {
        this.cdC204 = cdC204;
    }

    public Thge044C204(Integer cdC204, String cdCasoPrueba) {
        this.cdC204 = cdC204;
        this.cdCasoPrueba = cdCasoPrueba;
    }

    public Integer getCdC204() {
        return cdC204;
    }

    public void setCdC204(Integer cdC204) {
        this.cdC204 = cdC204;
    }

    public String getCdCasoPrueba() {
        return cdCasoPrueba;
    }

    public void setCdCasoPrueba(String cdCasoPrueba) {
        this.cdCasoPrueba = cdCasoPrueba;
    }

    public String getTxCondDtoEntr() {
        return txCondDtoEntr;
    }

    public void setTxCondDtoEntr(String txCondDtoEntr) {
        this.txCondDtoEntr = txCondDtoEntr;
    }

    public String getNbDescCaso() {
        return nbDescCaso;
    }

    public void setNbDescCaso(String nbDescCaso) {
        this.nbDescCaso = nbDescCaso;
    }

    public byte[] getNbResultEsp() {
        return nbResultEsp;
    }

    public void setNbResultEsp(byte[] nbResultEsp) {
        this.nbResultEsp = nbResultEsp;
    }

    public byte[] getTxEvidenciaPba() {
        return txEvidenciaPba;
    }

    public void setTxEvidenciaPba(byte[] txEvidenciaPba) {
        this.txEvidenciaPba = txEvidenciaPba;
    }

    public List<Thge048T955> getThge048T955List() {
        return thge048T955List;
    }

    public void setThge048T955List(List<Thge048T955> thge048T955List) {
        this.thge048T955List = thge048T955List;
    }

    public Thge042T926 getCdT926() {
        return cdT926;
    }

    public void setCdT926(Thge042T926 cdT926) {
        this.cdT926 = cdT926;
    }

    public Thge045PrioridadCp getCdPrioridadCp() {
        return cdPrioridadCp;
    }

    public void setCdPrioridadCp(Thge045PrioridadCp cdPrioridadCp) {
        this.cdPrioridadCp = cdPrioridadCp;
    }

    public Thge046CatCaso getCdCategoriaCaso() {
        return cdCategoriaCaso;
    }

    public void setCdCategoriaCaso(Thge046CatCaso cdCategoriaCaso) {
        this.cdCategoriaCaso = cdCategoriaCaso;
    }

    public Thge047ResultObt getCdResulObtenido() {
        return cdResulObtenido;
    }

    public void setCdResulObtenido(Thge047ResultObt cdResulObtenido) {
        this.cdResulObtenido = cdResulObtenido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdC204 != null ? cdC204.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thge044C204)) {
            return false;
        }
        Thge044C204 other = (Thge044C204) object;
        if ((this.cdC204 == null && other.cdC204 != null) || (this.cdC204 != null && !this.cdC204.equals(other.cdC204))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.bbva.business.entity.Thge044C204[ cdC204=" + cdC204 + " ]";
    }
    
}
