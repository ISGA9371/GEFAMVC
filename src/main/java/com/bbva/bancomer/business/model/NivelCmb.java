package com.bbva.bancomer.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "THGE010_NIVEL") //este es el NOMBRE DE LA TABLA EN LA BASE
public class NivelCmb {

    @Id
    //@GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "CD_CONSEC_NIVEL")
    private Integer cd_requerimiento;

    @Column(name = "CD_NIVEL")
    private Integer cd_nivel;

    @Column(name = "NB_NIVEL")
    private String nb_nivel;

    @Column(name = "CD_TIPO_NIVEL")
    private Integer cd_tipo_nivel;

    @Column(name = "CD_USUARIO_RESP")
    private String cd_usuario_resp;

    @Column(name = "CD_NIVEL_SUPERIOR")
    private Integer cd_nivel_superior;

    public Integer getCd_requerimiento() {
        return cd_requerimiento;
    }

    public void setCd_requerimiento(Integer cd_requerimiento) {
        this.cd_requerimiento = cd_requerimiento;
    }

    public Integer getCd_nivel() {
        return cd_nivel;
    }

    public void setCd_nivel(Integer cd_nivel) {
        this.cd_nivel = cd_nivel;
    }

    public String getNb_nivel() {
        return nb_nivel;
    }

    public void setNb_nivel(String nb_nivel) {
        this.nb_nivel = nb_nivel;
    }

    public Integer getCd_tipo_nivel() {
        return cd_tipo_nivel;
    }

    public void setCd_tipo_nivel(Integer cd_tipo_nivel) {
        this.cd_tipo_nivel = cd_tipo_nivel;
    }

    public String getCd_usuario_resp() {
        return cd_usuario_resp;
    }

    public void setCd_usuario_resp(String cd_usuario_resp) {
        this.cd_usuario_resp = cd_usuario_resp;
    }

    public Integer getCd_nivel_superior() {
        return cd_nivel_superior;
    }

    public void setCd_nivel_superior(Integer cd_nivel_superior) {
        this.cd_nivel_superior = cd_nivel_superior;
    }

    public NivelCmb() {}

    public NivelCmb(Integer cd_requerimiento, Integer cd_nivel, String nb_nivel, Integer cd_tipo_nivel, String cd_usuario_resp, Integer cd_nivel_superior) {
        this.cd_requerimiento = cd_requerimiento;
        this.cd_nivel = cd_nivel;
        this.nb_nivel = nb_nivel;
        this.cd_tipo_nivel = cd_tipo_nivel;
        this.cd_usuario_resp = cd_usuario_resp;
        this.cd_nivel_superior = cd_nivel_superior;
    }
}
