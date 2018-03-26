package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.Typology;

import java.util.List;

public interface TypologyService {

    //Typology saveRequirement(Typology requirement);

    List<Typology> findAllNew();

    List<Typology> findAllMod();
}
