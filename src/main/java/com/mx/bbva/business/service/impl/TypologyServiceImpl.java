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
    public List<Typology> findAllNew() { return typologyRepository.findAllByTypologyComponent("0"); }

    @Override
    public List<Typology> findAllMod() { return typologyRepository.findAllByTypologyComponent("1"); }

    @Autowired
    public void setRequirementRepository(TypologyRepository requirementRepository) {
        this.typologyRepository = requirementRepository;
    }
}
