package com.bbva.bancomer.business.model;

import javax.persistence.*;

@Entity
@Table(name = "TADO002_CLIENTE") //este es el NOMBRE DE LA TABLA EN LA BASE
public class Cliente {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //ESTO ES PARA CUANDO ES INT AUTO INCREMENT
    @Column(name = "cd_idcl") //NOMBRE DE LA COLUMNA EN LAB ASE
    private Integer id;

    @Column(name = "nb_nombre") //NOMBRE DE LA COLUMNA EN LAB ASE
    private String nombre;

    //@OneToOne(mappedBy = "cliente") //NOMBRE DE LA COLUMNA EN LAB ASE//NOMBRE DE LA COLUMNA EN LAB ASE
    //private ConjuntoHN72 conjunto;

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

    /*public ConjuntoHN72 getConjunto() {
        return conjunto;
    }

    public void setConjunto(ConjuntoHN72 conjunto) {
        this.conjunto = conjunto;
    }
    */
}
