package com.bbva.bancomer.business.service.implementation;


import com.bbva.bancomer.business.model.Technology;
import com.bbva.bancomer.business.repository.TechnologyRepository;
import com.bbva.bancomer.business.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyServiceImp implements TechnologyService {
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
