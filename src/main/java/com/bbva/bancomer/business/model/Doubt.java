package com.bbva.bancomer.business.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "THGE027_DUDA")
public class Doubt {

    @Id
    //@GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name="CD_DUDA")
    private int cd_duda;

    @Column(name="CD_COMPONENTE")
    private int cd_componente;

    @Column(name="FH_ALTA")
    private String fh_alta;

    @Column(name="ST_DUDA")
    private int st_duda;

    @Column(name="TX_VENTREGA")
    private String tx_ventrega;

    @Column(name="NB_DESC_DUDA_HIST")
    private String nb_desc_duda_hist;

    @Column(name="NB_DESC_RES_HIST")
    private String nb_desc_res_hist;

    @Column(name="CD_PRIORIDAD")
    private int cd_prioridad;

    @Column(name="CD_TIPO_DUDA")
    private int cd_tipo_duda;

    @Column(name="CD_USU_PETICION")
    private String cd_usu_peticion;

    @Column(name="CD_USU_RESP")
    private String cd_usu_resp;

    @Column(name="FH_RESOLUCION")
    private String fh_resolucion;

    @Column(name="NU_RES_INCORR")
    private int nu_res_incorr;

    //Cosntructor por defecto para Hibernate
    public Doubt() {
    }

    public Doubt (int cd_duda, int cd_componente, String fh_alta, int st_duda, String tx_ventrega, String nb_desc_duda_hist,
                  String nb_desc_res_hist, int cd_prioridad, int cd_tipo_duda, String cd_usu_peticion, String cd_usu_resp,
                  String fh_resolucion, int nu_res_incorr) {
        this.cd_duda=cd_duda;
        this.cd_componente=cd_componente;
        this.fh_alta=fh_alta;
        this.st_duda=st_duda;
        this.tx_ventrega=tx_ventrega;
        this.nb_desc_duda_hist=nb_desc_duda_hist;
        this.nb_desc_res_hist=nb_desc_res_hist;
        this.cd_prioridad=cd_prioridad;
        this.cd_tipo_duda=cd_tipo_duda;
        this.cd_usu_peticion=cd_usu_peticion;
        this.cd_usu_resp=cd_usu_resp;
        this.fh_resolucion=fh_resolucion;
        this.nu_res_incorr=nu_res_incorr;
    }

    public int getCd_duda() {
        return cd_duda;
    }

    public void setCd_duda(int cd_duda) {
        this.cd_duda = cd_duda;
    }

    public int getCd_componente() {
        return cd_componente;
    }

    public void setCd_componente(int cd_componente) {
        this.cd_componente = cd_componente;
    }

    public String getFh_alta() {
        return fh_alta;
    }

    public void setFh_alta(String fh_alta) {
        this.fh_alta = fh_alta;
    }

    public int getSt_duda() {
        return st_duda;
    }

    public void setSt_duda(int st_duda) {
        this.st_duda = st_duda;
    }

    public String getTx_ventrega() {
        return tx_ventrega;
    }

    public void setTx_ventrega(String tx_ventrega) {
        this.tx_ventrega = tx_ventrega;
    }

    public String getNb_desc_duda_hist() {
        return nb_desc_duda_hist;
    }

    public void setNb_desc_duda_hist(String nb_desc_duda_hist) {
        this.nb_desc_duda_hist = nb_desc_duda_hist;
    }

    public String getNb_desc_res_hist() {
        return nb_desc_res_hist;
    }

    public void setNb_desc_res_hist(String nb_desc_res_hist) {
        this.nb_desc_res_hist = nb_desc_res_hist;
    }

    public int getCd_prioridad() {
        return cd_prioridad;
    }

    public void setCd_prioridad(int cd_prioridad) {
        this.cd_prioridad = cd_prioridad;
    }

    public int getCd_tipo_duda() {
        return cd_tipo_duda;
    }

    public void setCd_tipo_duda(int cd_tipo_duda) {
        this.cd_tipo_duda = cd_tipo_duda;
    }

    public String getCd_usu_peticion() {
        return cd_usu_peticion;
    }

    public void setCd_usu_peticion(String cd_usu_peticion) {
        this.cd_usu_peticion = cd_usu_peticion;
    }

    public String getCd_usu_resp() {
        return cd_usu_resp;
    }

    public void setCd_usu_resp(String cd_usu_resp) {
        this.cd_usu_resp = cd_usu_resp;
    }

    public String getFh_resolucion() {
        return fh_resolucion;
    }

    public void setFh_resolucion(String fh_resolucion) {
        this.fh_resolucion = fh_resolucion;
    }

    public int getNu_res_incorr() {
        return nu_res_incorr;
    }

    public void setNu_res_incorr(int nu_res_incorr) {
        this.nu_res_incorr = nu_res_incorr;
    }

    @Override
    public String toString() {
        return "Doubt{" +
                " cd_duda=" +  cd_duda+
                ", cd_componente=" +  cd_componente+
                ", fh_alta=" +  fh_alta+
                ", st_duda=" +  st_duda+
                ", tx_ventrega=" +  tx_ventrega+
                ", nb_desc_duda_hist=" +  nb_desc_duda_hist+
                ", nb_desc_res_hist=" +  nb_desc_res_hist+
                ", cd_prioridad=" +  cd_prioridad+
                ", cd_tipo_duda=" +  cd_tipo_duda+
                ", cd_usu_peticion=" +  cd_usu_peticion+
                ", cd_usu_resp=" +  cd_usu_resp+
                ", fh_resolucion=" +  fh_resolucion+
                ", nu_res_incorr=" +  nu_res_incorr+
                '}';
    }

}
