package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Typology;
import com.mx.bbva.business.repository.TypologyRepository;
import com.mx.bbva.business.service.TypologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypologyServiceImpl implements TypologyService {
    private TypologyRepository typologyRepository;

    @Override
    public List<Typology> findByComponent(boolean typologyComponent) {
        return typologyRepository.findAllByTypologyComponentModified(typologyComponent);
    }

    @Override
    public Typology findTypology(Integer typologyId) {
        return typologyRepository.findById(typologyId).orElse(null);
    }

    @Override
    public List<Typology> findAllTypologies() {
        return typologyRepository.findAll();
    }

    @Autowired
    public void setRequirementRepository(TypologyRepository requirementRepository) {
        this.typologyRepository = requirementRepository;
    }
}
