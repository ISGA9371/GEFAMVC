package com.bbva.bancomer.business.model;

public class NivelCmbModel {

    private Integer cd_requerimiento;
    private Integer cd_nivel;
    private String nb_nivel;
    private Integer cd_tipo_nivel;
    private String cd_usuario_resp;
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

    public NivelCmbModel() {
    }

    public NivelCmbModel(Integer cd_requerimiento, Integer cd_nivel, String nb_nivel, Integer cd_tipo_nivel, String cd_usuario_resp, Integer cd_nivel_superior) {
        this.cd_requerimiento = cd_requerimiento;
        this.cd_nivel = cd_nivel;
        this.nb_nivel = nb_nivel;
        this.cd_tipo_nivel = cd_tipo_nivel;
        this.cd_usuario_resp = cd_usuario_resp;
        this.cd_nivel_superior = cd_nivel_superior;
    }
}
