package com.mx.bbva.business.service.impl;


import com.mx.bbva.business.model.Technology;
import com.mx.bbva.business.repository.TechnologyRepository;
import com.mx.bbva.business.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyServiceImpl implements TechnologyService {
    private TechnologyRepository technologyRepository;

    @Override
    public List<Technology> findAllTechnologies() {
        return technologyRepository.findAll();
    }

    @Autowired
    public void setTechnologyRepository(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }
}
