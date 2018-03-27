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
    public List<Typology> findByComponent(String typologyComponent) {
        return typologyRepository.findAllByTypologyComponent(typologyComponent);
    }
    @Override
    public Typology findById(String typologyId) {
        return typologyRepository.findByTypologyId(typologyId);
    }

    @Autowired
    public void setRequirementRepository(TypologyRepository requirementRepository) {
        this.typologyRepository = requirementRepository;
    }
}
