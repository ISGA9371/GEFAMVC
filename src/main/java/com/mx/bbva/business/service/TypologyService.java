package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.Typology;

import java.util.List;

public interface TypologyService {
    List<Typology> findByComponent(String typologyComponent);
    Typology findById(String typologyId);
}
