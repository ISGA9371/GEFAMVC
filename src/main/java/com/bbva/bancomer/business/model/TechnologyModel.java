package com.bbva.bancomer.business.model;

public class TechnologyModel {

    private Integer id;
    private String nombre;

    public TechnologyModel(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public TechnologyModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
