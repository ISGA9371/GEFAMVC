package com.bbva.bancomer.business.model;


import javax.persistence.*;

@Entity
@Table(name = "THGE002_TECNOLOGIA")
public class Tecnologia {

    @Id
    @GeneratedValue(/*strategy= GenerationType.IDENTITY*/)
    @Column(name = "CD_TECNOLOGIA")
    private Integer id;
    @Column(name = "NB_TECNOLOGIA")
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
