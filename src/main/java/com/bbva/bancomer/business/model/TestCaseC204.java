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
@Table(name = "thge044_c204", catalog = "gestion_factoria", schema = "")
@NamedQueries({
        @NamedQuery(name = "TestCaseC204.findAll", query = "SELECT t FROM TestCaseC204 t")})
public class TestCaseC204 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_C204", nullable = false)
    private Integer cdC204;
    @Basic(optional = false)
    @Column(name = "CD_CASO_PRUEBA", nullable = false, length = 12)
    private String cdCasoPrueba;
    @Column(name = "TX_COND_DTO_ENTR", length = 200)
    private String txCondDtoEntr;
    @Column(name = "NB_DESC_CASO", length = 1000)
    private String nbDescCaso;
    @Lob
    @Column(name = "NB_RESULT_ESP")
    private byte[] nbResultEsp;
    @Lob
    @Column(name = "TX_EVIDENCIA_PBA")
    private byte[] txEvidenciaPba;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdC204")
    private List<T955> t955List;
    @JoinColumn(name = "CD_T926", referencedColumnName = "CD_T926")
    @ManyToOne
    private T926 cdT926;
    @JoinColumn(name = "CD_PRIORIDAD_CP", referencedColumnName = "CD_PRIORIDAD_CP", nullable = false)
    @ManyToOne(optional = false)
    private PriorityTestCase cdPriorityTestCase;
    @JoinColumn(name = "CD_CATEGORIA_CASO", referencedColumnName = "CD_CATEGORIA_CASO", nullable = false)
    @ManyToOne(optional = false)
    private TestCaseCategory cdCategoriaCaso;
    @JoinColumn(name = "CD_RESUL_OBTENIDO", referencedColumnName = "CD_RESUL_OBTENIDO")
    @ManyToOne
    private Result cdResulObtenido;

    public TestCaseC204() {
    }

    public TestCaseC204(Integer cdC204) {
        this.cdC204 = cdC204;
    }

    public TestCaseC204(Integer cdC204, String cdCasoPrueba) {
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

    public List<T955> getT955List() {
        return t955List;
    }

    public void setT955List(List<T955> t955List) {
        this.t955List = t955List;
    }

    public T926 getCdT926() {
        return cdT926;
    }

    public void setCdT926(T926 cdT926) {
        this.cdT926 = cdT926;
    }

    public PriorityTestCase getCdPriorityTestCase() {
        return cdPriorityTestCase;
    }

    public void setCdPriorityTestCase(PriorityTestCase cdPriorityTestCase) {
        this.cdPriorityTestCase = cdPriorityTestCase;
    }

    public TestCaseCategory getCdCategoriaCaso() {
        return cdCategoriaCaso;
    }

    public void setCdCategoriaCaso(TestCaseCategory cdCategoriaCaso) {
        this.cdCategoriaCaso = cdCategoriaCaso;
    }

    public Result getCdResulObtenido() {
        return cdResulObtenido;
    }

    public void setCdResulObtenido(Result cdResulObtenido) {
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
        if (!(object instanceof TestCaseC204)) {
            return false;
        }
        TestCaseC204 other = (TestCaseC204) object;
        if ((this.cdC204 == null && other.cdC204 != null) || (this.cdC204 != null && !this.cdC204.equals(other.cdC204))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bbva.TestCaseC204[ cdC204=" + cdC204 + " ]";
    }

}
