package com.mx.bbva.business.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "thge035_metodologia")
public class Methodology implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "CD_METODOLOGIA")
    private Integer methodologyId;

    @Column(name = "NB_METODOLOGIA")
    private String methodologyName;

    public Methodology(){}

    public Integer getMethodologyId() {
        return methodologyId;
    }

    public void setMethodologyId(Integer methodologyId) {
        this.methodologyId = methodologyId;
    }

    public String getMethodologyName() {
        return methodologyName;
    }

    public void setMethodologyName(String methodologyName) {
        this.methodologyName = methodologyName;
    }
}
