package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Nature;
import com.mx.bbva.business.repository.NatureRepository;
import com.mx.bbva.business.service.NatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NatureServiceImpl implements NatureService {
    private NatureRepository natureRepository;

    @Override
    public List<Nature> findAllNatures() {
        return natureRepository.findAll();
    }

    @Autowired
    public void setNatureRepository(NatureRepository natureRepository) {
        this.natureRepository = natureRepository;
    }
}
