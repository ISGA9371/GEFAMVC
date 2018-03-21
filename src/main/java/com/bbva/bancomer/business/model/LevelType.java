package com.bbva.bancomer.business.model;

import javax.persistence.*;

@Entity
@Table(name ="THGE004_TIPO_NIVEL")
public class LevelType {
    @Id
    /*@GeneratedValue()*/
    @Column(name = "CD_TIPO_NIVEL")
    private Integer id;

    @Column(name = "NB_TIPO_NIVEL")
    private String nombre;

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
