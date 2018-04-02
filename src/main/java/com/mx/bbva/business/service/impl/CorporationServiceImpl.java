package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Corporation;
import com.mx.bbva.business.repository.CorporationRepository;
import com.mx.bbva.business.service.CorporationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorporationServiceImpl implements CorporationService {
    private CorporationRepository corporationRepository;

    @Override
    public List<Corporation> findAllCorporations() {
        return corporationRepository.findAll();
    }

    @Autowired
    public void setCorporationRepository(CorporationRepository corporationRepository) {
        this.corporationRepository = corporationRepository;
    }
}
