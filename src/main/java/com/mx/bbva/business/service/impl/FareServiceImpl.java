package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Fare;
import com.mx.bbva.business.entity.Requirement;
import com.mx.bbva.business.entity.Status;
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
    public Double findByRequirement(Requirement requirement) {
        Fare fare = fareRepository.findFareValueByCompanyAndTechnologyAndAreaAndStatus(
                requirement.getCompany(), requirement.getTechnology(), requirement.getArea(), new Status(55));
        return fare != null ? fare.getFareValue() : new Double(0L);
    }

    @Autowired
    public void setRequirementRepository(FareRepository fareRepository) {
        this.fareRepository = fareRepository;
    }
}
