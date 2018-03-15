package com.bbva.bancomer.business.model;


import com.sun.istack.internal.Nullable;

import javax.persistence.*;

@Entity
@Table(name="THGE017_REQUERIM")
public class Requerimiento {

    @Id
    //@GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="CD_REQUERIMIENTO")
    private Integer cd_requerimiento;

    @Column(name="NB_REQUERIMIENTO")
    private String nb_requerimiento;

    @Column(name="CD_NIVEL")
    private Integer cd_nivel;

    @Column(name="CD_TECNOLOGIA")
    private Integer cd_tecnologia;

    @Column(name="CD_EMPRESA")
    private Integer cd_empresa;

    @Column(name="CD_AREA")
    private Integer cd_area;

    @Column(name="CD_TIPO_SERVICIO")
    private Integer cd_tipo_servicio;

    @Column(name="CD_TIPO_PROY")
    private Integer cd_tipo_proyecto;

    @Column(name="CD_APLICACION")
    private Integer cd_aplicacion;

    @Column(name="CD_CANAL")
    private Integer cd_canal;

    @Column(name="NU_HORA_REQ")
    private Double nu_hora_rec;

    @Column(name="CD_SCRUM")
    private Integer cd_scrum;

    @Column(name="CD_USUARIO_RESP")
    private String cd_usuario_resp;

    @Column(name="CD_USUARIO_GESTOR")
    private String cd_usuario_gestor;

    @Column(name="ST_REQUERIMIENTO")
    private Integer st_requerimiento;

    @Column(name="NU_HRS_TOT")
    private Integer nu_hrs_tot;

    @Column(name="NU_HRS_FACT")
    private Integer nu_hrs_fact;

    @Column(name="ST_FACTURADO")
    private Integer st_facturado;

    @Column(name="TM_ALTA_REQ")
    private String tm_alta_rec;

    @Column(name="NU_FACTURABLE")
    private Integer nu_facturable;

    //Cosntructor por defecto para Hibernate
    public Requerimiento(){}


    //Constructor Nuestro
    public Requerimiento(Integer cd_requerimiento, String nb_requerimiento, Integer cd_nivel, Integer cd_tecnologia, Integer cd_empresa, Integer cd_area, Integer cd_tipo_servicio, Integer cd_tipo_proyecto, Integer cd_aplicacion, Integer cd_canal, Double nu_hora_rec, Integer cd_scrum, String cd_usuario_resp, String cd_usuario_gestor, Integer st_requerimiento, Integer nu_hrs_tot, Integer nu_hrs_fact, Integer st_facturado, String tm_alta_rec, Integer nu_facturable) {
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

    public Integer getCd_requerimiento() {
        return cd_requerimiento;
    }

    public void setCd_requerimiento(Integer cd_requerimiento) {
        this.cd_requerimiento = cd_requerimiento;
    }

    public String getNb_requerimiento() {
        return nb_requerimiento;
    }

    public void setNb_requerimiento(String nb_requerimiento) {
        this.nb_requerimiento = nb_requerimiento;
    }

    public Integer getCd_nivel() {
        return cd_nivel;
    }

    public void setCd_nivel(Integer cd_nivel) {
        this.cd_nivel = cd_nivel;
    }

    public Integer getCd_tecnologia() {
        return cd_tecnologia;
    }

    public void setCd_tecnologia(Integer cd_tecnologia) {
        this.cd_tecnologia = cd_tecnologia;
    }

    public Integer getCd_empresa() {
        return cd_empresa;
    }

    public void setCd_empresa(Integer cd_empresa) {
        this.cd_empresa = cd_empresa;
    }

    public Integer getCd_area() {
        return cd_area;
    }

    public void setCd_area(Integer cd_area) {
        this.cd_area = cd_area;
    }

    public Integer getCd_tipo_servicio() {
        return cd_tipo_servicio;
    }

    public void setCd_tipo_servicio(Integer cd_tipo_servicio) {
        this.cd_tipo_servicio = cd_tipo_servicio;
    }

    public Integer getCd_tipo_proyecto() {
        return cd_tipo_proyecto;
    }

    public void setCd_tipo_proyecto(Integer cd_tipo_proyecto) {
        this.cd_tipo_proyecto = cd_tipo_proyecto;
    }

    public Integer getCd_aplicacion() {
        return cd_aplicacion;
    }

    public void setCd_aplicacion(Integer cd_aplicacion) {
        this.cd_aplicacion = cd_aplicacion;
    }

    public Integer getCd_canal() {
        return cd_canal;
    }

    public void setCd_canal(Integer cd_canal) {
        this.cd_canal = cd_canal;
    }

    public Double getNu_hora_rec() {
        return nu_hora_rec;
    }

    public void setNu_hora_rec(Double nu_hora_rec) {
        this.nu_hora_rec = nu_hora_rec;
    }

    public Integer getCd_scrum() {
        return cd_scrum;
    }

    public void setCd_scrum(Integer cd_scrum) {
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

    public Integer getSt_requerimiento() {
        return st_requerimiento;
    }

    public void setSt_requerimiento(Integer st_requerimiento) {
        this.st_requerimiento = st_requerimiento;
    }

    public Integer getNu_hrs_tot() {
        return nu_hrs_tot;
    }

    public void setNu_hrs_tot(Integer nu_hrs_tot) {
        this.nu_hrs_tot = nu_hrs_tot;
    }

    public Integer getNu_hrs_fact() {
        return nu_hrs_fact;
    }

    public void setNu_hrs_fact(Integer nu_hrs_fact) {
        this.nu_hrs_fact = nu_hrs_fact;
    }

    public Integer getSt_facturado() {
        return st_facturado;
    }

    public void setSt_facturado(Integer st_facturado) {
        this.st_facturado = st_facturado;
    }

    public String getTm_alta_rec() {
        return tm_alta_rec;
    }

    public void setTm_alta_rec(String tm_alta_rec) {
        this.tm_alta_rec = tm_alta_rec;
    }

    public Integer getNu_facturable() {
        return nu_facturable;
    }

    public void setNu_facturable(Integer nu_facturable) {
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
