package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Fare;
import com.mx.bbva.business.repository.FareRepository;
import com.mx.bbva.business.service.FareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FareServiceImpl implements FareService {
    private FareRepository fareRepository;

    @Override
    public List<Fare> findAllFares() {
        return fareRepository.findAll();
    }

    @Override
    public Fare findRequirementFare(Integer companyId, Integer technologyId, Integer areaId) {
        return fareRepository.findCurrentCompanyFareByTechnologyAndArea(companyId, technologyId, areaId);
    }

    @Autowired
    public void setRequirementRepository(FareRepository fareRepository) {
        this.fareRepository = fareRepository;
    }
}
