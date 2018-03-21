package com.bbva.bancomer.business.model;

public class AreaModel {

    private Integer cd_area;
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

    public AreaModel() {
    }

    public AreaModel(Integer cd_area, String nb_area) {
        this.cd_area = cd_area;
        this.nb_area = nb_area;
    }
}
