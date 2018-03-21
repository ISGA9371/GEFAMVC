package com.bbva.bancomer.business.model;

import javax.persistence.*;

@Entity
@Table(name ="THGE010_NIVEL")
public class Nivel {
    @Id
    @GeneratedValue(/**/)
    @Column(name = "CD_TIPO_NIVEL")
    Integer id;

    @Column(name = "NB_TIPO_NIVEL")
    String nombre;

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
