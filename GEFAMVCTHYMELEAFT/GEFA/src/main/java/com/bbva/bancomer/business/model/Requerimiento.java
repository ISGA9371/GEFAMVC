package com.bbva.bancomer.business.model;


import com.sun.istack.internal.Nullable;

import javax.persistence.*;

@Entity
@Table(name="thge017_requerim")
public class Requerimiento {

    @Id
    @GeneratedValue
    @Column(name="CD_REQUERIMIENTO")
    private int cd_requerimiento;

    @Column(name="NB_REQUERIMIENTO")
    private String nb_requerimiento;

    @Column(name="CD_NIVEL")
    private int cd_nivel;

    @Column(name="CD_TECNOLOGIA")
    private int cd_tecnologia;

    @Column(name="CD_EMPRESA")
    private int cd_empresa;

    @Column(name="CD_AREA")
    private int cd_area;

    @Column(name="CD_TIPO_SERVICIO")
    private int cd_tipo_servicio;

    @Column(name="CD_TIPO_PROYECTO")
    private int cd_tipo_proyecto;

    @Column(name="CD_APLICACION")
    private int cd_aplicacion;

    @Column(name="CD_CANAL")
    private int cd_canal;

    @Column(name="NU_HORA_REC")
    private double nu_hora_rec;

    @Column(name="CD_SCRUM")
    private int cd_scrum;

    @Column(name="CD_USUARIO_RESP")
    private String cd_usuario_resp;

    @Column(name="CD_USUARIO_GESTOR")
    private String cd_usuario_gestor;

    @Column(name="ST_REQUERIMIENTO")
    private int st_requerimiento;

    @Column(name="NU_HRS_TOT")
    private int nu_hrs_tot;

    @Column(name="NU_HRS_FACT")
    private int nu_hrs_fact;

    @Column(name="ST_FACTURADO")
    private int st_facturado;

    @Column(name="TM_ALTA_REC")
    private String tm_alta_rec;

    @Column(name="NU_FACTURABLE")
    private int nu_facturable;

    //Cosntructor por defecto para Hibernate
    public Requerimiento(){}


    //Constructor Nuestro
    public Requerimiento(int cd_requerimiento, String nb_requerimiento, int cd_nivel, int cd_tecnologia, int cd_empresa, int cd_area, int cd_tipo_servicio, int cd_tipo_proyecto, int cd_aplicacion, int cd_canal, double nu_hora_rec, int cd_scrum, String cd_usuario_resp, String cd_usuario_gestor, int st_requerimiento, int nu_hrs_tot, int nu_hrs_fact, int st_facturado, String tm_alta_rec, int nu_facturable) {
        this.cd_requerimiento = cd_requerimiento;
        this.nb_requerimiento = nb_requerimiento;
        this.cd_nivel = cd_nivel;
        this.cd_tecnologia = cd_tecnologia;
        this.cd_empresa = cd_empresa;
        this.cd_area = cd_area;
        this.cd_tipo_servicio = cd_tipo_servicio;
        this.cd_tipo_proyecto = cd_tipo_proyecto;
        this.cd_aplicacion = cd_aplicacion;
        this.cd_canal = cd_canal;
        this.nu_hora_rec = nu_hora_rec;
        this.cd_scrum = cd_scrum;
        this.cd_usuario_resp = cd_usuario_resp;
        this.cd_usuario_gestor = cd_usuario_gestor;
        this.st_requerimiento = st_requerimiento;
        this.nu_hrs_tot = nu_hrs_tot;
        this.nu_hrs_fact = nu_hrs_fact;
        this.st_facturado = st_facturado;
        this.tm_alta_rec = tm_alta_rec;
        this.nu_facturable = nu_facturable;
    }

    public int getCd_requerimiento() {
        return cd_requerimiento;
    }

    public void setCd_requerimiento(int cd_requerimiento) {
        this.cd_requerimiento = cd_requerimiento;
    }

    public String getNb_requerimiento() {
        return nb_requerimiento;
    }

    public void setNb_requerimiento(String nb_requerimiento) {
        this.nb_requerimiento = nb_requerimiento;
    }

    public int getCd_nivel() {
        return cd_nivel;
    }

    public void setCd_nivel(int cd_nivel) {
        this.cd_nivel = cd_nivel;
    }

    public int getCd_tecnologia() {
        return cd_tecnologia;
    }

    public void setCd_tecnologia(int cd_tecnologia) {
        this.cd_tecnologia = cd_tecnologia;
    }

    public int getCd_empresa() {
        return cd_empresa;
    }

    public void setCd_empresa(int cd_empresa) {
        this.cd_empresa = cd_empresa;
    }

    public int getCd_area() {
        return cd_area;
    }

    public void setCd_area(int cd_area) {
        this.cd_area = cd_area;
    }

    public int getCd_tipo_servicio() {
        return cd_tipo_servicio;
    }

    public void setCd_tipo_servicio(int cd_tipo_servicio) {
        this.cd_tipo_servicio = cd_tipo_servicio;
    }

    public int getCd_tipo_proyecto() {
        return cd_tipo_proyecto;
    }

    public void setCd_tipo_proyecto(int cd_tipo_proyecto) {
        this.cd_tipo_proyecto = cd_tipo_proyecto;
    }

    public int getCd_aplicacion() {
        return cd_aplicacion;
    }

    public void setCd_aplicacion(int cd_aplicacion) {
        this.cd_aplicacion = cd_aplicacion;
    }

    public int getCd_canal() {
        return cd_canal;
    }

    public void setCd_canal(int cd_canal) {
        this.cd_canal = cd_canal;
    }

    public double getNu_hora_rec() {
        return nu_hora_rec;
    }

    public void setNu_hora_rec(double nu_hora_rec) {
        this.nu_hora_rec = nu_hora_rec;
    }

    public int getCd_scrum() {
        return cd_scrum;
    }

    public void setCd_scrum(int cd_scrum) {
        this.cd_scrum = cd_scrum;
    }

    public String getCd_usuario_resp() {
        return cd_usuario_resp;
    }

    public void setCd_usuario_resp(String cd_usuario_resp) {
        this.cd_usuario_resp = cd_usuario_resp;
    }

    public String getCd_usuario_gestor() {
        return cd_usuario_gestor;
    }

    public void setCd_usuario_gestor(String cd_usuario_gestor) {
        this.cd_usuario_gestor = cd_usuario_gestor;
    }

    public int getSt_requerimiento() {
        return st_requerimiento;
    }

    public void setSt_requerimiento(int st_requerimiento) {
        this.st_requerimiento = st_requerimiento;
    }

    public int getNu_hrs_tot() {
        return nu_hrs_tot;
    }

    public void setNu_hrs_tot(int nu_hrs_tot) {
        this.nu_hrs_tot = nu_hrs_tot;
    }

    public int getNu_hrs_fact() {
        return nu_hrs_fact;
    }

    public void setNu_hrs_fact(int nu_hrs_fact) {
        this.nu_hrs_fact = nu_hrs_fact;
    }

    public int getSt_facturado() {
        return st_facturado;
    }

    public void setSt_facturado(int st_facturado) {
        this.st_facturado = st_facturado;
    }

    public String getTm_alta_rec() {
        return tm_alta_rec;
    }

    public void setTm_alta_rec(String tm_alta_rec) {
        this.tm_alta_rec = tm_alta_rec;
    }

    public int getNu_facturable() {
        return nu_facturable;
    }

    public void setNu_facturable(int nu_facturable) {
        this.nu_facturable = nu_facturable;
    }


    @Override
    public String toString() {
        return "Requerimiento{" +
                "cd_requerimiento=" + cd_requerimiento +
                ", nb_requerimiento='" + nb_requerimiento + '\'' +
                ", cd_nivel=" + cd_nivel +
                ", cd_tecnologia=" + cd_tecnologia +
                ", cd_empresa=" + cd_empresa +
                ", cd_area=" + cd_area +
                ", cd_tipo_servicio=" + cd_tipo_servicio +
                ", cd_tipo_proyecto=" + cd_tipo_proyecto +
                ", cd_aplicacion=" + cd_aplicacion +
                ", cd_canal=" + cd_canal +
                ", nu_hora_rec=" + nu_hora_rec +
                ", cd_scrum=" + cd_scrum +
                ", cd_usuario_resp='" + cd_usuario_resp + '\'' +
                ", cd_usuario_gestor='" + cd_usuario_gestor + '\'' +
                ", st_requerimiento=" + st_requerimiento +
                ", nu_hrs_tot=" + nu_hrs_tot +
                ", nu_hrs_fact=" + nu_hrs_fact +
                ", st_facturado=" + st_facturado +
                ", tm_alta_rec='" + tm_alta_rec + '\'' +
                ", nu_facturable=" + nu_facturable +
                '}';
    }
}
