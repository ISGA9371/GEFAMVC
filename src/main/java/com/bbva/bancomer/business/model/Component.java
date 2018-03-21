/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbva.bancomer.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//import java.util.Date;
//import java.util.List;

/**
 * @author Guevara
 */

@Entity
@Table(name = "THGE009_COMPONENTE", catalog = "GESTION_FACTORIA", schema = "")
public class Component {

    @Id
    //@GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name="CD_COMPONENTE")
    private int cd_componente;

    @Column(name="NB_COMPOMNENTE")
    private String nb_componente;

    @Column(name="CD_REQUERIMIENTO")
    private int cd_requerimiento;

    @Column(name="TX_VENTRAGA")
    private String tx_ventraga;

    @Column(name="TP_NVO_MOD")
    private String tp_nvo_mod;

    @Column(name="CD_TIPOLOGIA")
    private int cd_tipologia;

    @Column(name="CD_TIPOLOGIA_EMP")
    private int cd_tipologia_emp;

    @Column(name="IM_COSTE_EMP")
    private double im_coste_emp;

    @Column(name="IM_CONSTE_INIC")
    private double im_conste_inic;

    @Column(name="ST_TIPIFICACION")
    private int st_tipificacion;

    @Column(name="TX_COM_TIPIF_EMP")
    private String tx_com_tipif_emp;

    @Column(name="FH_NEG_EMP_CGF_SW")
    private String fh_neg_emp_cgf_sw;

    @Column(name="FH_PRV_EMP_CGF_SW")
    private String fh_prv_emp_cgf_sw;

    @Column(name="FH_R_CGF_EMP_DIS")
    private String fh_r_cgf_emp_dis;

    @Column(name="FH_R_EMP_CGF_SW")
    private String fh_r_emp_cgf_sw;

    @Column(name="ST_COMPONENTE")
    private int st_componente;

    @Column(name="TM_ALTA_COMP")
    private String tm_alta_comp;

    //Cosntructor por defecto para Hibernate
    public Component() {
    }

    public Component (int cd_componente, String nb_componente, int cd_requerimiento, String tx_ventraga, String tp_nvo_mod, int cd_tipologia, int cd_tipologia_emp,
                      double im_coste_emp, double im_conste_inic, int st_tipificacion,  String tx_com_tipif_emp, String fh_neg_emp_cgf_sw, String fh_prv_emp_cgf_sw,
                      String fh_r_cgf_emp_dis, String fh_r_emp_cgf_sw, int st_componente, String tm_alta_comp) {

        this.cd_componente=cd_componente;
        this.nb_componente=nb_componente;
        this.cd_requerimiento=cd_requerimiento;
        this.tx_ventraga=tx_ventraga;
        this.tp_nvo_mod=tp_nvo_mod;
        this.cd_tipologia=cd_tipologia;
        this.cd_tipologia_emp=cd_tipologia_emp;
        this.im_coste_emp=im_coste_emp;
        this.im_conste_inic=im_conste_inic;
        this.st_tipificacion=st_tipificacion;
        this.tx_com_tipif_emp=tx_com_tipif_emp;
        this.fh_neg_emp_cgf_sw=fh_neg_emp_cgf_sw;
        this.fh_prv_emp_cgf_sw=fh_prv_emp_cgf_sw;
        this.fh_r_cgf_emp_dis=fh_r_cgf_emp_dis;
        this.fh_r_emp_cgf_sw=fh_r_emp_cgf_sw;
        this.st_componente=st_componente;
        this.tm_alta_comp=tm_alta_comp;

    }

    public int getCd_componente() {
        return cd_componente;
    }

    public void setCd_componente(int cd_componente) {
        this.cd_componente = cd_componente;
    }

    public String getNb_componente() {
        return nb_componente;
    }

    public void setNb_componente(String nb_componente) {
        this.nb_componente = nb_componente;
    }

    public int getCd_requerimiento() {
        return cd_requerimiento;
    }

    public void setCd_requerimiento(int cd_requerimiento) {
        this.cd_requerimiento = cd_requerimiento;
    }

    public String getTx_ventraga() {
        return tx_ventraga;
    }

    public void setTx_ventraga(String tx_ventraga) {
        this.tx_ventraga = tx_ventraga;
    }

    public String getTp_nvo_mod() {
        return tp_nvo_mod;
    }

    public void setTp_nvo_mod(String tp_nvo_mod) {
        this.tp_nvo_mod = tp_nvo_mod;
    }

    public int getCd_tipologia() {
        return cd_tipologia;
    }

    public void setCd_tipologia(int cd_tipologia) {
        this.cd_tipologia = cd_tipologia;
    }

    public int getCd_tipologia_emp() {
        return cd_tipologia_emp;
    }

    public void setCd_tipologia_emp(int cd_tipologia_emp) {
        this.cd_tipologia_emp = cd_tipologia_emp;
    }

    public double getIm_coste_emp() {
        return im_coste_emp;
    }

    public void setIm_coste_emp(double im_coste_emp) {
        this.im_coste_emp = im_coste_emp;
    }

    public double getIm_conste_inic() {
        return im_conste_inic;
    }

    public void setIm_conste_inic(double im_conste_inic) {
        this.im_conste_inic = im_conste_inic;
    }

    public int getSt_tipificacion() {
        return st_tipificacion;
    }

    public void setSt_tipificacion(int st_tipificacion) {
        this.st_tipificacion = st_tipificacion;
    }

    public String getTx_com_tipif_emp() {
        return tx_com_tipif_emp;
    }

    public void setTx_com_tipif_emp(String tx_com_tipif_emp) {
        this.tx_com_tipif_emp = tx_com_tipif_emp;
    }

    public String getFh_neg_emp_cgf_sw() {
        return fh_neg_emp_cgf_sw;
    }

    public void setFh_neg_emp_cgf_sw(String fh_neg_emp_cgf_sw) {
        this.fh_neg_emp_cgf_sw = fh_neg_emp_cgf_sw;
    }

    public String getFh_prv_emp_cgf_sw() {
        return fh_prv_emp_cgf_sw;
    }

    public void setFh_prv_emp_cgf_sw(String fh_prv_emp_cgf_sw) {
        this.fh_prv_emp_cgf_sw = fh_prv_emp_cgf_sw;
    }

    public String getFh_r_cgf_emp_dis() {
        return fh_r_cgf_emp_dis;
    }

    public void setFh_r_cgf_emp_dis(String fh_r_cgf_emp_dis) {
        this.fh_r_cgf_emp_dis = fh_r_cgf_emp_dis;
    }

    public String getFh_r_emp_cgf_sw() {
        return fh_r_emp_cgf_sw;
    }

    public void setFh_r_emp_cgf_sw(String fh_r_emp_cgf_sw) {
        this.fh_r_emp_cgf_sw = fh_r_emp_cgf_sw;
    }

    public int getSt_componente() {
        return st_componente;
    }

    public void setSt_componente(int st_componente) {
        this.st_componente = st_componente;
    }

    public String getTm_alta_comp() {
        return tm_alta_comp;
    }

    public void setTm_alta_comp(String tm_alta_comp) {
        this.tm_alta_comp = tm_alta_comp;
    }

    @Override
    public String toString() {
        return "Component{" +
                "cd_componente=" + cd_componente +
                ",nb_componente=" + nb_componente +
                ",cd_requerimiento=" + cd_requerimiento +
                ",tx_ventraga=" + tx_ventraga +
                ",tp_nvo_mod=" + tp_nvo_mod +
                ",cd_tipologia=" + cd_tipologia +
                ",cd_tipologia_emp=" + cd_tipologia_emp +
                ",im_coste_emp=" + im_coste_emp +
                ",im_conste_inic=" + im_conste_inic +
                ",st_tipificacion=" + st_tipificacion +
                ",tx_com_tipif_emp=" + tx_com_tipif_emp +
                ",fh_neg_emp_cgf_sw=" + fh_neg_emp_cgf_sw +
                ",fh_prv_emp_cgf_sw=" + fh_prv_emp_cgf_sw +
                ",fh_r_cgf_emp_dis=" + fh_r_cgf_emp_dis +
                ",fh_r_emp_cgf_sw=" + fh_r_emp_cgf_sw +
                ",st_componente=" + st_componente +
                ",tm_alta_comp=" + tm_alta_comp +
                '}';
    }
}
