package com.bbva.bancomer.business.model;


import javax.persistence.*;

@Entity
@Table(name = "THGE010_NIVEL")
public class Level {

    @Id
    //@GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name="CD_CONSEC_NIVEL")
    private Integer cd_consec_nivel;

    @Column(name="CD_NIVEL")
    private Integer cd_nivel;

    @Column(name="NB_NIVEL")
    private String nb_nivel;

    /*
    @Column(name="CD_TIPO_NIVEL")
    private int cd_tipo_nivel;*/

    @ManyToOne
    @JoinColumn(name="cd_tipo_nivel")
    private LevelType type;

    @Column(name="CD_USUARIO_RESP")
    private String cd_usuario_resp;

    @Column(name="CD_NIVEL_SUPERIOR")
    private Integer cd_nivel_superior;

    //Cosntructor por defecto para Hibernate
    public Level() {
    }

    public Level (Integer cd_consec_nivel, Integer cd_nivel, String nb_nivel, Integer cd_tipo_nivel, String cd_usuario_resp, Integer cd_nivel_superior) {
        this.cd_consec_nivel = cd_consec_nivel;
        this.cd_nivel = cd_nivel;
        this.nb_nivel = nb_nivel;
        //this.cd_tipo_nivel = cd_tipo_nivel;
        this.cd_usuario_resp = cd_usuario_resp;
        this.cd_nivel_superior = cd_nivel_superior;
    }

    public Integer getCd_consec_nivel() {
        return cd_consec_nivel;
    }

    public void setCd_consec_nivel(Integer cd_consec_nivel) {
        this.cd_consec_nivel = cd_consec_nivel;
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

    public LevelType getType() {
        return type;
    }

    public void setType(LevelType type) {
        this.type = type;
    }

    /*public Integer getCd_tipo_nivel() {
        return cd_tipo_nivel;
    }

    public void setCd_tipo_nivel(Integer cd_tipo_nivel) {
        this.cd_tipo_nivel = cd_tipo_nivel;
    }*/

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

    @Override
    public String toString() {
        return "Level{" +
                "cd_consec_nivel=" +  cd_consec_nivel +
                ", cd_nivel=" + cd_nivel +
                ", nb_nivel=" + nb_nivel +
                //", cd_tipo_nivel=" + cd_tipo_nivel +
                ", cd_usuario_resp=" + cd_usuario_resp +
                ", cd_nivel_superior=" + cd_nivel_superior +
                '}';
    }

}