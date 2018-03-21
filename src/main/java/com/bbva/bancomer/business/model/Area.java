package com.bbva.bancomer.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "THGE030_AREA") //este es el NOMBRE DE LA TABLA EN LA BASE
public class Area {

    @Id
    //@GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "CD_AREA")
    private Integer cd_area;

    @Column(name = "NB_AREA")
    private String nb_area;

    public Integer getCd_area() {
        return cd_area;
    }

    public void setCd_area(Integer cd_area) {
        this.cd_area = cd_area;
    }

    public String getNb_area() {
        return nb_area;
    }

    public void setNb_area(String nb_area) {
        this.nb_area = nb_area;
    }

    public Area() {
    }

    public Area(Integer cd_area, String nb_area) {
        this.cd_area = cd_area;
        this.nb_area = nb_area;
    }
}
